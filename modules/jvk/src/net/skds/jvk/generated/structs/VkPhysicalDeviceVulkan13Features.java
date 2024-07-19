package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceVulkan13Features extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceVulkan13Features.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_3_FEATURES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int robustImageAccess;

	@NativeType("VkBool32")
	public int inlineUniformBlock;

	@NativeType("VkBool32")
	public int descriptorBindingInlineUniformBlockUpdateAfterBind;

	@NativeType("VkBool32")
	public int pipelineCreationCacheControl;

	@NativeType("VkBool32")
	public int privateData;

	@NativeType("VkBool32")
	public int shaderDemoteToHelperInvocation;

	@NativeType("VkBool32")
	public int shaderTerminateInvocation;

	@NativeType("VkBool32")
	public int subgroupSizeControl;

	@NativeType("VkBool32")
	public int computeFullSubgroups;

	@NativeType("VkBool32")
	public int synchronization2;

	@NativeType("VkBool32")
	public int textureCompressionASTC_HDR;

	@NativeType("VkBool32")
	public int shaderZeroInitializeWorkgroupMemory;

	@NativeType("VkBool32")
	public int dynamicRendering;

	@NativeType("VkBool32")
	public int shaderIntegerDotProduct;

	@NativeType("VkBool32")
	public int maintenance4;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}