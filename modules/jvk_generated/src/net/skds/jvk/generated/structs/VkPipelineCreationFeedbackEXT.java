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
* struct VkPipelineCreationFeedback {
* 	VkPipelineCreationFeedbackFlags flags;
* 	// pad (4)
* 	uint64_t duration;
* };
*</pre>
**/
@AutoGenerated
public final class VkPipelineCreationFeedbackEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG
	);
	private static final int FLAGS_OFFSET = 0;
	private static final int DURATION_OFFSET = 8;
	
	public VkPipelineCreationFeedbackEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCreationFeedbackEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCreationFeedbackEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("VkPipelineCreationFeedbackFlags")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	@NativeType("VkPipelineCreationFeedbackFlags")
	public VkPipelineCreationFeedbackEXT flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long duration() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + DURATION_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPipelineCreationFeedbackEXT duration(long value) {
		LONG_HANDLE.set(this.segment, this.offset + DURATION_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPipelineCreationFeedbackEXT> {
		
		private static final StructConstructor<VkPipelineCreationFeedbackEXT> CONSTRUCTOR = VkPipelineCreationFeedbackEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPipelineCreationFeedbackEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPipelineCreationFeedbackEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPipelineCreationFeedbackEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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