package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static net.skds.lib2.natives.SafeLinker.*;
import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkVideoCapabilitiesKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkVideoCapabilityFlagsKHR capabilityFlags;
* 	// pad (4)
* 	VkDeviceSize minBitstreamBufferOffsetAlignment;
* 	VkDeviceSize minBitstreamBufferSizeAlignment;
* 	VkExtent2D videoPictureExtentGranularity;
* 	VkExtent2D minExtent;
* 	VkExtent2D maxExtent;
* 	uint32_t maxReferencePicturesSlotsCount;
* 	uint32_t maxReferencePicturesActiveCount;
* 	VkExtensionProperties stdHeaderVersion;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoCapabilitiesKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			VkExtent2D.MEMORY_LAYOUT,
			VkExtent2D.MEMORY_LAYOUT,
			VkExtent2D.MEMORY_LAYOUT,
			JAVA_INT,
			JAVA_INT,
			VkExtensionProperties.MEMORY_LAYOUT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int CAPABILITY_FLAGS_OFFSET = 16;
	private static final int MIN_BITSTREAM_BUFFER_OFFSET_ALIGNMENT_OFFSET = 24;
	private static final int MIN_BITSTREAM_BUFFER_SIZE_ALIGNMENT_OFFSET = 32;
	private static final int VIDEO_PICTURE_EXTENT_GRANULARITY_OFFSET = 40;
	private static final int MIN_EXTENT_OFFSET = 48;
	private static final int MAX_EXTENT_OFFSET = 56;
	private static final int MAX_REFERENCE_PICTURES_SLOTS_COUNT_OFFSET = 64;
	private static final int MAX_REFERENCE_PICTURES_ACTIVE_COUNT_OFFSET = 68;
	private static final int STD_HEADER_VERSION_OFFSET = 72;
	
	public VkVideoCapabilitiesKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoCapabilitiesKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoCapabilitiesKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoCapabilitiesKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoCapabilitiesKHR sType$Default() {
		INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET, 1);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoCapabilitiesKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoCapabilityFlagsKHR")
	public int capabilityFlags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + CAPABILITY_FLAGS_OFFSET);
	}
	
	@NativeType("VkVideoCapabilityFlagsKHR")
	public VkVideoCapabilitiesKHR capabilityFlags(int value) {
		INT_HANDLE.set(this.segment, this.offset + CAPABILITY_FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long minBitstreamBufferOffsetAlignment() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MIN_BITSTREAM_BUFFER_OFFSET_ALIGNMENT_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkVideoCapabilitiesKHR minBitstreamBufferOffsetAlignment(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MIN_BITSTREAM_BUFFER_OFFSET_ALIGNMENT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long minBitstreamBufferSizeAlignment() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MIN_BITSTREAM_BUFFER_SIZE_ALIGNMENT_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkVideoCapabilitiesKHR minBitstreamBufferSizeAlignment(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MIN_BITSTREAM_BUFFER_SIZE_ALIGNMENT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D videoPictureExtentGranularity() {
		return new VkExtent2D(this.segment, this.offset + VIDEO_PICTURE_EXTENT_GRANULARITY_OFFSET);
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D minExtent() {
		return new VkExtent2D(this.segment, this.offset + MIN_EXTENT_OFFSET);
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D maxExtent() {
		return new VkExtent2D(this.segment, this.offset + MAX_EXTENT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public int maxReferencePicturesSlotsCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_REFERENCE_PICTURES_SLOTS_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoCapabilitiesKHR maxReferencePicturesSlotsCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_REFERENCE_PICTURES_SLOTS_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxReferencePicturesActiveCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_REFERENCE_PICTURES_ACTIVE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoCapabilitiesKHR maxReferencePicturesActiveCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_REFERENCE_PICTURES_ACTIVE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkExtensionProperties")
	public VkExtensionProperties stdHeaderVersion() {
		return new VkExtensionProperties(this.segment, this.offset + STD_HEADER_VERSION_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoCapabilitiesKHR> {
		
		private static final StructConstructor<VkVideoCapabilitiesKHR> CONSTRUCTOR = VkVideoCapabilitiesKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoCapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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