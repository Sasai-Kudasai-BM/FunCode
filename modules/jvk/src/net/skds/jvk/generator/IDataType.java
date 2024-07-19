package net.skds.jvk.generator;

interface IDataType {

	String getName();

	String comment();

	NativeTypeEnum nativeType();

	int size();

	default String nativeTypeName() {
		if (nativeType() == NativeTypeEnum.POINTER) {
			return getName() + "*";
		}
		return getName();
	}

	default void generate() {
	}
}
