package net.skds.clicker.gui;

import net.skds.clicker.Clicker;
import net.skds.clicker.Script;
import net.skds.lib2.awtutils.SwingDocListener;
import net.skds.lib2.awtutils.layouts.HorizontalLayout;
import net.skds.lib2.awtutils.layouts.LayoutMode;
import net.skds.lib2.awtutils.layouts.VerticalLayout;
import net.skds.lib2.utils.ImageUtils;
import net.skds.lib2.utils.SKDSUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class ClickerWindow extends JFrame {

	private static final Icon ACT_OFF_ICN = getIcon("images/inactive.png");
	private static final Icon ACT_ON_ICN = getIcon("images/active.png");
	private static final Icon DEL_ICN = getIcon("images/delete.png");
	private static final int LW = 600;

	public final Clicker clicker = new Clicker();

	private final PresetsList presetsList;
	private final JButton newPreset;
	private final JScrollPane scrollPane;

	public ClickerWindow() {
		super("Cum clicker");
		clicker.start();
		//KeyboardFocusManager.setCurrentKeyboardFocusManager(null);
		if (SKDSUtils.OS_TYPE == SKDSUtils.OSType.WINDOWS) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
		setLayout(new BorderLayout());
		this.presetsList = new PresetsList();
		scrollPane = new JScrollPane(presetsList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(LW + 20, 0));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane, BorderLayout.WEST);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.newPreset = new JButton("+");
		this.newPreset.setPreferredSize(new Dimension(LW, 20));
		this.newPreset.setFocusPainted(false);
		this.newPreset.addActionListener(e -> {
			Script preset = clicker.options.newScript();
			PresetPanel p = new PresetPanel(preset);
			this.presetsList.add(p, 1);
			scrollPane.revalidate();
		});
		this.presetsList.add(this.newPreset);
		updatePresets();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				clicker.options.saveAsync();
			}
		});

		setPreferredSize(new Dimension(800, 600));
		pack();
		setLocation(-getWidth() / 2, -getHeight() / 2);
		setLocationRelativeTo(null);
		setVisible(true);
		requestFocus();
	}

	private static Icon getIcon(String path) {
		return new ImageIcon(ImageUtils.readPNG(ClickerWindow.class.getClassLoader().getResourceAsStream(path)));
	}

	void updatePresets() {
		this.presetsList.removeAll();
		this.presetsList.add(newPreset);
		for (Script preset : clicker.options.getScripts()) {
			PresetPanel p = new PresetPanel(preset);
			this.presetsList.add(p);
			preset.setPresetActivationListener(p);
		}
		scrollPane.revalidate();
	}

	private static class PresetsList extends JPanel {
		public PresetsList() {
			setLayout(new VerticalLayout());

			//setPreferredSize(new Dimension(200, 0));
		}
	}

	private class PresetPanel extends JPanel implements Clicker.ActivationListener {

		private static final int H = 20;
		private static final int HH = H + 20;

		final Script script;
		final JTextField name;
		final JCheckBox enabled;
		final JCheckBox toggle;

		final JLabel activationLabel;

		final JButton setKeys;

		boolean listeningKeys = false;
		Clicker.KeyTrigger lastTrigger;

		final KeyListener setKeyListener0 = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				if (!listeningKeys) {
					return;
				}
				int mod = e.getModifiersEx() & Clicker.STANDARD_MOD_MASK;
				if (Clicker.isModKey(kc)) {
					addMask(mod);
				} else {
					addKey(new Clicker.Key(kc, Clicker.KeyType.KEYBOARD), mod);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				stopListeningKeys(false);
			}
		};
		final MouseListener setKeyListener1 = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!listeningKeys) {
					return;
				}
				addKey(Clicker.Key.fromMouse(e), 0);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				stopListeningKeys(false);
			}
		};
		final WindowFocusListener focusListener = new WindowAdapter() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				stopListeningKeys(true);
			}
		};

		PresetPanel(Script script) {
			this.script = script;
			this.lastTrigger = script.getTrigger();
			setPreferredSize(new Dimension(LW, HH));
			setBorder(BorderFactory.createEtchedBorder());
			setLayout(new HorizontalLayout(0, LayoutMode.CENTER));

			this.name = new JTextField(script.getName());
			this.name.setPreferredSize(new Dimension(80, H));
			this.name.getDocument().addDocumentListener(new SwingDocListener(e -> {
				this.script.setName(this.name.getText());
			}));

			this.enabled = new JCheckBox("Enabled", null, script.isActive());
			this.enabled.setFocusPainted(false);
			this.enabled.addActionListener(e -> {
				if (enabled.isSelected()) {
					clicker.enable(this.script);
				} else {
					clicker.disable(this.script);
				}
				clicker.options.saveAsync();
			});

			this.toggle = new JCheckBox("Toggle", null, script.getTrigger().toggle());
			this.toggle.setFocusPainted(false);
			this.toggle.addActionListener(e -> {
				//clicker.disable(this.script);
				//this.enabled.setSelected(false);
				clicker.options.saveAsync();
				this.script.setTrigger(this.script.getTrigger().withToggle(this.toggle.isSelected()));
			});

			this.setKeys = new JButton(script.getTrigger().toString());
			this.setKeys.setPreferredSize(new Dimension(160, H));
			this.setKeys.setFocusPainted(false);
			this.setKeys.addActionListener(e -> {
				if (listeningKeys) return;
				SwingUtilities.invokeLater(this::startListeningKeys);
			});

			JButton delete = new JButton(DEL_ICN);
			delete.setFocusPainted(false);
			delete.setPreferredSize(new Dimension(H, H));
			delete.addActionListener(e -> {
				clicker.removeScript(script);
				updatePresets();
				ClickerWindow.this.removeWindowFocusListener(focusListener);
				clicker.options.saveAsync();
			});

			this.activationLabel = new JLabel(ACT_OFF_ICN);
			this.activationLabel.setPreferredSize(new Dimension(H, H));

			add(this.name);
			add(this.setKeys);
			add(this.toggle);
			add(this.enabled);
			add(this.activationLabel);
			add(delete);

		}

		void addKey(Clicker.Key key, int modMask) {
			Clicker.KeyTrigger trigger = this.script.getTrigger().addKeyAndMods(key, modMask);
			this.script.setTrigger(trigger);
			this.setKeys.setText(trigger.toString());
		}

		void addMask(int modMask) {
			Clicker.KeyTrigger trigger = this.script.getTrigger().addModMask(modMask);
			this.script.setTrigger(trigger);
			this.setKeys.setText(trigger.toString());
		}

		void startListeningKeys() {
			if (listeningKeys) {
				return;
			}
			this.lastTrigger = this.script.getTrigger();
			this.listeningKeys = true;
			ClickerWindow.this.presetsList.setEnabled(false);
			this.script.setTrigger(Clicker.KeyTrigger.BLANK);

			ClickerWindow.this.addWindowFocusListener(focusListener);
			this.setKeys.addKeyListener(setKeyListener0);
			this.setKeys.addMouseListener(setKeyListener1);
			this.setKeys.setText("?");
			this.setKeys.requestFocus();
		}

		void stopListeningKeys(boolean cancel) {
			if (!listeningKeys) {
				return;
			}
			Clicker.KeyTrigger trigger = script.getTrigger();
			if (!cancel && trigger.modMask() != 0 && trigger.keys().length == 0) {
				cancel = true;
			}
			if (cancel) {
				this.script.setTrigger(this.lastTrigger);
			} else {
				clicker.options.saveAsync();
			}
			ClickerWindow.this.removeWindowFocusListener(focusListener);
			this.setKeys.removeKeyListener(setKeyListener0);
			this.setKeys.removeMouseListener(setKeyListener1);
			ClickerWindow.this.presetsList.setEnabled(true);
			listeningKeys = false;
			this.requestFocus();
			this.setKeys.setText(trigger.toString());
		}


		@Override
		public void acceptActiveState(Script script, boolean isActive) {
			SwingUtilities.invokeLater(() -> {
				if (isActive) {
					activationLabel.setIcon(ACT_ON_ICN);
				} else {
					activationLabel.setIcon(ACT_OFF_ICN);
				}
			});
		}
	}
}
