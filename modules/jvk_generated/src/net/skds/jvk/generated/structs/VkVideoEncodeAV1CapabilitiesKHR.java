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
* struct VkVideoEncodeAV1CapabilitiesKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkVideoEncodeAV1CapabilityFlagsKHR flags;
* 	VkExtent2D codedPictureAlignment;
* 	VkExtent2D maxTiles;
* 	VkExtent2D minTileSize;
* 	VkExtent2D maxTileSize;
* 	VkVideoEncodeAV1SuperblockSizeFlagsKHR superblockSizes;
* 	uint32_t maxSingleReferenceCount;
* 	uint32_t singleReferenceNameMask;
* 	uint32_t maxUnidirectionalCompoundReferenceCount;
* 	uint32_t maxUnidirectionalCompoundGroup1ReferenceCount;
* 	uint32_t unidirectionalCompoundReferenceNameMask;
* 	uint32_t maxBidirectionalCompoundReferenceCount;
* 	uint32_t maxBidirectionalCompoundGroup1ReferenceCount;
* 	uint32_t maxBidirectionalCompoundGroup2ReferenceCount;
* 	uint32_t bidirectionalCompoundReferenceNameMask;
* 	uint32_t maxTemporalLayerCount;
* 	uint32_t maxSpatialLayerCount;
* 	uint32_t maxOperatingPoints;
* 	uint32_t minQIndex;
* 	uint32_t maxQIndex;
* 	VkBool32 prefersGopRemainingFrames;
* 	VkBool32 requiresGopRemainingFrames;
* 	VkVideoEncodeAV1StdFlagsKHR stdSyntaxFlags;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkVideoEncodeAV1CapabilitiesKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			VkExtent2D.MEMORY_LAYOUT,
			VkExtent2D.MEMORY_LAYOUT,
			VkExtent2D.MEMORY_LAYOUT,
			VkExtent2D.MEMORY_LAYOUT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
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
	private static final int FLAGS_OFFSET = 16;
	private static final int MAX_LEVEL_OFFSET = -1;
	private static final int CODED_PICTURE_ALIGNMENT_OFFSET = 20;
	private static final int MAX_TILES_OFFSET = 28;
	private static final int MIN_TILE_SIZE_OFFSET = 36;
	private static final int MAX_TILE_SIZE_OFFSET = 44;
	private static final int SUPERBLOCK_SIZES_OFFSET = 52;
	private static final int MAX_SINGLE_REFERENCE_COUNT_OFFSET = 56;
	private static final int SINGLE_REFERENCE_NAME_MASK_OFFSET = 60;
	private static final int MAX_UNIDIRECTIONAL_COMPOUND_REFERENCE_COUNT_OFFSET = 64;
	private static final int MAX_UNIDIRECTIONAL_COMPOUND_GROUP1_REFERENCE_COUNT_OFFSET = 68;
	private static final int UNIDIRECTIONAL_COMPOUND_REFERENCE_NAME_MASK_OFFSET = 72;
	private static final int MAX_BIDIRECTIONAL_COMPOUND_REFERENCE_COUNT_OFFSET = 76;
	private static final int MAX_BIDIRECTIONAL_COMPOUND_GROUP1_REFERENCE_COUNT_OFFSET = 80;
	private static final int MAX_BIDIRECTIONAL_COMPOUND_GROUP2_REFERENCE_COUNT_OFFSET = 84;
	private static final int BIDIRECTIONAL_COMPOUND_REFERENCE_NAME_MASK_OFFSET = 88;
	private static final int MAX_TEMPORAL_LAYER_COUNT_OFFSET = 92;
	private static final int MAX_SPATIAL_LAYER_COUNT_OFFSET = 96;
	private static final int MAX_OPERATING_POINTS_OFFSET = 100;
	private static final int MIN_QINDEX_OFFSET = 104;
	private static final int MAX_QINDEX_OFFSET = 108;
	private static final int PREFERS_GOP_REMAINING_FRAMES_OFFSET = 112;
	private static final int REQUIRES_GOP_REMAINING_FRAMES_OFFSET = 116;
	private static final int STD_SYNTAX_FLAGS_OFFSET = 120;
	
	public VkVideoEncodeAV1CapabilitiesKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeAV1CapabilitiesKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkVideoEncodeAV1CapabilitiesKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeAV1CapabilitiesKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_CAPABILITIES_KHR **/
	@NativeType("VkStructureType")
	public VkVideoEncodeAV1CapabilitiesKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000513000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkVideoEncodeAV1CapabilitiesKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkVideoEncodeAV1CapabilityFlagsKHR")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	@NativeType("VkVideoEncodeAV1CapabilityFlagsKHR")
	public VkVideoEncodeAV1CapabilitiesKHR flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D codedPictureAlignment() {
		return new VkExtent2D(this.segment, this.offset + CODED_PICTURE_ALIGNMENT_OFFSET);
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D maxTiles() {
		return new VkExtent2D(this.segment, this.offset + MAX_TILES_OFFSET);
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D minTileSize() {
		return new VkExtent2D(this.segment, this.offset + MIN_TILE_SIZE_OFFSET);
	}
	
	@NativeType("VkExtent2D")
	public VkExtent2D maxTileSize() {
		return new VkExtent2D(this.segment, this.offset + MAX_TILE_SIZE_OFFSET);
	}
	
	@NativeType("VkVideoEncodeAV1SuperblockSizeFlagsKHR")
	public int superblockSizes() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SUPERBLOCK_SIZES_OFFSET);
	}
	
	@NativeType("VkVideoEncodeAV1SuperblockSizeFlagsKHR")
	public VkVideoEncodeAV1CapabilitiesKHR superblockSizes(int value) {
		INT_HANDLE.set(this.segment, this.offset + SUPERBLOCK_SIZES_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxSingleReferenceCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_SINGLE_REFERENCE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxSingleReferenceCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_SINGLE_REFERENCE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int singleReferenceNameMask() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SINGLE_REFERENCE_NAME_MASK_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR singleReferenceNameMask(int value) {
		INT_HANDLE.set(this.segment, this.offset + SINGLE_REFERENCE_NAME_MASK_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxUnidirectionalCompoundReferenceCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_UNIDIRECTIONAL_COMPOUND_REFERENCE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxUnidirectionalCompoundReferenceCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_UNIDIRECTIONAL_COMPOUND_REFERENCE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxUnidirectionalCompoundGroup1ReferenceCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_UNIDIRECTIONAL_COMPOUND_GROUP1_REFERENCE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxUnidirectionalCompoundGroup1ReferenceCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_UNIDIRECTIONAL_COMPOUND_GROUP1_REFERENCE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int unidirectionalCompoundReferenceNameMask() {
		return (int) INT_HANDLE.get(this.segment, this.offset + UNIDIRECTIONAL_COMPOUND_REFERENCE_NAME_MASK_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR unidirectionalCompoundReferenceNameMask(int value) {
		INT_HANDLE.set(this.segment, this.offset + UNIDIRECTIONAL_COMPOUND_REFERENCE_NAME_MASK_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxBidirectionalCompoundReferenceCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_BIDIRECTIONAL_COMPOUND_REFERENCE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxBidirectionalCompoundReferenceCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_BIDIRECTIONAL_COMPOUND_REFERENCE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxBidirectionalCompoundGroup1ReferenceCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_BIDIRECTIONAL_COMPOUND_GROUP1_REFERENCE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxBidirectionalCompoundGroup1ReferenceCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_BIDIRECTIONAL_COMPOUND_GROUP1_REFERENCE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxBidirectionalCompoundGroup2ReferenceCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_BIDIRECTIONAL_COMPOUND_GROUP2_REFERENCE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxBidirectionalCompoundGroup2ReferenceCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_BIDIRECTIONAL_COMPOUND_GROUP2_REFERENCE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int bidirectionalCompoundReferenceNameMask() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BIDIRECTIONAL_COMPOUND_REFERENCE_NAME_MASK_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR bidirectionalCompoundReferenceNameMask(int value) {
		INT_HANDLE.set(this.segment, this.offset + BIDIRECTIONAL_COMPOUND_REFERENCE_NAME_MASK_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxTemporalLayerCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_TEMPORAL_LAYER_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxTemporalLayerCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_TEMPORAL_LAYER_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxSpatialLayerCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_SPATIAL_LAYER_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxSpatialLayerCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_SPATIAL_LAYER_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxOperatingPoints() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_OPERATING_POINTS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxOperatingPoints(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_OPERATING_POINTS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int minQIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MIN_QINDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR minQIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + MIN_QINDEX_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxQIndex() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_QINDEX_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkVideoEncodeAV1CapabilitiesKHR maxQIndex(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_QINDEX_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean prefersGopRemainingFrames() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PREFERS_GOP_REMAINING_FRAMES_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeAV1CapabilitiesKHR prefersGopRemainingFrames(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + PREFERS_GOP_REMAINING_FRAMES_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean requiresGopRemainingFrames() {
		return (int) INT_HANDLE.get(this.segment, this.offset + REQUIRES_GOP_REMAINING_FRAMES_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkVideoEncodeAV1CapabilitiesKHR requiresGopRemainingFrames(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + REQUIRES_GOP_REMAINING_FRAMES_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkVideoEncodeAV1StdFlagsKHR")
	public int stdSyntaxFlags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + STD_SYNTAX_FLAGS_OFFSET);
	}
	
	@NativeType("VkVideoEncodeAV1StdFlagsKHR")
	public VkVideoEncodeAV1CapabilitiesKHR stdSyntaxFlags(int value) {
		INT_HANDLE.set(this.segment, this.offset + STD_SYNTAX_FLAGS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkVideoEncodeAV1CapabilitiesKHR> {
		
		private static final StructConstructor<VkVideoEncodeAV1CapabilitiesKHR> CONSTRUCTOR = VkVideoEncodeAV1CapabilitiesKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkVideoEncodeAV1CapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkVideoEncodeAV1CapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkVideoEncodeAV1CapabilitiesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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