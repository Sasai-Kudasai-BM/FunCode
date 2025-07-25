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
* struct VkAccelerationStructureCreateInfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkAccelerationStructureCreateFlagsKHR createFlags;
* 	// pad (4)
* 	VkBuffer* buffer;
* 	VkDeviceSize offset;
* 	VkDeviceSize size;
* 	VkAccelerationStructureTypeKHR type;
* 	// pad (4)
* 	VkDeviceAddress deviceAddress;
* };
*</pre>
**/
@AutoGenerated
public final class VkAccelerationStructureCreateInfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int CREATE_FLAGS_OFFSET = 16;
	private static final int BUFFER_OFFSET = 24;
	private static final int OFFSET_OFFSET = 32;
	private static final int SIZE_OFFSET = 40;
	private static final int TYPE_OFFSET = 48;
	private static final int DEVICE_ADDRESS_OFFSET = 56;
	
	public VkAccelerationStructureCreateInfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAccelerationStructureCreateInfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAccelerationStructureCreateInfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_CREATE_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_CREATE_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkAccelerationStructureCreateInfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_CREATE_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkAccelerationStructureCreateInfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000150017);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkAccelerationStructureCreateInfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkAccelerationStructureCreateFlagsKHR")
	public int createFlags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + CREATE_FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkAccelerationStructureCreateFlagsKHR")
	public VkAccelerationStructureCreateInfoKHR createFlags(int value) {
		INT_HANDLE.set(this.segment, this.offset + CREATE_FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBuffer*")
	public long buffer() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + BUFFER_OFFSET);
	}
	
	@NativeType("VkBuffer*")
	public VkAccelerationStructureCreateInfoKHR buffer(long value) {
		LONG_HANDLE.set(this.segment, this.offset + BUFFER_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long offset() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + OFFSET_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkAccelerationStructureCreateInfoKHR offset(long value) {
		LONG_HANDLE.set(this.segment, this.offset + OFFSET_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long size() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkAccelerationStructureCreateInfoKHR size(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkAccelerationStructureTypeKHR")
	public int type() {
		return (int) INT_HANDLE.get(this.segment, this.offset + TYPE_OFFSET);
	}
	
	@NativeType("VkAccelerationStructureTypeKHR")
	public VkAccelerationStructureCreateInfoKHR type(int value) {
		INT_HANDLE.set(this.segment, this.offset + TYPE_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkDeviceAddress")
	public long deviceAddress() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + DEVICE_ADDRESS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkDeviceAddress")
	public VkAccelerationStructureCreateInfoKHR deviceAddress(long value) {
		LONG_HANDLE.set(this.segment, this.offset + DEVICE_ADDRESS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkAccelerationStructureCreateInfoKHR> {
		
		private static final StructConstructor<VkAccelerationStructureCreateInfoKHR> CONSTRUCTOR = VkAccelerationStructureCreateInfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkAccelerationStructureCreateInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkAccelerationStructureCreateInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkAccelerationStructureCreateInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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