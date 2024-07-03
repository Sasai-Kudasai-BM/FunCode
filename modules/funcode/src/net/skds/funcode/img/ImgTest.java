package net.skds.funcode.img;

import net.skds.lib.utils.ImageUtils;
import net.skds.lib.utils.SKDSUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImgTest {

	public static void main(String[] args) throws IOException, AWTException {

		File f = SKDSUtils.collectFileTree(new File("img")).getFirst();
		InputStream is = new BufferedInputStream(new FileInputStream(f));
		BufferedImage bi = ImageUtils.readPNG(is);

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		ImageCapabilities capabilities = new ImageCapabilities(true);
		var cnf = gd.getDefaultConfiguration();


		var vi = cnf.createCompatibleVolatileImage(bi.getWidth(), bi.getHeight(), capabilities, Transparency.TRANSLUCENT);
		var vi2 = cnf.createCompatibleVolatileImage(bi.getWidth(), bi.getHeight(), capabilities, Transparency.TRANSLUCENT);
		Graphics2D g = vi.createGraphics();
		Graphics2D g2 = vi2.createGraphics();
		g2.drawImage(bi, null, 0, 0);
		g2.dispose();
		//Graphics2D g = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB).createGraphics();


		g.drawImage(vi2, 0, 0, null);

		var timer = SKDSUtils.startTimeMeasure();
		g.setColor(Color.BLUE);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < 100000; i++) {
			g.fillOval(100, 100, 200, 200);
			//g.drawImage(vi2, 0, 0, null);
		}

		System.out.println(timer.query());
	}
}
