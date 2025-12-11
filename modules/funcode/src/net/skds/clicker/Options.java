package net.skds.clicker;

import net.skds.lib2.io.codec.PostDeserializeCall;
import net.skds.lib2.io.codec.SosisonUtils;
import net.skds.lib2.utils.ThreadUtils;

import java.nio.file.Path;
import java.util.LinkedList;

@SuppressWarnings("FieldMayBeFinal")
public class Options implements PostDeserializeCall, Cloneable {

	private static final Path path = Path.of("clicker-options.json");
	private static Options instance;

	private transient boolean dirty = false;

	private LinkedList<Script> scripts = new LinkedList<>();

	public Iterable<Script> getScripts() {
		return scripts;
	}

	public void removeScript(Script p) {
		if (scripts.remove(p)) {
			markDirty();
		}
	}

	public void markDirty() {
		dirty = true;
	}

	public Script newScript() {
		Script preset = new Script(this);
		this.scripts.addFirst(preset);
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
				SosisonUtils.saveJson(path, this);
				dirty = false;
			}
		}
	}

	@Override
	public void postDeserialized() {
		for (Script preset : scripts) {
			preset.options = this;
		}
	}

	@SuppressWarnings({"CloneDoesntDeclareCloneNotSupportedException", "MethodDoesntCallSuperMethod"})
	@Override
	protected Options clone() {
		Options cl = new Options();
		for (Script p : scripts) {
			Script p2 = new Script(cl);
			cl.scripts.addLast(p2);
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
			options = SosisonUtils.readJson(path, Options.class);
			if (options == null) {
				options = new Options();
				SosisonUtils.saveJson(path, options);
			}
			instance = options;
		}
		return options;
	}
}
