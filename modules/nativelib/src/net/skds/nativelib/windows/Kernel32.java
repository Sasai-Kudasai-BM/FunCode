package net.skds.nativelib.windows;

import java.lang.invoke.MethodHandle;

import static net.skds.ninvoker.NInvoker.*;


@SuppressWarnings("unused")
public final class Kernel32 {

	public static final boolean INITIALIZED = winInit("kernel32");

	private static final MethodHandle getModuleHandle = createWinHandle("GetModuleHandleW", LONG, LONG);

	public static long getModuleHandle(long ptr) {
		try {
			assert getModuleHandle != null;
			return (long) getModuleHandle.invokeExact(ptr);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private Kernel32() {
	}
}
