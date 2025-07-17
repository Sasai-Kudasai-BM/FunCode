package net.skds.jvk.test;

import net.skds.lib2.benchmark.Benchmark;
import net.skds.lib2.mat.ByteArrayPrimitiveOperations;
import net.skds.lib2.mat.NativeByteArrayOperations;
import net.skds.lib2.natives.MemoryAccess;
import net.skds.lib2.utils.logger.SKDSLogger;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class JVKBaseTest {

	public static void main(String[] args) {

		SKDSLogger.replaceOuts();

		//System.out.println(VKDefinitions.getErr(VK10.vkCreateInstance(0, 0, 0)));
		bench();

	}

	static void bench() {

		int size = 1024 * 10;
		int loops = 1024 * 100;

		var b1 = new Benchmark(loops, loops) {
			byte[] array;

			@Override
			protected void prepare() {
				array = new byte[size * 8];
			}

			@Override
			protected void bench() {
				for (int i = 0; i < size; i++) {
					ByteArrayPrimitiveOperations.setInt(array, i * 8, i);
				}
			}
		};
		var b2 = new Benchmark(loops, loops) {
			IntBuffer buffer;

			@Override
			protected void prepare() {
				buffer = ByteBuffer.allocateDirect(size * 8).asIntBuffer();
			}

			@Override
			protected void bench() {
				for (int i = 0; i < size; i++) {
					buffer.put(i * 2, i);
				}
			}
		};
		Arena arena = Arena.ofAuto();
		var b3 = new Benchmark(loops, loops) {
			MemorySegment ms;

			@Override
			protected void prepare() {
				ms = arena.allocate(size * 8);
			}

			@Override
			protected void bench() {
				for (int i = 0; i < size; i++) {
					MemoryAccess.setInt(ms, i * 8, i);
				}
			}
		};
		var b4 = new Benchmark(loops, loops) {
			MemorySegment ms;
			byte[] array;

			@Override
			protected void prepare() {
				ms = arena.allocate(size * 8);
				array = new byte[size * 8];
			}

			@Override
			protected void bench() {
				for (int i = 0; i < size; i++) {
					NativeByteArrayOperations.setInt(array, i * 8, i);
				}
				MemorySegment.copy(array, 0, ms, ValueLayout.JAVA_BYTE.withOrder(ByteOrder.nativeOrder()), 0, size * 8);
			}
		};
		b1.run();
		b2.run();
		b3.run();
		b4.run();
		System.out.println(b1.result());
		System.out.println(b2.result());
		System.out.println(b3.result());
		System.out.println(b4.result());
	}
}
