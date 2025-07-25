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
* struct VkRefreshObjectKHR {
* 	VkObjectType objectType;
* 	// pad (4)
* 	uint64_t objectHandle;
* 	VkRefreshObjectFlagsKHR flags;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkRefreshObjectKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int OBJECT_TYPE_OFFSET = 0;
	private static final int OBJECT_HANDLE_OFFSET = 8;
	private static final int FLAGS_OFFSET = 16;
	
	public VkRefreshObjectKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRefreshObjectKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRefreshObjectKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("VkObjectType")
	public int objectType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + OBJECT_TYPE_OFFSET);
	}
	
	@NativeType("VkObjectType")
	public VkRefreshObjectKHR objectType(int value) {
		INT_HANDLE.set(this.segment, this.offset + OBJECT_TYPE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long objectHandle() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + OBJECT_HANDLE_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkRefreshObjectKHR objectHandle(long value) {
		LONG_HANDLE.set(this.segment, this.offset + OBJECT_HANDLE_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkRefreshObjectFlagsKHR")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkRefreshObjectFlagsKHR")
	public VkRefreshObjectKHR flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkRefreshObjectKHR> {
		
		private static final StructConstructor<VkRefreshObjectKHR> CONSTRUCTOR = VkRefreshObjectKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkRefreshObjectKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkRefreshObjectKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkRefreshObjectKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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