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
* struct VkSampleLocationsInfoEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkSampleCountFlagBits sampleLocationsPerPixel;
* 	VkExtent2D sampleLocationGridSize;
* 	uint32_t sampleLocationsCount;
* 	VkSampleLocationEXT* pSampleLocations;
* };
*</pre>
**/
@AutoGenerated
public final class VkSampleLocationsInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			VkExtent2D.MEMORY_LAYOUT,
			JAVA_INT,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SAMPLE_LOCATIONS_PER_PIXEL_OFFSET = 16;
	private static final int SAMPLE_LOCATION_GRID_SIZE_OFFSET = 20;
	private static final int SAMPLE_LOCATIONS_COUNT_OFFSET = 28;
	private static final int P_SAMPLE_LOCATIONS_OFFSET = 32;
	
	public VkSampleLocationsInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSampleLocationsInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSampleLocationsInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_SAMPLE_LOCATIONS_INFO_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_SAMPLE_LOCATIONS_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkSampleLocationsInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_SAMPLE_LOCATIONS_INFO_EXT **/
	@NativeType("VkStructureType")
	public VkSampleLocationsInfoEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000143000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkSampleLocationsInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSampleCountFlagBits")
	public int sampleLocationsPerPixel() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SAMPLE_LOCATIONS_PER_PIXEL_OFFSET);
	}
	
	@NativeType("VkSampleCountFlagBits")
	public VkSampleLocationsInfoEXT sampleLocationsPerPixel(int value) {
		INT_HANDLE.set(this.segment, this.offset + SAMPLE_LOCATIONS_PER_PIXEL_OFFSET, value);
		return this;
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D sampleLocationGridSize() {
		return new VkExtent2D(this.segment, this.offset + SAMPLE_LOCATION_GRID_SIZE_OFFSET);
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public int sampleLocationsCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SAMPLE_LOCATIONS_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("uint32_t")
	public VkSampleLocationsInfoEXT sampleLocationsCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + SAMPLE_LOCATIONS_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSampleLocationEXT*")
	public long pSampleLocations() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_SAMPLE_LOCATIONS_OFFSET);
	}
	
	@NativeType("VkSampleLocationEXT*")
	public VkSampleLocationsInfoEXT pSampleLocations(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_SAMPLE_LOCATIONS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkSampleLocationsInfoEXT> {
		
		private static final StructConstructor<VkSampleLocationsInfoEXT> CONSTRUCTOR = VkSampleLocationsInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkSampleLocationsInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkSampleLocationsInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkSampleLocationsInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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