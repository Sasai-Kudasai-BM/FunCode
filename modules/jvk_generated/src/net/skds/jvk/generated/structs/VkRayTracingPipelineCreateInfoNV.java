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
* struct VkRayTracingPipelineCreateInfoNV {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkPipelineCreateFlags flags;
* 	uint32_t stageCount;
* 	VkPipelineShaderStageCreateInfo* pStages;
* 	uint32_t groupCount;
* 	// pad (4)
* 	VkRayTracingShaderGroupCreateInfoNV* pGroups;
* 	uint32_t maxRecursionDepth;
* 	// pad (4)
* 	VkPipelineLayout* layout;
* 	VkPipeline* basePipelineHandle;
* 	int32_t basePipelineIndex;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkRayTracingPipelineCreateInfoNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FLAGS_OFFSET = 16;
	private static final int STAGE_COUNT_OFFSET = 20;
	private static final int P_STAGES_OFFSET = 24;
	private static final int GROUP_COUNT_OFFSET = 32;
	private static final int P_GROUPS_OFFSET = 40;
	private static final int MAX_RECURSION_DEPTH_OFFSET = 48;
	private static final int LAYOUT_OFFSET = 56;
	private static final int BASE_PIPELINE_HANDLE_OFFSET = 64;
	private static final int BASE_PIPELINE_INDEX_OFFSET = 72;
	
	public VkRayTracingPipelineCreateInfoNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRayTracingPipelineCreateInfoNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRayTracingPipelineCreateInfoNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_RAY_TRACING_PIPELINE_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_RAY_TRACING_PIPELINE_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public VkRayTracingPipelineCreateInfoNV sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_RAY_TRACING_PIPELINE_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public VkRayTracingPipelineCreateInfoNV sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000165000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkRayTracingPipelineCreateInfoNV pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkPipelineCreateFlags")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkPipelineCreateFlags")
	public VkRayTracingPipelineCreateInfoNV flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int stageCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + STAGE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkRayTracingPipelineCreateInfoNV stageCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + STAGE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkPipelineShaderStageCreateInfo*")
	public long pStages() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_STAGES_OFFSET);
	}
	
	@NativeType("VkPipelineShaderStageCreateInfo*")
	public VkRayTracingPipelineCreateInfoNV pStages(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_STAGES_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int groupCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + GROUP_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkRayTracingPipelineCreateInfoNV groupCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + GROUP_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkRayTracingShaderGroupCreateInfoNV*")
	public long pGroups() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_GROUPS_OFFSET);
	}
	
	@NativeType("VkRayTracingShaderGroupCreateInfoNV*")
	public VkRayTracingPipelineCreateInfoNV pGroups(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_GROUPS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxRecursionDepth() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_RECURSION_DEPTH_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkRayTracingPipelineCreateInfoNV maxRecursionDepth(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_RECURSION_DEPTH_OFFSET, value);
		return this;
	}
	
	@NativeType("VkPipelineLayout*")
	public long layout() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + LAYOUT_OFFSET);
	}
	
	@NativeType("VkPipelineLayout*")
	public VkRayTracingPipelineCreateInfoNV layout(long value) {
		LONG_HANDLE.set(this.segment, this.offset + LAYOUT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkPipeline*")
	public long basePipelineHandle() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + BASE_PIPELINE_HANDLE_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkPipeline*")
	public VkRayTracingPipelineCreateInfoNV basePipelineHandle(long value) {
		LONG_HANDLE.set(this.segment, this.offset + BASE_PIPELINE_HANDLE_OFFSET, value);
		return this;
	}
	
	@NativeType("int32_t")
	public int basePipelineIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BASE_PIPELINE_INDEX_OFFSET);
	}
	
	@NativeType("int32_t")
	public VkRayTracingPipelineCreateInfoNV basePipelineIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + BASE_PIPELINE_INDEX_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkRayTracingPipelineCreateInfoNV> {
		
		private static final StructConstructor<VkRayTracingPipelineCreateInfoNV> CONSTRUCTOR = VkRayTracingPipelineCreateInfoNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkRayTracingPipelineCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkRayTracingPipelineCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkRayTracingPipelineCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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