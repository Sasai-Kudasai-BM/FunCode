package net.skds.nativelib;

import java.lang.invoke.MethodHandle;

import static net.skds.ninvoker.NInvoker.*;

public final class User32 {

	public static final boolean INITIALIZED = winInit("user32");

	private static final MethodHandle getKeyState = createWinHandle("GetKeyState", SHORT, INT);
	private static final MethodHandle getAsyncKeyState = createWinHandle("GetAsyncKeyState", SHORT, INT);

	public static short getKeyState(int key) {
		try {
			return (short) getKeyState.invokeExact(key);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	public static short getAsyncKeyState(int key) {
		try {
			return (short) getAsyncKeyState.invokeExact(key);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private User32() {
	}
}
