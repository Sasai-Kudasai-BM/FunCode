import net.skds.lib2.benchmark.Benchmark;

public class ArraySumTest {

	// 1671944704
	public static void main(String[] args) {

		var b = new Benchmark(1, 1) {
			static final int size = 200_000_000;
			int s;
			final int[] array = new int[size];

			@Override
			protected void prepare() {
				for (int i = 0; i < size; i++) {
					array[i] = (i * (i + 0x1abbbaf6)) ^ i;
				}
			}

			@Override
			protected void bench() {
				//s = Arrays.stream(array).sum();
				s = 0;
				for (int i = 0; i < size; i++) {
					s += array[i];
				}
			}


		};
		b.run();
		System.out.println(b.s);
		System.out.println(b.result());
	}

}
