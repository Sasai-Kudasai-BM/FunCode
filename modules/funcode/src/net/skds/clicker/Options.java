package net.skds.clicker;

import net.skds.lib2.io.json.JsonPostDeserializeCall;
import net.skds.lib2.io.json.JsonUtils;
import net.skds.lib2.utils.ThreadUtils;

import java.nio.file.Path;
import java.util.LinkedList;

@SuppressWarnings("FieldMayBeFinal")
public class Options implements JsonPostDeserializeCall, Cloneable {

	private static final Path path = Path.of("clicker-options.json");
	private static Options instance;

	private transient boolean dirty = false;

	private LinkedList<Script> presets = new LinkedList<>();

	public Iterable<Script> getPresets() {
		return presets;
	}

	public void removeScript(Script p) {
		if (presets.remove(p)) {
			markDirty();
		}
	}

	public void markDirty() {
		dirty = true;
	}

	public Script newPreset() {
		Script preset = new Script(this);
		this.presets.addFirst(preset);
		markDirty();
		return preset;
	}

	public void saveAsync() {
		if (!dirty) {
			return;
		}
		ThreadUtils.runTaskNewThread(clone()::save);
	}

	public void save() {
		if (dirty) {
			synchronized (path) {
				JsonUtils.saveJson(path, this);
				dirty = false;
			}
		}
	}

	@Override
	public void postDeserializedJson() {
		for (Script preset : presets) {
			preset.options = this;
		}
	}

	@SuppressWarnings({"CloneDoesntDeclareCloneNotSupportedException", "MethodDoesntCallSuperMethod"})
	@Override
	protected Options clone() {
		Options cl = new Options();
		for (Script p : presets) {
			Script p2 = new Script(cl);
			cl.presets.addLast(p2);
			p2.active = p.active;
			p2.trigger = p.trigger;
			p2.action = p.action;
			p2.name = p.name;
			p2.period = p.period;
		}
		cl.dirty = dirty;
		return cl;
	}


	public static Options getInstance() {
		Options options = instance;
		if (options == null) {
			options = JsonUtils.readJson(path, Options.class);
			if (options == null) {
				options = new Options();
				JsonUtils.saveJson(path, options);
			}
			instance = options;
		}
		return options;
	}
}
