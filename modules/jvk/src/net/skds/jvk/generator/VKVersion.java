package net.skds.jvk.generator;

import net.skds.jvk.VKDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib.utils.Holders;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.ninvoker.NInvoker;
import org.w3c.dom.Element;

import java.lang.invoke.MethodHandle;
import java.util.ArrayList;
import java.util.List;


public class VKVersion {
	boolean extension;
	String name;
	final List<Object> contents = new ArrayList<>();    // String, Enum, Command, Type, Holder

	public static VKVersion create(Element e) {
		VKVersion vkv = new VKVersion();
		switch (e.getNodeName()) {
			case "feature" -> feature(e, vkv);
			case "extension" -> extension(e, vkv);
			default -> throw new RuntimeException(e.getNodeName());
		}

		var lst = e.getElementsByTagName("require");
		for (int i = 0; i < lst.getLength(); i++) {
			if (lst.item(i) instanceof Element e2) {
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
							case "command" -> vkv.contents.add(VKGen.commands.get(e3.getAttribute("name")));
						}
					}
				}
			}
		}

		return vkv;
	}

	public void export() {
		ClassBuilder cb;
		if (!extension) {
			String pack = VKGen.ROOT_PACKAGE;
			cb = new ClassBuilder(pack, name, ClassBuilder.Type.CLASS, true, true);

			switch (name) {
				case "VK10" -> {
					cb.field("INITIALIZED", boolean.class, "VKDefinitions.INITIALIZED", "");
					cb.setSeal("VK11");
				}
				case "VK11" -> {
					cb.setExtend("VK10");
					cb.setSeal("VK12");
				}
				case "VK12" -> {
					cb.setExtend("VK11");
					cb.setSeal("VK13");
				}
				case "VK13" -> cb.setExtend("VK12");
			}
		} else {
			String pack = VKGen.ROOT_PACKAGE + ".extensions";
			cb = new ClassBuilder(pack, name, ClassBuilder.Type.CLASS, true, true);
			cb.field("INITIALIZED", boolean.class, "VKDefinitions.INITIALIZED", "");
		}

		cb.checkImport(AutoGenerated.class);
		cb.checkImport(NativeType.class);
		cb.checkImport(VKDefinitions.class);
		cb.importStatic(NInvoker.class);
		for (Object o : contents) {
			writeContent(o, cb);
		}

		cb.export();
	}

	private void writeContent(Object o, ClassBuilder cb) {
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
			}
			cb.field(value.name(), value.type() == null ? null : value.type().javaType.clazz, init, value.comment());
		} else if (o instanceof ICommand command) {

			var t = command.returnType().nativeType().javaType.clazz;

			StringBuilder body = new StringBuilder("\t\ttry {\n\t\t\t");
			StringBuilder mh = new StringBuilder("createHandle(\"")
					.append(command.name())
					.append("\", ")
					.append(command.returnType().nativeType().javaType.clazz.getSimpleName().toUpperCase());
			if (t != void.class) {
				body.append("return (").append(t.getSimpleName()).append(") ");
			}
			body.append(command.name()).append(".invokeExact(");
			var args = command.arguments();
			for (var arg : args) {
				body.append(arg.name()).append(", ");
				mh.append(", ").append(arg.type().getSimpleName().toUpperCase());
			}
			if (args.length > 0) {
				body.setLength(body.length() - 2);
			}
			mh.append(")");
			body.append(");\n");
			body.append("\t\t} catch (Throwable e) { throw new RuntimeException(e); }");

			cb.field(command.name(), MethodHandle.class, mh.toString(), "", true);
			//createWinHandle("GetAsyncKeyState", SHORT, INT)
			cb.method(command.name(), t, body.toString(), command.comment(), "@NativeType(\"" + command.returnType().getName() + "\")", args);
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
		String number = e.getAttribute("name");
		vkv.name = number.toLowerCase();
		vkv.extension = true;
	}
}
