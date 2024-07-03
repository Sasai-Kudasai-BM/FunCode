package net.skds.funcode.neurodebik.ai;

import lombok.Getter;

public class SimpleNet implements ILayer, Cloneable, LayerInput, LayerOutput {

	private final Layer[] layers;
	@Getter
	private final int width;
	private final int inputSize;
	private final int outputSize;
	@Getter
	private final float bias;

	public SimpleNet(int layers, int width, int inputSize, int outputSize, float bias) {
		this.width = width;
		this.inputSize = inputSize;
		this.outputSize = outputSize;
		this.bias = bias;
		this.layers = new Layer[layers];
		Layer first = new Layer(new float[inputSize], new float[width], bias);
		final int l1 = layers - 1;
		this.layers[0] = first;
		for (int i = 1; i < l1; i++) {
			this.layers[i] = first = new Layer(first.outputBuffer(), new float[width], bias);
		}
		this.layers[l1] = new Layer(first.outputBuffer(), new float[outputSize], bias);
	}

	public int getLayers() {
		return layers.length;
	}

	@Override
	public void process() {
		for (int i = 0; i < layers.length; i++) {
			layers[i].process();
			//System.out.println(Arrays.toString(layers[i].outputBuffer()));
		}
		//System.out.println("==========================");
	}

	@Override
	public void mutate(float value) {
		for (int i = 0; i < layers.length; i++) {
			layers[i].mutate(value);
		}
	}

	@Override
	public float[] weights() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void copyWeights(float[] values) {
		throw new UnsupportedOperationException();
	}

	@Override
	public SimpleNet clone() {
		final SimpleNet clone = new SimpleNet(layers.length, width, inputSize, outputSize, bias);
		for (int i = 0; i < layers.length; i++) {
			clone.layers[i].copyWeights(layers[i].weights());
		}
		return clone;
	}

	public void clone(SimpleNet other) {
		for (int i = 0; i < layers.length; i++) {
			layers[i].copyWeights(other.layers[i].weights());
		}
	}

	@Override
	public int outputSize() {
		return outputSize;
	}

	@Override
	public float[] outputBuffer() {
		return layers[layers.length - 1].outputBuffer();
	}

	@Override
	public void setOutputBuffer(float[] buffer) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int inputSize() {
		return inputSize;
	}

	@Override
	public float[] inputBuffer() {
		return layers[0].inputBuffer();
	}

	@Override
	public void setInputBuffer(float[] buffer) {
		throw new UnsupportedOperationException();
	}

	//@Override
	//public void treat(float value) {
	//	for (int i = 0; i < layers.length; i++) {
	//		layers[i].treat(value);
	//	}
	//}
}
