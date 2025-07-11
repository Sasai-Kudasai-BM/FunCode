package net.skds.jvk.generator;

import net.skds.lib2.misc.clazz.classbuilder.*;

import java.lang.reflect.Modifier;
import java.util.List;

interface IEnumType extends IDataType {

	boolean isBitmask();

	List<EnumType.Value> values();

	@Override
	default void generate() {
		if (getName().equals("VkResult")) return;
		String pack = VKGen.ROOT_PACKAGE + ".enums";
		TextClassBuilder cb = new TextClassBuilder(pack, getName().replace(" ", ""), ClassType.CLASS).setFinal(true);

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
			CBField field = new CBField(
					value.name(),
					Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL,
					CBType.of(nt.javaType.clazz),
					null,
					new CBJavadoc(value.comment()),
					new CodeBody(init + ";")
			);
			cb.addElement(field);
		}

		VKGen.export(cb);
	}

	//@Override
	//default String nativeTypeName() {
	//	return getName();
	//}
}
