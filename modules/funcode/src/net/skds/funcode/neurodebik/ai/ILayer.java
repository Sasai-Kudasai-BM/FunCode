package net.skds.funcode.neurodebik.ai;

public interface ILayer {// extends LayerInput, LayerOutput {

	void process();

	//void treat(float value);

	void mutate(float value);

	float[] weights();

	void copyWeights(float[] values);
}
