package net.skds.jvk.generator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.SequenceLayout;

@RequiredArgsConstructor
class ArrayType implements IDataType {

	@Getter
	private final IDataType ref;

	private final String comment;

	private SequenceLayout layout;

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
	public MemoryLayout memoryLayout() {
		SequenceLayout l = this.layout;
		if (l == null) {
			l = MemoryLayout.sequenceLayout(length, ref.memoryLayout());
			this.layout = l;
		}
		return l;
	}


	@Override
	public String toString() {
		return getName();
	}
}
