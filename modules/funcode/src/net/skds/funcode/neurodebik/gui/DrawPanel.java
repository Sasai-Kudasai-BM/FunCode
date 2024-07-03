package net.skds.funcode.neurodebik.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {

	public final BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
	public final Graphics2D ig = image.createGraphics();

	private final Color drawColor = new Color(0, 0, 0, 16);

	private int mouseBtn = -1;

	public DrawPanel() {
		setPreferredSize(new Dimension(800, 800));

		ig.setColor(Color.WHITE);
		ig.fillRect(0, 0, 16, 16);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseBtn = e.getButton();
				paint(e.getX(), e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				mouseBtn = -1;
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				paint(e.getX(), e.getY());
			}
		});
	}

	private void paint(int x, int y) {

		if (mouseBtn == 1) {
			ig.setColor(drawColor);
		} else if (mouseBtn == 3) {
			ig.setColor(Color.WHITE);
		} else {
			return;
		}

		x = (x / 50) & 15;
		y = (y / 50) & 15;

		ig.fillRect(x, y, 1, 1);
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}
