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
* struct VkAttachmentReferenceStencilLayout {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkImageLayout stencilLayout;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkAttachmentReferenceStencilLayoutKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int STENCIL_LAYOUT_OFFSET = 16;
	
	public VkAttachmentReferenceStencilLayoutKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAttachmentReferenceStencilLayoutKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAttachmentReferenceStencilLayoutKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_STENCIL_LAYOUT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_STENCIL_LAYOUT **/
	@NativeType("VkStructureType")
	public VkAttachmentReferenceStencilLayoutKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_STENCIL_LAYOUT **/
	@NativeType("VkStructureType")
	public VkAttachmentReferenceStencilLayoutKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000241001);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkAttachmentReferenceStencilLayoutKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageLayout")
	public int stencilLayout() {
		return (int) INT_HANDLE.get(this.segment, this.offset + STENCIL_LAYOUT_OFFSET);
	}
	
	@NativeType("VkImageLayout")
	public VkAttachmentReferenceStencilLayoutKHR stencilLayout(int value) {
		INT_HANDLE.set(this.segment, this.offset + STENCIL_LAYOUT_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkAttachmentReferenceStencilLayoutKHR> {
		
		private static final StructConstructor<VkAttachmentReferenceStencilLayoutKHR> CONSTRUCTOR = VkAttachmentReferenceStencilLayoutKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkAttachmentReferenceStencilLayoutKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkAttachmentReferenceStencilLayoutKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkAttachmentReferenceStencilLayoutKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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