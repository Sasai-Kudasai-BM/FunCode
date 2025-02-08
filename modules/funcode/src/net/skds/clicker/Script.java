package net.skds.clicker;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Script {
	transient Options options;

	@Getter
	boolean active = false;
	@Getter
	Clicker.KeyTrigger trigger = Clicker.KeyTrigger.BLANK;
	@Getter
	Clicker.Action action = Clicker.Action.BLANK;
	@Getter
	String name = "new";
	@Getter
	long period = 100;

	@Setter
	transient Clicker.ActivationListener presetActivationListener = (p, a) -> {
	};

	Script(Options options) {
		this.options = options;
	}

	private Script() {
	}

	@Override
	public String toString() {
		return name + ": " + trigger;
	}

	public void setActive(boolean active) {
		if (this.active != active) {
			options.markDirty();
			this.active = active;
		}
	}

	public void setTrigger(Clicker.KeyTrigger trigger) {
		if (this.trigger != trigger) {
			options.markDirty();
			this.trigger = trigger;
		}
	}

	public void setAction(Clicker.Action action) {
		if (this.action != action) {
			options.markDirty();
			this.action = action;
		}
	}

	public void setName(String name) {
		if (!Objects.equals(this.name, name)) {
			options.markDirty();
			this.name = name;
		}
	}

	public void setPeriod(long period) {
		if (this.period != period) {
			options.markDirty();
			this.period = period;
		}
	}
}
