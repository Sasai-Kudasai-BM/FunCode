package net.skds.jvk.generator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ArrayType implements IDataType {

	@Getter
	private final IDataType ref;

	private final String comment;

	@Getter
	private final int length;

	@Override
	public String getName() {
		return ref.getName() + "[" + length + "]";
	}

	@Override
	public String nativeTypeName() {
		return ref.nativeTypeName() + "[" + length + "]";
	}

	@Override
	public String comment() {
		return ref.comment();
	}

	@Override
	public NativeTypeEnum nativeType() {
		return ref.nativeType();
	}

	@Override
	public int size() {
		return ref.size() * length;
	}


	@Override
	public String toString() {
		return getName();
	}
}
