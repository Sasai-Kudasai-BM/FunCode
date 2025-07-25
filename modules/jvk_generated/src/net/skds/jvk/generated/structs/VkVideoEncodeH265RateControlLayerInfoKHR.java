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
* struct VkVideoEncodeH265RateControlLayerInfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 useMinQp;
* 	VkVideoEncodeH265QpKHR minQp;
* 	VkBool32 useMaxQp;
* 	VkVideoEncodeH265QpKHR maxQp;
* 	VkBool32 useMaxFrameSize;
* 	VkVideoEncodeH265FrameSizeKHR maxFrameSize;
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeH265RateControlLayerInfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			VkVideoEncodeH265QpKHR.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH265QpKHR.MEMORY_LAYOUT,
			JAVA_INT,
			VkVideoEncodeH265FrameSizeKHR.MEMORY_LAYOUT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int USE_MIN_QP_OFFSET = 16;
	private static final int MIN_QP_OFFSET = 20;
	private static final int USE_MAX_QP_OFFSET = 32;
	private static final int MAX_QP_OFFSET = 36;
	private static final int USE_MAX_FRAME_SIZE_OFFSET = 48;
	private static final int MAX_FRAME_SIZE_OFFSET = 52;
	
	public VkVideoEncodeH265RateControlLayerInfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH265RateControlLayerInfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeH265RateControlLayerInfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_LAYER_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_LAYER_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH265RateControlLayerInfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_LAYER_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeH265RateControlLayerInfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000039010);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoEncodeH265RateControlLayerInfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean useMinQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MIN_QP_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH265RateControlLayerInfoKHR useMinQp(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MIN_QP_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265QpKHR")
	public VkVideoEncodeH265QpKHR minQp() {
		return new VkVideoEncodeH265QpKHR(this.segment, this.offset + MIN_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public boolean useMaxQp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MAX_QP_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH265RateControlLayerInfoKHR useMaxQp(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MAX_QP_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265QpKHR")
	public VkVideoEncodeH265QpKHR maxQp() {
		return new VkVideoEncodeH265QpKHR(this.segment, this.offset + MAX_QP_OFFSET);
	}
	
	@NativeType("VkBool32")
	public boolean useMaxFrameSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USE_MAX_FRAME_SIZE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeH265RateControlLayerInfoKHR useMaxFrameSize(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + USE_MAX_FRAME_SIZE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkVideoEncodeH265FrameSizeKHR")
	public VkVideoEncodeH265FrameSizeKHR maxFrameSize() {
		return new VkVideoEncodeH265FrameSizeKHR(this.segment, this.offset + MAX_FRAME_SIZE_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeH265RateControlLayerInfoKHR> {
		
		private static final StructConstructor<VkVideoEncodeH265RateControlLayerInfoKHR> CONSTRUCTOR = VkVideoEncodeH265RateControlLayerInfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeH265RateControlLayerInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeH265RateControlLayerInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeH265RateControlLayerInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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