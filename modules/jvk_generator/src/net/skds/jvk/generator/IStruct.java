package net.skds.jvk.generator;

import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.misc.clazz.classbuilder.*;
import net.skds.lib2.natives.SafeLinker;
import net.skds.lib2.natives.struct.CStruct;
import net.skds.lib2.utils.StringUtils;

import java.lang.foreign.*;
import java.lang.reflect.Modifier;
import java.util.List;


interface IStruct extends IDataType {

	String PACKAGE = VKGen.ROOT_PACKAGE + ".structs";

	String comment();

	List<VkgStructMember> members();

	@Override
	default void generate() {
		TextClassBuilder cb = new TextClassBuilder(PACKAGE, getName(), ClassType.CLASS)
				.extend(CStruct.class)
				.setFinal(true)
				.setJavadoc(new CBJavadoc(VKGen.createCLayoutJavadoc(memoryLayout())))
				.checkImport(Arena.class)
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
				new CodeBody(VKGen.createMemLayout(memoryLayout(), cb) + ";")
		));

		// members
		for (VkgStructMember member : members()) {
			expMemberFields(cb, member);
		}

		// constructors
		cb.addElement(new CBConstructor(
				Modifier.PUBLIC,
				cb.thisType(),
				null,
				null,
				null,
				new CodeBody("this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());")
		));
		cb.addElement(new CBConstructor(
				Modifier.PUBLIC,
				cb.thisType(),
				null,
				null,
				List.of(new CBMethod.Arg(
						Arena.class,
						"arena"
				)),
				new CodeBody("this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());")
		));
		cb.addElement(new CBConstructor(
				Modifier.PUBLIC,
				cb.thisType(),
				null,
				null,
				List.of(
						new CBMethod.Arg(MemorySegment.class, "segment"),
						new CBMethod.Arg(long.class, "offset")
				),
				new CodeBody("super(segment, offset);")
		));

		// members
		for (VkgStructMember member : members()) {
			expMemberMethods(cb, member);
		}

		// array
		TextClassBuilder cba = new TextClassBuilder(PACKAGE, "Array", ClassType.CLASS)
				.extend(CBType.of(VkStructArray.class, cb.name))
				.setFinal(true)
				.setStatic(true);

		cba.addElement(new CBField(
				"CONSTRUCTOR",
				Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL,
				CBType.of(StructConstructor.class, cb.name),
				null,
				null,
				new CodeBody(cb.name + "::new;")

		));

		cba.addElement(new CBConstructor(
				Modifier.PUBLIC,
				cba.thisType(),
				null,
				null,
				List.of(new CBMethod.Arg(int.class, "size")),
				new CodeBody("super(Arena.ofAuto(), new "
						+ cb.name
						+ "[size], CONSTRUCTOR, MEMORY_LAYOUT);")
		));
		cba.addElement(new CBConstructor(
				Modifier.PUBLIC,
				cba.thisType(),
				null,
				null,
				List.of(new CBMethod.Arg(Arena.class, "arena"), new CBMethod.Arg(int.class, "size")),
				new CodeBody("super(arena, new "
						+ cb.name
						+ "[size], CONSTRUCTOR, MEMORY_LAYOUT);")
		));
		cba.addElement(new CBConstructor(
				Modifier.PUBLIC,
				cba.thisType(),
				null,
				null,
				List.of(new CBMethod.Arg(MemorySegment.class, "segment"), new CBMethod.Arg(long.class, "offset"), new CBMethod.Arg(int.class, "size")),
				new CodeBody("super(segment, offset, new "
						+ cb.name
						+ "[size], CONSTRUCTOR, MEMORY_LAYOUT);")
		));

		cb.addElement(cba);

		// overrides
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

		// end
		VKGen.export(cb);
	}

	@Override
	StructLayout memoryLayout();

	private static void expMemberFields(TextClassBuilder cb, VkgStructMember member) {
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

		if (member.type.memoryLayout() instanceof GroupLayout) {
			expComplex(member, cb);
		} else {
			IDataType t = member.type;
			if (t instanceof ArrayType at) {
				MemoryLayout sub = at.memoryLayout().elementLayout();
				if (sub instanceof GroupLayout) {
					expArrayComplex(member, cb, at.getRef());
				} else {
					if (t.nativeType() == null || t.nativeType() == NativeTypeEnum.VOID) {
						System.err.println(t);
						return;
					}
					expArrayGetter(member, cb, sub);
					expArraySetter(member, cb, sub);
				}
			} else {
				if (t.nativeType() == null || t.nativeType() == NativeTypeEnum.VOID) {
					System.err.println(t);
					return;
				}
				expGetter(member, cb);
				expSetter(member, cb, member.value);
			}
		}

	}

	private static void expComplex(VkgStructMember member, TextClassBuilder cb) {
		CBType rt = VKGen.cbType(member.type);
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				rt,
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				null,
				new CodeBody("return new "
						+ rt.name()
						+ "(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET"
						+ ");"
				)
		));
	}

	private static void expArrayComplex(VkgStructMember member, TextClassBuilder cb, IDataType sub) {
		CBType rt = VKGen.cbType(sub);
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				rt,
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				List.of(new CBMethod.Arg(int.class, "i")),
				new CodeBody("return new "
						+ rt.name()
						+ "(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET + "
						+ VKGen.referMemLayout(sub.memoryLayout(), cb)
						+ ".byteSize() * i);"
				)
		));
		CBType rt2 = new CBType(cb.name + ".Array", cb.pack);
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				rt2,
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				null,
				new CodeBody("return new Array(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET, "
						+ ((ArrayType) member.type).getLength()
						+ ");"
				)
		));
	}

	private static void expGetter(VkgStructMember member, TextClassBuilder cb) {
		cb.importStatic(SafeLinker.class, "*");
		Class<?> rt = member.type.nativeType().javaType.clazz;
		Class<?> jrt = member.type.javaType().clazz;
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				CBType.of(jrt),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				null,
				new CodeBody("return ("
						+ rt.getSimpleName()
						+ ") "
						+ rt.getSimpleName().toUpperCase()
						+ "_HANDLE.get(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET"
						+ ")" + member.type.booleanCastAppender() + ";"
				)
		));
	}

	private static void expArrayGetter(VkgStructMember member, TextClassBuilder cb, MemoryLayout subLayout) {
		cb.importStatic(SafeLinker.class, "*");
		cb.importStatic(ValueLayout.class, "*");
		Class<?> rt = member.type.nativeType().javaType.clazz;
		Class<?> jrt = member.type.javaType().clazz;
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				CBType.of(jrt),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				List.of(new CBMethod.Arg(int.class, "i")),
				new CodeBody("return ("
						+ rt.getSimpleName()
						+ ") "
						+ rt.getSimpleName().toUpperCase()
						+ "_HANDLE.get(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET + "
						+ VKGen.referMemLayout(subLayout, cb)
						+ ".byteSize() * i)" + member.type.booleanCastAppender() + ";"
				)
		));
		cb.addElement(new CBMethod(
				member.name + "Array",
				Modifier.PUBLIC,
				CBType.of(jrt.arrayType()),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				null,
				new CodeBody("var array = new "
						+ jrt.getSimpleName() + "[" + ((ArrayType) member.type).getLength() + "];",
						"\tMemorySegment.copy(this.segment, "
								+ rt.getSimpleName().toUpperCase()
								+ ", this.offset + "
								+ StringUtils.uppercaseUnderlined(member.name)
								+ "_OFFSET, array, 0, array.length);",
						"\treturn array;"
				)
		));
		if (member.type.nativeType() == NativeTypeEnum.CHAR) cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				CBType.of(String.class),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				null,
				new CodeBody("return this.segment.getString(this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET);"
				)
		));
	}

	private static void expArraySetter(VkgStructMember member, TextClassBuilder cb, MemoryLayout subLayout) {
		IDataType t = member.type;
		if (t.nativeType() == null || t.nativeType() == NativeTypeEnum.VOID) {
			System.err.println(t);
			return;
		}
		Class<?> in = member.type.nativeType().javaType.clazz;
		Class<?> jin = member.type.javaType().clazz;
		cb.importStatic(SafeLinker.class, "*");
		cb.importStatic(ValueLayout.class, "*");
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				cb.thisType(),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				List.of(new CBMethod.Arg(int.class, "i"), new CBMethod.Arg(jin, "value")),
				new CodeBody(in.getSimpleName().toUpperCase()
						+ "_HANDLE.set(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET + "
						+ VKGen.referMemLayout(subLayout, cb)
						+ ".byteSize() * i, value" + member.type.booleanUnCastAppender() + ");",
						"\treturn this;"
				)
		));
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				cb.thisType(),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				List.of(new CBMethod.Arg(jin.arrayType(), "value")),
				new CodeBody("MemorySegment.copy(value, 0, this.segment, "
						+ in.getSimpleName().toUpperCase()
						+ ", this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET"
						+ ", value.length);",
						"\treturn this;"
				)
		));
		if (member.type.nativeType() == NativeTypeEnum.CHAR) cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				cb.thisType(),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				List.of(new CBMethod.Arg(String.class, "value")),
				new CodeBody("this.segment.setString(this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET, value" + member.type.booleanUnCastAppender() + ");",
						"\treturn this;"
				)
		));
	}

	private static void expSetter(VkgStructMember member, TextClassBuilder cb, Object init) {
		IDataType t = member.type;
		if (t.nativeType() == null || t.nativeType() == NativeTypeEnum.VOID) {
			System.err.println(t);
			return;
		}
		Class<?> in = member.type.nativeType().javaType.clazz;
		Class<?> jin = member.type.javaType().clazz;
		cb.importStatic(SafeLinker.class, "*");
		cb.addElement(new CBMethod(
				member.name,
				Modifier.PUBLIC,
				cb.thisType(),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				List.of(new CBMethod.Arg(jin, "value")),
				new CodeBody(in.getSimpleName().toUpperCase() +
						"_HANDLE.set(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET"
						+ ", value" + member.type.booleanUnCastAppender() + ");",
						"\treturn this;"
				)
		));
		if (init != null) cb.addElement(new CBMethod(
				member.name + "$Default",
				Modifier.PUBLIC,
				cb.thisType(),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.type.nativeTypeName()))),
				new CBJavadoc(member.comment),
				null,
				new CodeBody(in.getSimpleName().toUpperCase()
						+ "_HANDLE.set(this.segment, this.offset + "
						+ StringUtils.uppercaseUnderlined(member.name) + "_OFFSET"
						+ ", "
						+ init
						+ ");",
						"\treturn this;"
				)
		));
	}
}
