package net.skds.funcode.sjni;

import net.skds.lib2.utils.logger.SKDSLogger;

import java.lang.constant.ClassDesc;
import java.util.function.Consumer;

public class SJNIClassGenerator {

	@SuppressWarnings("unchecked")
	public static <I, T extends I> Class<T> createImpl(Class<I> interfaceClass) {
		String name = interfaceClass.getName() + "$Generated";


		ClassDesc cd = ClassDesc.of(name);
		//ConstantPoolBuilder cpb = ConstantPoolBuilder.of();
		Consumer<Object> consumer = System.out::println;
		//cd.
		byte[] bytes = null;// ClassFile.of().build(cd, consumer);
		Class<?> cl = SJNIClassLoader.INSTANCE.compileClass(name, bytes);
		return (Class<T>) cl;
	}

	public static void main(String[] args) {
		SKDSLogger.replaceOuts();

		//JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//compiler.run(null, System.out, System.err, sourceFile.getPath());

		//Class<? extends Lol> cl = createImpl(Lol.class);
		//System.out.println(cl);
	}

	private interface Lol {

	}
}
