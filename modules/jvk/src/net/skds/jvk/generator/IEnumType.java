package net.skds.jvk.generator;

import java.util.List;

interface IEnumType extends IDataType {

	boolean isBitmask();

	List<EnumType.Value> values();

	@Override
	default void generate() {
		if (getName().equals("VkResult")) return;
		String pack = VKGen.ROOT_PACKAGE + ".enums";
		ClassBuilder cb = new ClassBuilder(pack, getName().replace(" ", ""), ClassBuilder.Type.CLASS);

		for (EnumType.Value value : values()) {
			if (value.v() == null) {
				continue;
			}
			NativeTypeEnum nt = nativeType();
			if (value.type() != null) {
				nt = value.type();
			}
			String init = String.valueOf(value.v());
			if (value.v().getClass() == Float.class) {
				init += "F";
			} else if (nt.javaType == JavaTypeEnum.LONG) {
				init += "L";
			}
			cb.field(value.name(), nt.javaType.clazz, init, value.comment());
		}

		cb.export();
	}

	//@Override
	//default String nativeTypeName() {
	//	return getName();
	//}
}
