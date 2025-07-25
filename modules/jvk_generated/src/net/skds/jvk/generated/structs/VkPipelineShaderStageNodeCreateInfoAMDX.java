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
* struct VkPipelineShaderStageNodeCreateInfoAMDX {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	char* pName;
* 	uint32_t index;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPipelineShaderStageNodeCreateInfoAMDX extends CStruct {
	
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
	private static final int P_NAME_OFFSET = 16;
	private static final int INDEX_OFFSET = 24;
	
	public VkPipelineShaderStageNodeCreateInfoAMDX() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineShaderStageNodeCreateInfoAMDX(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineShaderStageNodeCreateInfoAMDX(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_NODE_CREATE_INFO_AMDX **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_NODE_CREATE_INFO_AMDX **/
	@NativeType("VkStructureType")
	public VkPipelineShaderStageNodeCreateInfoAMDX sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_NODE_CREATE_INFO_AMDX **/
	@NativeType("VkStructureType")
	public VkPipelineShaderStageNodeCreateInfoAMDX sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000134004);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPipelineShaderStageNodeCreateInfoAMDX pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("char*")
	public long pName() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NAME_OFFSET);
	}
	
	/** optional **/
	@NativeType("char*")
	public VkPipelineShaderStageNodeCreateInfoAMDX pName(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NAME_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int index() {
		return (int) INT_HANDLE.get(this.segment, this.offset + INDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPipelineShaderStageNodeCreateInfoAMDX index(int value) {
		INT_HANDLE.set(this.segment, this.offset + INDEX_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPipelineShaderStageNodeCreateInfoAMDX> {
		
		private static final StructConstructor<VkPipelineShaderStageNodeCreateInfoAMDX> CONSTRUCTOR = VkPipelineShaderStageNodeCreateInfoAMDX::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPipelineShaderStageNodeCreateInfoAMDX[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPipelineShaderStageNodeCreateInfoAMDX[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPipelineShaderStageNodeCreateInfoAMDX[size], CONSTRUCTOR, MEMORY_LAYOUT);
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