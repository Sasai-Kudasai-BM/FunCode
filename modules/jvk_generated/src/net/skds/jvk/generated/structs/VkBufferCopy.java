package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static java.lang.foreign.ValueLayout.*;
import static net.skds.lib2.natives.LinkerUtils.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkBufferCopy {
* 	VkDeviceSize srcOffset;
* 	VkDeviceSize dstOffset;
* 	VkDeviceSize size;
* };
*</pre>
**/
@AutoGenerated
public final class VkBufferCopy extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int SRC_OFFSET_OFFSET = 0;
	private static final int DST_OFFSET_OFFSET = 8;
	private static final int SIZE_OFFSET = 16;
	
	public VkBufferCopy() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkBufferCopy(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkBufferCopy(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("VkDeviceSize")
	public long srcOffset() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SRC_OFFSET_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkBufferCopy srcOffset(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SRC_OFFSET_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long dstOffset() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + DST_OFFSET_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkBufferCopy dstOffset(long value) {
		LONG_HANDLE.set(this.segment, this.offset + DST_OFFSET_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long size() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkBufferCopy size(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SIZE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkBufferCopy> {
		
		private static final StructConstructor<VkBufferCopy> CONSTRUCTOR = VkBufferCopy::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkBufferCopy[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkBufferCopy[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkBufferCopy[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
	}
	
	@Override
	public int getAlignment() {
		return (int) MEMORY_LAYOUT.byteAlignment();
	}
	
	@Override
	public int getSize() {
		return (int) MEMORY_LAYOUT.byteSize();
	}
	
}