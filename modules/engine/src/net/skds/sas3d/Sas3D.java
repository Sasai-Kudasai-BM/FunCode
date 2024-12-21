package net.skds.sas3d;

import net.skds.sas3d.vulkan.VKCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Sas3D {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Sas3D") {
			@Override
			public void paint(Graphics g) {
			}

			@Override
			public Graphics getGraphics() {
				return null;
			}
		};

		VKCore core = new VKCore(true, frame, "Sas3D", "Sas3D");

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
