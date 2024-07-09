package net.skds.ninvoker.struct;

import net.skds.lib.utils.Holders;
import net.skds.lib.utils.UnsafeAnal;
import net.skds.ninvoker.NInvoker;
import sun.misc.Unsafe;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteOrder;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class NativeStructureWrapper {

	//private static final Cleaner CLEANER = Cleaner.create();
	private static final Unsafe UNSAFE = UnsafeAnal.UNSAFE;
	private static final boolean swapByteOrder = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;

	private final Class<? extends AbstractNativeStructure> type;
	private final Codec[] fields;
	public final int size;
	//private final boolean useCleaner;

	public NativeStructureWrapper(Class<? extends AbstractNativeStructure> type) {
		this.type = type;
		//this.useCleaner = useCleaner;
		Holders.IntHolder size = new Holders.IntHolder();
		this.fields = Stream.of(type.getDeclaredFields())
				.filter(f -> (f.getModifiers() & (Modifier.TRANSIENT | Modifier.STATIC)) == 0)
				.map(f -> {
							Class<?> c = f.getType();
							if (c.isPrimitive()) {
								if (c == int.class) {
									return new IntCodec(f, size);
								} else if (c == long.class) {
									return new LongCodec(f, size);
								} else if (c == byte.class) {
									return new ByteCodec(f, size);
								} else if (c == short.class) {
									return new ShortCodec(f, size);
								} else if (c == float.class) {
									return new FloatCodec(f, size);
								} else if (c == double.class) {
									return new DoubleCodec(f, size);
								}

							} else if (c.isArray()) {
								if (c == int[].class) {
									return new ArrayCodec(f, size, 4);
								} else if (c == long[].class) {
									return new ArrayCodec(f, size, 8);
								} else if (c == byte[].class) {
									return new ArrayCodec(f, size, 1);
								} else if (c == short[].class) {
									return new ArrayCodec(f, size, 2);
								} else if (c == float[].class) {
									return new ArrayCodec(f, size, 4);
								} else if (c == double[].class) {
									return new ArrayCodec(f, size, 8);
								}
							} else if (c.isAssignableFrom(NativeData.class)) {
								return new StructCodec(f, size);
							}

							throw new IllegalArgumentException("Class \"" + type + "\" has field \"" + f.getName() + "\" of invalid type \"" + c + "\"");
						}
				)
				.peek(c -> size.increment(c.size()))
				.toArray(Codec[]::new);
		this.size = size.getValue();
	}

	public void get(AbstractNativeStructure structure) {
		try {
			for (int i = 0; i < fields.length; i++) {
				fields[i].read(structure);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void put(AbstractNativeStructure structure) {
		try {
			for (int i = 0; i < fields.length; i++) {
				fields[i].write(structure);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractNativeStructure> T[] allocArray(Supplier<T> constructor, int len) {
		T[] arr = (T[]) Array.newInstance(type, len);
		long address = UNSAFE.allocateMemory((long) size * len);
		for (int i = 0; i < len; i++) {
			T struct = constructor.get();
			arr[i] = struct;
			struct.address = (long) size * i + address;
		}
		return arr;
	}

	public long alloc(AbstractNativeStructure structure) {
		long address = UNSAFE.allocateMemory(size);
		structure.address = address;
		return address;
	}

	public long cAlloc(AbstractNativeStructure structure) {
		long address = alloc(structure);
		UNSAFE.setMemory(address, size, (byte) 0x0);
		return address;
	}

	public void free(AbstractNativeStructure structure) {
		UNSAFE.freeMemory(structure.address);
		structure.address = 0;
	}

	private abstract static class Codec {

		protected final Field field;
		protected final int offset;

		private Codec(Field field, Holders.IntHolder offset) {
			this.field = field;
			this.offset = offset.getValue();
			field.setAccessible(true);
		}

		protected long address(AbstractNativeStructure structure) {
			return structure.address + offset;
		}

		abstract void read(AbstractNativeStructure structure) throws IllegalAccessException;

		abstract void write(AbstractNativeStructure structure) throws IllegalAccessException;

		abstract int size();
	}

	private static class StructCodec extends Codec {

		private final Supplier<NativeData> constructor;
		private final int size;

		@SuppressWarnings("unchecked")
		private StructCodec(Field field, Holders.IntHolder offset) {
			super(field, offset);
			try {
				DataClass dc = field.getAnnotation(DataClass.class);
				Class<?> c = (dc == null) ? field.getClass() : dc.value();
				var cns = (Constructor<NativeData>) c.getConstructor();
				this.constructor = () -> {
					try {
						return cns.newInstance();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				};
				this.size = constructor.get().size();

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			NativeData nd = (NativeData) field.get(structure);
			if (nd == null) {
				nd = constructor.get();
				field.set(structure, nd);
			}
			nd.get();
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			NativeData nd = (NativeData) field.get(structure);
			if (nd != null) {
				nd.put();
			}
		}

		@Override
		int size() {
			return size;
		}
	}

	private static class ArrayCodec extends Codec {

		protected final int length;
		protected final int bytes;
		protected final int arrayBase;
		protected final Class<?> type;

		private ArrayCodec(Field field, Holders.IntHolder offset, int bytes) {
			super(field, offset);
			this.bytes = bytes;
			ArrayLength al = field.getAnnotation(ArrayLength.class);
			if (al == null) {
				throw new RuntimeException("arrays must have @ArrayLength");
			}
			this.length = al.value();
			this.arrayBase = UNSAFE.arrayBaseOffset(field.getType());
			this.type = field.getType().componentType();
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			Object arr = field.get(structure);
			if (arr == null || Array.getLength(arr) != length) {
				arr = Array.newInstance(type, length);
				field.set(structure, arr);
			}
			NInvoker.transferArray(address(structure), arr, length, 0, bytes, arrayBase);
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			Object arr = field.get(structure);
			if (arr == null) {
				UNSAFE.setMemory(address(structure), (long) bytes * length, (byte) 0);
			} else {
				NInvoker.transferArray(arr, address(structure), length, 0, bytes, arrayBase);
			}
		}

		@Override
		int size() {
			return length * bytes;
		}
	}

	private static class IntCodec extends Codec {


		private IntCodec(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setInt(structure, UNSAFE.getInt(address(structure)));
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putInt(address(structure), field.getInt(structure));
		}

		@Override
		int size() {
			return 4;
		}
	}

	private static class LongCodec extends Codec {


		private LongCodec(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setLong(structure, UNSAFE.getLong(address(structure)));
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putLong(address(structure), field.getLong(structure));
		}

		@Override
		int size() {
			return 8;
		}
	}

	private static class ShortCodec extends Codec {


		private ShortCodec(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setShort(structure, UNSAFE.getShort(address(structure)));
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putShort(address(structure), field.getShort(structure));
		}

		@Override
		int size() {
			return 2;
		}
	}

	private static class ByteCodec extends Codec {

		private ByteCodec(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setByte(structure, UNSAFE.getByte(address(structure)));
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putByte(address(structure), field.getByte(structure));
		}

		@Override
		int size() {
			return 1;
		}
	}

	private static class FloatCodec extends Codec {

		private FloatCodec(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setFloat(structure, UNSAFE.getFloat(address(structure)));
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putFloat(address(structure), field.getFloat(structure));
		}

		@Override
		int size() {
			return 4;
		}
	}

	private static class DoubleCodec extends Codec {

		private DoubleCodec(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void read(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setDouble(structure, UNSAFE.getDouble(address(structure)));
		}

		@Override
		void write(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putDouble(address(structure), field.getDouble(structure));
		}

		@Override
		int size() {
			return 8;
		}
	}
}
