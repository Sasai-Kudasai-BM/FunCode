package net.skds.funcode.speedtest;

import javax.swing.*;
import java.awt.*;

public class Speed {


	public static void main(String[] args) {

		JFrame frame = new JFrame("ggg");

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				System.out.println(g2d.getPaint());
				super.paintComponent(g);
			}
		};

		panel.setPreferredSize(new Dimension(800, 600));
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
