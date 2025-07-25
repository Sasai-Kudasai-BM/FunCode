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
* struct VkDataGraphPipelineSessionMemoryRequirementsInfoARM {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkDataGraphPipelineSessionARM* session;
* 	VkDataGraphPipelineSessionBindPointARM bindPoint;
* 	uint32_t objectIndex;
* };
*</pre>
**/
@AutoGenerated
public final class VkDataGraphPipelineSessionMemoryRequirementsInfoARM extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SESSION_OFFSET = 16;
	private static final int BIND_POINT_OFFSET = 24;
	private static final int OBJECT_INDEX_OFFSET = 28;
	
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_SESSION_MEMORY_REQUIREMENTS_INFO_ARM **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_SESSION_MEMORY_REQUIREMENTS_INFO_ARM **/
	@NativeType("VkStructureType")
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_SESSION_MEMORY_REQUIREMENTS_INFO_ARM **/
	@NativeType("VkStructureType")
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000507004);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDataGraphPipelineSessionARM*")
	public long session() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SESSION_OFFSET);
	}
	
	@NativeType("VkDataGraphPipelineSessionARM*")
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM session(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SESSION_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDataGraphPipelineSessionBindPointARM")
	public int bindPoint() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BIND_POINT_OFFSET);
	}
	
	@NativeType("VkDataGraphPipelineSessionBindPointARM")
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM bindPoint(int value) {
		INT_HANDLE.set(this.segment, this.offset + BIND_POINT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int objectIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + OBJECT_INDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkDataGraphPipelineSessionMemoryRequirementsInfoARM objectIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + OBJECT_INDEX_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkDataGraphPipelineSessionMemoryRequirementsInfoARM> {
		
		private static final StructConstructor<VkDataGraphPipelineSessionMemoryRequirementsInfoARM> CONSTRUCTOR = VkDataGraphPipelineSessionMemoryRequirementsInfoARM::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkDataGraphPipelineSessionMemoryRequirementsInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkDataGraphPipelineSessionMemoryRequirementsInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkDataGraphPipelineSessionMemoryRequirementsInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
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