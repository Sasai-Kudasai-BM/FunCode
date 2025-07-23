package net.skds.jvk.shader;

import java.lang.foreign.MemorySegment;

public record SpirvPointer(int size, long address, MemorySegment segment) {

	public SpirvPointer(MemorySegment segment) {
		this((int) segment.byteSize(), segment.address(), segment);
	}
	
	public SpirvPointer(int size, long address) {
		this(size, address, null);
	}
}
