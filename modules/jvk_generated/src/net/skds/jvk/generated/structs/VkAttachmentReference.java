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
* struct VkAttachmentReference {
* 	uint32_t attachment;
* 	VkImageLayout layout;
* };
*</pre>
**/
@AutoGenerated
public final class VkAttachmentReference extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			JAVA_INT
	);
	private static final int ATTACHMENT_OFFSET = 0;
	private static final int LAYOUT_OFFSET = 4;
	
	public VkAttachmentReference() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAttachmentReference(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAttachmentReference(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("uint32_t")
	public int attachment() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ATTACHMENT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkAttachmentReference attachment(int value) {
		INT_HANDLE.set(this.segment, this.offset + ATTACHMENT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkImageLayout")
	public int layout() {
		return (int) INT_HANDLE.get(this.segment, this.offset + LAYOUT_OFFSET);
	}
	
	@NativeType("VkImageLayout")
	public VkAttachmentReference layout(int value) {
		INT_HANDLE.set(this.segment, this.offset + LAYOUT_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkAttachmentReference> {
		
		private static final StructConstructor<VkAttachmentReference> CONSTRUCTOR = VkAttachmentReference::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkAttachmentReference[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkAttachmentReference[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkAttachmentReference[size], CONSTRUCTOR, MEMORY_LAYOUT);
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