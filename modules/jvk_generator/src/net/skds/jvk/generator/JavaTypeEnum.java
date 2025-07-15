package net.skds.jvk.generator;

import lombok.AllArgsConstructor;

import java.lang.foreign.ValueLayout;
import java.util.function.Function;

@AllArgsConstructor
enum JavaTypeEnum {
	BOOLEAN(boolean.class, ValueLayout.JAVA_BOOLEAN, 1, Boolean::valueOf),
	BYTE(byte.class, ValueLayout.JAVA_BYTE, 1, Byte::valueOf),
	SHORT(short.class, ValueLayout.JAVA_SHORT, 2, Short::valueOf),
	INT(int.class, ValueLayout.JAVA_INT, 4, Integer::valueOf),
	LONG(long.class, ValueLayout.JAVA_LONG, 8, Long::valueOf),
	FLOAT(float.class, ValueLayout.JAVA_FLOAT, 4, Float::valueOf),
	DOUBLE(double.class, ValueLayout.JAVA_DOUBLE, 8, Double::valueOf),
	VOID(void.class, null, 0, s -> null);

	public final Class<?> clazz;
	public final ValueLayout layout;
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
