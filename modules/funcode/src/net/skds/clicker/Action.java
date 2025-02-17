package net.skds.clicker;

import lombok.AllArgsConstructor;
import net.skds.lib2.io.json.codec.typed.ConfigEnumType;

import java.util.ArrayList;
import java.util.List;

public interface Action {

	class Delay implements Action {
		int duration = 100;
	}

	class Loop implements Action {
		public static final Loop ROOT = new Loop();

		List<Action> actions = new ArrayList<>();
		int count = 10;

		static {
			ROOT.count = -1;
			ROOT.actions.add(new Click());
			ROOT.actions.add(new Delay());
		}
	}

	abstract class KeyAction implements Action {
		Clicker.Key key = Clicker.Key.LMB;
	}

	class Press extends KeyAction {

	}

	class Release extends KeyAction {

	}

	class Click extends KeyAction {

	}

	class Beep implements Action {
	}

	@AllArgsConstructor
	enum Type implements ConfigEnumType<Action> {
		DELAY(Delay.class),
		PRESS(Press.class),
		RELEASE(Release.class),
		LOOP(Loop.class),
		BEEP(Beep.class),
		CLICK(Click.class);

		private final Class<?> tClass;

		@Override
		@SuppressWarnings("unchecked")
		public Class<Action> getTypeClass() {
			return (Class<Action>) tClass;
		}
	}

}
