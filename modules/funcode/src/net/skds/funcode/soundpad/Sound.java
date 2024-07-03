package net.skds.funcode.soundpad;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Sound {

	public final String name;
	public final byte[] data;

	public Sound(File file, AudioFormat af) throws Exception {
		this.name = file.getName();
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
		inputStream = AudioSystem.getAudioInputStream(af, inputStream);
		data = inputStream.readAllBytes();
	}
}
