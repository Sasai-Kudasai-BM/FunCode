package net.skds.jvk.generator;

import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.misc.clazz.classbuilder.*;
import net.skds.lib2.natives.SafeLinker;
import net.skds.lib2.natives.struct.CStruct;
import net.skds.lib2.utils.StringUtils;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;
import java.lang.reflect.Modifier;
import java.util.List;


interface IStruct extends IDataType {

	String comment();

	List<VkgStructMember> members();

	@Override
	default void generate() {
		String pack = VKGen.ROOT_PACKAGE + ".structs";
		TextClassBuilder cb = new TextClassBuilder(pack, getName(), ClassType.CLASS)
				.extend(CStruct.class)
				.setFinal(true)
				.setJavadoc(new CBJavadoc(VKGen.createCLayoutJavadoc(memoryLayout())))
				.importStatic(SafeLinker.class, "*")
				.importStatic(ValueLayout.class, "*")
				.importStatic(MemoryLayout.class, "*");
		// layout
		cb.addElement(new CBField(
				"MEMORY_LAYOUT",
				Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL,
				CBType.of(MemoryLayout.class),
				null,
				null,
				new CodeBody(VKGen.createMemLayout(memoryLayout()) + ";")
		));

		// members
		for (VkgStructMember member : members()) {
			expMemberFields(cb, member);
		}
		for (VkgStructMember member : members()) {
			expMemberMethods(cb, member);
		}

		cb.addElement(new CBMethod(
				"getAlignment",
				Modifier.PUBLIC,
				CBType.of(int.class),
				List.of(new CBAnnotation(Override.class)),
				null,
				null,
				new CodeBody("return (int) MEMORY_LAYOUT.byteAlignment();")
		));
		cb.addElement(new CBMethod(
				"getSize",
				Modifier.PUBLIC,
				CBType.of(int.class),
				List.of(new CBAnnotation(Override.class)),
				null,
				null,
				new CodeBody("return (int) MEMORY_LAYOUT.byteSize();")
		));
		// array
		VKGen.export(cb);
	}

	@Override
	StructLayout memoryLayout();

	private static void expMemberFields(TextClassBuilder cb, VkgStructMember member) {
		IDataType t = member.type;
		if (t.nativeType() == null) {
			return;
		}
		CBField field = new CBField(
				StringUtils.uppercaseUnderlined(member.name) + "_OFFSET",
				Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL,
				CBType.of(int.class),
				null,
				null,
				new CodeBody(member.offset + ";")
		);
		cb.addElement(field);
	}

	private static void expMemberMethods(TextClassBuilder cb, VkgStructMember member) {
		//if (member.type instanceof Union u) {
		//	expUnion(cb, u, member);
		//	continue;
		//} else if (member.type instanceof Struct s) {
		//	String pack = VKGen.ROOT_PACKAGE + ".structs";
		//	String name = s.getName();
		//	cb.fieldD(member.name,
		//			new ClassBuilderJVK.CT(name, pack, false),
		//			"",
		//			member.comment,
		//			"@StructMember()\n\t@NativeType(\"" + s.nativeTypeName() + "\")",
		//			false
		//	);
		//	continue;
		//} else if (member.type instanceof ArrayType a) {
		//	expArray(cb, a, member);
		//	continue;
		//}

		IDataType t = member.type;
		if (t.nativeType() == null || t.nativeType() == NativeTypeEnum.VOID) {
			System.err.println(t);
			return;
		}

		String ini = "";
		if (member.value != null) {
			ini = member.value.toString();
		}
		expGetter(member, cb);

	}

	private static void expGetter(VkgStructMember member, TextClassBuilder cb) {
		cb.importStatic(SafeLinker.class, "*");
		Class<?> rt = member.type.nativeType().javaType.clazz;
		CBMethod method = new CBMethod(
				member.name,
				Modifier.PUBLIC,
				CBType.of(rt),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				null,
				new CodeBody("return ("
						+ rt.getSimpleName()
						+ ") INT_HANDLE.get(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET"
						+ ");"
				)
		);
		cb.addElement(method);
	}

	//List.of(new CBMethod.Arg(member.type.nativeType().javaType.clazz, "value")),

	/*
	private static void expUnion(TextClassBuilder cb, Union u, VkgStructMember member) {
		cb.fieldD(member.name, byte[].class, "", member.comment,
				"@StructMember(size = " + u.size() + ")\n\t@NativeType(\"" + u.nativeTypeName() + "\")",
				false
		);
		String ucn = StringUtils.uppercaseFirstChar(member.name);
		Collection<JavaTypeEnum> collection = new LinkedHashSet<>();
		for (var m : u.getMembers()) {
			collectNatives(collection, m, u);
		}
		for (var n : collection) {
			Class<?> type = n.clazz;
			String uct = StringUtils.uppercaseFirstChar(type.getSimpleName());
			String bodyGet = "\t\treturn NativeByteArrayOperations.get" + uct + "(this." + member.name + ", i);";
			String bodySet = "\t\treturn NativeByteArrayOperations.set" + uct + "(this." + member.name + ", i, value);";
			cb.methodD("get" + ucn + uct.charAt(0), type, bodyGet, "", "", "", new ClassBuilderJVK.Arg(int.class, "i"));
			cb.methodD("set" + ucn, type, bodySet, "", "", "", new ClassBuilderJVK.Arg(int.class, "i"), new ClassBuilderJVK.Arg(type, "value"));
		}
	}

	private static void collectNatives(Collection<JavaTypeEnum> collection, IDataType root, Union union) {
		if (root.nativeType() != null) {
			collection.add(root.nativeType().javaType);
		} else if (root instanceof Union u) {
			for (var m : u.getMembers()) {
				collectNatives(collection, m, union);
			}
		} else {
			System.out.println("skipping union member " + root + " struct " + union.getName());
		}
	}


	private static void expArray(TextClassBuilder cb, ArrayType a, VkgStructMember member) {
		if (a.getRef() instanceof Union) {
			throw new UnsupportedOperationException("TODO?");
			//cb.checkImport(StructMember.class);
			//cb.fieldD(member.name(),
			//		byte[].class,
			//		"",
			//		member.comment(),
			//		"@StructMember(size = " + a.size() + ")\n\t@NativeType(\"" + a.nativeTypeName() + "\")",
			//		false
			//);
		} else if (a.getRef() instanceof Struct s) {

			String pack = VKGen.ROOT_PACKAGE + ".structs";
			String name = s.getName();

			cb.checkImport(StructMember.class);
			cb.fieldD(member.name,
					new ClassBuilderJVK.CT(name, pack, true),
					"",
					member.comment,
					"@StructMember(size = " + a.getLength() + ")\n\t@NativeType(\"" + a.nativeTypeName() + "\")",
					false
			);
		} else {
			cb.checkImport(StructMember.class);
			IDataType t = a.getRef();
			if (t.nativeType() == null) {
				System.err.println(t);
			}
			if (t.nativeType() == NativeTypeEnum.VOID) {
				return;
			}
			cb.fieldD(member.name,
					t.nativeType().javaType.clazz.arrayType(),
					"", member.comment,
					"@StructMember(size = " + a.getLength() + ")\n\t@NativeType(\"" + a.nativeTypeName() + "\")",
					false
			);
		}
	}

	 */


	//@Override
	//default String nativeTypeName() {
	//	return getName();
	//}
}
