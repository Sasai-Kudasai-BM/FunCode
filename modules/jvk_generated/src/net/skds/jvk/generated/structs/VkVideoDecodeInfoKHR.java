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
* struct VkVideoDecodeInfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkVideoDecodeFlagsKHR flags;
* 	// pad (4)
* 	VkBuffer* srcBuffer;
* 	VkDeviceSize srcBufferOffset;
* 	VkDeviceSize srcBufferRange;
* 	VkVideoPictureResourceInfoKHR dstPictureResource;
* 	VkVideoReferenceSlotInfoKHR* pSetupReferenceSlot;
* 	uint32_t referenceSlotCount;
* 	// pad (4)
* 	VkVideoReferenceSlotInfoKHR* pReferenceSlots;
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoDecodeInfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			VkVideoPictureResourceInfoKHR.MEMORY_LAYOUT,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FLAGS_OFFSET = 16;
	private static final int SRC_BUFFER_OFFSET = 24;
	private static final int SRC_BUFFER_OFFSET_OFFSET = 32;
	private static final int SRC_BUFFER_RANGE_OFFSET = 40;
	private static final int DST_PICTURE_RESOURCE_OFFSET = 48;
	private static final int P_SETUP_REFERENCE_SLOT_OFFSET = 96;
	private static final int REFERENCE_SLOT_COUNT_OFFSET = 104;
	private static final int P_REFERENCE_SLOTS_OFFSET = 112;
	
	public VkVideoDecodeInfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoDecodeInfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoDecodeInfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_DECODE_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_DECODE_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkVideoDecodeInfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_DECODE_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkVideoDecodeInfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000024000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoDecodeInfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkVideoDecodeFlagsKHR")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkVideoDecodeFlagsKHR")
	public VkVideoDecodeInfoKHR flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBuffer*")
	public long srcBuffer() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SRC_BUFFER_OFFSET);
	}
	
	@NativeType("VkBuffer*")
	public VkVideoDecodeInfoKHR srcBuffer(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SRC_BUFFER_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long srcBufferOffset() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SRC_BUFFER_OFFSET_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkVideoDecodeInfoKHR srcBufferOffset(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SRC_BUFFER_OFFSET_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long srcBufferRange() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SRC_BUFFER_RANGE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkVideoDecodeInfoKHR srcBufferRange(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SRC_BUFFER_RANGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoPictureResourceInfoKHR")
	public VkVideoPictureResourceInfoKHR dstPictureResource() {
		return new VkVideoPictureResourceInfoKHR(this.segment, this.offset + DST_PICTURE_RESOURCE_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkVideoReferenceSlotInfoKHR*")
	public long pSetupReferenceSlot() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_SETUP_REFERENCE_SLOT_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkVideoReferenceSlotInfoKHR*")
	public VkVideoDecodeInfoKHR pSetupReferenceSlot(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_SETUP_REFERENCE_SLOT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public int referenceSlotCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + REFERENCE_SLOT_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public VkVideoDecodeInfoKHR referenceSlotCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + REFERENCE_SLOT_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoReferenceSlotInfoKHR*")
	public long pReferenceSlots() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_REFERENCE_SLOTS_OFFSET);
	}
	
	@NativeType("VkVideoReferenceSlotInfoKHR*")
	public VkVideoDecodeInfoKHR pReferenceSlots(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_REFERENCE_SLOTS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoDecodeInfoKHR> {
		
		private static final StructConstructor<VkVideoDecodeInfoKHR> CONSTRUCTOR = VkVideoDecodeInfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoDecodeInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoDecodeInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoDecodeInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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