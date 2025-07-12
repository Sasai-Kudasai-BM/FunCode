package net.skds.jvk.generator;

import lombok.CustomLog;
import lombok.Getter;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.misc.clazz.classbuilder.*;
import net.skds.lib2.natives.SafeLinker;
import net.skds.lib2.natives.struct.CStruct;
import net.skds.lib2.utils.StringUtils;
import org.w3c.dom.Element;

import java.lang.foreign.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@CustomLog
class Union extends DataType {

	public static final String PACKAGE = VKGen.ROOT_PACKAGE + ".unions";

	@Getter
	private final List<IDataType> members = new ArrayList<>();
	private UnionLayout layout;


	public Union(Element e) {
		this.name = e.getAttribute("name");

		VKGen.addTask(() -> {
			var mems = e.getElementsByTagName("member");
			for (int i = 0; i < mems.getLength(); i++) {
				Element member = (Element) mems.item(i);
				IDataType type = VKGen.getDataType(member.getElementsByTagName("type").item(0).getTextContent());
				if (member.getTextContent().contains("[")) {
					String cut = StringUtils.cutStringAfter(member.getTextContent(), '[');
					cut = StringUtils.cutStringBefore(cut, ']');
					int l = Integer.parseInt(cut);
					type = new ArrayType(type, l);
				}
				if (member.getTextContent().contains("*")) {
					type = new PointerType(type);
				}
				members.add(type);
			}
		});
	}

	@Override
	public UnionLayout memoryLayout() {
		UnionLayout l = this.layout;
		if (l == null) {
			l = MemoryLayout.unionLayout(members.stream().
					filter(d -> {
						//if (d.nativeType() == NativeTypeEnum.VOID || ((d instanceof PointerType pp) && pp.pnt().nativeType() == NativeTypeEnum.VOID)) {
						if (d.nativeType() == NativeTypeEnum.VOID) {
							log.warn("Skipping struct member " + d);
							return false;
						}
						return true;
					})
					.map(d -> d.memoryLayout().withName(d.nativeTypeName()))
					.toArray(MemoryLayout[]::new)
			).withName(getName());
			this.layout = l;
		}
		return l;
	}


	@Override
	public String toString() {
		return getName();
	}

	@Override
	public void generate() {
		TextClassBuilder cb = new TextClassBuilder(PACKAGE, getName(), ClassType.CLASS)
				.extend(CStruct.class)
				.setFinal(true)
				.setJavadoc(new CBJavadoc(VKGen.createCLayoutJavadoc(memoryLayout())))
				.checkImport(Arena.class)
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

		EnumSet<JavaTypeEnum> processed = EnumSet.noneOf(JavaTypeEnum.class);
		// members
		for (IDataType member : members) {
			if (member.nativeType() != null && !processed.add(member.nativeType().javaType)) {
				continue;
			}
			expMemberMethods(cb, member);
		}

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
		// array
		VKGen.export(cb);
	}

	private static void expMemberMethods(TextClassBuilder cb, IDataType member) {
		if (member.memoryLayout() instanceof GroupLayout) {
			expComplex(member, cb);
		} else {
			if (member instanceof ArrayType at) {
				MemoryLayout sub = at.memoryLayout().elementLayout();
				if (sub instanceof GroupLayout) {
					expArrayComplex(member, cb, at.getRef());
				} else {
					if (member.nativeType() == null || member.nativeType() == NativeTypeEnum.VOID) {
						System.err.println(member);
						return;
					}
					expArrayGetter(member, cb, sub);
					expArraySetter(member, cb, sub);
				}
			} else {
				if (member.nativeType() == null || member.nativeType() == NativeTypeEnum.VOID) {
					System.err.println(member);
					return;
				}
				expGetter(member, cb);
				expSetter(member, cb);
			}
		}

	}

	private static void expComplex(IDataType member, TextClassBuilder cb) {
		CBType rt = VKGen.cbType(member);
		cb.addElement(new CBMethod(
				"as" + StringUtils.uppercaseFirstChar(rt.name()),
				Modifier.PUBLIC,
				rt,
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.nativeTypeName()))),
				null,
				null,
				new CodeBody("return new "
						+ rt.name()
						+ "(this.segment, this.offset);"
				)
		));
	}

	private static void expArrayComplex(IDataType member, TextClassBuilder cb, IDataType sub) {
		CBType rt = VKGen.cbType(sub);
		cb.addElement(new CBMethod(
				"as" + StringUtils.uppercaseFirstChar(rt.name()),
				Modifier.PUBLIC,
				rt,
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.nativeTypeName()))),
				null,
				List.of(new CBMethod.Arg(int.class, "i")),
				new CodeBody("return new "
						+ rt.name()
						+ "(this.segment, this.offset + "
						+ VKGen.referMemLayout(sub.memoryLayout(), cb)
						+ ".byteSize() * i);"
				)
		));
		CBType rt2 = new CBType(cb.name + ".Array", cb.pack);
		cb.addElement(new CBMethod(
				"as" + StringUtils.uppercaseFirstChar(rt2.name()),
				Modifier.PUBLIC,
				rt2,
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.nativeTypeName()))),
				null,
				null,
				new CodeBody("return new Array(this.segment, this.offset);")
		));
	}

	private static void expGetter(IDataType member, TextClassBuilder cb) {
		cb.importStatic(SafeLinker.class, "*");
		Class<?> rt = member.nativeType().javaType.clazz;
		cb.addElement(new CBMethod(
				"as" + StringUtils.uppercaseFirstChar(rt.getSimpleName()),
				Modifier.PUBLIC,
				CBType.of(rt),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.nativeTypeName()))),
				null,
				null,
				new CodeBody("return ("
						+ rt.getSimpleName()
						+ ") "
						+ rt.getSimpleName().toUpperCase()
						+ "_HANDLE.get(this.segment, this.offset);"
				)
		));
	}

	private static void expArrayGetter(IDataType member, TextClassBuilder cb, MemoryLayout subLayout) {
		cb.importStatic(SafeLinker.class, "*");
		cb.importStatic(ValueLayout.class, "*");
		Class<?> rt = member.nativeType().javaType.clazz;
		cb.addElement(new CBMethod(
				"as" + StringUtils.uppercaseFirstChar(rt.getSimpleName()),
				Modifier.PUBLIC,
				CBType.of(rt),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.nativeTypeName()))),
				null,
				List.of(new CBMethod.Arg(int.class, "i")),
				new CodeBody("return ("
						+ rt.getSimpleName()
						+ ") "
						+ rt.getSimpleName().toUpperCase()
						+ "_HANDLE.get(this.segment, this.offset + ValueLayout."
						+ VKGen.referMemLayout(subLayout, cb)
						+ ".byteSize() * i);"
				)
		));
	}

	private static void expArraySetter(IDataType member, TextClassBuilder cb, MemoryLayout subLayout) {
		if (member.nativeType() == null || member.nativeType() == NativeTypeEnum.VOID) {
			System.err.println(member);
			return;
		}
		Class<?> in = member.nativeType().javaType.clazz;
		cb.importStatic(SafeLinker.class, "*");
		cb.importStatic(ValueLayout.class, "*");
		cb.addElement(new CBMethod(
				"as" + StringUtils.uppercaseFirstChar(in.getSimpleName()),
				Modifier.PUBLIC,
				cb.thisType(),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.nativeTypeName()))),
				null,
				List.of(new CBMethod.Arg(int.class, "i"), new CBMethod.Arg(in, "value")),
				new CodeBody(in.getSimpleName().toUpperCase()
						+ "_HANDLE.set(this.segment, this.offset + ValueLayout."
						+ VKGen.referMemLayout(subLayout, cb)
						+ ".byteSize() * i, value);",
						"\treturn this;"
				)
		));
	}

	private static void expSetter(IDataType member, TextClassBuilder cb) {
		if (member.nativeType() == null || member.nativeType() == NativeTypeEnum.VOID) {
			System.err.println(member);
			return;
		}
		Class<?> in = member.nativeType().javaType.clazz;
		cb.importStatic(SafeLinker.class, "*");
		cb.addElement(new CBMethod(
				"as" + StringUtils.uppercaseFirstChar(in.getSimpleName()),
				Modifier.PUBLIC,
				cb.thisType(),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(member.nativeTypeName()))),
				null,
				List.of(new CBMethod.Arg(in, "value")),
				new CodeBody(
						in.getSimpleName().toUpperCase() +
								"_HANDLE.set(this.segment, this.offset, value);",
						"\treturn this;"
				)
		));
	}
}
