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
* struct VkPresentWait2InfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint64_t presentId;
* 	uint64_t timeout;
* };
*</pre>
**/
@AutoGenerated
public final class VkPresentWait2InfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int PRESENT_ID_OFFSET = 16;
	private static final int TIMEOUT_OFFSET = 24;
	
	public VkPresentWait2InfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPresentWait2InfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPresentWait2InfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PRESENT_WAIT_2_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PRESENT_WAIT_2_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkPresentWait2InfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PRESENT_WAIT_2_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkPresentWait2InfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000480002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPresentWait2InfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long presentId() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + PRESENT_ID_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPresentWait2InfoKHR presentId(long value) {
		LONG_HANDLE.set(this.segment, this.offset + PRESENT_ID_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long timeout() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + TIMEOUT_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPresentWait2InfoKHR timeout(long value) {
		LONG_HANDLE.set(this.segment, this.offset + TIMEOUT_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPresentWait2InfoKHR> {
		
		private static final StructConstructor<VkPresentWait2InfoKHR> CONSTRUCTOR = VkPresentWait2InfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPresentWait2InfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPresentWait2InfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPresentWait2InfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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