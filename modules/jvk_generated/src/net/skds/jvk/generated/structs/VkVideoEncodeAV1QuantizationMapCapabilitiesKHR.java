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
* struct VkVideoEncodeAV1QuantizationMapCapabilitiesKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	int32_t minQIndexDelta;
* 	int32_t maxQIndexDelta;
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeAV1QuantizationMapCapabilitiesKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int MIN_QINDEX_DELTA_OFFSET = 16;
	private static final int MAX_QINDEX_DELTA_OFFSET = 20;
	
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_QUANTIZATION_MAP_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_QUANTIZATION_MAP_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_QUANTIZATION_MAP_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000553007);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("int32_t")
	public int minQIndexDelta() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MIN_QINDEX_DELTA_OFFSET);
	}
	
	@NativeType("int32_t")
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR minQIndexDelta(int value) {
		INT_HANDLE.set(this.segment, this.offset + MIN_QINDEX_DELTA_OFFSET, value);
		return this;
	}
	
	@NativeType("int32_t")
	public int maxQIndexDelta() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_QINDEX_DELTA_OFFSET);
	}
	
	@NativeType("int32_t")
	public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR maxQIndexDelta(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_QINDEX_DELTA_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeAV1QuantizationMapCapabilitiesKHR> {
		
		private static final StructConstructor<VkVideoEncodeAV1QuantizationMapCapabilitiesKHR> CONSTRUCTOR = VkVideoEncodeAV1QuantizationMapCapabilitiesKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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