package net.skds.funcode.soundpad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Settings {

	private String inputName = "Main Mic";
	private String outputName = "CABLE Input";

	private int bits = 18;
	private int channels = 1;
	private int frequency = 48000;
	private int samples = 1024;
}
