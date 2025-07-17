package net.skds.jvk.vulkan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TriangleDemo {

	public final VkCore vkCore = new VkCore(new VulkanParameters("TriangleDemo", "TriangleDemo", true));

	private final JFrame frame = new JFrame("TriangleDemo") {
		{
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					vkCore.dispose();
				}
			});
			setPreferredSize(new Dimension(1200, 800));
			pack();
		}

		@Override
		public void paint(Graphics g) {
		}

		@Override
		public Graphics getGraphics() {
			return null;
		}
	};

	public void start() {
		vkCore.init();
		frame.setVisible(true);
	}
}
