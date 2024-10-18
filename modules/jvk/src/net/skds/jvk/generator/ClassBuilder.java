package net.skds.jvk.generator;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.skds.lib.utils.annotations.AutoGenerated;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
class ClassBuilder {

	@Setter
	String extend;
	@Setter
	String seal;
	public final String pack;
	public final String name;
	public final Type type;
	public final boolean fnl;
	public final boolean ordered;

	private final Set<Import> imports = new HashSet<>();
	public final List<Field> fields = new ArrayList<>();
	public final List<Method> methods = new ArrayList<>();

	public final List<Object> contents = new ArrayList<>();

	public ClassBuilder(String pack, String name, Type type) {
		this.pack = pack;
		this.name = name;
		this.type = type;
		this.fnl = true;
		this.ordered = false;
		checkImport(AutoGenerated.class);
	}


	public void method(String name, Class<?> rt, String body, String comment, Arg... args) {
		var mtd = new Method(name, rt, args, body, comment, "", false);
		methods.add(mtd);
		contents.add(mtd);
		checkImport(rt);
		checkImport(args);
	}

	public void method(String name, Class<?> rt, String body, String comment, String prefix, Arg... args) {
		var mtd = new Method(name, rt, args, body, comment, prefix, false);
		methods.add(mtd);
		contents.add(mtd);
		checkImport(rt);
		checkImport(args);
	}

	public void methodP(String name, Class<?> rt, String body, String comment, String prefix, Arg... args) {
		var mtd = new Method(name, rt, args, body, comment, prefix, true);
		methods.add(mtd);
		contents.add(mtd);
		checkImport(rt);
		checkImport(args);
	}

	public void field(String name, Class<?> type, String initializer, String comment) {
		var fld = new Field(name, new CT(type.getSimpleName(), type.getPackageName(), false), initializer, comment, "", false, true);
		fields.add(fld);
		contents.add(fld);
		checkImport(type);
	}

	public void field(String name, Class<?> type, String initializer, String comment, String prefix, boolean p) {
		var fld = new Field(name, new CT(type.getSimpleName(), type.getPackageName(), false), initializer, comment, prefix, p, true);
		fields.add(fld);
		contents.add(fld);
		checkImport(type);
	}

	public void fieldD(String name, Class<?> type, String initializer, String comment, String prefix, boolean p) {
		var fld = new Field(name, new CT(type.getSimpleName(), type.getPackageName(), false), initializer, comment, prefix, p, false);
		fields.add(fld);
		contents.add(fld);
		checkImport(type);
	}

	public void fieldD(String name, CT type, String initializer, String comment, String prefix, boolean p) {
		var fld = new Field(name, type, initializer, comment, prefix, p, false);
		fields.add(fld);
		contents.add(fld);
		checkImport(type.name, type.pack, type.array);
	}

	public void comment(String comment) {
		contents.add(comment);
	}

	public void export() {
		try {
			File dir = new File(VKGen.EXPORT_DIR, pack.replace(".", "/"));
			dir.mkdirs();
			File fl = new File(dir, name + ".java");
			Files.writeString(fl.toPath(), toString(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void writeMethod(Method mtd, StringBuilder sb) {
		sb.append("\n\t");
		if (mtd.comment != null && !mtd.comment.isEmpty()) {
			sb.append("/**\n\t* ").append(mtd.comment.replace("\n", "\n\t* ")).append("\n\t*/\n\t");
		}
		if (!mtd.prefix.isEmpty()) {
			sb.append(mtd.prefix).append("\n\t");
		}
		if (mtd.p) {
			sb.append("protected ");
		} else {
			sb.append("public static ");
		}
		sb.append(mtd.rt.getSimpleName()).append(" ").append(mtd.name).append("(");
		if (mtd.args != null) {
			for (int i = 0; i < mtd.args.length; i++) {
				if (i != 0) {
					sb.append(", ");
				}
				Arg arg = mtd.args[i];
				if (arg.insertion != null) {
					sb.append(arg.insertion).append(" ");
				}
				sb.append(arg.type.getSimpleName()).append(" ").append(arg.name);
			}
		}
		sb.append(") {\n");
		sb.append(mtd.body);
		sb.append("\n\t}\n");
	}

	private void writeContent(Object o, StringBuilder sb) {
		if (o instanceof String comment) {
			sb.append("\n\t// ").append(comment.replace("\t", "").replace("\n", "\n\t//")).append("\n");
		} else if (o instanceof Field fld) {
			writeField(fld, sb);
		} else if (o instanceof Method mtd) {
			writeMethod(mtd, sb);
		}
	}

	private void writeField(Field fld, StringBuilder sb) {
		sb.append("\n\t");
		if (fld.comment != null && !fld.comment.isEmpty()) {
			sb.append("/**\n\t* ").append(fld.comment.replace("\n", "\n\t* ")).append("\n\t*/\n\t");
		}
		if (!fld.prefix.isEmpty()) {
			sb.append(fld.prefix).append("\n\t");
		}
		if (fld.type != null) {
			if (type == Type.CLASS) {
				if (fld.p) {
					sb.append("private");
				} else {
					sb.append("public");
				}
				if (fld.sf) {
					sb.append(" static final");
				}
			}
			sb.append(" ").append(fld.type.name).append(fld.type.arrayAppend()).append(" ").append(fld.name);
			if (fld.initializer != null && !fld.initializer.isEmpty()) {
				sb.append(" = ").append(fld.initializer);
			}
			sb.append(";");
		}
		sb.append("\n");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("package ").append(pack).append(";\n");

		for (Import imp : imports) {
			sb.append("import ");
			if (imp.s) {
				sb.append("static ");
			}
			sb.append(imp.t.pack).append(".").append(imp.t.name);
			if (imp.s) {
				sb.append(".*");
			}
			sb.append(";\n");
		}
		sb.append("\n@AutoGenerated\n@SuppressWarnings(\"unused\")\npublic ");
		if (fnl) {
			if (seal != null) {
				sb.append("sealed ");
			} else {
				sb.append("final ");
			}
		}
		sb.append(type.name().toLowerCase()).append(" ").append(name);
		if (extend != null) {
			sb.append(" extends ").append(extend);
		}
		if (seal != null) {
			sb.append(" permits ").append(seal);
		}
		sb.append(" {\n\n");

		if (ordered) {
			for (Object o : contents) {
				writeContent(o, sb);
			}
		} else {
			for (Field fld : fields) {
				writeField(fld, sb);
			}

			sb.append("\n");

			for (Method mtd : methods) {
				writeMethod(mtd, sb);
			}
		}

		return sb.append("}").toString();
	}

	public record Arg(Class<?> type, String name, String insertion) {
		public Arg(Class<?> type, String name) {
			this(type, name, null);
		}
	}

	public record Method(String name, Class<?> rt, Arg[] args, String body, String comment, String prefix, boolean p) {

	}

	public record Field(String name, CT type, String initializer, String comment, String prefix, boolean p,
						boolean sf) {

	}

	public enum Type {
		CLASS, ENUM;
	}

	public record CT(String name, String pack, boolean array) {
		String arrayAppend() {
			return array ? "[]" : "";
		}
	}

	private record Import(CT t, boolean s) {
	}

	private void checkImport(Arg... type) {
		for (int i = 0; i < type.length; i++) {
			checkImport(type[i].type);
		}
	}

	public void checkImport(Class<?> type) {
		if (type == null || type.isPrimitive() || (type.isArray() && type.getComponentType().isPrimitive())) return;
		imports.add(new Import(new CT(type.getSimpleName(), type.getPackageName(), false), false));
	}

	public void importStatic(Class<?> type) {
		if (type == null || type.isPrimitive()) return;
		imports.add(new Import(new CT(type.getSimpleName(), type.getPackageName(), false), true));
	}

	public void checkImport(String name, String pack, boolean isArray) {
		if (type == null || Character.isLowerCase(name.charAt(0))) return;
		imports.add(new Import(new CT(name, pack, isArray), false));
	}

	public void importStatic(String name, String pack, boolean isArray) {
		if (type == null || Character.isLowerCase(name.charAt(0))) return;
		imports.add(new Import(new CT(name, pack, isArray), true));
	}
}
