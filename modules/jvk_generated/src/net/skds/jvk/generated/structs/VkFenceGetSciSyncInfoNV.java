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
* struct VkFenceGetSciSyncInfoNV {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkFence* fence;
* 	VkExternalFenceHandleTypeFlagBits handleType;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkFenceGetSciSyncInfoNV extends CStruct {
	
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
	private static final int FENCE_OFFSET = 16;
	private static final int HANDLE_TYPE_OFFSET = 24;
	
	public VkFenceGetSciSyncInfoNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkFenceGetSciSyncInfoNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkFenceGetSciSyncInfoNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_FENCE_GET_SCI_SYNC_INFO_NV **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_FENCE_GET_SCI_SYNC_INFO_NV **/
	@NativeType("VkStructureType")
	public VkFenceGetSciSyncInfoNV sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_FENCE_GET_SCI_SYNC_INFO_NV **/
	@NativeType("VkStructureType")
	public VkFenceGetSciSyncInfoNV sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000373002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkFenceGetSciSyncInfoNV pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFence*")
	public long fence() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + FENCE_OFFSET);
	}
	
	@NativeType("VkFence*")
	public VkFenceGetSciSyncInfoNV fence(long value) {
		LONG_HANDLE.set(this.segment, this.offset + FENCE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkExternalFenceHandleTypeFlagBits")
	public int handleType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + HANDLE_TYPE_OFFSET);
	}
	
	@NativeType("VkExternalFenceHandleTypeFlagBits")
	public VkFenceGetSciSyncInfoNV handleType(int value) {
		INT_HANDLE.set(this.segment, this.offset + HANDLE_TYPE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkFenceGetSciSyncInfoNV> {
		
		private static final StructConstructor<VkFenceGetSciSyncInfoNV> CONSTRUCTOR = VkFenceGetSciSyncInfoNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkFenceGetSciSyncInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkFenceGetSciSyncInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkFenceGetSciSyncInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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