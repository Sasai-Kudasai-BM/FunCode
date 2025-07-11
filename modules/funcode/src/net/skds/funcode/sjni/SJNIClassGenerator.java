package net.skds.funcode.sjni;

import net.skds.lib2.utils.logger.SKDSLogger;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.Label;
import java.lang.classfile.Opcode;
import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.MethodTypeDesc;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SJNIClassGenerator {


	public static void main(String[] args) throws Exception {
		SKDSLogger.replaceOuts();

		kek2();
	}

	static void kek2() throws Exception {

		byte[] bytes = ClassFile.of().build(ClassDesc.of("net.skds.test", "TestClass"), cb -> {
			cb.withMethod(
					"test",
					MethodTypeDesc.of(ConstantDescs.CD_int, ConstantDescs.CD_boolean),
					Modifier.PUBLIC | Modifier.STATIC,
					mb -> mb.withCode(code -> code
							.localVariable(0, "keks", ConstantDescs.CD_boolean, code.startLabel(), code.endLabel())
							.iload(0)
							.ifThen(Opcode.IFEQ, bcb -> bcb.loadConstant(33).ireturn())
							.loadConstant(17L)
							.l2i()
							.ireturn()
					)
			);
		});
		Class<?> c = SJNIClassLoader.INSTANCE.compileClass(null, bytes);
		System.out.println(c);
		Method m = c.getDeclaredMethod("test", boolean.class);
		System.out.println(m);
		System.out.println(m.invoke(null, false));
		System.out.println(m.invoke(null, true));
	}

	static void kek() throws IOException {
		var p = ClassFile.of().parse(LolImpl.class.getResourceAsStream("SJNIClassGenerator$LolImpl.class").readAllBytes());

		StringBuilder sb = new StringBuilder("\nFlags ");
		sb.append(p.flags().flags());
		sb.append("\nsuperclass ").append(p.superclass());

		sb.append("\nfields");
		p.fields().forEach(f -> {

		});
		p.methods().forEach(m -> {
			sb.append("\n\t").append(m);
			sb.append("\n\t\tparent ").append(m.parent());
			sb.append("\n\t\tflags ").append(m.flags().flags());
			m.code().ifPresent(cm -> {
				sb.append("\n\t\tcm ").append(cm);
				cm.elementList().forEach(ce -> {
					if (ce instanceof Label) return;
					sb.append("\n\t\t\t ").append(ce);
				});
			});

		});
		System.out.println(sb);
	}

	private interface Lol {

		int test();

	}

	private static class LolImpl implements Lol {

		@Override
		public int test() {
			int hash = hashCode();
			boolean s = hash < 0;
			if (!s) hash++;

			return hash;
		}
		/*
		public int test2() {
			try {
				new LolImpl().test();
			} catch (Exception e) {
				System.out.println(e.toString());
			}

			return 0;
		}

		public int test3(int a) {

			test4(3, 0);
			test4();
			return 0;
		}

		public int test4(int... a) {
			return 0;
		}

 		*/
	}
}
