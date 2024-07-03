package net.skds.jvk.generator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointerType implements IDataType {

	@Getter
	private final IDataType pnt;

	@Override
	public String getName() {
		return pnt.getName();
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
