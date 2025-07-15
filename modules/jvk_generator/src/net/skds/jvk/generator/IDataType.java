package net.skds.jvk.generator;

import java.lang.foreign.MemoryLayout;

interface IDataType {

	String getName();

	String comment();

	NativeTypeEnum nativeType();

	default JavaTypeEnum javaType() {
		return nativeType().javaType;
	}

	default boolean booleanCast() {
		if (nativeType() == null) return false;
		return nativeType().javaType != javaType() && javaType() == JavaTypeEnum.BOOLEAN;
	}

	default String booleanCastAppender() {
		if (!booleanCast()) return "";
		return " != 0";
	}

	default String booleanUnCastAppender() {
		if (!booleanCast()) return "";
		return " ? (" + nativeType().javaType.clazz.getSimpleName() + ") 1 : (" + nativeType().javaType.clazz.getSimpleName() + ") 0";
	}

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
