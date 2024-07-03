package net.skds.jvk.generator;

import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public enum JavaTypeEnum {
	BYTE(byte.class, 1, Byte::valueOf),
	SHORT(short.class, 2, Short::valueOf),
	INT(int.class, 4, Integer::valueOf),
	LONG(long.class, 8, Long::valueOf),
	FLOAT(float.class, 4, Float::valueOf),
	DOUBLE(double.class, 8, Double::valueOf),
	VOID(void.class, 0, s -> null);

	public final Class<?> clazz;
	public final int byteSize;
	private final Function<String, Object> parser;

	public Object parse(String value) {

		if (value.startsWith("(")) {
			boolean invert = value.startsWith("~");
			boolean isLong = value.contains("LL");
			value = value.replace("(", "").replace(")", "").replace("U", "").replace("~", "").replace("L", "");
			long num = Long.parseLong(value);
			if (invert) {
				num = ~num;
			}
			return isLong ? num : (int) num;
		} else if (value.startsWith("0x")) {
			return Long.parseLong(value.substring(2), 16);
		}

		return parser.apply(value);
	}
}
