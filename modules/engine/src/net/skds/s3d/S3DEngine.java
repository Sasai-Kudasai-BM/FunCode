package net.skds.s3d;

import net.skds.s3d.vulkan.VKCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class S3DEngine {

	public static void main(String[] args) {

		JFrame frame = new JFrame("S3D") {
			@Override
			public void paint(Graphics g) {
			}

			@Override
			public Graphics getGraphics() {
				return null;
			}
		};

		VKCore core = new VKCore(true, frame, "S3d Test", "S3D");

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				core.dispose();
			}
		});

		frame.setPreferredSize(new Dimension(1200, 800));
		frame.pack();
		frame.setVisible(true);
		core.init();
	}

}
