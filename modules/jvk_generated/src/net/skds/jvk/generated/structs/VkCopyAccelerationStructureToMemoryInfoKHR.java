package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.jvk.generated.unions.VkDeviceOrHostAddressKHR;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static java.lang.foreign.ValueLayout.*;
import static net.skds.lib2.natives.LinkerUtils.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkCopyAccelerationStructureToMemoryInfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkAccelerationStructureKHR* src;
* 	VkDeviceOrHostAddressKHR dst;
* 	VkCopyAccelerationStructureModeKHR mode;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkCopyAccelerationStructureToMemoryInfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			VkDeviceOrHostAddressKHR.MEMORY_LAYOUT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SRC_OFFSET = 16;
	private static final int DST_OFFSET = 24;
	private static final int MODE_OFFSET = 32;
	
	public VkCopyAccelerationStructureToMemoryInfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkCopyAccelerationStructureToMemoryInfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkCopyAccelerationStructureToMemoryInfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_COPY_ACCELERATION_STRUCTURE_TO_MEMORY_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_COPY_ACCELERATION_STRUCTURE_TO_MEMORY_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkCopyAccelerationStructureToMemoryInfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_COPY_ACCELERATION_STRUCTURE_TO_MEMORY_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkCopyAccelerationStructureToMemoryInfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000150011);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkCopyAccelerationStructureToMemoryInfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkAccelerationStructureKHR*")
	public long src() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SRC_OFFSET);
	}
	
	@NativeType("VkAccelerationStructureKHR*")
	public VkCopyAccelerationStructureToMemoryInfoKHR src(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SRC_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceOrHostAddressKHR")
	public VkDeviceOrHostAddressKHR dst() {
		return new VkDeviceOrHostAddressKHR(this.segment, this.offset + DST_OFFSET);
	}
	
	@NativeType("VkCopyAccelerationStructureModeKHR")
	public int mode() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MODE_OFFSET);
	}
	
	@NativeType("VkCopyAccelerationStructureModeKHR")
	public VkCopyAccelerationStructureToMemoryInfoKHR mode(int value) {
		INT_HANDLE.set(this.segment, this.offset + MODE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkCopyAccelerationStructureToMemoryInfoKHR> {
		
		private static final StructConstructor<VkCopyAccelerationStructureToMemoryInfoKHR> CONSTRUCTOR = VkCopyAccelerationStructureToMemoryInfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkCopyAccelerationStructureToMemoryInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkCopyAccelerationStructureToMemoryInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkCopyAccelerationStructureToMemoryInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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