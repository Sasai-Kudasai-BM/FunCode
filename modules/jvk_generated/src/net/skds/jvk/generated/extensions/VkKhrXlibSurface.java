package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrXlibSurface {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_XLIB_SURFACE_CREATE_INFO_KHR = 0;

	private static final MethodHandle vkCreateXlibSurfaceKHR = createHandle("vkCreateXlibSurfaceKHR", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkCreateXlibSurfaceKHR(@NativeType("VkInstance*") long instance, @NativeType("VkXlibSurfaceCreateInfoKHR*") long pCreateInfo, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkSurfaceKHR**") long pSurface) {
		try {
			return (int) vkCreateXlibSurfaceKHR.invokeExact(instance, pCreateInfo, pAllocator, pSurface);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetPhysicalDeviceXlibPresentationSupportKHR = createHandle("vkGetPhysicalDeviceXlibPresentationSupportKHR", INT, LONG, INT, LONG, LONG);

	@NativeType("VkBool32")
	public static int vkGetPhysicalDeviceXlibPresentationSupportKHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t") int queueFamilyIndex, @NativeType("Display**") long dpy, @NativeType("VisualID*") long visualID) {
		try {
			return (int) vkGetPhysicalDeviceXlibPresentationSupportKHR.invokeExact(physicalDevice, queueFamilyIndex, dpy, visualID);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}