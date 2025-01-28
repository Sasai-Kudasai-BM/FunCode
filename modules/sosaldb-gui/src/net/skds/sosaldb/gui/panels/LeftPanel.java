package net.skds.sosaldb.gui.panels;

import net.skds.sosaldb.gui.SosalDbWindow;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends Panel {

	public static final int WIDTH = 300;

	public LeftPanel(SosalDbWindow window) {
		super(window);
		setPreferredSize(new Dimension(WIDTH, 0));
		setLayout(new BorderLayout());
		add(new AddButton(), BorderLayout.NORTH);

		DatabaseList dbList = new DatabaseList();
		JScrollPane dbScroll = new JScrollPane(dbList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(dbScroll, BorderLayout.CENTER);
	}

	private static class AddButton extends JButton {
		AddButton() {
			super("Add");
			setPreferredSize(new Dimension(WIDTH, 50));
		}
	}

	private static class DatabaseList extends JPanel {
		DatabaseList() {
			//setPreferredSize(new Dimension(WIDTH, 50));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		}
	}
}
