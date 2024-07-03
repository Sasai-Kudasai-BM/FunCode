package net.skds.nativelib;

import java.lang.invoke.MethodHandle;

import static net.skds.ninvoker.NInvoker.*;


public final class Kernel32 {

	public static final boolean INITIALIZED = winInit("kernel32");

	private static final MethodHandle getModuleHandle = createWinHandle("GetModuleHandleW", LONG, LONG);

	public static long getModuleHandle(long ptr) {
		try {
			return (long) getModuleHandle.invokeExact(ptr);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private Kernel32() {
	}
}
