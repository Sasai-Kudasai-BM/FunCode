package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceVulkanMemoryModelFeaturesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceVulkanMemoryModelFeaturesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_MEMORY_MODEL_FEATURES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int vulkanMemoryModel;

	@NativeType("VkBool32")
	public int vulkanMemoryModelDeviceScope;

	@NativeType("VkBool32")
	public int vulkanMemoryModelAvailabilityVisibilityChains;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}