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
* struct VkPhysicalDeviceInlineUniformBlockProperties {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t maxInlineUniformBlockSize;
* 	uint32_t maxPerStageDescriptorInlineUniformBlocks;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks;
* 	uint32_t maxDescriptorSetInlineUniformBlocks;
* 	uint32_t maxDescriptorSetUpdateAfterBindInlineUniformBlocks;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceInlineUniformBlockPropertiesEXT extends CStruct {
	
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
	private static final int MAX_INLINE_UNIFORM_BLOCK_SIZE_OFFSET = 16;
	private static final int MAX_PER_STAGE_DESCRIPTOR_INLINE_UNIFORM_BLOCKS_OFFSET = 20;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_INLINE_UNIFORM_BLOCKS_OFFSET = 24;
	private static final int MAX_DESCRIPTOR_SET_INLINE_UNIFORM_BLOCKS_OFFSET = 28;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_INLINE_UNIFORM_BLOCKS_OFFSET = 32;
	
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000138001);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxInlineUniformBlockSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_INLINE_UNIFORM_BLOCK_SIZE_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT maxInlineUniformBlockSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_INLINE_UNIFORM_BLOCK_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorInlineUniformBlocks() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_INLINE_UNIFORM_BLOCKS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT maxPerStageDescriptorInlineUniformBlocks(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_INLINE_UNIFORM_BLOCKS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_INLINE_UNIFORM_BLOCKS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_INLINE_UNIFORM_BLOCKS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetInlineUniformBlocks() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_INLINE_UNIFORM_BLOCKS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT maxDescriptorSetInlineUniformBlocks(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_INLINE_UNIFORM_BLOCKS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindInlineUniformBlocks() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_INLINE_UNIFORM_BLOCKS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceInlineUniformBlockPropertiesEXT maxDescriptorSetUpdateAfterBindInlineUniformBlocks(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_INLINE_UNIFORM_BLOCKS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceInlineUniformBlockPropertiesEXT> {
		
		private static final StructConstructor<VkPhysicalDeviceInlineUniformBlockPropertiesEXT> CONSTRUCTOR = VkPhysicalDeviceInlineUniformBlockPropertiesEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceInlineUniformBlockPropertiesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceInlineUniformBlockPropertiesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceInlineUniformBlockPropertiesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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