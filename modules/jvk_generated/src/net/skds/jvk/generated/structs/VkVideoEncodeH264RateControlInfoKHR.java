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
* struct VkVideoEncodeH264RateControlInfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkVideoEncodeH264RateControlFlagsKHR flags;
* 	uint32_t gopFrameCount;
* 	uint32_t idrPeriod;
* 	uint32_t consecutiveBFrameCount;
* 	uint32_t temporalLayerCount;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeH264RateControlInfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FLAGS_OFFSET = 16;
	private static final int GOP_FRAME_COUNT_OFFSET = 20;
	private static final int IDR_PERIOD_OFFSET = 24;
	private static final int CONSECUTIVE_BFRAME_COUNT_OFFSET = 28;
	private static final int TEMPORAL_LAYER_COUNT_OFFSET = 32;
	
	public VkVideoEncodeH264RateControlInfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH264RateControlInfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH264RateControlInfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH264RateControlInfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH264RateControlInfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000038008);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoEncodeH264RateControlInfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkVideoEncodeH264RateControlFlagsKHR")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkVideoEncodeH264RateControlFlagsKHR")
	public VkVideoEncodeH264RateControlInfoKHR flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int gopFrameCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + GOP_FRAME_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeH264RateControlInfoKHR gopFrameCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + GOP_FRAME_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int idrPeriod() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IDR_PERIOD_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeH264RateControlInfoKHR idrPeriod(int value) {
		INT_HANDLE.set(this.segment, this.offset + IDR_PERIOD_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int consecutiveBFrameCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + CONSECUTIVE_BFRAME_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeH264RateControlInfoKHR consecutiveBFrameCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + CONSECUTIVE_BFRAME_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int temporalLayerCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + TEMPORAL_LAYER_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeH264RateControlInfoKHR temporalLayerCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + TEMPORAL_LAYER_COUNT_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeH264RateControlInfoKHR> {
		
		private static final StructConstructor<VkVideoEncodeH264RateControlInfoKHR> CONSTRUCTOR = VkVideoEncodeH264RateControlInfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeH264RateControlInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeH264RateControlInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeH264RateControlInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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