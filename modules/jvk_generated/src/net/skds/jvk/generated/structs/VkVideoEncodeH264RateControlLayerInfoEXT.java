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
* struct VkVideoEncodeH264RateControlLayerInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint8_t temporalLayerId;
* 	// pad (3)
* 	VkBool32 useInitialRcQp;
* 	VkVideoEncodeH264QpEXT initialRcQp;
* 	VkBool32 useMinQp;
* 	VkVideoEncodeH264QpEXT minQp;
* 	VkBool32 useMaxQp;
* 	VkVideoEncodeH264QpEXT maxQp;
* 	VkBool32 useMaxFrameSize;
* 	VkVideoEncodeH264FrameSizeEXT maxFrameSize;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeH264RateControlLayerInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_BYTE,
			paddingLayout(3),
			JAVA_INT,
			VkVideoEncodeH264QpEXT.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH264QpEXT.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH264QpEXT.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH264FrameSizeEXT.MEMORY_LAYOUT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int TEMPORAL_LAYER_ID_OFFSET = 16;
	private static final int USE_INITIAL_RC_QP_OFFSET = 20;
	private static final int INITIAL_RC_QP_OFFSET = 24;
	private static final int USE_MIN_QP_OFFSET = 36;
	private static final int MIN_QP_OFFSET = 40;
	private static final int USE_MAX_QP_OFFSET = 52;
	private static final int MAX_QP_OFFSET = 56;
	private static final int USE_MAX_FRAME_SIZE_OFFSET = 68;
	private static final int MAX_FRAME_SIZE_OFFSET = 72;
	
	public VkVideoEncodeH264RateControlLayerInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH264RateControlLayerInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH264RateControlLayerInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_LAYER_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_LAYER_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH264RateControlLayerInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_LAYER_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH264RateControlLayerInfoEXT sType$Default() {
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
	public VkVideoEncodeH264RateControlLayerInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint8_t")
	public byte temporalLayerId() {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + TEMPORAL_LAYER_ID_OFFSET);
	}
	
	@NativeType("uint8_t")
	public VkVideoEncodeH264RateControlLayerInfoEXT temporalLayerId(byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + TEMPORAL_LAYER_ID_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public int useInitialRcQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_INITIAL_RC_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH264RateControlLayerInfoEXT useInitialRcQp(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_INITIAL_RC_QP_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH264QpEXT")
	public VkVideoEncodeH264QpEXT initialRcQp() {
		return new VkVideoEncodeH264QpEXT(this.segment, this.offset + INITIAL_RC_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public int useMinQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MIN_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH264RateControlLayerInfoEXT useMinQp(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MIN_QP_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH264QpEXT")
	public VkVideoEncodeH264QpEXT minQp() {
		return new VkVideoEncodeH264QpEXT(this.segment, this.offset + MIN_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public int useMaxQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MAX_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH264RateControlLayerInfoEXT useMaxQp(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MAX_QP_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH264QpEXT")
	public VkVideoEncodeH264QpEXT maxQp() {
		return new VkVideoEncodeH264QpEXT(this.segment, this.offset + MAX_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public int useMaxFrameSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MAX_FRAME_SIZE_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH264RateControlLayerInfoEXT useMaxFrameSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MAX_FRAME_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH264FrameSizeEXT")
	public VkVideoEncodeH264FrameSizeEXT maxFrameSize() {
		return new VkVideoEncodeH264FrameSizeEXT(this.segment, this.offset + MAX_FRAME_SIZE_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeH264RateControlLayerInfoEXT> {
		
		private static final StructConstructor<VkVideoEncodeH264RateControlLayerInfoEXT> CONSTRUCTOR = VkVideoEncodeH264RateControlLayerInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeH264RateControlLayerInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeH264RateControlLayerInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeH264RateControlLayerInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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