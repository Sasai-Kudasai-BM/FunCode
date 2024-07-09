package net.skds.jvk.generator;

interface IDataType {

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
