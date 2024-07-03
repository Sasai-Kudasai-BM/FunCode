package net.skds.funcode.neurodebik.ai;

public interface LayerInput {

	int outputSize();

	float[] outputBuffer();

	void setOutputBuffer(float[] buffer);
}
