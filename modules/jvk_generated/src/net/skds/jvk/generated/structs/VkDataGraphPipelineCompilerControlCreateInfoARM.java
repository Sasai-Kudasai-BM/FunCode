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
* struct VkDataGraphPipelineCompilerControlCreateInfoARM {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	char* pVendorOptions;
* };
*</pre>
**/
@AutoGenerated
public final class VkDataGraphPipelineCompilerControlCreateInfoARM extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int P_VENDOR_OPTIONS_OFFSET = 16;
	
	public VkDataGraphPipelineCompilerControlCreateInfoARM() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDataGraphPipelineCompilerControlCreateInfoARM(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDataGraphPipelineCompilerControlCreateInfoARM(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_COMPILER_CONTROL_CREATE_INFO_ARM **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_COMPILER_CONTROL_CREATE_INFO_ARM **/
	@NativeType("VkStructureType")
	public VkDataGraphPipelineCompilerControlCreateInfoARM sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_COMPILER_CONTROL_CREATE_INFO_ARM **/
	@NativeType("VkStructureType")
	public VkDataGraphPipelineCompilerControlCreateInfoARM sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000507010);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkDataGraphPipelineCompilerControlCreateInfoARM pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("char*")
	public long pVendorOptions() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_VENDOR_OPTIONS_OFFSET);
	}
	
	@NativeType("char*")
	public VkDataGraphPipelineCompilerControlCreateInfoARM pVendorOptions(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_VENDOR_OPTIONS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkDataGraphPipelineCompilerControlCreateInfoARM> {
		
		private static final StructConstructor<VkDataGraphPipelineCompilerControlCreateInfoARM> CONSTRUCTOR = VkDataGraphPipelineCompilerControlCreateInfoARM::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkDataGraphPipelineCompilerControlCreateInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkDataGraphPipelineCompilerControlCreateInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkDataGraphPipelineCompilerControlCreateInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
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