package net.skds.clicker.gui.layouts;

import javax.swing.*;
import java.awt.*;

//TODO
public class SmartScrollPaneLayout extends ScrollPaneLayout {

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		return super.preferredLayoutSize(parent);
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		Dimension dim = super.minimumLayoutSize(parent);
		JScrollPane scrollPane = (JScrollPane) parent;


		return dim;
	}

	@Override
	public void layoutContainer(Container parent) {
		super.layoutContainer(parent);
	}
}
