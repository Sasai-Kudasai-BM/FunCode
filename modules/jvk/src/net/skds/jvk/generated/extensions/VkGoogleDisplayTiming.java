package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkGoogleDisplayTiming {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_PRESENT_TIMES_INFO_GOOGLE = 0;

	private static final MethodHandle vkGetRefreshCycleDurationGOOGLE = createHandle("vkGetRefreshCycleDurationGOOGLE", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_DEVICE_LOST,VK_ERROR_SURFACE_LOST_KHR
	*/
	@NativeType("VkResult")
	public static int vkGetRefreshCycleDurationGOOGLE(@NativeType("VkDevice*") long device, @NativeType("VkSwapchainKHR*") /*external sync*/ long swapchain, @NativeType("VkRefreshCycleDurationGOOGLE*") long pDisplayTimingProperties) {
		try {
			return (int) vkGetRefreshCycleDurationGOOGLE.invokeExact(device, swapchain, pDisplayTimingProperties);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetPastPresentationTimingGOOGLE = createHandle("vkGetPastPresentationTimingGOOGLE", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_DEVICE_LOST,VK_ERROR_OUT_OF_DATE_KHR,VK_ERROR_SURFACE_LOST_KHR
	*/
	@NativeType("VkResult")
	public static int vkGetPastPresentationTimingGOOGLE(@NativeType("VkDevice*") long device, @NativeType("VkSwapchainKHR*") /*external sync*/ long swapchain, @NativeType("uint32_t*") /*optional*/ long pPresentationTimingCount, @NativeType("VkPastPresentationTimingGOOGLE*") /*optional*/ long pPresentationTimings) {
		try {
			return (int) vkGetPastPresentationTimingGOOGLE.invokeExact(device, swapchain, pPresentationTimingCount, pPresentationTimings);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}