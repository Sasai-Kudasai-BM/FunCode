package net.skds.jvk.generator;

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
	public int size() {
		return NativeTypeEnum.POINTER.size();
	}

	@Override
	public String toString() {
		return "Pointer{" + pnt.toString() + "}";
	}
}
