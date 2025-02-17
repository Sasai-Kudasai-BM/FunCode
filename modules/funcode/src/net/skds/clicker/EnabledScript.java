package net.skds.clicker;

class EnabledScript {

	private final Clicker clicker;
	final Script script;

	Stack stack;

	boolean active = false;
	boolean lastMatches = false;
	long lastClick = 0;

	EnabledScript(Clicker clicker, Script script) {
		this.clicker = clicker;
		this.script = script;
		this.stack = new Stack(null, script.action);
	}

	void pushStack(Action newAction) {
		this.stack = new Stack(this.stack, newAction);
	}

	void tick() {
		boolean km = clicker.keysMatches(script.trigger);
		if (km != lastMatches) {
			lastMatches = km;
			if (script.getTrigger().toggle()) {
				if (!km) {
					active = !active;
					script.presetActivationListener.acceptActiveState(script, active);
				}
			} else {
				active = km;
				script.presetActivationListener.acceptActiveState(script, km);
			}
		}
		if (active) {
			//RobotUtils.ROBOT.
			long t = System.currentTimeMillis();
			if (script.period + lastClick <= t) {
				lastClick = t;
				System.out.println("Sex " + script);
			} else {
				Thread.yield();
			}
		}
	}

	private static class Stack {
		Action action;
		Stack parent;
		int pos = 0;
		long lastDelay = 0;

		public Stack(Stack parent, Action action) {
			this.parent = parent;
			this.action = action;
			if (parent != null) {
				this.lastDelay = parent.lastDelay;
			}
		}
	}
}
