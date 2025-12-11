package net.skds.pixex.gui;

import net.skds.lib2.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PEFrame extends JFrame {
	public PEFrame() {
		super("PixelEngine");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		add(new DrawArea(), BorderLayout.CENTER);

		//setMinimumSize(new Dimension(300, 50));
		pack();
		setLocation(-getWidth() / 2, -getHeight() / 2);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class DrawArea extends JPanel implements ImageUtils.PerPixelDraw {

		BufferedImage image;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			BufferedImage img = this.image;
			if (img == null) {
				img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
				this.image = img;
			}
			ImageUtils.drawPerPixel(img, this);
			g.drawImage(img, 0, 0, null);
		}

		@Override
		public int draw(int x, int y) {
			return x % 2 == 0 ? 0xff00ff : y % 3 == 0 ? 0xaaaaaa : 0x0;
		}
	}
}
