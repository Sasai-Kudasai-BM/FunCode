package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrAndroidSurface {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_ANDROID_SURFACE_CREATE_INFO_KHR = 0;

	private static final MethodHandle vkCreateAndroidSurfaceKHR = createHandle("vkCreateAndroidSurfaceKHR", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_NATIVE_WINDOW_IN_USE_KHR
	*/
	@NativeType("VkResult")
	public static int vkCreateAndroidSurfaceKHR(@NativeType("VkInstance*") long instance, @NativeType("VkAndroidSurfaceCreateInfoKHR*") long pCreateInfo, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkSurfaceKHR**") long pSurface) {
		try {
			return (int) vkCreateAndroidSurfaceKHR.invokeExact(instance, pCreateInfo, pAllocator, pSurface);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}