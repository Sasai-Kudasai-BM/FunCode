package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceDescriptorIndexingProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceDescriptorIndexingProperties.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

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


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}