package net.skds.funcode.natives;

import net.skds.lib2.benchmark.Benchmark;
import net.skds.lib2.natives.LinkerUtils;

import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.nio.file.Path;
import java.util.Arrays;

@SuppressWarnings("DataFlowIssue")
public class NativeTester {

	static {
		System.load(Path.of("testjni.dll").toAbsolutePath().toString());
	}

	private static final SymbolLookup LIBRARY = LinkerUtils.library(Path.of("test.dll"));

	private static final MethodHandle test0 = LinkerUtils.createHandleCritical(LIBRARY, "test0", true, LinkerUtils.INT, LinkerUtils.INT);
	private static final MethodHandle test1 = LinkerUtils.createHandleCritical(LIBRARY, "test1", true, LinkerUtils.INT, LinkerUtils.INT);

	private static int test0(int in) {
		try {
			return (int) test0.invokeExact(in);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static native int test0jni(int i);

	private static native int test1jni(int i);

	private static int test1(int in) {
		try {
			return (int) test1.invokeExact(in);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	static void main() {
		int[] kek = new int[7];
		int c = 10_000;

		System.out.println(test0.getClass());
		System.out.println(test1.getClass());


		System.out.println("=========================");

		System.out.println(Benchmark.runSimple(() -> {
			int s = 0;
			for (int i = 0; i < c; i++) {
				s += test0j(i);
			}
			kek[0] = s;
		}));
		System.out.println(Benchmark.runSimple(() -> {
			int s = 0;
			for (int i = 0; i < c; i++) {
				s += test1j(i);
			}
			kek[1] = s;
		}));

		System.out.println("=========================");

		System.out.println(Benchmark.runSimple(() -> {
			int s = 0;
			for (int i = 0; i < c; i++) {
				s += test0(i);
			}
			kek[2] = s;
		}));
		System.out.println(Benchmark.runSimple(() -> {
			int s = 0;
			for (int i = 0; i < c; i++) {
				s += test1(i);
			}
			kek[3] = s;
		}));

		//System.out.println("=========================");
		//System.out.println(Benchmark.runSimple(() -> {
		//	int s = 0;
		//	for (int i = 0; i < c; i++) {
		//		s += test0jni(i);
		//	}
		//	kek[4] = s;
		//}));
		//System.out.println(Benchmark.runSimple(() -> {
		//	int s = 0;
		//	for (int i = 0; i < c; i++) {
		//		s += test1jni(i);
		//	}
		//	kek[5] = s;
		//}));

		System.out.println("=========================");
		System.out.println(Benchmark.runSimple(() -> {
			int s = 0;
			for (int i = 0; i < c; i++) {
				s += (int) System.currentTimeMillis();
			}
			kek[6] = s;
		}));

		System.out.println("=========================");

		System.out.println(Arrays.toString(kek));

	}

	private static int test0j(final int in) {
		return 0;
	}

	private static int test1j(final int in) {
		return in * in ^ 4;
	}
}
