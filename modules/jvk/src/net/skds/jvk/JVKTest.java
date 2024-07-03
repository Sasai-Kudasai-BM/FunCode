package net.skds.jvk;


import net.skds.nativelib.Kernel32;
import net.skds.ninvoker.NInvoker;

import javax.swing.*;
import java.awt.*;

public class JVKTest {

	public static void main(String[] args) throws Exception {

		var device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		var configuration = device.getDefaultConfiguration();


		//GraphicsEnvironment.getLocalGraphicsEnvironment().


		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		frame.setPreferredSize(new Dimension(200, 100));
		frame.pack();
		frame.setVisible(true);


		System.out.println(NInvoker.getHWnd(frame));
		System.out.println(Kernel32.getModuleHandle(0));

	}
}
