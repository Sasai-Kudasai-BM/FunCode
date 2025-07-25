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
* struct VkExportMetalObjectCreateInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkExportMetalObjectTypeFlagBitsEXT exportObjectType;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkExportMetalObjectCreateInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int EXPORT_OBJECT_TYPE_OFFSET = 16;
	
	public VkExportMetalObjectCreateInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkExportMetalObjectCreateInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkExportMetalObjectCreateInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_EXPORT_METAL_OBJECT_CREATE_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_EXPORT_METAL_OBJECT_CREATE_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkExportMetalObjectCreateInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_EXPORT_METAL_OBJECT_CREATE_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkExportMetalObjectCreateInfoEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000311000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkExportMetalObjectCreateInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkExportMetalObjectTypeFlagBitsEXT")
	public int exportObjectType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + EXPORT_OBJECT_TYPE_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkExportMetalObjectTypeFlagBitsEXT")
	public VkExportMetalObjectCreateInfoEXT exportObjectType(int value) {
		INT_HANDLE.set(this.segment, this.offset + EXPORT_OBJECT_TYPE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkExportMetalObjectCreateInfoEXT> {
		
		private static final StructConstructor<VkExportMetalObjectCreateInfoEXT> CONSTRUCTOR = VkExportMetalObjectCreateInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkExportMetalObjectCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkExportMetalObjectCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkExportMetalObjectCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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