package net.skds.jvk.generator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.SequenceLayout;
import java.util.StringJoiner;

@RequiredArgsConstructor
class ArrayType implements IDataType {

	@Getter
	private final IDataType ref;

	private SequenceLayout layout;

	@Getter
	private final int length;

	@Getter
	private final int[] trueLength;

	public ArrayType(IDataType ref, int length) {
		this.ref = ref;
		this.length = length;
		this.trueLength = new int[]{length};
	}

	@Override
	public String getName() {
		return ref.getName() + "[" + length + "]";
	}

	@Override
	public String nativeTypeName() {
		if (trueLength.length > 1) {
			StringJoiner sj = new StringJoiner("][", "[", "]");
			for (int i = 0; i < trueLength.length; i++) {
				sj.add(String.valueOf(trueLength[i]));
			}
			return ref.nativeTypeName() + sj;
		}
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
	public SequenceLayout memoryLayout() {
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
