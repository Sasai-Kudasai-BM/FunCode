package net.skds.ninvoker.struct;

import net.skds.lib2.unsafe.MemoryStack;
import net.skds.lib2.unsafe.UnsafeAnal;
import net.skds.lib2.utils.Holders;
import sun.misc.Unsafe;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class NativeStructureWrapper {

	//private static final Cleaner CLEANER = Cleaner.create();
	private static final Unsafe UNSAFE = UnsafeAnal.UNSAFE;
	//private static final boolean swapByteOrder = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;


	private final Class<? extends AbstractNativeStructure> type;
	private final Adapter[] fields;
	public final int size;
	final int arrayPadding;
	private final Supplier<? extends AbstractNativeStructure> constructor;

	public NativeStructureWrapper(Class<? extends AbstractNativeStructure> type) {
		this.type = type;
		try {
			Constructor<?> c = type.getConstructor();
			this.constructor = () -> {
				try {
					return (AbstractNativeStructure) c.newInstance();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			};
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
		//this.useCleaner = useCleaner;
		Holders.IntHolder size = new Holders.IntHolder();
		this.fields = Stream.of(type.getDeclaredFields())
				.filter(f -> (f.getModifiers() & (Modifier.TRANSIENT | Modifier.STATIC)) == 0)
				.map(f -> {
							Class<?> c = f.getType();
							if (c.isPrimitive()) {
								if (c == int.class) {
									return new IntAdapter(f, size);
								} else if (c == long.class) {
									return new LongAdapter(f, size);
								} else if (c == byte.class) {
									return new ByteAdapter(f, size);
								} else if (c == short.class) {
									return new ShortAdapter(f, size);
								} else if (c == float.class) {
									return new FloatAdapter(f, size);
								} else if (c == double.class) {
									return new DoubleAdapter(f, size);
								}

							} else if (c.isArray()) {
								if (c == int[].class) {
									return new ArrayAdapter(f, size, 4);
								} else if (c == long[].class) {
									return new ArrayAdapter(f, size, 8);
								} else if (c == byte[].class) {
									return new ArrayAdapter(f, size, 1);
								} else if (c == short[].class) {
									return new ArrayAdapter(f, size, 2);
								} else if (c == float[].class) {
									return new ArrayAdapter(f, size, 4);
								} else if (c == double[].class) {
									return new ArrayAdapter(f, size, 8);
								} else if (NativeData.class.isAssignableFrom(c.componentType())) {
									return new StructArrayAdapter(f, size);
								}
							} else if (AbstractNativeStructure.class.isAssignableFrom(c)) {
								return new StructAdapter(f, size);
							}

							throw new IllegalArgumentException("Class \"" + type + "\" has field \"" + f.getName() + "\" of invalid type \"" + c + "\"");
						}
				)
				.peek(c -> size.increment(c.alignedSize()))
				.toArray(Adapter[]::new);
		this.size = size.getValue();

		if (fields.length > 0) {
			arrayPadding = align(fields[0].alignment(), this.size);
		} else {
			arrayPadding = 0;
		}
	}

	public void get(AbstractNativeStructure structure) {
		try {
			for (int i = 0; i < fields.length; i++) {
				fields[i].get(structure);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void put(AbstractNativeStructure structure) {
		try {
			for (int i = 0; i < fields.length; i++) {
				fields[i].put(structure);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractNativeStructure> T[] allocArray(int len) {
		T[] arr = (T[]) Array.newInstance(type, len);
		long address = UNSAFE.allocateMemory((long) size * len);
		for (int i = 0; i < len; i++) {
			T struct = (T) constructor.get();
			arr[i] = struct;
			struct.address = (long) size * i + address;
		}
		return arr;
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractNativeStructure> T[] allocArray(int len, MemoryStack stack) {
		T[] arr = (T[]) Array.newInstance(type, len);
		long address = stack.pushSize(size * len);
		for (int i = 0; i < len; i++) {
			T struct = (T) constructor.get();
			arr[i] = struct;
			struct.address = (long) (size + arrayPadding) * i + address;
		}
		return arr;
	}

	@SuppressWarnings("unchecked")
	public <T extends AbstractNativeStructure> long allocArray(T[] array, MemoryStack stack) {
		long address = stack.pushSize(size * array.length);
		for (int i = 0; i < array.length; i++) {
			T struct = (T) constructor.get();
			array[i] = struct;
			struct.address = (long) (size + arrayPadding) * i + address;
		}
		return address;
	}

	public long alloc(AbstractNativeStructure structure) {
		long address = UNSAFE.allocateMemory(size);
		structure.address = address;
		return address;
	}

	public long alloc(AbstractNativeStructure structure, MemoryStack stack) {
		long address = stack.pushSize(size);
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

	static int align(int alignment, int pos) {
		if (alignment == 0) return 0;
		int mod = pos % alignment;
		return mod == 0 ? 0 : alignment - mod;
	}

	private abstract static class Adapter {

		protected final Field field;
		protected int offset;
		protected int alignPadding;

		private Adapter(Field field, Holders.IntHolder offset, int alignment) {
			this.field = field;
			realign(offset, alignment);
			field.setAccessible(true);
		}

		private Adapter(Field field, Holders.IntHolder offset) {
			this.field = field;
			realign(offset, alignment());
			field.setAccessible(true);
		}

		protected void realign(Holders.IntHolder offset, int alignment) {
			this.alignPadding = align(alignment, offset.getValue());
			this.offset = offset.getValue() + alignPadding;
		}

		protected long address(AbstractNativeStructure structure) {
			return structure.address + offset;
		}

		abstract void get(AbstractNativeStructure structure) throws IllegalAccessException;

		abstract void put(AbstractNativeStructure structure) throws IllegalAccessException;

		abstract int size();

		int alignedSize() {
			return alignPadding + size();
		}

		int alignment() {
			return size();
		}
	}

	private static class StructAdapter extends Adapter {

		private final Supplier<NativeData> constructor;
		private final int size;
		private final int zeroEAlign;

		@SuppressWarnings("unchecked")
		private StructAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
			try {
				DataClass dc = field.getAnnotation(DataClass.class);
				Class<?> c = (dc == null) ? field.getType() : dc.value();
				var cns = (Constructor<NativeData>) c.getConstructor();
				this.constructor = () -> {
					try {
						return cns.newInstance();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				};
				NativeStructureWrapper wrapper = ((AbstractNativeStructure) constructor.get()).getWrapper();
				this.size = wrapper.size;
				if (wrapper.fields.length > 0) {
					zeroEAlign = wrapper.fields[0].alignment();
					realign(offset, zeroEAlign);
				} else {
					zeroEAlign = 1;
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			NativeData nd = (NativeData) field.get(structure);
			if (nd == null) {
				nd = constructor.get();
				field.set(structure, nd);
			}
			nd.delegate(address(structure));
			nd.get();
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			NativeData nd = (NativeData) field.get(structure);
			if (nd != null) {
				nd.delegate(address(structure));
				nd.put();
			}
		}

		@Override
		int size() {
			return size;
		}

		@Override
		int alignment() {
			return zeroEAlign;
		}
	}

	private static class StructArrayAdapter extends Adapter {

		private final Supplier<AbstractNativeStructure> constructor;
		private final int elementSize;
		private final int size;
		private final int extraSize;
		private final int length;
		private final Class<?> type;
		private final int zeroEAlign;

		@SuppressWarnings("unchecked")
		private StructArrayAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
			try {
				ArrayLength al = field.getAnnotation(ArrayLength.class);
				if (al == null) {
					throw new RuntimeException("arrays must have @ArrayLength");
				}
				this.length = al.value();
				DataClass dc = field.getAnnotation(DataClass.class);
				this.type = (dc == null) ? field.getType().componentType() : dc.value();
				var cns = (Constructor<AbstractNativeStructure>) type.getConstructor();
				this.constructor = () -> {
					try {
						return cns.newInstance();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				};
				NativeStructureWrapper wrapper = constructor.get().getWrapper();
				if (wrapper.fields.length > 0) {
					this.zeroEAlign = wrapper.fields[0].alignment();
					realign(offset, zeroEAlign);
					this.extraSize = align(zeroEAlign, wrapper.size);
				} else {
					this.zeroEAlign = 1;
					this.extraSize = 0;
				}
				this.elementSize = wrapper.size;
				this.size = wrapper.size * length + alignPadding;


			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		int alignedSize() {
			return this.size;
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			Object array = field.get(structure);
			if (array == null) {
				array = Array.newInstance(type, length);
				field.set(structure, array);
			}
			for (int i = 0; i < length; i++) {
				NativeData nd = (NativeData) Array.get(array, i);
				if (nd == null) {
					nd = constructor.get();
					Array.set(array, i, nd);
				}
				nd.delegate(address(structure) + (long) (elementSize + extraSize) * i);
				nd.get();
			}
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			Object array = field.get(structure);
			if (array == null) {
				return;
			}
			for (int i = 0; i < length; i++) {
				NativeData nd = (NativeData) Array.get(array, i);
				if (nd != null) {
					nd.delegate(address(structure) + (long) (elementSize + extraSize) * i);
					nd.put();
				}
			}
		}

		@Override
		int size() {
			return size;
		}

		@Override
		int alignment() {
			return zeroEAlign;
		}
	}

	private static class ArrayAdapter extends Adapter {

		protected final int length;
		protected final int bytes;
		protected final int arrayBase;
		protected final Class<?> type;

		private ArrayAdapter(Field field, Holders.IntHolder offset, int bytes) {
			super(field, offset, bytes);
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
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			Object arr = field.get(structure);
			if (arr == null || Array.getLength(arr) != length) {
				arr = Array.newInstance(type, length);
				field.set(structure, arr);
			}
			UnsafeAnal.transferArray(address(structure), arr, length, 0, bytes, arrayBase);
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			Object arr = field.get(structure);
			if (arr == null) {
				UNSAFE.setMemory(address(structure), (long) bytes * length, (byte) 0);
			} else {
				UnsafeAnal.transferArray(arr, address(structure), length, 0, bytes, arrayBase);
			}
		}

		@Override
		int size() {
			return length * bytes;
		}

		@Override
		int alignment() {
			return bytes;
		}
	}

	private static class IntAdapter extends Adapter {


		private IntAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setInt(structure, UNSAFE.getInt(address(structure)));
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putInt(address(structure), field.getInt(structure));
		}

		@Override
		int size() {
			return 4;
		}
	}

	private static class LongAdapter extends Adapter {


		private LongAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setLong(structure, UNSAFE.getLong(address(structure)));
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putLong(address(structure), field.getLong(structure));
		}

		@Override
		int size() {
			return 8;
		}
	}

	private static class ShortAdapter extends Adapter {


		private ShortAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setShort(structure, UNSAFE.getShort(address(structure)));
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putShort(address(structure), field.getShort(structure));
		}

		@Override
		int size() {
			return 2;
		}
	}

	private static class ByteAdapter extends Adapter {

		private ByteAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setByte(structure, UNSAFE.getByte(address(structure)));
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putByte(address(structure), field.getByte(structure));
		}

		@Override
		int size() {
			return 1;
		}
	}

	private static class FloatAdapter extends Adapter {

		private FloatAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setFloat(structure, UNSAFE.getFloat(address(structure)));
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putFloat(address(structure), field.getFloat(structure));
		}

		@Override
		int size() {
			return 4;
		}
	}

	private static class DoubleAdapter extends Adapter {

		private DoubleAdapter(Field field, Holders.IntHolder offset) {
			super(field, offset);
		}

		@Override
		void get(AbstractNativeStructure structure) throws IllegalAccessException {
			field.setDouble(structure, UNSAFE.getDouble(address(structure)));
		}

		@Override
		void put(AbstractNativeStructure structure) throws IllegalAccessException {
			UNSAFE.putDouble(address(structure), field.getDouble(structure));
		}

		@Override
		int size() {
			return 8;
		}
	}
}
