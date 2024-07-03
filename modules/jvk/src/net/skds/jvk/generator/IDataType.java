package net.skds.jvk.generator;

public interface IDataType {

	String getName();

	String comment();

	NativeTypeEnum nativeType();

	int size();

	default String className() {
		return "class " + getName();
	}

	default void generate() {
	}
}
