package net.skds.funcode.neurodebik.ai;

public interface LayerOutput {

	int inputSize();

	float[] inputBuffer();
	
	void setInputBuffer(float[] buffer);
}
