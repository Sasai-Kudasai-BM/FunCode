package net.skds.jvk.generator;

import lombok.RequiredArgsConstructor;

public class DataType implements IDataType {

	protected String name;
	protected String comment = "";
	protected NativeTypeEnum nativeType;

	@Override
	public String name() {
		return name;
	}

	@Override
	public String comment() {
		return comment;
	}

	@Override
	public NativeTypeEnum nativeType() {
		return nativeType;
	}

	@Override
	public int size() {
		return nativeType.byteSize();
	}


	@Override
	public String toString() {
		return name + "[" + nativeType + "]";
	}

	@RequiredArgsConstructor
	protected static class Aliased implements IDataType {

		final String alias;
		final String name;
		IDataType parent;

		protected IDataType getParent() {
			if (parent == null) {
				parent = VKGen.types.get(alias);
			}
			return parent;
		}

		@Override
		public String name() {
			return name;
		}

		@Override
		public String comment() {
			return getParent().comment();
		}

		@Override
		public NativeTypeEnum nativeType() {
			return getParent().nativeType();
		}

		@Override
		public int size() {
			return getParent().size();
		}

		@Override
		public String toString() {
			return name + "[" + nativeType() + "]";
		}
	}
}
