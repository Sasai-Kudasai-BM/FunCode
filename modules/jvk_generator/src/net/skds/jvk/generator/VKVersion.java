package net.skds.jvk.generator;

import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.misc.clazz.classbuilder.*;
import net.skds.lib2.natives.SafeLinker;
import net.skds.lib2.utils.Holders;
import net.skds.lib2.utils.StringUtils;
import org.w3c.dom.Element;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class VKVersion {
	boolean extension;
	String name;
	final List<Object> contents = new ArrayList<>();    // String, Enum, Command, Type, Holder
	final Set<String> names = new HashSet<>();

	public static VKVersion create(Element e) {
		VKVersion vkv = new VKVersion();
		switch (e.getNodeName()) {
			case "feature" -> feature(e, vkv);
			case "extension" -> extension(e, vkv);
			default -> throw new RuntimeException(e.getNodeName());
		}

		var lst = e.getElementsByTagName("require");
		for (int i = 0; i < lst.getLength(); i++) {
			if (lst.item(i) instanceof Element e2 && VKGen.isApiAllowed(e2.getAttribute("api"))) {
				String comment = e2.getAttribute("comment");
				if (!comment.isEmpty()) {
					vkv.contents.add(comment);
				}
				var lst2 = e2.getChildNodes();
				for (int i2 = 0; i2 < lst2.getLength(); i2++) {
					if (lst2.item(i2) instanceof Element e3) {
						comment = e3.getAttribute("comment");
						if (!comment.isEmpty()) {
							vkv.contents.add(comment);
						}
						switch (e3.getNodeName()) {
							case "comment" -> vkv.contents.add(e3.getTextContent());
							case "enum" -> {
								var vv = EnumType.parseValue(e3);
								if (vv == null) {
									Holders.ObjectHolder<EnumType.Value> h = new Holders.ObjectHolder<>();
									vkv.contents.add(h);
									VKGen.addTask(() -> h.setValue(EnumType.parseValue(e3)));
								} else {
									if (!vkv.names.add(vv.name())) {
										break;
									}
									vkv.contents.add(vv);
								}
							}
							case "type" -> {
								var t = VKGen.types.get(e3.getAttribute("name"));
								if (t == null) {
									System.out.println("skip " + e3.getAttribute("name"));
								} else {
									vkv.contents.add(t);
								}
							}
							case "command" -> {
								String nme = e3.getAttribute("name");
								if (vkv.names.add(nme)) {
									vkv.contents.add(VKGen.commands.get(nme));
								}
							}
						}
					}
				}
			}
		}

		vkv.contents.removeIf(o -> o instanceof EnumType.Value v && v.type() == null);
		return vkv;
	}

	public void export() {
		if (contents.isEmpty()) {
			return;
		}
		TextClassBuilder cb;
		if (!extension) {
			String pack = VKGen.ROOT_PACKAGE;
			cb = new TextClassBuilder(pack, name, ClassType.CLASS);

			if (name.startsWith("VK")) {
				int n = Integer.parseInt(name.substring(3));
				if (n == 0) {
					cb.permit(new CBType("VK11", pack));
				} else if (n == VkDefinitions.vkApiVersionMinor(VkDefinitions.VK_HEADER_VERSION_COMPLETE)) {
					cb.setFinal(true)
							.extend(new CBType("VK1" + (n - 1), pack));
				} else {
					cb.permit(new CBType("VK1" + (n + 1), pack))
							.extend(new CBType("VK1" + (n - 1), pack));
				}
			}
		} else {
			String pack = VKGen.ROOT_PACKAGE + ".extensions";
			cb = new TextClassBuilder(pack, name, ClassType.CLASS).setFinal(true);
		}


		cb.checkImport(VkDefinitions.class);
		cb.importStatic(SafeLinker.class, "*");

		for (Object o : contents) {
			writeContent(o, cb);
		}

		VKGen.export(cb);
	}

	private void writeContent(Object o, TextClassBuilder cb) {
		if (o instanceof Holders.ObjectHolder<?> h) {
			writeContent(h.getValue(), cb);
			return;
		}

		if (o instanceof String s) {
			cb.comment(s);
		} else if (o instanceof EnumType.Value value) {
			String init = String.valueOf(value.v());
			if (value.v().getClass() == Float.class) {
				init += "F";
			} else if (value.type().javaType == JavaTypeEnum.LONG) {
				init += "L";
			}
			CBField field = new CBField(
					value.name(),
					Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL,
					CBType.of(value.type().javaType.clazz),
					null,
					new CBJavadoc(value.comment()),
					new CodeBody(init + ";")
			);
			cb.addElement(field);
		} else if (o instanceof ICommand command) {

			var t = command.returnType().nativeType().javaType.clazz;
			var jt = command.returnType().javaType().clazz;

			StringBuilder mh = new StringBuilder("createHandle(")
					.append("VkDefinitions.LIBRARY_LOOKUP, \"")
					.append(command.name())
					.append("\", ")
					.append(command.returnType().nativeType().javaType.clazz.getSimpleName().toUpperCase());


			StringBuilder body0 = new StringBuilder("\t");
			if (jt != void.class) {
				body0.append("return (").append(t.getSimpleName()).append(") ");
			}
			body0.append(command.name()).append(".invokeExact(");
			List<CBMethod.Arg> args = command.arguments();
			List<CommandArgument> rawArgs = command.rawArguments();
			for (int i = 0; i < args.size(); i++) {
				var arg = args.get(i);
				var rawArg = rawArgs.get(i);
				body0.append(arg.name()).append(rawArg.type().booleanUnCastAppender()).append(", ");
				mh.append(", ").append(arg.type().name().toUpperCase());
			}
			if (!args.isEmpty()) {
				body0.setLength(body0.length() - 2);
			}
			mh.append(");");
			body0.append(")").append(command.returnType().booleanCastAppender()).append(";");

			List<String> body = List.of(
					"try {",
					"\t" + body0,
					"\t} catch (Throwable e) {",
					"\t\tthrow new Error(e);",
					"\t}"
			);
			CBField field = new CBField(
					command.name(),
					Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL,
					CBType.of(MethodHandle.class),
					null,
					null,
					new CodeBody(mh.toString())
			);
			cb.addElement(field);

			CBMethod method = new CBMethod(
					command.name(),
					Modifier.PUBLIC | Modifier.STATIC,
					CBType.of(jt),
					List.of(new CBAnnotation(NativeType.class, StringUtils.quote(command.returnType().nativeTypeName()))),
					new CBJavadoc(command.comment()),
					args,
					new CodeBody(body)
			);
			cb.addElement(method);
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name).append("\n");
		for (Object o : contents) {
			sb.append("\t").append(o).append("\n");
		}
		return sb.toString();
	}

	private static void feature(Element e, VKVersion vkv) {
		String number = e.getAttribute("number");
		vkv.name = "VK" + number.replace(".", "");
	}

	private static void extension(Element e, VKVersion vkv) {
		String number = e.getAttribute("name").toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (String s : number.split("_")) {
			if (!s.isEmpty()) {
				sb.append(Character.toUpperCase(s.charAt(0)));
				if (s.length() > 1) {
					sb.append(s.substring(1));
				}
			}
		}
		vkv.name = sb.toString();
		vkv.extension = true;
	}
}
