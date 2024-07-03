package net.skds.funcode.neurodebik.ai;

import net.skds.lib.utils.ArrayUtils;
import net.skds.lib.utils.SKDSUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleValidator implements NNValidator {

	public final ArrayList<float[]> picList = new ArrayList<>(600);
	public final ArrayList<BufferedImage> picList0 = new ArrayList<>(600);
	public final ArrayList<String> nameList = new ArrayList<>(600);

	private final float step;

	public SimpleValidator() throws IOException {
		for (File f : SKDSUtils.collectFileTree(new File("item"))) {
			BufferedImage img = ImageIO.read(f);
			if (img.getWidth() != 16 || img.getHeight() != 16) {
				f.delete();
				continue;
			}
			float[] clr = new float[256];
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 16; y++) {
					int c = img.getRGB(x, y);
					if (((c >> 24) & 255) == 0) {
						clr[x * 16 + y] = 1;
					} else {
						clr[x * 16 + y] = ((c & 255) + ((c >> 8) & 255) + ((c >> 16) & 255)) / (255f * 3);
					}
				}
			}
			//System.out.println(Arrays.toString(clr));

			picList0.add(img);
			picList.add(clr);
			String n = f.getName();
			nameList.add(n.substring(0, n.length() - 4));
		}

		step = 1f / (picList.size() - 1);
		System.out.println("images loaded");
	}

	public int outputSize() {
		return picList.size();
	}

	@Override
	public float validate(SimpleNet net) {
		float score = 0;

		for (int i = 0; i < picList.size(); i++) {
			float[] in = picList.get(i);
			ArrayUtils.copySameSize(in, net.inputBuffer(), in.length);
			net.process();
			float[] out = net.outputBuffer();
			float max = -Float.MAX_VALUE;
			int maxi = -1;
			for (int j = 0; j < out.length; j++) {
				float val = out[j];
				if (val > max) {
					max = val;
					maxi = j;
				}
				//if (i == j) {
				//	score += val;
				//} else {
				//	score -= val * step;
				//}
			}
			if (maxi == i) {
				score++;
			}
		}

		return score;
	}
}
