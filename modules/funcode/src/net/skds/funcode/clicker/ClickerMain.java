package net.skds.funcode.clicker;

import net.skds.nativelib.User32;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class ClickerMain {

	public static void main(String[] args) throws Throwable {

		//ThreadUtil.runTickable(ClickerMain::tick, "keyTick", 10);

		Toolkit.getDefaultToolkit().beep();

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable t = clipboard.getContents(null);
		System.out.println(t.getTransferData(DataFlavor.stringFlavor));
	}

	static boolean tick() {

		System.out.println(User32.getAsyncKeyState(32));

		return true;
	}
}
