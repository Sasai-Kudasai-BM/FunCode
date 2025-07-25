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
* struct VkPhysicalDeviceExternalBufferInfo {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBufferCreateFlags flags;
* 	VkBufferUsageFlags usage;
* 	VkExternalMemoryHandleTypeFlagBits handleType;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceExternalBufferInfo extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FLAGS_OFFSET = 16;
	private static final int USAGE_OFFSET = 20;
	private static final int HANDLE_TYPE_OFFSET = 24;
	
	public VkPhysicalDeviceExternalBufferInfo() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceExternalBufferInfo(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceExternalBufferInfo(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceExternalBufferInfo sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceExternalBufferInfo sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000071002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceExternalBufferInfo pNext(long value) {
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
	public VkPhysicalDeviceExternalBufferInfo flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkBufferUsageFlags")
	public int usage() {
		return (int) INT_HANDLE.get(this.segment, this.offset + USAGE_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkBufferUsageFlags")
	public VkPhysicalDeviceExternalBufferInfo usage(int value) {
		INT_HANDLE.set(this.segment, this.offset + USAGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkExternalMemoryHandleTypeFlagBits")
	public int handleType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + HANDLE_TYPE_OFFSET);
	}
	
	@NativeType("VkExternalMemoryHandleTypeFlagBits")
	public VkPhysicalDeviceExternalBufferInfo handleType(int value) {
		INT_HANDLE.set(this.segment, this.offset + HANDLE_TYPE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceExternalBufferInfo> {
		
		private static final StructConstructor<VkPhysicalDeviceExternalBufferInfo> CONSTRUCTOR = VkPhysicalDeviceExternalBufferInfo::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceExternalBufferInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceExternalBufferInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceExternalBufferInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
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