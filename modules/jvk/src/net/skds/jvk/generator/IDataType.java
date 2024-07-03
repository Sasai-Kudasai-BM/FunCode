package net.skds.jvk.generator;

public interface IDataType {

	String name();

	String comment();

	NativeTypeEnum nativeType();

	int size();

	default String className() {
		return "class " + name();
	}
}
