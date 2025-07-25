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
* struct VkRenderPassFragmentDensityMapCreateInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkAttachmentReference fragmentDensityMapAttachment;
* };
*</pre>
**/
@AutoGenerated
public final class VkRenderPassFragmentDensityMapCreateInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			VkAttachmentReference.MEMORY_LAYOUT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FRAGMENT_DENSITY_MAP_ATTACHMENT_OFFSET = 16;
	
	public VkRenderPassFragmentDensityMapCreateInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRenderPassFragmentDensityMapCreateInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRenderPassFragmentDensityMapCreateInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_RENDER_PASS_FRAGMENT_DENSITY_MAP_CREATE_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_RENDER_PASS_FRAGMENT_DENSITY_MAP_CREATE_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkRenderPassFragmentDensityMapCreateInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_RENDER_PASS_FRAGMENT_DENSITY_MAP_CREATE_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkRenderPassFragmentDensityMapCreateInfoEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000218002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkRenderPassFragmentDensityMapCreateInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkAttachmentReference")
	public VkAttachmentReference fragmentDensityMapAttachment() {
		return new VkAttachmentReference(this.segment, this.offset + FRAGMENT_DENSITY_MAP_ATTACHMENT_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkRenderPassFragmentDensityMapCreateInfoEXT> {
		
		private static final StructConstructor<VkRenderPassFragmentDensityMapCreateInfoEXT> CONSTRUCTOR = VkRenderPassFragmentDensityMapCreateInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkRenderPassFragmentDensityMapCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkRenderPassFragmentDensityMapCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkRenderPassFragmentDensityMapCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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