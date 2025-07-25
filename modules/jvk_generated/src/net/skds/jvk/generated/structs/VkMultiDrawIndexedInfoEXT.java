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
* struct VkMultiDrawIndexedInfoEXT {
* 	uint32_t firstIndex;
* 	uint32_t indexCount;
* 	int32_t vertexOffset;
* };
*</pre>
**/
@AutoGenerated
public final class VkMultiDrawIndexedInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			JAVA_INT,
			JAVA_INT
	);
	private static final int FIRST_INDEX_OFFSET = 0;
	private static final int INDEX_COUNT_OFFSET = 4;
	private static final int VERTEX_OFFSET_OFFSET = 8;
	
	public VkMultiDrawIndexedInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMultiDrawIndexedInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMultiDrawIndexedInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("uint32_t")
	public int firstIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FIRST_INDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkMultiDrawIndexedInfoEXT firstIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + FIRST_INDEX_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int indexCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + INDEX_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkMultiDrawIndexedInfoEXT indexCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + INDEX_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("int32_t")
	public int vertexOffset() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VERTEX_OFFSET_OFFSET);
	}
	
	@NativeType("int32_t")
	public VkMultiDrawIndexedInfoEXT vertexOffset(int value) {
		INT_HANDLE.set(this.segment, this.offset + VERTEX_OFFSET_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkMultiDrawIndexedInfoEXT> {
		
		private static final StructConstructor<VkMultiDrawIndexedInfoEXT> CONSTRUCTOR = VkMultiDrawIndexedInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkMultiDrawIndexedInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkMultiDrawIndexedInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkMultiDrawIndexedInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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