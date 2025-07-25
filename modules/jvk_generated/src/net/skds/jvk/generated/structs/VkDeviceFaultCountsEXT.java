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
* struct VkDeviceFaultCountsEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t addressInfoCount;
* 	uint32_t vendorInfoCount;
* 	VkDeviceSize vendorBinarySize;
* };
*</pre>
**/
@AutoGenerated
public final class VkDeviceFaultCountsEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int ADDRESS_INFO_COUNT_OFFSET = 16;
	private static final int VENDOR_INFO_COUNT_OFFSET = 20;
	private static final int VENDOR_BINARY_SIZE_OFFSET = 24;
	
	public VkDeviceFaultCountsEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDeviceFaultCountsEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDeviceFaultCountsEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_DEVICE_FAULT_COUNTS_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_DEVICE_FAULT_COUNTS_EXT **/
	@NativeType("VkStructureType")
	public VkDeviceFaultCountsEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_DEVICE_FAULT_COUNTS_EXT **/
	@NativeType("VkStructureType")
	public VkDeviceFaultCountsEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000341001);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkDeviceFaultCountsEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public int addressInfoCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ADDRESS_INFO_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public VkDeviceFaultCountsEXT addressInfoCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + ADDRESS_INFO_COUNT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public int vendorInfoCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VENDOR_INFO_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public VkDeviceFaultCountsEXT vendorInfoCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + VENDOR_INFO_COUNT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkDeviceSize")
	public long vendorBinarySize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + VENDOR_BINARY_SIZE_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkDeviceSize")
	public VkDeviceFaultCountsEXT vendorBinarySize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + VENDOR_BINARY_SIZE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkDeviceFaultCountsEXT> {
		
		private static final StructConstructor<VkDeviceFaultCountsEXT> CONSTRUCTOR = VkDeviceFaultCountsEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkDeviceFaultCountsEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkDeviceFaultCountsEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkDeviceFaultCountsEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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