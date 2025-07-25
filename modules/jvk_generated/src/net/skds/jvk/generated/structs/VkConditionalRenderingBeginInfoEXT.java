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
* struct VkConditionalRenderingBeginInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBuffer* buffer;
* 	VkDeviceSize offset;
* 	VkConditionalRenderingFlagsEXT flags;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkConditionalRenderingBeginInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int BUFFER_OFFSET = 16;
	private static final int OFFSET_OFFSET = 24;
	private static final int FLAGS_OFFSET = 32;
	
	public VkConditionalRenderingBeginInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkConditionalRenderingBeginInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkConditionalRenderingBeginInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_CONDITIONAL_RENDERING_BEGIN_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_CONDITIONAL_RENDERING_BEGIN_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkConditionalRenderingBeginInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_CONDITIONAL_RENDERING_BEGIN_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkConditionalRenderingBeginInfoEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000081002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkConditionalRenderingBeginInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBuffer*")
	public long buffer() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + BUFFER_OFFSET);
	}
	
	@NativeType("VkBuffer*")
	public VkConditionalRenderingBeginInfoEXT buffer(long value) {
		LONG_HANDLE.set(this.segment, this.offset + BUFFER_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long offset() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + OFFSET_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkConditionalRenderingBeginInfoEXT offset(long value) {
		LONG_HANDLE.set(this.segment, this.offset + OFFSET_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkConditionalRenderingFlagsEXT")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkConditionalRenderingFlagsEXT")
	public VkConditionalRenderingBeginInfoEXT flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkConditionalRenderingBeginInfoEXT> {
		
		private static final StructConstructor<VkConditionalRenderingBeginInfoEXT> CONSTRUCTOR = VkConditionalRenderingBeginInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkConditionalRenderingBeginInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkConditionalRenderingBeginInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkConditionalRenderingBeginInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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