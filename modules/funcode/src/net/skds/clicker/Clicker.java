package net.skds.clicker;

import net.skds.clicker.gui.ClickerWindow;
import net.skds.lib2.utils.ArrayUtils;
import net.skds.lib2.utils.linkiges.Obj2BooleanPair;
import net.skds.lib2.utils.linkiges.Obj2BooleanPairRecord;
import net.skds.lib2.utils.logger.SKDSLogger;
import net.skds.lib2.utils.platforms.PlatformFeatures;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.awt.event.MouseEvent.*;

public class Clicker implements KeyListener, MouseListener, Runnable {

	public static final int STANDARD_MOD_MASK = SHIFT_DOWN_MASK | CTRL_DOWN_MASK | ALT_DOWN_MASK | META_DOWN_MASK;

	public final Options options;
	private final PlatformFeatures platform = PlatformFeatures.getInstance();
	private final Thread thread;
	private final LinkedBlockingQueue<Obj2BooleanPair<Key>> inputQueue = new LinkedBlockingQueue<>();

	private final Map<Script, EnabledScript> enabledScripts = new HashMap<>();
	private final Set<Key> activeKeys = new HashSet<>();
	private int activeMods = 0;
	private boolean running = true;

	public Clicker() {
		this.options = Options.getInstance();
		this.thread = new Thread(this, "Clicker");
		this.thread.setDaemon(true);
	}

	public void start() {
		if (!running) {
			throw new RuntimeException("Clicker was already stopped");
		}
		this.platform.addKeyListener(this);
		this.platform.addMouseListener(this);
		this.thread.start();
		for (Script script : options.getScripts()) {
			if (script.isActive()) {
				enable(script);
			}
		}
	}

	public void stop() {
		running = false;
		this.platform.removeKeyListener(this);
		this.platform.removeMouseListener(this);
	}

	private long getTimeOut() {
		long wt = 1000;
		if (!enabledScripts.isEmpty()) {
			long t = System.currentTimeMillis();
			for (EnabledScript es : enabledScripts.values()) {
				if (es.active) {
					long dt = es.script.period + es.lastClick - t;
					if (dt < wt) {
						wt = dt;
					}
				}
			}
		}
		wt -= 2;
		if (wt < 0) {
			wt = 0;
		}
		return wt;
	}

	@Override
	public void run() {
		while (running) {
			try {
				long t;
				synchronized (enabledScripts) {
					t = getTimeOut();
				}
				Obj2BooleanPair<Key> e = inputQueue.poll(t, TimeUnit.MILLISECONDS);
				if (e != null) {
					Key k = e.objectValue();
					if (e.booleanValue()) {
						activeKeys.add(k);
					} else {
						activeKeys.remove(k);
					}
				}
				synchronized (enabledScripts) {
					for (EnabledScript es : enabledScripts.values()) {
						es.tick();
					}
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void enable(Script script) {
		script.setActive(true);
		synchronized (enabledScripts) {
			enabledScripts.put(script, new EnabledScript(this, script));
		}
	}

	public void disable(Script script) {
		script.setActive(false);
		synchronized (enabledScripts) {
			enabledScripts.remove(script);
		}
	}

	public boolean keysMatches(KeyTrigger trigger) {
		if (trigger.keys.length == 0) return false;
		int rm = trigger.modMask;
		if ((rm & activeMods) != rm) return false;
		return ArrayUtils.containsAll(activeKeys, trigger.keys);
	}

	public void removeScript(Script p) {
		options.removeScript(p);
		disable(p);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		activeMods = e.getModifiersEx();
		if (isModKey(e.getKeyCode())) return;
		inputQueue.offer(new Obj2BooleanPairRecord<>(Key.fromKeyboard(e), true));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		activeMods = e.getModifiersEx();
		if (isModKey(e.getKeyCode())) return;
		inputQueue.offer(new Obj2BooleanPairRecord<>(Key.fromKeyboard(e), false));
	}


	@Override
	public void mousePressed(MouseEvent e) {
		inputQueue.offer(new Obj2BooleanPairRecord<>(Key.fromMouse(e), true));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		inputQueue.offer(new Obj2BooleanPairRecord<>(Key.fromMouse(e), false));
	}

	@FunctionalInterface
	public interface ActivationListener {
		void acceptActiveState(Script script, boolean isActive);
	}


	public record Key(int id, KeyType type) {
		private static final Key[] EA = {};
		public static final Key LMB = new Key(BUTTON1, KeyType.MOUSE);
		public static final Key RMB = new Key(BUTTON3, KeyType.MOUSE);
		public static final Key MMB = new Key(BUTTON2, KeyType.MOUSE);

		public static Key fromKeyboard(KeyEvent e) {
			return new Key(e.getKeyCode(), KeyType.KEYBOARD);
		}

		public static Key fromMouse(MouseEvent e) {
			return switch (e.getButton()) {
				case BUTTON1 -> LMB;
				case BUTTON2 -> MMB;
				case BUTTON3 -> RMB;
				default -> new Key(e.getButton(), KeyType.MOUSE);
			};
		}

		@Override
		public String toString() {
			return switch (type) {
				case MOUSE -> switch (id) {
					case BUTTON1 -> "LMB";
					case BUTTON2 -> "MMB";
					case BUTTON3 -> "RMB";
					default -> "MB" + id;
				};
				case KEYBOARD -> KeyEvent.getKeyText(id);
			};
		}
	}

	public enum KeyType {
		KEYBOARD, MOUSE;
	}

	public record KeyTrigger(boolean toggle, Key[] keys, int modMask) {
		public static final KeyTrigger BLANK = new KeyTrigger(false, Key.EA, 0);

		public KeyTrigger withToggle(boolean toggle) {
			if (this.toggle == toggle) return this;
			return new KeyTrigger(toggle, this.keys.clone(), this.modMask);
		}

		public KeyTrigger addKey(Key key) {
			Key[] keys = ArrayUtils.addToArrayAsSet(this.keys, key);
			if (keys == this.keys) return this;
			return new KeyTrigger(this.toggle, keys, this.modMask);
		}

		public KeyTrigger addKeyAndMods(Key key, int mods) {
			Key[] keys = ArrayUtils.addToArrayAsSet(this.keys, key);
			if (keys == this.keys && (mods | this.modMask) == this.modMask) return this;
			return new KeyTrigger(this.toggle, keys, mods | this.modMask);
		}

		public KeyTrigger withKeys(Key[] keys) {
			if (Arrays.equals(this.keys, keys)) return this;
			return new KeyTrigger(this.toggle, keys.clone(), this.modMask);
		}

		public KeyTrigger withModMask(int modMask) {
			if (this.modMask == modMask) return this;
			return new KeyTrigger(this.toggle, this.keys.clone(), modMask);
		}

		public KeyTrigger addModMask(int modMask) {
			if ((modMask | this.modMask) == this.modMask) return this;
			return new KeyTrigger(this.toggle, this.keys.clone(), modMask | this.modMask);
		}

		@Override
		public String toString() {
			if (keys.length == 0) {
				return "---";
			}
			StringBuilder sb = new StringBuilder();
			if (modMask != 0) {
				sb.append(KeyEvent.getModifiersExText(modMask)).append('+');
			}
			for (int i = 0; i < keys.length; i++) {
				sb.append(keys[i]).append('+');
			}
			sb.setLength(sb.length() - 1);
			return sb.toString();
		}
	}

	public record Action(Key[] hold, Key[] click) {

		public static final Action BLANK = new Action(Key.EA, Key.EA);

		public Action addHold(Key hold) {
			Key[] keys = ArrayUtils.addToArrayAsSet(this.hold, hold);
			if (keys == this.hold) return this;
			return new Action(keys, this.click);
		}

		public Action addClick(Key click) {
			Key[] keys = ArrayUtils.addToArrayAsSet(this.click, click);
			if (keys == this.click) return this;
			return new Action(this.hold, keys);
		}

		public Action withHold(Key[] hold) {
			if (Arrays.equals(this.hold, hold)) return this;
			return new Action(hold.clone(), this.click);
		}

		public Action withClick(Key[] click) {
			if (Arrays.equals(this.click, click)) return this;
			return new Action(this.hold.clone(), click.clone());
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			if (hold.length > 0) {
				sb.append("H ");
				for (int i = 0; i < hold.length; i++) {
					sb.append(hold[i]).append('+');
				}
				sb.setLength(sb.length() - 1);
				sb.append("; ");
			}
			for (int i = 0; i < click.length; i++) {
				sb.append(click[i]).append('+');
			}
			sb.setLength(sb.length() - 1);
			return sb.toString();
		}
	}

	public static boolean isModKey(int key) {
		return switch (key) {
			case KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_META -> true;
			default -> false;
		};
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	public static void main(String[] args) {
		SKDSLogger.replaceOuts();
		new ClickerWindow();
	}
}
