package net.skds.funcode.audio;

import net.skds.lib.mat.FastMath;

import javax.sound.sampled.*;

public class AudioMain {

	public static void main(String[] args) throws LineUnavailableException {

		Mixer mixer = null;
		Mixer mixer2 = null;
		for (Mixer.Info info : AudioSystem.getMixerInfo()) {
			System.out.println(info);
			System.out.println(info.getClass());


			if (info.getName().startsWith("CABLE Input")) {
				mixer = AudioSystem.getMixer(info);
				//break;
			}
			if (info.getName().startsWith("CABLE Output")) {
				mixer2 = AudioSystem.getMixer(info);
				//break;
			}


		}
		System.out.println("==============================");


		final byte[] data = new byte[1024 * 1024];
		for (int i = 0; i < data.length; i += 2) {
			data[i] = (byte) FastMath.RANDOM.nextInt();
		}
		//AudioFormat af = new AudioFormat(44100, 16, 1, true, false);
		AudioFormat af = new AudioFormat(44100, 16, 1, true, false);
		DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, af);
		DataLine.Info dataLineInfo2 = new DataLine.Info(TargetDataLine.class, af);


		//SourceDataLine sdl = (SourceDataLine) mixer.getLine(dataLineInfo);//;AudioSystem.getLine(dataLineInfo);
		//sdl.open();
		//sdl.start();
		//sdl.write(data, 0, data.length);
		//sdl.close();

		//System.out.println(mixer2.getMaxLines(dataLineInfo));
		//System.out.println(mixer2.getMaxLines(dataLineInfo2));

		SourceDataLine sdl2 = (SourceDataLine) mixer2.getLine(dataLineInfo);//;AudioSystem.getLine(dataLineInfo);
		sdl2.open();
		sdl2.start();
		sdl2.write(data, 0, data.length);
		sdl2.close();

		//try (TargetDataLine tdl = AudioSystem.getTargetDataLine(af)) {
		/*
		try (TargetDataLine tdl = AudioSystem.getTargetDataLine(af)) {
			System.out.println(tdl);
			tdl.open();
			tdl.start();


			tdl.read(data, 0, data.length);
			System.out.println(tdl.isOpen());
			System.out.println(tdl.isActive());
			System.out.println(tdl.isRunning());
			System.out.println(tdl.getBufferSize());
			System.out.println(tdl.available());

			Files.write(Path.of("kek.pcm"), data, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try (SourceDataLine sdl = AudioSystem.getSourceDataLine(af)) {
			System.out.println(sdl);
			sdl.open();
			sdl.start();

			sdl.write(data, 0, data.length);

		}

		 */

	}
}
