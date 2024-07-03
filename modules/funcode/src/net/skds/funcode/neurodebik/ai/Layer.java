package net.skds.funcode.neurodebik.ai;

import net.skds.lib.mat.FastMath;
import net.skds.lib.utils.ArrayUtils;

public class Layer implements ILayer, LayerOutput, LayerInput, Cloneable {

	private final float bias;

	private final int inputSize;
	private final int outputSize;

	private float[] outputBuffer;
	private float[] inputBuffer;

	private final float[] weights;
	//private final float[] lastMod;

	public Layer(float[] inputBuffer, float[] outputBuffer, float bias) {
		this(inputBuffer.length, outputBuffer.length, bias);
		setOutputBuffer(outputBuffer);
		setInputBuffer(inputBuffer);
	}

	public Layer(int inputBufferSize, int outputBufferSize, float bias) {
		this.bias = bias;
		this.inputSize = inputBufferSize;
		this.outputSize = outputBufferSize;

		this.weights = new float[inputBufferSize * outputBufferSize];
	}

	@Override
	public void process() {
		for (int o = 0; o < outputSize; o++) {
			float s = 0;
			for (int i = 0; i < inputSize; i++) {
				s += inputBuffer[i] * weights[weightIndex(i, o)];
			}
			if (s < bias) {
				s = 0;
			} else if (s > 1) {
				s = 1;
			}
			outputBuffer[o] = s;
		}
		//System.out.println(inputBuffer);
	}

	//@Override
	//public void treat(final float value) {
	//	for (int i = 0; i < lastMod.length; i++) {
	//		lastMod[i] *= value;
	//	}
	//}

	@Override
	public void mutate(final float value) {
		for (int i = 0; i < weights.length; i++) {
			//final float last = lastMod[i];
			final float n = (FastMath.RANDOM.nextFloat() - .5f) * value;
			//lastMod[i] = n;
			//weights[i] += last + n;
			weights[i] += n;
		}
	}

	@Override
	public float[] weights() {
		return weights;
	}

	@Override
	public void copyWeights(float[] values) {
		ArrayUtils.copySameSize(values, weights, weights.length);
	}

	private int weightIndex(final int i, final int o) {
		return i * outputSize + o;
	}

	@Override
	public int outputSize() {
		return outputSize;
	}

	@Override
	public float[] outputBuffer() {
		return outputBuffer;
	}

	@Override
	public void setOutputBuffer(float[] buffer) {
		this.outputBuffer = buffer;
	}

	@Override
	public int inputSize() {
		return inputSize;
	}

	@Override
	public float[] inputBuffer() {
		return inputBuffer;
	}

	@Override
	public void setInputBuffer(float[] buffer) {
		this.inputBuffer = buffer;
	}

	@Override
	public Layer clone() {
		Layer clone = new Layer(inputSize, outputSize, bias);
		ArrayUtils.copySameSize(weights, clone.weights, weights.length);
		return clone;
	}
}
