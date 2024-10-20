package net.skds.jvk.generator;

import lombok.RequiredArgsConstructor;

class DataType implements IDataType {

	protected String name;
	protected String comment = "";
	protected NativeTypeEnum nativeType;

	@Override
	public String getName() {
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
		return nativeType.size();
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
				parent = VKGen.getDataType(alias);
			}
			return parent;
		}

		@Override
		public String getName() {
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
