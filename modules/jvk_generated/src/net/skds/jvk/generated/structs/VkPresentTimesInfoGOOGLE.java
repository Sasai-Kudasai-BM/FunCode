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
* struct VkPresentTimesInfoGOOGLE {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t swapchainCount;
* 	// pad (4)
* 	VkPresentTimeGOOGLE* pTimes;
* };
*</pre>
**/
@AutoGenerated
public final class VkPresentTimesInfoGOOGLE extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SWAPCHAIN_COUNT_OFFSET = 16;
	private static final int P_TIMES_OFFSET = 24;
	
	public VkPresentTimesInfoGOOGLE() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPresentTimesInfoGOOGLE(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPresentTimesInfoGOOGLE(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PRESENT_TIMES_INFO_GOOGLE **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PRESENT_TIMES_INFO_GOOGLE **/
	@NativeType("VkStructureType")
	public VkPresentTimesInfoGOOGLE sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PRESENT_TIMES_INFO_GOOGLE **/
	@NativeType("VkStructureType")
	public VkPresentTimesInfoGOOGLE sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000092000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPresentTimesInfoGOOGLE pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int swapchainCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SWAPCHAIN_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPresentTimesInfoGOOGLE swapchainCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + SWAPCHAIN_COUNT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkPresentTimeGOOGLE*")
	public long pTimes() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_TIMES_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkPresentTimeGOOGLE*")
	public VkPresentTimesInfoGOOGLE pTimes(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_TIMES_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPresentTimesInfoGOOGLE> {
		
		private static final StructConstructor<VkPresentTimesInfoGOOGLE> CONSTRUCTOR = VkPresentTimesInfoGOOGLE::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPresentTimesInfoGOOGLE[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPresentTimesInfoGOOGLE[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPresentTimesInfoGOOGLE[size], CONSTRUCTOR, MEMORY_LAYOUT);
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