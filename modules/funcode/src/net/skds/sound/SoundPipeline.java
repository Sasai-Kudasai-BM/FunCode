package net.skds.sound;

public interface SoundPipeline {

	int sampleSize();

	void process(float[] inputBuffer, float[] outputBuffer);

	interface Stage {

		void process(float[] inputBuffer, float[] outputBuffer);

		int inputSize(int sampleSize);

		int outputSize(int sampleSize);

	}
}
