package net.skds.sound;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PCMFormat {
	PCM_INT_8(1),
	PCM_INT_16(2),
	PCM_FLOAT_32(4),
	;
	private final int byteSize;
	//private final IntFunction<Object> arrayConstructor;
}
