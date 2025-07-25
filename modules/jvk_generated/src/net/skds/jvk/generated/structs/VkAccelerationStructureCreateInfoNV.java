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
* struct VkAccelerationStructureCreateInfoNV {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkDeviceSize compactedSize;
* 	VkAccelerationStructureInfoNV info;
* };
*</pre>
**/
@AutoGenerated
public final class VkAccelerationStructureCreateInfoNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			VkAccelerationStructureInfoNV.MEMORY_LAYOUT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int COMPACTED_SIZE_OFFSET = 16;
	private static final int INFO_OFFSET = 24;
	
	public VkAccelerationStructureCreateInfoNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAccelerationStructureCreateInfoNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAccelerationStructureCreateInfoNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public VkAccelerationStructureCreateInfoNV sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public VkAccelerationStructureCreateInfoNV sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000165001);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkAccelerationStructureCreateInfoNV pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long compactedSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + COMPACTED_SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkAccelerationStructureCreateInfoNV compactedSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + COMPACTED_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkAccelerationStructureInfoNV")
	public VkAccelerationStructureInfoNV info() {
		return new VkAccelerationStructureInfoNV(this.segment, this.offset + INFO_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkAccelerationStructureCreateInfoNV> {
		
		private static final StructConstructor<VkAccelerationStructureCreateInfoNV> CONSTRUCTOR = VkAccelerationStructureCreateInfoNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkAccelerationStructureCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkAccelerationStructureCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkAccelerationStructureCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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