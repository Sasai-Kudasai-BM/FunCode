package net.skds.funcode.audio;

import net.skds.lib.mat.ComplexUtils.ComplexFloat;
import net.skds.lib.mat.FastMath;

public class FFT {


	private final ComplexFloat[] omegaTable;

	private final int frCut;
	private final int harmonics;
	private final int N;
	private final int oversamp;
	private final int oversampN;
	final int osN2;
	public final int shift;

	private short[] toEncode0;
	private short[] toEncode1;
	private short[] toEncode2;

	private final ComplexFloat[] decodeBuffer;
	private final ComplexFloat[] encodeBuffer;

	public FFT(int sampleCount, int zeroFreq, int harmonics, int frCutoff) {
		this.N = sampleCount;
		this.oversamp = sampleCount / 2;
		this.oversampN = N + (oversamp * 2);
		this.osN2 = oversampN / 2;
		this.harmonics = harmonics;
		this.shift = Integer.numberOfLeadingZeros(oversampN) + 1;
		this.frCut = Math.min(sampleCount, frCutoff / zeroFreq);

		this.omegaTable = new ComplexFloat[oversampN / 2];

		this.decodeBuffer = new ComplexFloat[oversampN];
		this.encodeBuffer = new ComplexFloat[oversampN];

		for (int i = 0; i < oversampN; i++) {
			decodeBuffer[i] = new ComplexFloat();
			encodeBuffer[i] = new ComplexFloat();
		}

		for (int i = 0; i < osN2; i++) {
			final ComplexFloat omega = omegaTable[i] = new ComplexFloat();
			final float f = 360f * i / oversampN;
			omega.re = FastMath.cos(f);
			omega.im = -FastMath.sin(f);
		}

	}

	private ComplexFloat omega(int k, int n) {
		final int i = oversampN * k / n;

		return omegaTable[i];
	}

	public short[] getNextData() {
		short[] ret = toEncode2;
		if (ret == null) {
			ret = new short[N];
		}
		toEncode2 = toEncode1;
		toEncode1 = toEncode0;
		toEncode0 = ret;
		return ret;
	}

	public void nextData(short[] data) {
		toEncode2 = toEncode1;
		toEncode1 = toEncode0;
		toEncode0 = data;
	}

	public void clearData() {
		toEncode2 = null;
		toEncode1 = null;
		toEncode0 = null;
	}

	public ComplexFloat[] encodeData() {
		if (toEncode0 == null || toEncode1 == null || toEncode2 == null) {
			return null;
		}
		long t = System.nanoTime();
		ComplexFloat o = new ComplexFloat();
		ComplexFloat e = new ComplexFloat();

		for (int k = 0; k < oversamp; k++) {
			encodeBuffer[k].set((float) toEncode2[N - oversamp + k] / Short.MAX_VALUE);
		}
		for (int k = 0; k < N; k++) {
			encodeBuffer[k + oversamp].set((float) toEncode1[k] / Short.MAX_VALUE);
		}
		for (int k = 0; k < oversamp; k++) {
			encodeBuffer[k + oversamp + N].set((float) toEncode0[k] / Short.MAX_VALUE);
		}

		for (int n = oversampN; n >= 2; n /= 2) {
			final int n2 = n / 2;

			for (int c = 0; c < osN2; c++) {
				final int k = c + ((2 * c / n) * n) / 2;

				e.set(encodeBuffer[k]);
				o.set(encodeBuffer[k + n2]);
				ComplexFloat r = encodeBuffer[k];
				ComplexFloat r2 = encodeBuffer[k + n2];

				r.set(e);
				r2.set(e);

				r.add(o);
				r2.sub(o);

				if (n != 2) {
					r2.mul(omega(c % n2, n));
				}

			}
		}

		//ComplexFloatWithID[] compactBuffer = Arrays.copyOf(encodeBuffer, encodeBuffer.length);
		ComplexFloat[] compactBuffer = encodeBuffer.clone();

		//Arrays.sort(compactBuffer, (p1, p2) -> {
		//	return p1.id - p2.id;
		//});
		//todo


		return compactBuffer;
	}

	public short[] decode(final ComplexFloat[] in) {
		long t = System.nanoTime();

		short[] result = new short[N];

		for (int k = 0; k < oversampN; k++) {
			decodeBuffer[k].reset();
		}
		//todo


		ComplexFloat o = new ComplexFloat();
		ComplexFloat e = new ComplexFloat();
		for (int n = oversampN; n >= 2; n /= 2) {
			final int n2 = n / 2;

			for (int c = 0; c < osN2; c++) {
				final int k = c + ((2 * c / n) * n) / 2;

				e.set(decodeBuffer[k]);
				o.set(decodeBuffer[k + n2]);
				ComplexFloat r = decodeBuffer[k];
				ComplexFloat r2 = decodeBuffer[k + n2];

				r.set(e);
				r2.set(e);

				r.add(o);
				r2.sub(o);

				r2.mulRev(omega(c % n2, n));

			}

		}

		for (int i = oversamp; i < N + oversamp; i++) {
			var comp = decodeBuffer[(Integer.reverse(i) >>> shift)];
			result[i - oversamp] = (short) (comp.re / N * Short.MAX_VALUE);
		}

		System.out.println("d " + (System.nanoTime() - t) / 1000000d);
		return result;
	}
}
