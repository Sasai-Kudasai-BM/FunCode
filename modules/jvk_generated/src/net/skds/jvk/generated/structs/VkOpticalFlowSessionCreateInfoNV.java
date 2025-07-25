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
* struct VkOpticalFlowSessionCreateInfoNV {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t width;
* 	uint32_t height;
* 	VkFormat imageFormat;
* 	VkFormat flowVectorFormat;
* 	VkFormat costFormat;
* 	VkOpticalFlowGridSizeFlagsNV outputGridSize;
* 	VkOpticalFlowGridSizeFlagsNV hintGridSize;
* 	VkOpticalFlowPerformanceLevelNV performanceLevel;
* 	VkOpticalFlowSessionCreateFlagsNV flags;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkOpticalFlowSessionCreateInfoNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int WIDTH_OFFSET = 16;
	private static final int HEIGHT_OFFSET = 20;
	private static final int IMAGE_FORMAT_OFFSET = 24;
	private static final int FLOW_VECTOR_FORMAT_OFFSET = 28;
	private static final int COST_FORMAT_OFFSET = 32;
	private static final int OUTPUT_GRID_SIZE_OFFSET = 36;
	private static final int HINT_GRID_SIZE_OFFSET = 40;
	private static final int PERFORMANCE_LEVEL_OFFSET = 44;
	private static final int FLAGS_OFFSET = 48;
	
	public VkOpticalFlowSessionCreateInfoNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkOpticalFlowSessionCreateInfoNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkOpticalFlowSessionCreateInfoNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_OPTICAL_FLOW_SESSION_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_OPTICAL_FLOW_SESSION_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public VkOpticalFlowSessionCreateInfoNV sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_OPTICAL_FLOW_SESSION_CREATE_INFO_NV **/
	@NativeType("VkStructureType")
	public VkOpticalFlowSessionCreateInfoNV sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000464004);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkOpticalFlowSessionCreateInfoNV pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int width() {
		return (int) INT_HANDLE.get(this.segment, this.offset + WIDTH_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkOpticalFlowSessionCreateInfoNV width(int value) {
		INT_HANDLE.set(this.segment, this.offset + WIDTH_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int height() {
		return (int) INT_HANDLE.get(this.segment, this.offset + HEIGHT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkOpticalFlowSessionCreateInfoNV height(int value) {
		INT_HANDLE.set(this.segment, this.offset + HEIGHT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFormat")
	public int imageFormat() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IMAGE_FORMAT_OFFSET);
	}
	
	@NativeType("VkFormat")
	public VkOpticalFlowSessionCreateInfoNV imageFormat(int value) {
		INT_HANDLE.set(this.segment, this.offset + IMAGE_FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFormat")
	public int flowVectorFormat() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLOW_VECTOR_FORMAT_OFFSET);
	}
	
	@NativeType("VkFormat")
	public VkOpticalFlowSessionCreateInfoNV flowVectorFormat(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLOW_VECTOR_FORMAT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkFormat")
	public int costFormat() {
		return (int) INT_HANDLE.get(this.segment, this.offset + COST_FORMAT_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkFormat")
	public VkOpticalFlowSessionCreateInfoNV costFormat(int value) {
		INT_HANDLE.set(this.segment, this.offset + COST_FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkOpticalFlowGridSizeFlagsNV")
	public int outputGridSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + OUTPUT_GRID_SIZE_OFFSET);
	}
	
	@NativeType("VkOpticalFlowGridSizeFlagsNV")
	public VkOpticalFlowSessionCreateInfoNV outputGridSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + OUTPUT_GRID_SIZE_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkOpticalFlowGridSizeFlagsNV")
	public int hintGridSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + HINT_GRID_SIZE_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkOpticalFlowGridSizeFlagsNV")
	public VkOpticalFlowSessionCreateInfoNV hintGridSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + HINT_GRID_SIZE_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkOpticalFlowPerformanceLevelNV")
	public int performanceLevel() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PERFORMANCE_LEVEL_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkOpticalFlowPerformanceLevelNV")
	public VkOpticalFlowSessionCreateInfoNV performanceLevel(int value) {
		INT_HANDLE.set(this.segment, this.offset + PERFORMANCE_LEVEL_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkOpticalFlowSessionCreateFlagsNV")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkOpticalFlowSessionCreateFlagsNV")
	public VkOpticalFlowSessionCreateInfoNV flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkOpticalFlowSessionCreateInfoNV> {
		
		private static final StructConstructor<VkOpticalFlowSessionCreateInfoNV> CONSTRUCTOR = VkOpticalFlowSessionCreateInfoNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkOpticalFlowSessionCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkOpticalFlowSessionCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkOpticalFlowSessionCreateInfoNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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