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
* struct VkPhysicalDeviceDescriptorBufferPropertiesEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 combinedImageSamplerDescriptorSingleArray;
* 	VkBool32 bufferlessPushDescriptors;
* 	VkBool32 allowSamplerImageViewPostSubmitCreation;
* 	// pad (4)
* 	VkDeviceSize descriptorBufferOffsetAlignment;
* 	uint32_t maxDescriptorBufferBindings;
* 	uint32_t maxResourceDescriptorBufferBindings;
* 	uint32_t maxSamplerDescriptorBufferBindings;
* 	uint32_t maxEmbeddedImmutableSamplerBindings;
* 	uint32_t maxEmbeddedImmutableSamplers;
* 	// pad (4)
* 	size_t bufferCaptureReplayDescriptorDataSize;
* 	size_t imageCaptureReplayDescriptorDataSize;
* 	size_t imageViewCaptureReplayDescriptorDataSize;
* 	size_t samplerCaptureReplayDescriptorDataSize;
* 	size_t accelerationStructureCaptureReplayDescriptorDataSize;
* 	size_t samplerDescriptorSize;
* 	size_t combinedImageSamplerDescriptorSize;
* 	size_t sampledImageDescriptorSize;
* 	size_t storageImageDescriptorSize;
* 	size_t uniformTexelBufferDescriptorSize;
* 	size_t robustUniformTexelBufferDescriptorSize;
* 	size_t storageTexelBufferDescriptorSize;
* 	size_t robustStorageTexelBufferDescriptorSize;
* 	size_t uniformBufferDescriptorSize;
* 	size_t robustUniformBufferDescriptorSize;
* 	size_t storageBufferDescriptorSize;
* 	size_t robustStorageBufferDescriptorSize;
* 	size_t inputAttachmentDescriptorSize;
* 	size_t accelerationStructureDescriptorSize;
* 	VkDeviceSize maxSamplerDescriptorBufferRange;
* 	VkDeviceSize maxResourceDescriptorBufferRange;
* 	VkDeviceSize samplerDescriptorBufferAddressSpaceSize;
* 	VkDeviceSize resourceDescriptorBufferAddressSpaceSize;
* 	VkDeviceSize descriptorBufferAddressSpaceSize;
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceDescriptorBufferPropertiesEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int COMBINED_IMAGE_SAMPLER_DESCRIPTOR_SINGLE_ARRAY_OFFSET = 16;
	private static final int BUFFERLESS_PUSH_DESCRIPTORS_OFFSET = 20;
	private static final int ALLOW_SAMPLER_IMAGE_VIEW_POST_SUBMIT_CREATION_OFFSET = 24;
	private static final int DESCRIPTOR_BUFFER_OFFSET_ALIGNMENT_OFFSET = 32;
	private static final int MAX_DESCRIPTOR_BUFFER_BINDINGS_OFFSET = 40;
	private static final int MAX_RESOURCE_DESCRIPTOR_BUFFER_BINDINGS_OFFSET = 44;
	private static final int MAX_SAMPLER_DESCRIPTOR_BUFFER_BINDINGS_OFFSET = 48;
	private static final int MAX_EMBEDDED_IMMUTABLE_SAMPLER_BINDINGS_OFFSET = 52;
	private static final int MAX_EMBEDDED_IMMUTABLE_SAMPLERS_OFFSET = 56;
	private static final int BUFFER_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET = 64;
	private static final int IMAGE_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET = 72;
	private static final int IMAGE_VIEW_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET = 80;
	private static final int SAMPLER_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET = 88;
	private static final int ACCELERATION_STRUCTURE_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET = 96;
	private static final int SAMPLER_DESCRIPTOR_SIZE_OFFSET = 104;
	private static final int COMBINED_IMAGE_SAMPLER_DESCRIPTOR_SIZE_OFFSET = 112;
	private static final int SAMPLED_IMAGE_DESCRIPTOR_SIZE_OFFSET = 120;
	private static final int STORAGE_IMAGE_DESCRIPTOR_SIZE_OFFSET = 128;
	private static final int UNIFORM_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET = 136;
	private static final int ROBUST_UNIFORM_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET = 144;
	private static final int STORAGE_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET = 152;
	private static final int ROBUST_STORAGE_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET = 160;
	private static final int UNIFORM_BUFFER_DESCRIPTOR_SIZE_OFFSET = 168;
	private static final int ROBUST_UNIFORM_BUFFER_DESCRIPTOR_SIZE_OFFSET = 176;
	private static final int STORAGE_BUFFER_DESCRIPTOR_SIZE_OFFSET = 184;
	private static final int ROBUST_STORAGE_BUFFER_DESCRIPTOR_SIZE_OFFSET = 192;
	private static final int INPUT_ATTACHMENT_DESCRIPTOR_SIZE_OFFSET = 200;
	private static final int ACCELERATION_STRUCTURE_DESCRIPTOR_SIZE_OFFSET = 208;
	private static final int MAX_SAMPLER_DESCRIPTOR_BUFFER_RANGE_OFFSET = 216;
	private static final int MAX_RESOURCE_DESCRIPTOR_BUFFER_RANGE_OFFSET = 224;
	private static final int SAMPLER_DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET = 232;
	private static final int RESOURCE_DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET = 240;
	private static final int DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET = 248;
	
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_BUFFER_PROPERTIES_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_BUFFER_PROPERTIES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_BUFFER_PROPERTIES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000316000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean combinedImageSamplerDescriptorSingleArray() {
		return (int) INT_HANDLE.get(this.segment, this.offset + COMBINED_IMAGE_SAMPLER_DESCRIPTOR_SINGLE_ARRAY_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT combinedImageSamplerDescriptorSingleArray(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + COMBINED_IMAGE_SAMPLER_DESCRIPTOR_SINGLE_ARRAY_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean bufferlessPushDescriptors() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BUFFERLESS_PUSH_DESCRIPTORS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT bufferlessPushDescriptors(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + BUFFERLESS_PUSH_DESCRIPTORS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean allowSamplerImageViewPostSubmitCreation() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ALLOW_SAMPLER_IMAGE_VIEW_POST_SUBMIT_CREATION_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT allowSamplerImageViewPostSubmitCreation(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + ALLOW_SAMPLER_IMAGE_VIEW_POST_SUBMIT_CREATION_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long descriptorBufferOffsetAlignment() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + DESCRIPTOR_BUFFER_OFFSET_ALIGNMENT_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT descriptorBufferOffsetAlignment(long value) {
		LONG_HANDLE.set(this.segment, this.offset + DESCRIPTOR_BUFFER_OFFSET_ALIGNMENT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorBufferBindings() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_BUFFER_BINDINGS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxDescriptorBufferBindings(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_BUFFER_BINDINGS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxResourceDescriptorBufferBindings() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_RESOURCE_DESCRIPTOR_BUFFER_BINDINGS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxResourceDescriptorBufferBindings(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_RESOURCE_DESCRIPTOR_BUFFER_BINDINGS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxSamplerDescriptorBufferBindings() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_SAMPLER_DESCRIPTOR_BUFFER_BINDINGS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxSamplerDescriptorBufferBindings(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_SAMPLER_DESCRIPTOR_BUFFER_BINDINGS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxEmbeddedImmutableSamplerBindings() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_EMBEDDED_IMMUTABLE_SAMPLER_BINDINGS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxEmbeddedImmutableSamplerBindings(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_EMBEDDED_IMMUTABLE_SAMPLER_BINDINGS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxEmbeddedImmutableSamplers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_EMBEDDED_IMMUTABLE_SAMPLERS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxEmbeddedImmutableSamplers(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_EMBEDDED_IMMUTABLE_SAMPLERS_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long bufferCaptureReplayDescriptorDataSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + BUFFER_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT bufferCaptureReplayDescriptorDataSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + BUFFER_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long imageCaptureReplayDescriptorDataSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + IMAGE_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT imageCaptureReplayDescriptorDataSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + IMAGE_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long imageViewCaptureReplayDescriptorDataSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + IMAGE_VIEW_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT imageViewCaptureReplayDescriptorDataSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + IMAGE_VIEW_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long samplerCaptureReplayDescriptorDataSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SAMPLER_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT samplerCaptureReplayDescriptorDataSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SAMPLER_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long accelerationStructureCaptureReplayDescriptorDataSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + ACCELERATION_STRUCTURE_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT accelerationStructureCaptureReplayDescriptorDataSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + ACCELERATION_STRUCTURE_CAPTURE_REPLAY_DESCRIPTOR_DATA_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long samplerDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SAMPLER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT samplerDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SAMPLER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long combinedImageSamplerDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + COMBINED_IMAGE_SAMPLER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT combinedImageSamplerDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + COMBINED_IMAGE_SAMPLER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long sampledImageDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SAMPLED_IMAGE_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT sampledImageDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SAMPLED_IMAGE_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long storageImageDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + STORAGE_IMAGE_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT storageImageDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + STORAGE_IMAGE_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long uniformTexelBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + UNIFORM_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT uniformTexelBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + UNIFORM_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long robustUniformTexelBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + ROBUST_UNIFORM_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustUniformTexelBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + ROBUST_UNIFORM_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long storageTexelBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + STORAGE_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT storageTexelBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + STORAGE_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long robustStorageTexelBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + ROBUST_STORAGE_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustStorageTexelBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + ROBUST_STORAGE_TEXEL_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long uniformBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + UNIFORM_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT uniformBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + UNIFORM_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long robustUniformBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + ROBUST_UNIFORM_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustUniformBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + ROBUST_UNIFORM_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long storageBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + STORAGE_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT storageBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + STORAGE_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long robustStorageBufferDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + ROBUST_STORAGE_BUFFER_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustStorageBufferDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + ROBUST_STORAGE_BUFFER_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long inputAttachmentDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + INPUT_ATTACHMENT_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT inputAttachmentDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + INPUT_ATTACHMENT_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("size_t")
	public long accelerationStructureDescriptorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + ACCELERATION_STRUCTURE_DESCRIPTOR_SIZE_OFFSET);
	}
	
	@NativeType("size_t")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT accelerationStructureDescriptorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + ACCELERATION_STRUCTURE_DESCRIPTOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long maxSamplerDescriptorBufferRange() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_SAMPLER_DESCRIPTOR_BUFFER_RANGE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxSamplerDescriptorBufferRange(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_SAMPLER_DESCRIPTOR_BUFFER_RANGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long maxResourceDescriptorBufferRange() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_RESOURCE_DESCRIPTOR_BUFFER_RANGE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxResourceDescriptorBufferRange(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_RESOURCE_DESCRIPTOR_BUFFER_RANGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long samplerDescriptorBufferAddressSpaceSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + SAMPLER_DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT samplerDescriptorBufferAddressSpaceSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + SAMPLER_DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long resourceDescriptorBufferAddressSpaceSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + RESOURCE_DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT resourceDescriptorBufferAddressSpaceSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + RESOURCE_DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceSize")
	public long descriptorBufferAddressSpaceSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkPhysicalDeviceDescriptorBufferPropertiesEXT descriptorBufferAddressSpaceSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + DESCRIPTOR_BUFFER_ADDRESS_SPACE_SIZE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceDescriptorBufferPropertiesEXT> {
		
		private static final StructConstructor<VkPhysicalDeviceDescriptorBufferPropertiesEXT> CONSTRUCTOR = VkPhysicalDeviceDescriptorBufferPropertiesEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceDescriptorBufferPropertiesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceDescriptorBufferPropertiesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceDescriptorBufferPropertiesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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