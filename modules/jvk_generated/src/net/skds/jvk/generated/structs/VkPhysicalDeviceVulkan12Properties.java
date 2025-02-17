package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkConformanceVersion;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceVulkan12Properties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceVulkan12Properties.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDriverId")
	public int driverID;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] driverName;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] driverInfo;

	@NativeType("VkConformanceVersion")
	public VkConformanceVersion conformanceVersion;

	@NativeType("VkShaderFloatControlsIndependence")
	public int denormBehaviorIndependence;

	@NativeType("VkShaderFloatControlsIndependence")
	public int roundingModeIndependence;

	@NativeType("VkBool32")
	public int shaderSignedZeroInfNanPreserveFloat16;

	@NativeType("VkBool32")
	public int shaderSignedZeroInfNanPreserveFloat32;

	@NativeType("VkBool32")
	public int shaderSignedZeroInfNanPreserveFloat64;

	@NativeType("VkBool32")
	public int shaderDenormPreserveFloat16;

	@NativeType("VkBool32")
	public int shaderDenormPreserveFloat32;

	@NativeType("VkBool32")
	public int shaderDenormPreserveFloat64;

	@NativeType("VkBool32")
	public int shaderDenormFlushToZeroFloat16;

	@NativeType("VkBool32")
	public int shaderDenormFlushToZeroFloat32;

	@NativeType("VkBool32")
	public int shaderDenormFlushToZeroFloat64;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTEFloat16;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTEFloat32;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTEFloat64;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTZFloat16;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTZFloat32;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTZFloat64;

	@NativeType("uint32_t")
	public int maxUpdateAfterBindDescriptorsInAllPools;

	@NativeType("VkBool32")
	public int shaderUniformBufferArrayNonUniformIndexingNative;

	@NativeType("VkBool32")
	public int shaderSampledImageArrayNonUniformIndexingNative;

	@NativeType("VkBool32")
	public int shaderStorageBufferArrayNonUniformIndexingNative;

	@NativeType("VkBool32")
	public int shaderStorageImageArrayNonUniformIndexingNative;

	@NativeType("VkBool32")
	public int shaderInputAttachmentArrayNonUniformIndexingNative;

	@NativeType("VkBool32")
	public int robustBufferAccessUpdateAfterBind;

	@NativeType("VkBool32")
	public int quadDivergentImplicitLod;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindSamplers;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindUniformBuffers;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindStorageBuffers;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindSampledImages;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindStorageImages;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindInputAttachments;

	@NativeType("uint32_t")
	public int maxPerStageUpdateAfterBindResources;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindSamplers;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindUniformBuffers;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindUniformBuffersDynamic;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindStorageBuffers;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindStorageBuffersDynamic;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindSampledImages;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindStorageImages;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindInputAttachments;

	@NativeType("VkResolveModeFlags")
	public int supportedDepthResolveModes;

	@NativeType("VkResolveModeFlags")
	public int supportedStencilResolveModes;

	@NativeType("VkBool32")
	public int independentResolveNone;

	@NativeType("VkBool32")
	public int independentResolve;

	@NativeType("VkBool32")
	public int filterMinmaxSingleComponentFormats;

	@NativeType("VkBool32")
	public int filterMinmaxImageComponentMapping;

	@NativeType("uint64_t")
	public long maxTimelineSemaphoreValueDifference;

	/**
	* optional
	*/
	@NativeType("VkSampleCountFlags")
	public int framebufferIntegerColorSampleCounts;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}