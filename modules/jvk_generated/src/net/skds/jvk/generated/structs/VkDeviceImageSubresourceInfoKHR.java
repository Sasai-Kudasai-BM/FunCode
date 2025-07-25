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
* struct VkDeviceImageSubresourceInfo {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkImageCreateInfo* pCreateInfo;
* 	VkImageSubresource2* pSubresource;
* };
*</pre>
**/
@AutoGenerated
public final class VkDeviceImageSubresourceInfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int P_CREATE_INFO_OFFSET = 16;
	private static final int P_SUBRESOURCE_OFFSET = 24;
	
	public VkDeviceImageSubresourceInfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDeviceImageSubresourceInfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDeviceImageSubresourceInfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_DEVICE_IMAGE_SUBRESOURCE_INFO **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_DEVICE_IMAGE_SUBRESOURCE_INFO **/
	@NativeType("VkStructureType")
	public VkDeviceImageSubresourceInfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_DEVICE_IMAGE_SUBRESOURCE_INFO **/
	@NativeType("VkStructureType")
	public VkDeviceImageSubresourceInfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000470004);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkDeviceImageSubresourceInfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageCreateInfo*")
	public long pCreateInfo() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_CREATE_INFO_OFFSET);
	}
	
	@NativeType("VkImageCreateInfo*")
	public VkDeviceImageSubresourceInfoKHR pCreateInfo(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_CREATE_INFO_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageSubresource2*")
	public long pSubresource() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_SUBRESOURCE_OFFSET);
	}
	
	@NativeType("VkImageSubresource2*")
	public VkDeviceImageSubresourceInfoKHR pSubresource(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_SUBRESOURCE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkDeviceImageSubresourceInfoKHR> {
		
		private static final StructConstructor<VkDeviceImageSubresourceInfoKHR> CONSTRUCTOR = VkDeviceImageSubresourceInfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkDeviceImageSubresourceInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkDeviceImageSubresourceInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkDeviceImageSubresourceInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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