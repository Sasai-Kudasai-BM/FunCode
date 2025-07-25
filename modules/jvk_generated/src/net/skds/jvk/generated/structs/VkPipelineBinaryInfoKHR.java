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
* struct VkPipelineBinaryInfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t binaryCount;
* 	// pad (4)
* 	VkPipelineBinaryKHR** pPipelineBinaries;
* };
*</pre>
**/
@AutoGenerated
public final class VkPipelineBinaryInfoKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int BINARY_COUNT_OFFSET = 16;
	private static final int P_PIPELINE_BINARIES_OFFSET = 24;
	
	public VkPipelineBinaryInfoKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineBinaryInfoKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineBinaryInfoKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_BINARY_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_BINARY_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkPipelineBinaryInfoKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_BINARY_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkPipelineBinaryInfoKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000483002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPipelineBinaryInfoKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public int binaryCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BINARY_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public VkPipelineBinaryInfoKHR binaryCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + BINARY_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkPipelineBinaryKHR**")
	public long pPipelineBinaries() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_PIPELINE_BINARIES_OFFSET);
	}
	
	@NativeType("VkPipelineBinaryKHR**")
	public VkPipelineBinaryInfoKHR pPipelineBinaries(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_PIPELINE_BINARIES_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPipelineBinaryInfoKHR> {
		
		private static final StructConstructor<VkPipelineBinaryInfoKHR> CONSTRUCTOR = VkPipelineBinaryInfoKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPipelineBinaryInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPipelineBinaryInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPipelineBinaryInfoKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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