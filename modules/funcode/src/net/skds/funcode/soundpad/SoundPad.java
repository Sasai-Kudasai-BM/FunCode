package net.skds.funcode.soundpad;

import net.skds.lib.mat.FastMath;
import net.skds.lib.utils.SKDSUtils;
import net.skds.lib.utils.ThreadUtil;
import net.skds.lib.utils.json.CFGLoader;

import javax.sound.sampled.*;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SoundPad {

	public static final SoundPad INSTANCE = new SoundPad();

	private final Mixer outMix;
	private final Mixer inMix;
	private final TargetDataLine inLine;
	private final SourceDataLine outLine;
	private final SourceDataLine extraOutLine;
	private final File settingsFile = new File("settings.json");
	private final Settings settings;
	private final AudioFormat af;

	private final BlockingQueue<Sound> playQueue = new LinkedBlockingQueue<>();
	private final Map<String, Sound> sounds = new HashMap<>();

	private final byte[] buffer;

	private SoundPad() {
		Settings s = CFGLoader.readConfig(settingsFile, Settings.class);
		if (s == null) {
			s = new Settings();
			CFGLoader.saveConfig(settingsFile, s);
		}
		this.settings = s;

		Mixer in = null;
		Mixer out = null;
		for (Mixer.Info info : AudioSystem.getMixerInfo()) {
			System.out.println(info.getName());
		}
		for (Mixer.Info info : AudioSystem.getMixerInfo()) {
			if (out == null && info.getName().startsWith(settings.getOutputName())) {
				out = AudioSystem.getMixer(info);
			}
			if (in == null && info.getName().startsWith(settings.getInputName())) {
				in = AudioSystem.getMixer(info);
			}
			if (in != null && out != null) {
				break;
			}
		}
		assert in != null;
		assert out != null;
		inMix = in;
		outMix = out;

		af = new AudioFormat(settings.getFrequency(), settings.getBits(), settings.getChannels(), true, false);
		try {
			inLine = (TargetDataLine) inMix.getLine(new DataLine.Info(TargetDataLine.class, af));
			outLine = (SourceDataLine) outMix.getLine(new DataLine.Info(SourceDataLine.class, af));
			extraOutLine = (SourceDataLine) outMix.getLine(new DataLine.Info(SourceDataLine.class, af));

		} catch (LineUnavailableException e) {
			throw new RuntimeException(e);
		}

		buffer = new byte[settings.getSamples() * af.getFrameSize()];
	}

	private void init() throws Exception {

		loadSounds();

		ThreadUtil.runNewThreadMainGroup(this::soundLoop, "SoundLoop");
		ThreadUtil.runNewThreadMainGroup(this::playLoop, "PlayLoop");

		//while (true) {
		//	ThreadUtil.await(1000 + FastMath.RANDOM.nextInt(2000));
		//	Sound s = sounds.values().iterator().next();
		//	playQueue.offer(s);
		//}
	}

	private void playLoop() {
		try {
			extraOutLine.open();
			extraOutLine.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			while (true) {
				Sound s = playQueue.take();
				extraOutLine.write(s.data, 0, s.data.length);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void soundLoop() {
		try {
			inLine.open();
			inLine.start();
			outLine.open();
			outLine.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while (true) {
			int len = inLine.read(buffer, 0, buffer.length);
			//test
			prikol(len);
			// test
			outLine.write(buffer, 0, len);
		}
	}

	private void prikol(int len) {
		if (len <= 1) return;

		byte[] b2 = buffer.clone();

		for (int i = 0; i < len; i += 2) {
			int i2 = len - i - 1;
			buffer[i] = b2[i2 - 1];
			buffer[i + 1] = b2[i2];
		}

		len /= 2;
		ShortBuffer sb = ByteBuffer.wrap(buffer).order(ByteOrder.nativeOrder()).asShortBuffer();
		short s0 = sb.get(0);
		short s1 = sb.get(len - 1);
		float k = (float) (s0 - s1) / len;
		for (int i = 0; i < len; i++) {
			short v = (short) FastMath.clamp(sb.get(i) + k * i - s0, Short.MIN_VALUE, Short.MAX_VALUE);

			sb.put(i, v);
		}


	}

	private void loadSounds() throws Exception {
		for (File f : SKDSUtils.collectFileTree(new File("sounds"))) {
			Sound s = new Sound(f, af);
			sounds.put(s.name, s);
		}
	}

	public static void main(String[] args) throws Exception {
		INSTANCE.init();
		System.out.println("running");
	}
}
