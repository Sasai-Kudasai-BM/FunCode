package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAndroidNativeBuffer {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	// VK_ANDROID_native_buffer is used between the Android Vulkan loader and drivers to implement the
	//                    WSI extensions. It is not exposed to applications and uses types that are not part of Android's
	//                    stable public API, so it is left disabled to keep it out of the standard Vulkan headers.
	//                

	public static final int VK_STRUCTURE_TYPE_NATIVE_BUFFER_ANDROID = 0;

	public static final int VK_STRUCTURE_TYPE_SWAPCHAIN_IMAGE_CREATE_INFO_ANDROID = 1;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENTATION_PROPERTIES_ANDROID = 2;

	private static final MethodHandle vkGetSwapchainGrallocUsageANDROID = createHandle("vkGetSwapchainGrallocUsageANDROID", INT, LONG, INT, INT, LONG);

	@NativeType("VkResult")
	public static int vkGetSwapchainGrallocUsageANDROID(@NativeType("VkDevice*") long device, @NativeType("VkFormat") int format, @NativeType("VkImageUsageFlags") int imageUsage, @NativeType("int*") long grallocUsage) {
		try {
			return (int) vkGetSwapchainGrallocUsageANDROID.invokeExact(device, format, imageUsage, grallocUsage);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkAcquireImageANDROID = createHandle("vkAcquireImageANDROID", INT, LONG, LONG, SHORT, LONG, LONG);

	@NativeType("VkResult")
	public static int vkAcquireImageANDROID(@NativeType("VkDevice*") long device, @NativeType("VkImage*") long image, @NativeType("int") short nativeFenceFd, @NativeType("VkSemaphore*") long semaphore, @NativeType("VkFence*") long fence) {
		try {
			return (int) vkAcquireImageANDROID.invokeExact(device, image, nativeFenceFd, semaphore, fence);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkQueueSignalReleaseImageANDROID = createHandle("vkQueueSignalReleaseImageANDROID", INT, LONG, INT, LONG, LONG, LONG);

	@NativeType("VkResult")
	public static int vkQueueSignalReleaseImageANDROID(@NativeType("VkQueue*") long queue, @NativeType("uint32_t") int waitSemaphoreCount, @NativeType("VkSemaphore**") long pWaitSemaphores, @NativeType("VkImage*") long image, @NativeType("int*") long pNativeFenceFd) {
		try {
			return (int) vkQueueSignalReleaseImageANDROID.invokeExact(queue, waitSemaphoreCount, pWaitSemaphores, image, pNativeFenceFd);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetSwapchainGrallocUsage2ANDROID = createHandle("vkGetSwapchainGrallocUsage2ANDROID", INT, LONG, INT, INT, INT, LONG, LONG);

	@NativeType("VkResult")
	public static int vkGetSwapchainGrallocUsage2ANDROID(@NativeType("VkDevice*") long device, @NativeType("VkFormat") int format, @NativeType("VkImageUsageFlags") int imageUsage, @NativeType("VkSwapchainImageUsageFlagsANDROID") int swapchainImageUsage, @NativeType("uint64_t*") long grallocConsumerUsage, @NativeType("uint64_t*") long grallocProducerUsage) {
		try {
			return (int) vkGetSwapchainGrallocUsage2ANDROID.invokeExact(device, format, imageUsage, swapchainImageUsage, grallocConsumerUsage, grallocProducerUsage);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}