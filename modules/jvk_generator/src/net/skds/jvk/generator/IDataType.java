package net.skds.jvk.generator;

import java.lang.foreign.MemoryLayout;

interface IDataType {

	String getName();

	String comment();

	NativeTypeEnum nativeType();

	MemoryLayout memoryLayout();

	default String nativeTypeName() {
		if (nativeType() == NativeTypeEnum.POINTER) {
			return getName() + "*";
		}
		return getName();
	}

	default void generate() {
	}
}
