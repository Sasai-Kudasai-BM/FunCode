package net.skds.funcode.camera;

import lombok.experimental.UtilityClass;

/**
 * @noinspection unused
 */
@UtilityClass
public class WinError {

	public static final int S_OK = 0x00000000;
	public static final int E_NOTIMPL = 0x80004001;
	public static final int E_NOINTERFACE = 0x80004002;
	public static final int E_POINTER = 0x80004003;
	public static final int E_ABORT = 0x80004004;
	public static final int E_FAIL = 0x80004005;
	public static final int E_UNEXPECTED = 0x8000FFFF;
	public static final int E_ACCESSDENIED = 0x80070005;
	public static final int E_HANDLE = 0x80070006;
	public static final int E_OUTOFMEMORY = 0x8007000E;
	public static final int E_INVALIDARG = 0x80070057;

	public static String getErr(int code) {
		return switch (code) {
			case S_OK -> "S_OK";
			case E_NOTIMPL -> "E_NOTIMPL";
			case E_NOINTERFACE -> "E_NOINTERFACE";
			case E_POINTER -> "E_POINTER";
			case E_ABORT -> "E_ABORT";
			case E_FAIL -> "E_FAIL";
			case E_UNEXPECTED -> "E_UNEXPECTED";
			case E_ACCESSDENIED -> "E_ACCESSDENIED";
			case E_HANDLE -> "E_HANDLE";
			case E_OUTOFMEMORY -> "E_OUTOFMEMORY";
			case E_INVALIDARG -> "E_INVALIDARG";
			default -> "UNKNOWN " + code;
		};
	}
}
