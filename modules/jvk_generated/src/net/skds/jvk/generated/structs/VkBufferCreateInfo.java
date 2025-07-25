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
* struct VkBufferCreateInfo {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBufferCreateFlags flags;
* 	// pad (4)
* 	VkDeviceSize size;
* 	VkBufferUsageFlags usage;
* 	VkSharingMode sharingMode;
* 	uint32_t queueFamilyIndexCount;
* 	// pad (4)
* 	uint32_t* pQueueFamilyIndices;
* };
*</pre>
**/
@AutoGenerated
public final class VkBufferCreateInfo extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FLAGS_OFFSET = 16;
	private static final int SIZE_OFFSET = 24;
	private static final int USAGE_OFFSET = 32;
	private static final int SHARING_MODE_OFFSET = 36;
	private static final int QUEUE_FAMILY_INDEX_COUNT_OFFSET = 40;
	private static final int P_QUEUE_FAMILY_INDICES_OFFSET = 48;
	
	public VkBufferCreateInfo() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkBufferCreateInfo(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkBufferCreateInfo(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO **/
	@NativeType("VkStructureType")
	public VkBufferCreateInfo sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO **/
	@NativeType("VkStructureType")
	public VkBufferCreateInfo sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 12);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkBufferCreateInfo pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkBufferCreateFlags")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkBufferCreateFlags")
	public VkBufferCreateInfo flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long size() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkBufferCreateInfo size(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBufferUsageFlags")
	public int usage() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USAGE_OFFSET);
	}
	
	@NativeType("VkBufferUsageFlags")
	public VkBufferCreateInfo usage(int value) {
		INT_HANDLE.set(this.segment, this.offset + USAGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSharingMode")
	public int sharingMode() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHARING_MODE_OFFSET);
	}
	
	@NativeType("VkSharingMode")
	public VkBufferCreateInfo sharingMode(int value) {
		INT_HANDLE.set(this.segment, this.offset + SHARING_MODE_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public int queueFamilyIndexCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + QUEUE_FAMILY_INDEX_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public VkBufferCreateInfo queueFamilyIndexCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + QUEUE_FAMILY_INDEX_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t*")
	public long pQueueFamilyIndices() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_QUEUE_FAMILY_INDICES_OFFSET);
	}
	
	@NativeType("uint32_t*")
	public VkBufferCreateInfo pQueueFamilyIndices(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_QUEUE_FAMILY_INDICES_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkBufferCreateInfo> {
		
		private static final StructConstructor<VkBufferCreateInfo> CONSTRUCTOR = VkBufferCreateInfo::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkBufferCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkBufferCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkBufferCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
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