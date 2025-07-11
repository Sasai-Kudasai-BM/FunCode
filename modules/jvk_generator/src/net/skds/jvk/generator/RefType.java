package net.skds.jvk.generator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.foreign.MemoryLayout;

@RequiredArgsConstructor
class RefType implements IDataType {

	@Getter
	private final IDataType ref;

	private final String name;

	@Override
	public String getName() {
		return name;
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
	public MemoryLayout memoryLayout() {
		return ref.memoryLayout();
	}


	@Override
	public String toString() {
		return "Ref(" + name + "){" + ref.toString() + "}";
	}
}
