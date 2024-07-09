package net.skds.jvk.generator;

import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.ninvoker.struct.NativeStructureWrapper;

import java.util.List;

interface IStruct extends IDataType {

	String comment();

	List<StructMember> members();

	@Override
	default void generate() {
		String pack = VKGen.ROOT_PACKAGE + ".structs";
		ClassBuilder cb = new ClassBuilder(pack, getName(), ClassBuilder.Type.CLASS);

		cb.checkImport(NativeType.class);
		cb.checkImport(AbstractNativeStructure.class);
		cb.checkImport(NativeStructureWrapper.class);
		cb.setExtend("AbstractNativeStructure");

		//	private static final NativeStructureWrapper VK_LAYER_PROPERTIES = new NativeStructureWrapper(VkLayerProperties.class);
		cb.field("WRAPPER", NativeStructureWrapper.class, "new NativeStructureWrapper(" + getName() + ".class)", "", "", true);


		//@Override
		//		protected NativeStructureWrapper getWrapper() {
		//			return VK_LAYER_PROPERTIES;
		//		}
		cb.methodP("getWrapper", NativeStructureWrapper.class, "\t\treturn WRAPPER;", "", "@Override");
		expMembers(cb, members());

		cb.export();
	}

	private static void expMembers(ClassBuilder cb, List<StructMember> members) {
		for (StructMember member : members) {
			if (member.type() instanceof Union u) {
				cb.checkImport(ArrayLength.class);
				cb.fieldD(member.name(), byte[].class, "", member.comment(), "@ArrayLength(" + u.size + ")\n\t@NativeType(\"" + u.name + "\")", false);
				continue;
			} else if (member.type() instanceof Struct s) {
				expMembers(cb, s.members());
				continue;
			}
			IDataType t = member.type();
			if (t.nativeType() == null) {
				System.err.println(t);
			}
			cb.fieldD(member.name(),
					t.nativeType().javaType.clazz,
					"", member.comment(),
					"@NativeType(\"" + t.getName() + "\")",
					false
			);
		}
	}
}
