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
* struct VkPhysicalDeviceVulkan12Properties {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkDriverId driverID;
* 	char[256] driverName;
* 	char[256] driverInfo;
* 	VkConformanceVersion conformanceVersion;
* 	VkShaderFloatControlsIndependence denormBehaviorIndependence;
* 	VkShaderFloatControlsIndependence roundingModeIndependence;
* 	VkBool32 shaderSignedZeroInfNanPreserveFloat16;
* 	VkBool32 shaderSignedZeroInfNanPreserveFloat32;
* 	VkBool32 shaderSignedZeroInfNanPreserveFloat64;
* 	VkBool32 shaderDenormPreserveFloat16;
* 	VkBool32 shaderDenormPreserveFloat32;
* 	VkBool32 shaderDenormPreserveFloat64;
* 	VkBool32 shaderDenormFlushToZeroFloat16;
* 	VkBool32 shaderDenormFlushToZeroFloat32;
* 	VkBool32 shaderDenormFlushToZeroFloat64;
* 	VkBool32 shaderRoundingModeRTEFloat16;
* 	VkBool32 shaderRoundingModeRTEFloat32;
* 	VkBool32 shaderRoundingModeRTEFloat64;
* 	VkBool32 shaderRoundingModeRTZFloat16;
* 	VkBool32 shaderRoundingModeRTZFloat32;
* 	VkBool32 shaderRoundingModeRTZFloat64;
* 	uint32_t maxUpdateAfterBindDescriptorsInAllPools;
* 	VkBool32 shaderUniformBufferArrayNonUniformIndexingNative;
* 	VkBool32 shaderSampledImageArrayNonUniformIndexingNative;
* 	VkBool32 shaderStorageBufferArrayNonUniformIndexingNative;
* 	VkBool32 shaderStorageImageArrayNonUniformIndexingNative;
* 	VkBool32 shaderInputAttachmentArrayNonUniformIndexingNative;
* 	VkBool32 robustBufferAccessUpdateAfterBind;
* 	VkBool32 quadDivergentImplicitLod;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindSamplers;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindUniformBuffers;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindStorageBuffers;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindSampledImages;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindStorageImages;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindInputAttachments;
* 	uint32_t maxPerStageUpdateAfterBindResources;
* 	uint32_t maxDescriptorSetUpdateAfterBindSamplers;
* 	uint32_t maxDescriptorSetUpdateAfterBindUniformBuffers;
* 	uint32_t maxDescriptorSetUpdateAfterBindUniformBuffersDynamic;
* 	uint32_t maxDescriptorSetUpdateAfterBindStorageBuffers;
* 	uint32_t maxDescriptorSetUpdateAfterBindStorageBuffersDynamic;
* 	uint32_t maxDescriptorSetUpdateAfterBindSampledImages;
* 	uint32_t maxDescriptorSetUpdateAfterBindStorageImages;
* 	uint32_t maxDescriptorSetUpdateAfterBindInputAttachments;
* 	VkResolveModeFlags supportedDepthResolveModes;
* 	VkResolveModeFlags supportedStencilResolveModes;
* 	VkBool32 independentResolveNone;
* 	VkBool32 independentResolve;
* 	VkBool32 filterMinmaxSingleComponentFormats;
* 	VkBool32 filterMinmaxImageComponentMapping;
* 	uint64_t maxTimelineSemaphoreValueDifference;
* 	VkSampleCountFlags framebufferIntegerColorSampleCounts;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceVulkan12Properties extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			sequenceLayout(256, JAVA_BYTE),
			sequenceLayout(256, JAVA_BYTE),
			VkConformanceVersion.MEMORY_LAYOUT,
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
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int DRIVER_ID_OFFSET = 16;
	private static final int DRIVER_NAME_OFFSET = 20;
	private static final int DRIVER_INFO_OFFSET = 276;
	private static final int CONFORMANCE_VERSION_OFFSET = 532;
	private static final int DENORM_BEHAVIOR_INDEPENDENCE_OFFSET = 536;
	private static final int ROUNDING_MODE_INDEPENDENCE_OFFSET = 540;
	private static final int SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT16_OFFSET = 544;
	private static final int SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT32_OFFSET = 548;
	private static final int SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT64_OFFSET = 552;
	private static final int SHADER_DENORM_PRESERVE_FLOAT16_OFFSET = 556;
	private static final int SHADER_DENORM_PRESERVE_FLOAT32_OFFSET = 560;
	private static final int SHADER_DENORM_PRESERVE_FLOAT64_OFFSET = 564;
	private static final int SHADER_DENORM_FLUSH_TO_ZERO_FLOAT16_OFFSET = 568;
	private static final int SHADER_DENORM_FLUSH_TO_ZERO_FLOAT32_OFFSET = 572;
	private static final int SHADER_DENORM_FLUSH_TO_ZERO_FLOAT64_OFFSET = 576;
	private static final int SHADER_ROUNDING_MODE_RTEFLOAT16_OFFSET = 580;
	private static final int SHADER_ROUNDING_MODE_RTEFLOAT32_OFFSET = 584;
	private static final int SHADER_ROUNDING_MODE_RTEFLOAT64_OFFSET = 588;
	private static final int SHADER_ROUNDING_MODE_RTZFLOAT16_OFFSET = 592;
	private static final int SHADER_ROUNDING_MODE_RTZFLOAT32_OFFSET = 596;
	private static final int SHADER_ROUNDING_MODE_RTZFLOAT64_OFFSET = 600;
	private static final int MAX_UPDATE_AFTER_BIND_DESCRIPTORS_IN_ALL_POOLS_OFFSET = 604;
	private static final int SHADER_UNIFORM_BUFFER_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET = 608;
	private static final int SHADER_SAMPLED_IMAGE_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET = 612;
	private static final int SHADER_STORAGE_BUFFER_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET = 616;
	private static final int SHADER_STORAGE_IMAGE_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET = 620;
	private static final int SHADER_INPUT_ATTACHMENT_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET = 624;
	private static final int ROBUST_BUFFER_ACCESS_UPDATE_AFTER_BIND_OFFSET = 628;
	private static final int QUAD_DIVERGENT_IMPLICIT_LOD_OFFSET = 632;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_SAMPLERS_OFFSET = 636;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_OFFSET = 640;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_BUFFERS_OFFSET = 644;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_SAMPLED_IMAGES_OFFSET = 648;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_IMAGES_OFFSET = 652;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_INPUT_ATTACHMENTS_OFFSET = 656;
	private static final int MAX_PER_STAGE_UPDATE_AFTER_BIND_RESOURCES_OFFSET = 660;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_SAMPLERS_OFFSET = 664;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_OFFSET = 668;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_DYNAMIC_OFFSET = 672;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_BUFFERS_OFFSET = 676;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_BUFFERS_DYNAMIC_OFFSET = 680;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_SAMPLED_IMAGES_OFFSET = 684;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_IMAGES_OFFSET = 688;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_INPUT_ATTACHMENTS_OFFSET = 692;
	private static final int SUPPORTED_DEPTH_RESOLVE_MODES_OFFSET = 696;
	private static final int SUPPORTED_STENCIL_RESOLVE_MODES_OFFSET = 700;
	private static final int INDEPENDENT_RESOLVE_NONE_OFFSET = 704;
	private static final int INDEPENDENT_RESOLVE_OFFSET = 708;
	private static final int FILTER_MINMAX_SINGLE_COMPONENT_FORMATS_OFFSET = 712;
	private static final int FILTER_MINMAX_IMAGE_COMPONENT_MAPPING_OFFSET = 716;
	private static final int MAX_TIMELINE_SEMAPHORE_VALUE_DIFFERENCE_OFFSET = 720;
	private static final int FRAMEBUFFER_INTEGER_COLOR_SAMPLE_COUNTS_OFFSET = 728;
	
	public VkPhysicalDeviceVulkan12Properties() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceVulkan12Properties(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceVulkan12Properties(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceVulkan12Properties sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceVulkan12Properties sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 52);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceVulkan12Properties pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDriverId")
	public int driverID() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DRIVER_ID_OFFSET);
	}
	
	@NativeType("VkDriverId")
	public VkPhysicalDeviceVulkan12Properties driverID(int value) {
		INT_HANDLE.set(this.segment, this.offset + DRIVER_ID_OFFSET, value);
		return this;
	}
	
	@NativeType("char[256]")
	public byte driverName(int i) {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + DRIVER_NAME_OFFSET + JAVA_BYTE.byteSize() * i);
	}
	
	@NativeType("char[256]")
	public byte[] driverNameArray() {
		var array = new byte[256];
		MemorySegment.copy(this.segment, BYTE, this.offset + DRIVER_NAME_OFFSET, array, 0, array.length);
		return array;
	}
	
	@NativeType("char[256]")
	public String driverName() {
		return this.segment.getString(this.offset + DRIVER_NAME_OFFSET);
	}
	
	@NativeType("char[256]")
	public VkPhysicalDeviceVulkan12Properties driverName(int i, byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + DRIVER_NAME_OFFSET + JAVA_BYTE.byteSize() * i, value);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPhysicalDeviceVulkan12Properties driverName(byte[] value) {
		MemorySegment.copy(value, 0, this.segment, BYTE, this.offset + DRIVER_NAME_OFFSET, value.length);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPhysicalDeviceVulkan12Properties driverName(String value) {
		this.segment.setString(this.offset + DRIVER_NAME_OFFSET, value);
		return this;
	}
	
	@NativeType("char[256]")
	public byte driverInfo(int i) {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + DRIVER_INFO_OFFSET + JAVA_BYTE.byteSize() * i);
	}
	
	@NativeType("char[256]")
	public byte[] driverInfoArray() {
		var array = new byte[256];
		MemorySegment.copy(this.segment, BYTE, this.offset + DRIVER_INFO_OFFSET, array, 0, array.length);
		return array;
	}
	
	@NativeType("char[256]")
	public String driverInfo() {
		return this.segment.getString(this.offset + DRIVER_INFO_OFFSET);
	}
	
	@NativeType("char[256]")
	public VkPhysicalDeviceVulkan12Properties driverInfo(int i, byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + DRIVER_INFO_OFFSET + JAVA_BYTE.byteSize() * i, value);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPhysicalDeviceVulkan12Properties driverInfo(byte[] value) {
		MemorySegment.copy(value, 0, this.segment, BYTE, this.offset + DRIVER_INFO_OFFSET, value.length);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPhysicalDeviceVulkan12Properties driverInfo(String value) {
		this.segment.setString(this.offset + DRIVER_INFO_OFFSET, value);
		return this;
	}
	
	@NativeType("VkConformanceVersion")
	public VkConformanceVersion conformanceVersion() {
		return new VkConformanceVersion(this.segment, this.offset + CONFORMANCE_VERSION_OFFSET);
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public int denormBehaviorIndependence() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DENORM_BEHAVIOR_INDEPENDENCE_OFFSET);
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public VkPhysicalDeviceVulkan12Properties denormBehaviorIndependence(int value) {
		INT_HANDLE.set(this.segment, this.offset + DENORM_BEHAVIOR_INDEPENDENCE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public int roundingModeIndependence() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ROUNDING_MODE_INDEPENDENCE_OFFSET);
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public VkPhysicalDeviceVulkan12Properties roundingModeIndependence(int value) {
		INT_HANDLE.set(this.segment, this.offset + ROUNDING_MODE_INDEPENDENCE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSignedZeroInfNanPreserveFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderSignedZeroInfNanPreserveFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSignedZeroInfNanPreserveFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderSignedZeroInfNanPreserveFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSignedZeroInfNanPreserveFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderSignedZeroInfNanPreserveFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormPreserveFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderDenormPreserveFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormPreserveFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderDenormPreserveFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormPreserveFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderDenormPreserveFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormFlushToZeroFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderDenormFlushToZeroFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormFlushToZeroFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderDenormFlushToZeroFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormFlushToZeroFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderDenormFlushToZeroFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTEFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTEFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTEFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTEFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTEFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTEFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTZFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTZFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTZFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTZFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTZFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTZFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxUpdateAfterBindDescriptorsInAllPools() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_UPDATE_AFTER_BIND_DESCRIPTORS_IN_ALL_POOLS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxUpdateAfterBindDescriptorsInAllPools(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_UPDATE_AFTER_BIND_DESCRIPTORS_IN_ALL_POOLS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderUniformBufferArrayNonUniformIndexingNative() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_UNIFORM_BUFFER_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderUniformBufferArrayNonUniformIndexingNative(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_UNIFORM_BUFFER_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSampledImageArrayNonUniformIndexingNative() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SAMPLED_IMAGE_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderSampledImageArrayNonUniformIndexingNative(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SAMPLED_IMAGE_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderStorageBufferArrayNonUniformIndexingNative() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_STORAGE_BUFFER_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderStorageBufferArrayNonUniformIndexingNative(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_STORAGE_BUFFER_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderStorageImageArrayNonUniformIndexingNative() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_STORAGE_IMAGE_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderStorageImageArrayNonUniformIndexingNative(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_STORAGE_IMAGE_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderInputAttachmentArrayNonUniformIndexingNative() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_INPUT_ATTACHMENT_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties shaderInputAttachmentArrayNonUniformIndexingNative(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_INPUT_ATTACHMENT_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean robustBufferAccessUpdateAfterBind() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ROBUST_BUFFER_ACCESS_UPDATE_AFTER_BIND_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties robustBufferAccessUpdateAfterBind(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + ROBUST_BUFFER_ACCESS_UPDATE_AFTER_BIND_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean quadDivergentImplicitLod() {
		return (int) INT_HANDLE.get(this.segment, this.offset + QUAD_DIVERGENT_IMPLICIT_LOD_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties quadDivergentImplicitLod(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + QUAD_DIVERGENT_IMPLICIT_LOD_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindSamplers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_SAMPLERS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindSamplers(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_SAMPLERS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindUniformBuffers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindUniformBuffers(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindStorageBuffers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_BUFFERS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindStorageBuffers(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_BUFFERS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindSampledImages() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_SAMPLED_IMAGES_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindSampledImages(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_SAMPLED_IMAGES_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindStorageImages() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_IMAGES_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindStorageImages(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_IMAGES_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindInputAttachments() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_INPUT_ATTACHMENTS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindInputAttachments(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_INPUT_ATTACHMENTS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageUpdateAfterBindResources() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_UPDATE_AFTER_BIND_RESOURCES_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxPerStageUpdateAfterBindResources(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_UPDATE_AFTER_BIND_RESOURCES_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindSamplers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_SAMPLERS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindSamplers(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_SAMPLERS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindUniformBuffers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindUniformBuffers(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindUniformBuffersDynamic() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_DYNAMIC_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindUniformBuffersDynamic(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_UNIFORM_BUFFERS_DYNAMIC_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindStorageBuffers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_BUFFERS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindStorageBuffers(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_BUFFERS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindStorageBuffersDynamic() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_BUFFERS_DYNAMIC_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindStorageBuffersDynamic(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_BUFFERS_DYNAMIC_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindSampledImages() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_SAMPLED_IMAGES_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindSampledImages(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_SAMPLED_IMAGES_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindStorageImages() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_IMAGES_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindStorageImages(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_IMAGES_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindInputAttachments() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_INPUT_ATTACHMENTS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindInputAttachments(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_INPUT_ATTACHMENTS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkResolveModeFlags")
	public int supportedDepthResolveModes() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SUPPORTED_DEPTH_RESOLVE_MODES_OFFSET);
	}
	
	@NativeType("VkResolveModeFlags")
	public VkPhysicalDeviceVulkan12Properties supportedDepthResolveModes(int value) {
		INT_HANDLE.set(this.segment, this.offset + SUPPORTED_DEPTH_RESOLVE_MODES_OFFSET, value);
		return this;
	}
	
	@NativeType("VkResolveModeFlags")
	public int supportedStencilResolveModes() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SUPPORTED_STENCIL_RESOLVE_MODES_OFFSET);
	}
	
	@NativeType("VkResolveModeFlags")
	public VkPhysicalDeviceVulkan12Properties supportedStencilResolveModes(int value) {
		INT_HANDLE.set(this.segment, this.offset + SUPPORTED_STENCIL_RESOLVE_MODES_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean independentResolveNone() {
		return (int) INT_HANDLE.get(this.segment, this.offset + INDEPENDENT_RESOLVE_NONE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties independentResolveNone(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + INDEPENDENT_RESOLVE_NONE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean independentResolve() {
		return (int) INT_HANDLE.get(this.segment, this.offset + INDEPENDENT_RESOLVE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties independentResolve(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + INDEPENDENT_RESOLVE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean filterMinmaxSingleComponentFormats() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FILTER_MINMAX_SINGLE_COMPONENT_FORMATS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties filterMinmaxSingleComponentFormats(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + FILTER_MINMAX_SINGLE_COMPONENT_FORMATS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean filterMinmaxImageComponentMapping() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FILTER_MINMAX_IMAGE_COMPONENT_MAPPING_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceVulkan12Properties filterMinmaxImageComponentMapping(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + FILTER_MINMAX_IMAGE_COMPONENT_MAPPING_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("uint64_t")
	public long maxTimelineSemaphoreValueDifference() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_TIMELINE_SEMAPHORE_VALUE_DIFFERENCE_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPhysicalDeviceVulkan12Properties maxTimelineSemaphoreValueDifference(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_TIMELINE_SEMAPHORE_VALUE_DIFFERENCE_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkSampleCountFlags")
	public int framebufferIntegerColorSampleCounts() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FRAMEBUFFER_INTEGER_COLOR_SAMPLE_COUNTS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkSampleCountFlags")
	public VkPhysicalDeviceVulkan12Properties framebufferIntegerColorSampleCounts(int value) {
		INT_HANDLE.set(this.segment, this.offset + FRAMEBUFFER_INTEGER_COLOR_SAMPLE_COUNTS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceVulkan12Properties> {
		
		private static final StructConstructor<VkPhysicalDeviceVulkan12Properties> CONSTRUCTOR = VkPhysicalDeviceVulkan12Properties::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceVulkan12Properties[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceVulkan12Properties[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceVulkan12Properties[size], CONSTRUCTOR, MEMORY_LAYOUT);
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