package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSwapchainCreateInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSwapchainCreateInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkSwapchainCreateFlagsKHR")
	public int flags;

	@NativeType("VkSurfaceKHR*")
	public long surface;

	@NativeType("uint32_t")
	public int minImageCount;

	@NativeType("VkFormat")
	public int imageFormat;

	@NativeType("VkColorSpaceKHR")
	public int imageColorSpace;

	@NativeType("VkExtent2D")
	public VkExtent2D imageExtent;

	@NativeType("uint32_t")
	public int imageArrayLayers;

	@NativeType("VkImageUsageFlags")
	public int imageUsage;

	@NativeType("VkSharingMode")
	public int imageSharingMode;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int queueFamilyIndexCount;

	@NativeType("uint32_t*")
	public long pQueueFamilyIndices;

	@NativeType("VkSurfaceTransformFlagBitsKHR")
	public int preTransform;

	@NativeType("VkCompositeAlphaFlagBitsKHR")
	public int compositeAlpha;

	@NativeType("VkPresentModeKHR")
	public int presentMode;

	@NativeType("VkBool32")
	public int clipped;

	/**
	* optional
	*/
	@NativeType("VkSwapchainKHR*")
	public long oldSwapchain;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}