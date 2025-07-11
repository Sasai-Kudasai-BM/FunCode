package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static net.skds.lib2.natives.SafeLinker.*;
import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkVideoEncodeH265RateControlInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t gopFrameCount;
* 	uint32_t idrPeriod;
* 	uint32_t consecutiveBFrameCount;
* 	VkVideoEncodeH265RateControlStructureFlagBitsEXT rateControlStructure;
* 	uint8_t subLayerCount;
* 	// pad (7)
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeH265RateControlInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_BYTE,
			paddingLayout(7)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int GOP_FRAME_COUNT_OFFSET = 16;
	private static final int IDR_PERIOD_OFFSET = 20;
	private static final int CONSECUTIVE_BFRAME_COUNT_OFFSET = 24;
	private static final int RATE_CONTROL_STRUCTURE_OFFSET = 28;
	private static final int SUB_LAYER_COUNT_OFFSET = 32;
	
	public VkVideoEncodeH265RateControlInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH265RateControlInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH265RateControlInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH265RateControlInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH265RateControlInfoEXT sType$Default() {
		INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET, 9);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoEncodeH265RateControlInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int gopFrameCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + GOP_FRAME_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeH265RateControlInfoEXT gopFrameCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + GOP_FRAME_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int idrPeriod() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IDR_PERIOD_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeH265RateControlInfoEXT idrPeriod(int value) {
		INT_HANDLE.set(this.segment, this.offset + IDR_PERIOD_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int consecutiveBFrameCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + CONSECUTIVE_BFRAME_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeH265RateControlInfoEXT consecutiveBFrameCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + CONSECUTIVE_BFRAME_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265RateControlStructureFlagBitsEXT")
	public int rateControlStructure() {
		return (int) INT_HANDLE.get(this.segment, this.offset + RATE_CONTROL_STRUCTURE_OFFSET);
	}
	
	@NativeType("VkVideoEncodeH265RateControlStructureFlagBitsEXT")
	public VkVideoEncodeH265RateControlInfoEXT rateControlStructure(int value) {
		INT_HANDLE.set(this.segment, this.offset + RATE_CONTROL_STRUCTURE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint8_t")
	public byte subLayerCount() {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + SUB_LAYER_COUNT_OFFSET);
	}
	
	@NativeType("uint8_t")
	public VkVideoEncodeH265RateControlInfoEXT subLayerCount(byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + SUB_LAYER_COUNT_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeH265RateControlInfoEXT> {
		
		private static final StructConstructor<VkVideoEncodeH265RateControlInfoEXT> CONSTRUCTOR = VkVideoEncodeH265RateControlInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeH265RateControlInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeH265RateControlInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeH265RateControlInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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