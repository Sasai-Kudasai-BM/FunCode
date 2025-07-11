package net.skds.jvk.generator;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.ValueLayout;

record PointerType(IDataType pnt) implements IDataType {

	@Override
	public String getName() {
		return pnt.getName();
	}

	@Override
	public String nativeTypeName() {
		return pnt.nativeTypeName() + "*";
	}

	@Override
	public String comment() {
		return pnt.comment();
	}

	@Override
	public NativeTypeEnum nativeType() {
		return NativeTypeEnum.POINTER;
	}


	@Override
	public MemoryLayout memoryLayout() {
		return ValueLayout.JAVA_LONG;
	}

	@Override
	public String toString() {
		return "Pointer{" + pnt.toString() + "}";
	}
}
