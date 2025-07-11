package net.skds.jvk.generator;

import lombok.RequiredArgsConstructor;

import java.lang.foreign.MemoryLayout;

@RequiredArgsConstructor
enum NativeTypeEnum implements IDataType {
	INT8_T(JavaTypeEnum.BYTE),
	UINT8_T(JavaTypeEnum.BYTE),
	CHAR(JavaTypeEnum.BYTE),
	INT16_T(JavaTypeEnum.SHORT),
	INT(JavaTypeEnum.SHORT),
	UINT16_T(JavaTypeEnum.SHORT),
	INT32_T(JavaTypeEnum.INT),
	UINT32_T(JavaTypeEnum.INT),
	INT64_T(JavaTypeEnum.LONG),
	UINT64_T(JavaTypeEnum.LONG),
	FLOAT(JavaTypeEnum.FLOAT),
	DOUBLE(JavaTypeEnum.DOUBLE),
	POINTER(JavaTypeEnum.LONG),
	HANDLE(JavaTypeEnum.LONG),
	SIZE_T(JavaTypeEnum.LONG),
	VOID(JavaTypeEnum.VOID);

	public final JavaTypeEnum javaType;

	private final String name = name().toLowerCase();

	public int byteSize() {
		return javaType.byteSize;
	}

	public Object parse(String value) {
		return javaType.parse(value);
	}

	@Override
	public String comment() {
		return "";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public NativeTypeEnum nativeType() {
		return this;
	}

	@Override
	public MemoryLayout memoryLayout() {
		return javaType.layout;
	}
}
