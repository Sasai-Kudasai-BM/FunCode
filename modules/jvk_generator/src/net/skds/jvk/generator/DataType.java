package net.skds.jvk.generator;

import lombok.RequiredArgsConstructor;

import java.lang.foreign.MemoryLayout;

class DataType implements IDataType {

	protected String name;
	protected String comment = "";
	protected NativeTypeEnum nativeType;

	@Override
	public MemoryLayout memoryLayout() {
		return nativeType.javaType.layout;
	}

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
		public MemoryLayout memoryLayout() {
			return getParent().memoryLayout();
		}

		@Override
		public String toString() {
			return name + "[" + nativeType() + "]";
		}
	}
}
