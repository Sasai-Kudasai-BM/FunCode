package net.skds.nativelib.system;

import net.skds.lib.unsafe.UnsafeAnal;
import sun.misc.Unsafe;

import java.lang.invoke.MethodHandle;

import static net.skds.ninvoker.NInvoker.*;

/**
 * Type                        | S/U | x86    | x64
 * ----------------------------+-----+--------+-------
 * BYTE, BOOLEAN               | U   | 8 bit  | 8 bit
 * ----------------------------+-----+--------+-------
 * SHORT                       | S   | 16 bit | 16 bit
 * USHORT, WORD                | U   | 16 bit | 16 bit
 * ----------------------------+-----+--------+-------
 * INT, LONG                   | S   | 32 bit | 32 bit
 * UINT, ULONG, DWORD          | U   | 32 bit | 32 bit
 * ----------------------------+-----+--------+-------
 * INT_PTR, LONG_PTR, LPARAM   | S   | 32 bit | 64 bit
 * UINT_PTR, ULONG_PTR, WPARAM | U   | 32 bit | 64 bit
 * ----------------------------+-----+--------+-------
 * LONGLONG                    | S   | 64 bit | 64 bit
 * ULONGLONG, QWORD            | U   | 64 bit | 64 bit
 */
class WinSys implements SystemMethods {

	private static final Unsafe unsafe = UnsafeAnal.UNSAFE;

	private final MethodHandle getCursorPos;

	WinSys() {
		winInit("user32");
		getCursorPos = createWinHandle("GetCursorPos", BOOLEAN, LONG);
	}

	//int GetMouseMovePointsEx(
	//  [in]  UINT             cbSize,
	//  [in]  LPMOUSEMOVEPOINT lppt,
	//  [out] LPMOUSEMOVEPOINT lpptBuf,
	//  [in]  int              nBufPoints,
	//  [in]  DWORD            resolution
	//);

	//typedef struct tagMOUSEMOVEPOINT {
	//  int       x;
	//  int       y;
	//  DWORD     time;
	//  ULONG_PTR dwExtraInfo;
	//} MOUSEMOVEPOINT, *PMOUSEMOVEPOINT, *LPMOUSEMOVEPOINT;
	@Override
	public void getMousePosition(double[] pos) {
		// BOOL GetCursorPos([out] LPPOINT lpPoint);

		if (pos == null || pos.length < 2) throw new IllegalArgumentException();
		long adr = unsafe.allocateMemory(8);
		try {
			assert getCursorPos != null;
			boolean b = (boolean) getCursorPos.invokeExact(adr);
			if (b) {
				//UnsafeAnal.transferArray(adr, pos, 2, 0);

				int[] pnt = new int[2];
				UnsafeAnal.transferArray(adr, pnt, 2, 0);
				pos[0] = pnt[0];
				pos[1] = pnt[1];
				System.out.println("============");
				System.out.println(Integer.toUnsignedString(pnt[0], 16));
				System.out.println(Integer.toUnsignedString(pnt[1], 16));
			}

		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			unsafe.freeMemory(adr);
		}

	}
}
