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
* struct VkPipelineCacheStageValidationIndexEntry {
* 	uint64_t codeSize;
* 	uint64_t codeOffset;
* };
*</pre>
**/
@AutoGenerated
public final class VkPipelineCacheStageValidationIndexEntry extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int CODE_SIZE_OFFSET = 0;
	private static final int CODE_OFFSET_OFFSET = 8;
	
	public VkPipelineCacheStageValidationIndexEntry() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCacheStageValidationIndexEntry(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCacheStageValidationIndexEntry(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("uint64_t")
	public long codeSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + CODE_SIZE_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPipelineCacheStageValidationIndexEntry codeSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + CODE_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long codeOffset() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + CODE_OFFSET_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPipelineCacheStageValidationIndexEntry codeOffset(long value) {
		LONG_HANDLE.set(this.segment, this.offset + CODE_OFFSET_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPipelineCacheStageValidationIndexEntry> {
		
		private static final StructConstructor<VkPipelineCacheStageValidationIndexEntry> CONSTRUCTOR = VkPipelineCacheStageValidationIndexEntry::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPipelineCacheStageValidationIndexEntry[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPipelineCacheStageValidationIndexEntry[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPipelineCacheStageValidationIndexEntry[size], CONSTRUCTOR, MEMORY_LAYOUT);
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