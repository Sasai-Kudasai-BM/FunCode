package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceFragmentShadingRatePropertiesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceFragmentShadingRatePropertiesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_PROPERTIES_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkExtent2D")
	public VkExtent2D minFragmentShadingRateAttachmentTexelSize;

	@NativeType("VkExtent2D")
	public VkExtent2D maxFragmentShadingRateAttachmentTexelSize;

	@NativeType("uint32_t")
	public int maxFragmentShadingRateAttachmentTexelSizeAspectRatio;

	@NativeType("VkBool32")
	public int primitiveFragmentShadingRateWithMultipleViewports;

	@NativeType("VkBool32")
	public int layeredShadingRateAttachments;

	@NativeType("VkBool32")
	public int fragmentShadingRateNonTrivialCombinerOps;

	@NativeType("VkExtent2D")
	public VkExtent2D maxFragmentSize;

	@NativeType("uint32_t")
	public int maxFragmentSizeAspectRatio;

	@NativeType("uint32_t")
	public int maxFragmentShadingRateCoverageSamples;

	@NativeType("VkSampleCountFlagBits")
	public int maxFragmentShadingRateRasterizationSamples;

	@NativeType("VkBool32")
	public int fragmentShadingRateWithShaderDepthStencilWrites;

	@NativeType("VkBool32")
	public int fragmentShadingRateWithSampleMask;

	@NativeType("VkBool32")
	public int fragmentShadingRateWithShaderSampleMask;

	@NativeType("VkBool32")
	public int fragmentShadingRateWithConservativeRasterization;

	@NativeType("VkBool32")
	public int fragmentShadingRateWithFragmentShaderInterlock;

	@NativeType("VkBool32")
	public int fragmentShadingRateWithCustomSampleLocations;

	@NativeType("VkBool32")
	public int fragmentShadingRateStrictMultiplyCombiner;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}