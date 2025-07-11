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
* struct VkVideoEncodeH265RateControlLayerInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint8_t temporalId;
* 	// pad (3)
* 	VkBool32 useInitialRcQp;
* 	VkVideoEncodeH265QpEXT initialRcQp;
* 	VkBool32 useMinQp;
* 	VkVideoEncodeH265QpEXT minQp;
* 	VkBool32 useMaxQp;
* 	VkVideoEncodeH265QpEXT maxQp;
* 	VkBool32 useMaxFrameSize;
* 	VkVideoEncodeH265FrameSizeEXT maxFrameSize;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeH265RateControlLayerInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_BYTE,
			paddingLayout(3),
			JAVA_INT,
			VkVideoEncodeH265QpEXT.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH265QpEXT.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH265QpEXT.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH265FrameSizeEXT.MEMORY_LAYOUT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int TEMPORAL_ID_OFFSET = 16;
	private static final int USE_INITIAL_RC_QP_OFFSET = 20;
	private static final int INITIAL_RC_QP_OFFSET = 24;
	private static final int USE_MIN_QP_OFFSET = 36;
	private static final int MIN_QP_OFFSET = 40;
	private static final int USE_MAX_QP_OFFSET = 52;
	private static final int MAX_QP_OFFSET = 56;
	private static final int USE_MAX_FRAME_SIZE_OFFSET = 68;
	private static final int MAX_FRAME_SIZE_OFFSET = 72;
	
	public VkVideoEncodeH265RateControlLayerInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH265RateControlLayerInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH265RateControlLayerInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_LAYER_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_LAYER_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH265RateControlLayerInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_LAYER_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH265RateControlLayerInfoEXT sType$Default() {
		INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET, 10);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoEncodeH265RateControlLayerInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint8_t")
	public byte temporalId() {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + TEMPORAL_ID_OFFSET);
	}
	
	@NativeType("uint8_t")
	public VkVideoEncodeH265RateControlLayerInfoEXT temporalId(byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + TEMPORAL_ID_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public int useInitialRcQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_INITIAL_RC_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH265RateControlLayerInfoEXT useInitialRcQp(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_INITIAL_RC_QP_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265QpEXT")
	public VkVideoEncodeH265QpEXT initialRcQp() {
		return new VkVideoEncodeH265QpEXT(this.segment, this.offset + INITIAL_RC_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public int useMinQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MIN_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH265RateControlLayerInfoEXT useMinQp(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MIN_QP_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265QpEXT")
	public VkVideoEncodeH265QpEXT minQp() {
		return new VkVideoEncodeH265QpEXT(this.segment, this.offset + MIN_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public int useMaxQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MAX_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH265RateControlLayerInfoEXT useMaxQp(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MAX_QP_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265QpEXT")
	public VkVideoEncodeH265QpEXT maxQp() {
		return new VkVideoEncodeH265QpEXT(this.segment, this.offset + MAX_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public int useMaxFrameSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MAX_FRAME_SIZE_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH265RateControlLayerInfoEXT useMaxFrameSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MAX_FRAME_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265FrameSizeEXT")
	public VkVideoEncodeH265FrameSizeEXT maxFrameSize() {
		return new VkVideoEncodeH265FrameSizeEXT(this.segment, this.offset + MAX_FRAME_SIZE_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeH265RateControlLayerInfoEXT> {
		
		private static final StructConstructor<VkVideoEncodeH265RateControlLayerInfoEXT> CONSTRUCTOR = VkVideoEncodeH265RateControlLayerInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeH265RateControlLayerInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeH265RateControlLayerInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeH265RateControlLayerInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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