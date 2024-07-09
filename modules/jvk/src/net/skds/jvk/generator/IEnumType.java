package net.skds.jvk.generator;

import java.util.List;

interface IEnumType extends IDataType {

	boolean isBitmask();

	List<EnumType.Value> values();

	@Override
	default void generate() {
		String pack = VKGen.ROOT_PACKAGE + ".enums";
		ClassBuilder cb = new ClassBuilder(pack, getName().replace(" ", ""), ClassBuilder.Type.CLASS);

		for (EnumType.Value value : values()) {
			if (value.v() == null) {
				continue;
			}
			String init = String.valueOf(value.v());
			if (value.v().getClass() == Float.class) {
				init += "F";
			}
			cb.field(value.name(), value.type() == null ? null : value.type().javaType.clazz, init, value.comment());
		}

		cb.export();
	}

}
