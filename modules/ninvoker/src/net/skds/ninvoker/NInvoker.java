package net.skds.ninvoker;

import net.skds.lib.utils.SKDSUtils;
import sun.awt.AWTAccessor;
import sun.awt.windows.WComponentPeer;

import java.awt.*;
import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/*
--add-exports
java.base/jdk.internal.misc=ALL-UNNAMED
--add-exports
java.desktop/sun.awt=ALL-UNNAMED
--add-exports
java.desktop/sun.awt.windows=ALL-UNNAMED
--enable-native-access=ALL-UNNAMED
 */
public final class NInvoker {

	private static final jdk.internal.misc.Unsafe UNSAFE = jdk.internal.misc.Unsafe.getUnsafe();

	public static final boolean NATIVE_ORDER = ByteOrder.BIG_ENDIAN == ByteOrder.nativeOrder();
	public static final Linker LINKER = Linker.nativeLinker();
	public static final SymbolLookup SYMBOL_LOOKUP = SymbolLookup.loaderLookup();
	public static final MethodHandles.Lookup METHOD_LOOKUP = MethodHandles.lookup();

	public static final MemoryLayout BYTE = ValueLayout.JAVA_BYTE;
	public static final MemoryLayout SHORT = ValueLayout.JAVA_SHORT;
	public static final MemoryLayout INT = ValueLayout.JAVA_INT;
	public static final MemoryLayout LONG = ValueLayout.JAVA_LONG;
	public static final MemoryLayout FLOAT = ValueLayout.JAVA_FLOAT;
	public static final MemoryLayout DOUBLE = ValueLayout.JAVA_DOUBLE;
	public static final MemoryLayout VOID = null;

	public static final TypeGlue G_BYTE = new TypeGlue(ValueLayout.JAVA_BYTE, byte.class);
	public static final TypeGlue G_SHORT = new TypeGlue(ValueLayout.JAVA_SHORT, short.class);
	public static final TypeGlue G_INT = new TypeGlue(ValueLayout.JAVA_INT, int.class);
	public static final TypeGlue G_LONG = new TypeGlue(ValueLayout.JAVA_LONG, long.class);
	public static final TypeGlue G_FLOAT = new TypeGlue(ValueLayout.JAVA_FLOAT, float.class);
	public static final TypeGlue G_DOUBLE = new TypeGlue(ValueLayout.JAVA_DOUBLE, double.class);
	public static final TypeGlue G_VOID = new TypeGlue(null, void.class);

	public static final int BYTE_ARRAY_BASE = UNSAFE.arrayBaseOffset(byte[].class);
	public static final int CHAR_ARRAY_BASE = UNSAFE.arrayBaseOffset(char[].class);
	public static final int SHORT_ARRAY_BASE = UNSAFE.arrayBaseOffset(short[].class);
	public static final int INT_ARRAY_BASE = UNSAFE.arrayBaseOffset(int[].class);
	public static final int FLOAT_ARRAY_BASE = UNSAFE.arrayBaseOffset(float[].class);
	public static final int LONG_ARRAY_BASE = UNSAFE.arrayBaseOffset(long[].class);
	public static final int DOUBLE_ARRAY_BASE = UNSAFE.arrayBaseOffset(double[].class);

	public static void transferArray(long src, byte[] dst, int size, int offset) {
		UNSAFE.copyMemory(src, 0, dst, offset + BYTE_ARRAY_BASE, size);
	}

	public static void transferArray(long src, Object dst, long size, long offset, int byteSize, int arrayOffset) {
		if (NATIVE_ORDER || byteSize == 1) {
			UNSAFE.copyMemory(src, 0, dst, offset * byteSize + arrayOffset, size * byteSize);
		} else {
			UNSAFE.copySwapMemory(src, 0, dst, offset, size * byteSize, byteSize);
		}
	}

	public static void transferArray(long src, short[] dst, int size, int offset) {
		transferArray(src, dst, size, offset, 2, SHORT_ARRAY_BASE);
	}

	public static void transferArray(long src, char[] dst, int size, int offset) {
		transferArray(src, dst, size, offset, 2, CHAR_ARRAY_BASE);
	}

	public static void transferArray(long src, int[] dst, int size, int offset) {
		transferArray(src, dst, size, offset, 4, INT_ARRAY_BASE);
	}

	public static void transferArray(long src, float[] dst, int size, int offset) {
		transferArray(src, dst, size, offset, 4, FLOAT_ARRAY_BASE);
	}

	public static void transferArray(long src, long[] dst, int size, int offset) {
		transferArray(src, dst, size, offset, 8, LONG_ARRAY_BASE);
	}

	public static void transferArray(long src, double[] dst, int size, int offset) {
		transferArray(src, dst, size, offset, 8, DOUBLE_ARRAY_BASE);
	}

	public static void transferArray(byte[] src, long dst, int size, int offset) {
		UNSAFE.copyMemory(src, offset + BYTE_ARRAY_BASE, null, dst, size);
	}

	public static void transferArray(Object src, long dst, long size, long offset, int byteSize, int arrayOffset) {
		if (NATIVE_ORDER || byteSize == 1) {
			UNSAFE.copyMemory(src, offset * byteSize + arrayOffset, null, dst, size * byteSize);
		} else {
			UNSAFE.copySwapMemory(src, offset * byteSize + arrayOffset, null, dst, size * byteSize, byteSize);
		}
	}

	public static void transferArray(short[] src, long dst, int size, int offset) {
		transferArray(src, dst, size, offset, 2, SHORT_ARRAY_BASE);
	}

	public static void transferArray(char[] src, long dst, int size, int offset) {
		transferArray(src, dst, size, offset, 2, CHAR_ARRAY_BASE);
	}

	public static void transferArray(int[] src, long dst, int size, int offset) {
		transferArray(src, dst, size, offset, 4, INT_ARRAY_BASE);
	}

	public static void transferArray(float[] src, long dst, int size, int offset) {
		transferArray(src, dst, size, offset, 4, FLOAT_ARRAY_BASE);
	}

	public static void transferArray(long[] src, long dst, int size, int offset) {
		transferArray(src, dst, size, offset, 8, LONG_ARRAY_BASE);
	}

	public static void transferArray(double[] src, long dst, int size, int offset) {
		transferArray(src, dst, size, offset, 8, DOUBLE_ARRAY_BASE);
	}

	public static <T> UpcallLink<T> createUpcallLink(Class<T> clazz, String name, TypeGlue returnType, TypeGlue... argTypes) {
		MethodHandle handle;
		try {
			handle = METHOD_LOOKUP.findVirtual(clazz, name, MethodType.methodType(returnType.jType, jArray(argTypes)));
		} catch (NoSuchMethodException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return new UpcallLink<>(fd(returnType, argTypes), handle);
	}

	public static FunctionDescriptor fd(TypeGlue returnType, TypeGlue[] argTypes) {
		return returnType.nType == null ? FunctionDescriptor.ofVoid(nArray(argTypes)) : FunctionDescriptor.of(returnType.nType, nArray(argTypes));
	}

	public static FunctionDescriptor fd(MemoryLayout returnType, MemoryLayout[] argTypes) {
		return returnType == null ? FunctionDescriptor.ofVoid(argTypes) : FunctionDescriptor.of(returnType, argTypes);
	}

	public static MethodHandle createHandle(String name, MemoryLayout returnType, MemoryLayout... arguments) {
		return LINKER.downcallHandle(
				SYMBOL_LOOKUP.find(name).orElseThrow(),
				fd(returnType, arguments)
		);
	}


	public static MethodHandle createWinHandle(String name, MemoryLayout returnType, MemoryLayout... arguments) {
		if (SKDSUtils.OS_TYPE != SKDSUtils.OSType.WINDOWS) {
			return null;
		}
		return createHandle(name, returnType, arguments);
	}

	public static boolean winInit(String libName) {
		if (SKDSUtils.OS_TYPE != SKDSUtils.OSType.WINDOWS) {
			return false;
		}
		System.loadLibrary(libName);
		return true;
	}

	public static String nullTerminatedString(byte[] data, Charset charset) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 0) {
				return new String(data, 0, i, charset);
			}
		}
		return new String(data, charset);
	}

	public static long getHWnd(Window window) {
		final AWTAccessor.ComponentAccessor acc = AWTAccessor.getComponentAccessor();
		long hWnd = acc.<WComponentPeer>getPeer(window).getHWnd();
		return hWnd;
	}

	private static Class<?>[] jArray(TypeGlue[] gt) {
		final Class<?>[] arr = new Class<?>[gt.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = gt[i].jType;
		}
		return arr;
	}

	private static ValueLayout[] nArray(TypeGlue[] gt) {
		final ValueLayout[] arr = new ValueLayout[gt.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = gt[i].nType;
		}
		return arr;
	}

	public static final class TypeGlue {
		private final ValueLayout nType;
		private final Class<?> jType;

		private TypeGlue(ValueLayout nType, Class<?> jType) {
			this.nType = nType;
			this.jType = jType;
		}
	}

	private NInvoker() {
	}
}
