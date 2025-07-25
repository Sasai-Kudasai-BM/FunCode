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
* struct VkPipelineCacheHeaderVersionSafetyCriticalOne {
* 	VkPipelineCacheHeaderVersionOne headerVersionOne;
* 	VkPipelineCacheValidationVersion validationVersion;
* 	uint32_t implementationData;
* 	uint32_t pipelineIndexCount;
* 	uint32_t pipelineIndexStride;
* 	uint64_t pipelineIndexOffset;
* };
*</pre>
**/
@AutoGenerated
public final class VkPipelineCacheHeaderVersionSafetyCriticalOne extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			VkPipelineCacheHeaderVersionOne.MEMORY_LAYOUT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_LONG
	);
	private static final int HEADER_VERSION_ONE_OFFSET = 0;
	private static final int VALIDATION_VERSION_OFFSET = 32;
	private static final int IMPLEMENTATION_DATA_OFFSET = 36;
	private static final int PIPELINE_INDEX_COUNT_OFFSET = 40;
	private static final int PIPELINE_INDEX_STRIDE_OFFSET = 44;
	private static final int PIPELINE_INDEX_OFFSET_OFFSET = 48;
	
	public VkPipelineCacheHeaderVersionSafetyCriticalOne() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCacheHeaderVersionSafetyCriticalOne(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCacheHeaderVersionSafetyCriticalOne(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("VkPipelineCacheHeaderVersionOne")
	public VkPipelineCacheHeaderVersionOne headerVersionOne() {
		return new VkPipelineCacheHeaderVersionOne(this.segment, this.offset + HEADER_VERSION_ONE_OFFSET);
	}
	
	@NativeType("VkPipelineCacheValidationVersion")
	public int validationVersion() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VALIDATION_VERSION_OFFSET);
	}
	
	@NativeType("VkPipelineCacheValidationVersion")
	public VkPipelineCacheHeaderVersionSafetyCriticalOne validationVersion(int value) {
		INT_HANDLE.set(this.segment, this.offset + VALIDATION_VERSION_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int implementationData() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IMPLEMENTATION_DATA_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPipelineCacheHeaderVersionSafetyCriticalOne implementationData(int value) {
		INT_HANDLE.set(this.segment, this.offset + IMPLEMENTATION_DATA_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int pipelineIndexCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PIPELINE_INDEX_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPipelineCacheHeaderVersionSafetyCriticalOne pipelineIndexCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + PIPELINE_INDEX_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int pipelineIndexStride() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PIPELINE_INDEX_STRIDE_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPipelineCacheHeaderVersionSafetyCriticalOne pipelineIndexStride(int value) {
		INT_HANDLE.set(this.segment, this.offset + PIPELINE_INDEX_STRIDE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long pipelineIndexOffset() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + PIPELINE_INDEX_OFFSET_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPipelineCacheHeaderVersionSafetyCriticalOne pipelineIndexOffset(long value) {
		LONG_HANDLE.set(this.segment, this.offset + PIPELINE_INDEX_OFFSET_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPipelineCacheHeaderVersionSafetyCriticalOne> {
		
		private static final StructConstructor<VkPipelineCacheHeaderVersionSafetyCriticalOne> CONSTRUCTOR = VkPipelineCacheHeaderVersionSafetyCriticalOne::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPipelineCacheHeaderVersionSafetyCriticalOne[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPipelineCacheHeaderVersionSafetyCriticalOne[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPipelineCacheHeaderVersionSafetyCriticalOne[size], CONSTRUCTOR, MEMORY_LAYOUT);
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