package net.skds.jvk.generator;

import java.util.List;

public interface IEnumType extends IDataType {

	boolean isBitmask();

	List<EnumType.Value> values();

	@Override
	default void generate() {
		String pack = VKGen.ROOT_PACKAGE + ".enums";
		ClassBuilder cb = new ClassBuilder(pack, getName(), ClassBuilder.Type.CLASS);

		for (EnumType.Value value : values()) {
			String init = String.valueOf(value.v());
			cb.field(value.name(), value.type() == null ? null : value.type().javaType.clazz, init, value.comment());
		}

		cb.export();
	}

}
