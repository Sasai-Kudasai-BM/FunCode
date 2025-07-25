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
* struct VkVideoEncodeQuantizationMapCapabilitiesKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkExtent2D maxQuantizationMapExtent;
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeQuantizationMapCapabilitiesKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			VkExtent2D.MEMORY_LAYOUT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int MAX_QUANTIZATION_MAP_EXTENT_OFFSET = 16;
	
	public VkVideoEncodeQuantizationMapCapabilitiesKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeQuantizationMapCapabilitiesKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeQuantizationMapCapabilitiesKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_QUANTIZATION_MAP_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_QUANTIZATION_MAP_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeQuantizationMapCapabilitiesKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_QUANTIZATION_MAP_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeQuantizationMapCapabilitiesKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000553000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoEncodeQuantizationMapCapabilitiesKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D maxQuantizationMapExtent() {
		return new VkExtent2D(this.segment, this.offset + MAX_QUANTIZATION_MAP_EXTENT_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeQuantizationMapCapabilitiesKHR> {
		
		private static final StructConstructor<VkVideoEncodeQuantizationMapCapabilitiesKHR> CONSTRUCTOR = VkVideoEncodeQuantizationMapCapabilitiesKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeQuantizationMapCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeQuantizationMapCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeQuantizationMapCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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