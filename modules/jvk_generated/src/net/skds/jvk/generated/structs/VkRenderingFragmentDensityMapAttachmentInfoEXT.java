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
* struct VkRenderingFragmentDensityMapAttachmentInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkImageView* imageView;
* 	VkImageLayout imageLayout;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkRenderingFragmentDensityMapAttachmentInfoEXT extends CStruct {
	
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
	private static final int IMAGE_VIEW_OFFSET = 16;
	private static final int IMAGE_LAYOUT_OFFSET = 24;
	
	public VkRenderingFragmentDensityMapAttachmentInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRenderingFragmentDensityMapAttachmentInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRenderingFragmentDensityMapAttachmentInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkRenderingFragmentDensityMapAttachmentInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkRenderingFragmentDensityMapAttachmentInfoEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000044007);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkRenderingFragmentDensityMapAttachmentInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageView*")
	public long imageView() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + IMAGE_VIEW_OFFSET);
	}
	
	@NativeType("VkImageView*")
	public VkRenderingFragmentDensityMapAttachmentInfoEXT imageView(long value) {
		LONG_HANDLE.set(this.segment, this.offset + IMAGE_VIEW_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageLayout")
	public int imageLayout() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IMAGE_LAYOUT_OFFSET);
	}
	
	@NativeType("VkImageLayout")
	public VkRenderingFragmentDensityMapAttachmentInfoEXT imageLayout(int value) {
		INT_HANDLE.set(this.segment, this.offset + IMAGE_LAYOUT_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkRenderingFragmentDensityMapAttachmentInfoEXT> {
		
		private static final StructConstructor<VkRenderingFragmentDensityMapAttachmentInfoEXT> CONSTRUCTOR = VkRenderingFragmentDensityMapAttachmentInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkRenderingFragmentDensityMapAttachmentInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkRenderingFragmentDensityMapAttachmentInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkRenderingFragmentDensityMapAttachmentInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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