package net.skds.sosaldb.gui.panels;

import net.skds.sosaldb.gui.SosalDbWindow;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public abstract class Panel extends JPanel {

	public final SosalDbWindow window;

	protected Panel(SosalDbWindow window) {
		this.window = window;
		//setBackground(SosalDbWindow.PANEL_COLOR);
		//setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, SosalDbWindow.BORDER_COLOR_A, SosalDbWindow.BORDER_COLOR_B));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}
}
