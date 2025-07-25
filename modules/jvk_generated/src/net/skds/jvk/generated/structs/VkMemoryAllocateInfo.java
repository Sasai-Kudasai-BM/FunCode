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
* struct VkMemoryAllocateInfo {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkDeviceSize allocationSize;
* 	uint32_t memoryTypeIndex;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkMemoryAllocateInfo extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int ALLOCATION_SIZE_OFFSET = 16;
	private static final int MEMORY_TYPE_INDEX_OFFSET = 24;
	
	public VkMemoryAllocateInfo() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMemoryAllocateInfo(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMemoryAllocateInfo(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO **/
	@NativeType("VkStructureType")
	public VkMemoryAllocateInfo sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_MEMORY_ALLOCATE_INFO **/
	@NativeType("VkStructureType")
	public VkMemoryAllocateInfo sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 5);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkMemoryAllocateInfo pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long allocationSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + ALLOCATION_SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkMemoryAllocateInfo allocationSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + ALLOCATION_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int memoryTypeIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MEMORY_TYPE_INDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkMemoryAllocateInfo memoryTypeIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + MEMORY_TYPE_INDEX_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkMemoryAllocateInfo> {
		
		private static final StructConstructor<VkMemoryAllocateInfo> CONSTRUCTOR = VkMemoryAllocateInfo::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkMemoryAllocateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkMemoryAllocateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkMemoryAllocateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
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