package net.skds.sosaldb.gui;

import net.skds.sosaldb.gui.panels.LeftPanel;
import net.skds.sosaldb.gui.panels.MainPanel;
import net.skds.sosaldb.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class SosalDbWindow extends JFrame {

	//public static final Color TEXT_COLOR = new Color(0x2B7C2B);
	//public static final Color PANEL_COLOR = new Color(0x1A1A50);
	//public static final Color BORDER_COLOR_A = new Color(0x3A3AA4);
	//public static final Color BORDER_COLOR_B = new Color(0x101033);

	private final TopPanel topPanel;
	private final LeftPanel leftPanel;
	private final MainPanel mainPanel;

	public SosalDbWindow() {
		super("SosalDB Gui");

		this.topPanel = new TopPanel(this);
		this.leftPanel = new LeftPanel(this);
		this.mainPanel = new MainPanel(this);

		setLayout(new BorderLayout());
		add(this.topPanel, BorderLayout.NORTH);
		add(this.leftPanel, BorderLayout.WEST);
		add(this.mainPanel, BorderLayout.CENTER);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(1200, 800));
		pack();
		setLocation(-getWidth() / 2, -getHeight() / 2);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SosalDbWindow();
	}
}
