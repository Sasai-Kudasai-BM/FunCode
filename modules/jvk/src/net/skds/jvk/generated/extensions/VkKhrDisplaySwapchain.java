package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrDisplaySwapchain {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_DISPLAY_PRESENT_INFO_KHR = 0;

	public static final int VK_ERROR_INCOMPATIBLE_DISPLAY_KHR = 1;

	private static final MethodHandle vkCreateSharedSwapchainsKHR = createHandle("vkCreateSharedSwapchainsKHR", INT, LONG, INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INCOMPATIBLE_DISPLAY_KHR,VK_ERROR_DEVICE_LOST,VK_ERROR_SURFACE_LOST_KHR
	*/
	@NativeType("VkResult")
	public static int vkCreateSharedSwapchainsKHR(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int swapchainCount, @NativeType("VkSwapchainCreateInfoKHR*") /*external sync*/ long pCreateInfos, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkSwapchainKHR**") long pSwapchains) {
		try {
			return (int) vkCreateSharedSwapchainsKHR.invokeExact(device, swapchainCount, pCreateInfos, pAllocator, pSwapchains);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}