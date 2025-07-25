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
* struct VkImageMemoryBarrier {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkAccessFlags srcAccessMask;
* 	VkAccessFlags dstAccessMask;
* 	VkImageLayout oldLayout;
* 	VkImageLayout newLayout;
* 	uint32_t srcQueueFamilyIndex;
* 	uint32_t dstQueueFamilyIndex;
* 	VkImage* image;
* 	VkImageSubresourceRange subresourceRange;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkImageMemoryBarrier extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_LONG,
			VkImageSubresourceRange.MEMORY_LAYOUT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SRC_ACCESS_MASK_OFFSET = 16;
	private static final int DST_ACCESS_MASK_OFFSET = 20;
	private static final int OLD_LAYOUT_OFFSET = 24;
	private static final int NEW_LAYOUT_OFFSET = 28;
	private static final int SRC_QUEUE_FAMILY_INDEX_OFFSET = 32;
	private static final int DST_QUEUE_FAMILY_INDEX_OFFSET = 36;
	private static final int IMAGE_OFFSET = 40;
	private static final int SUBRESOURCE_RANGE_OFFSET = 48;
	
	public VkImageMemoryBarrier() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkImageMemoryBarrier(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkImageMemoryBarrier(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER **/
	@NativeType("VkStructureType")
	public VkImageMemoryBarrier sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER **/
	@NativeType("VkStructureType")
	public VkImageMemoryBarrier sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 45);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkImageMemoryBarrier pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkAccessFlags")
	public int srcAccessMask() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SRC_ACCESS_MASK_OFFSET);
	}
	
	@NativeType("VkAccessFlags")
	public VkImageMemoryBarrier srcAccessMask(int value) {
		INT_HANDLE.set(this.segment, this.offset + SRC_ACCESS_MASK_OFFSET, value);
		return this;
	}
	
	@NativeType("VkAccessFlags")
	public int dstAccessMask() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DST_ACCESS_MASK_OFFSET);
	}
	
	@NativeType("VkAccessFlags")
	public VkImageMemoryBarrier dstAccessMask(int value) {
		INT_HANDLE.set(this.segment, this.offset + DST_ACCESS_MASK_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageLayout")
	public int oldLayout() {
		return (int) INT_HANDLE.get(this.segment, this.offset + OLD_LAYOUT_OFFSET);
	}
	
	@NativeType("VkImageLayout")
	public VkImageMemoryBarrier oldLayout(int value) {
		INT_HANDLE.set(this.segment, this.offset + OLD_LAYOUT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageLayout")
	public int newLayout() {
		return (int) INT_HANDLE.get(this.segment, this.offset + NEW_LAYOUT_OFFSET);
	}
	
	@NativeType("VkImageLayout")
	public VkImageMemoryBarrier newLayout(int value) {
		INT_HANDLE.set(this.segment, this.offset + NEW_LAYOUT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int srcQueueFamilyIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SRC_QUEUE_FAMILY_INDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkImageMemoryBarrier srcQueueFamilyIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + SRC_QUEUE_FAMILY_INDEX_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int dstQueueFamilyIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DST_QUEUE_FAMILY_INDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkImageMemoryBarrier dstQueueFamilyIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + DST_QUEUE_FAMILY_INDEX_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImage*")
	public long image() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + IMAGE_OFFSET);
	}
	
	@NativeType("VkImage*")
	public VkImageMemoryBarrier image(long value) {
		LONG_HANDLE.set(this.segment, this.offset + IMAGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageSubresourceRange")
	public VkImageSubresourceRange subresourceRange() {
		return new VkImageSubresourceRange(this.segment, this.offset + SUBRESOURCE_RANGE_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkImageMemoryBarrier> {
		
		private static final StructConstructor<VkImageMemoryBarrier> CONSTRUCTOR = VkImageMemoryBarrier::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkImageMemoryBarrier[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkImageMemoryBarrier[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkImageMemoryBarrier[size], CONSTRUCTOR, MEMORY_LAYOUT);
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