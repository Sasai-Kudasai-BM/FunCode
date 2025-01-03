package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceVulkan13Properties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceVulkan13Properties.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_3_PROPERTIES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int minSubgroupSize;

	@NativeType("uint32_t")
	public int maxSubgroupSize;

	@NativeType("uint32_t")
	public int maxComputeWorkgroupSubgroups;

	@NativeType("VkShaderStageFlags")
	public int requiredSubgroupSizeStages;

	@NativeType("uint32_t")
	public int maxInlineUniformBlockSize;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorInlineUniformBlocks;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks;

	@NativeType("uint32_t")
	public int maxDescriptorSetInlineUniformBlocks;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindInlineUniformBlocks;

	@NativeType("uint32_t")
	public int maxInlineUniformTotalSize;

	@NativeType("VkBool32")
	public int integerDotProduct8BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct8BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct8BitMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct4x8BitPackedUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct4x8BitPackedSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct4x8BitPackedMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct16BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct16BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct16BitMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct32BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct32BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct32BitMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct64BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct64BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProduct64BitMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating8BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating8BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating16BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating16BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating32BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating32BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating64BitUnsignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating64BitSignedAccelerated;

	@NativeType("VkBool32")
	public int integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated;

	@NativeType("VkDeviceSize")
	public long storageTexelBufferOffsetAlignmentBytes;

	@NativeType("VkBool32")
	public int storageTexelBufferOffsetSingleTexelAlignment;

	@NativeType("VkDeviceSize")
	public long uniformTexelBufferOffsetAlignmentBytes;

	@NativeType("VkBool32")
	public int uniformTexelBufferOffsetSingleTexelAlignment;

	@NativeType("VkDeviceSize")
	public long maxBufferSize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}