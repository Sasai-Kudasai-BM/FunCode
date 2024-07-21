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
		cb.field("WRAPPER", NativeStructureWrapper.class, "new NativeStructureWrapper(" + getName() + ".class)", "", "", false);


		//@Override
		//		protected NativeStructureWrapper getWrapper() {
		//			return VK_LAYER_PROPERTIES;
		//		}
		cb.methodP("getWrapper", NativeStructureWrapper.class, "\t\treturn WRAPPER;", "", "@Override");
		expMembers(cb, members());

		cb.export();
	}

	private static void expUnion(ClassBuilder cb, Union u, StructMember member) {
		cb.checkImport(ArrayLength.class);
		cb.fieldD(member.name(), byte[].class, "", member.comment(), "@ArrayLength(" + u.size + ")\n\t@NativeType(\"" + u.nativeTypeName() + "\")", false);
	}


	private static void expArray(ClassBuilder cb, ArrayType a, StructMember member) {
		if (a.getRef() instanceof Union) {
			cb.checkImport(ArrayLength.class);
			cb.fieldD(member.name(),
					byte[].class,
					"",
					member.comment(),
					"@ArrayLength(" + a.getLength() + ")\n\t@NativeType(\"" + a.nativeTypeName() + "\")",
					false
			);
		} else if (a.getRef() instanceof Struct s) {

			String pack = VKGen.ROOT_PACKAGE + ".structs";
			String name = s.getName();

			cb.checkImport(ArrayLength.class);
			cb.fieldD(member.name(),
					new ClassBuilder.CT(name, pack),
					"",
					member.comment(),
					"@ArrayLength(" + a.getLength() + ")\n\t@NativeType(\"" + a.nativeTypeName() + "\")",
					false
			);
		} else {
			cb.checkImport(ArrayLength.class);
			IDataType t = a.getRef();
			if (t.nativeType() == null) {
				System.err.println(t);
			}
			if (t.nativeType() == NativeTypeEnum.VOID) {
				return;
			}
			cb.fieldD(member.name(),
					t.nativeType().javaType.clazz.arrayType(),
					"", member.comment(),
					"@ArrayLength(" + a.getLength() + ")\n\t@NativeType(\"" + a.nativeTypeName() + "\")",
					false
			);
		}
	}

	private static void expMembers(ClassBuilder cb, List<StructMember> members) {
		for (StructMember member : members) {
			if (member.type() instanceof Union u) {
				expUnion(cb, u, member);
				continue;
			} else if (member.type() instanceof Struct s) {

				String pack = VKGen.ROOT_PACKAGE + ".structs";
				String name = s.getName();

				cb.fieldD(member.name(),
						new ClassBuilder.CT(name, pack),
						"",
						member.comment(),
						"@NativeType(\"" + s.nativeTypeName() + "\")",
						false
				);
				continue;
			} else if (member.type() instanceof ArrayType a) {
				expArray(cb, a, member);
				continue;
			}
			IDataType t = member.type();
			if (t.nativeType() == null) {
				System.err.println(t);
			}
			if (t.nativeType() == NativeTypeEnum.VOID) {
				return;
			}
			String ini = "";
			if (member.value() != null) {
				ini = member.value().toString();
			}
			cb.fieldD(member.name(),
					t.nativeType().javaType.clazz,
					ini, member.comment(),
					"@NativeType(\"" + t.nativeTypeName() + "\")",
					false
			);
		}
	}

	//@Override
	//default String nativeTypeName() {
	//	return getName();
	//}
}
