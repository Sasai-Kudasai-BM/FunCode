package net.skds.jvk.generator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NativeTypeEnum {
	INT8_T(JavaTypeEnum.BYTE),
	UINT8_T(JavaTypeEnum.BYTE),
	CHAR(JavaTypeEnum.BYTE),
	INT16_T(JavaTypeEnum.SHORT),
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

	public int byteSize() {
		return javaType.byteSize;
	}

	public Object parse(String value) {
		return javaType.parse(value);
	}
}
