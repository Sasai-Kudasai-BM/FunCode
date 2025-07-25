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
* struct VkMemoryBarrierAccessFlags3KHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkAccessFlags3KHR srcAccessMask3;
* 	VkAccessFlags3KHR dstAccessMask3;
* };
*</pre>
**/
@AutoGenerated
public final class VkMemoryBarrierAccessFlags3KHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SRC_ACCESS_MASK3_OFFSET = 16;
	private static final int DST_ACCESS_MASK3_OFFSET = 24;
	
	public VkMemoryBarrierAccessFlags3KHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMemoryBarrierAccessFlags3KHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMemoryBarrierAccessFlags3KHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_MEMORY_BARRIER_ACCESS_FLAGS_3_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_MEMORY_BARRIER_ACCESS_FLAGS_3_KHR **/
	@NativeType("VkStructureType")
	public VkMemoryBarrierAccessFlags3KHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_MEMORY_BARRIER_ACCESS_FLAGS_3_KHR **/
	@NativeType("VkStructureType")
	public VkMemoryBarrierAccessFlags3KHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000574002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkMemoryBarrierAccessFlags3KHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkAccessFlags3KHR")
	public long srcAccessMask3() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SRC_ACCESS_MASK3_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkAccessFlags3KHR")
	public VkMemoryBarrierAccessFlags3KHR srcAccessMask3(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SRC_ACCESS_MASK3_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkAccessFlags3KHR")
	public long dstAccessMask3() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + DST_ACCESS_MASK3_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkAccessFlags3KHR")
	public VkMemoryBarrierAccessFlags3KHR dstAccessMask3(long value) {
		LONG_HANDLE.set(this.segment, this.offset + DST_ACCESS_MASK3_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkMemoryBarrierAccessFlags3KHR> {
		
		private static final StructConstructor<VkMemoryBarrierAccessFlags3KHR> CONSTRUCTOR = VkMemoryBarrierAccessFlags3KHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkMemoryBarrierAccessFlags3KHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkMemoryBarrierAccessFlags3KHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkMemoryBarrierAccessFlags3KHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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