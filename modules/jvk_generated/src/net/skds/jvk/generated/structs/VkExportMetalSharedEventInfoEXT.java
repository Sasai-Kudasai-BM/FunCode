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
* struct VkExportMetalSharedEventInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkSemaphore* semaphore;
* 	VkEvent* event;
* 	MTLSharedEvent_id* mtlSharedEvent;
* };
*</pre>
**/
@AutoGenerated
public final class VkExportMetalSharedEventInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SEMAPHORE_OFFSET = 16;
	private static final int EVENT_OFFSET = 24;
	private static final int MTL_SHARED_EVENT_OFFSET = 32;
	
	public VkExportMetalSharedEventInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkExportMetalSharedEventInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkExportMetalSharedEventInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_EXPORT_METAL_SHARED_EVENT_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_EXPORT_METAL_SHARED_EVENT_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkExportMetalSharedEventInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_EXPORT_METAL_SHARED_EVENT_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkExportMetalSharedEventInfoEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000311010);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkExportMetalSharedEventInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkSemaphore*")
	public long semaphore() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SEMAPHORE_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkSemaphore*")
	public VkExportMetalSharedEventInfoEXT semaphore(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SEMAPHORE_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkEvent*")
	public long event() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + EVENT_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkEvent*")
	public VkExportMetalSharedEventInfoEXT event(long value) {
		LONG_HANDLE.set(this.segment, this.offset + EVENT_OFFSET, value);
		return this;
	}
	
	@NativeType("MTLSharedEvent_id*")
	public long mtlSharedEvent() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MTL_SHARED_EVENT_OFFSET);
	}
	
	@NativeType("MTLSharedEvent_id*")
	public VkExportMetalSharedEventInfoEXT mtlSharedEvent(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MTL_SHARED_EVENT_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkExportMetalSharedEventInfoEXT> {
		
		private static final StructConstructor<VkExportMetalSharedEventInfoEXT> CONSTRUCTOR = VkExportMetalSharedEventInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkExportMetalSharedEventInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkExportMetalSharedEventInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkExportMetalSharedEventInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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