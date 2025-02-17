package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrXcbSurface {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_XCB_SURFACE_CREATE_INFO_KHR = 0;

	private static final MethodHandle vkCreateXcbSurfaceKHR = createHandle("vkCreateXcbSurfaceKHR", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkCreateXcbSurfaceKHR(@NativeType("VkInstance*") long instance, @NativeType("VkXcbSurfaceCreateInfoKHR*") long pCreateInfo, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkSurfaceKHR**") long pSurface) {
		try {
			return (int) vkCreateXcbSurfaceKHR.invokeExact(instance, pCreateInfo, pAllocator, pSurface);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetPhysicalDeviceXcbPresentationSupportKHR = createHandle("vkGetPhysicalDeviceXcbPresentationSupportKHR", INT, LONG, INT, LONG, LONG);

	@NativeType("VkBool32")
	public static int vkGetPhysicalDeviceXcbPresentationSupportKHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t") int queueFamilyIndex, @NativeType("xcb_connection_t**") long connection, @NativeType("xcb_visualid_t*") long visual_id) {
		try {
			return (int) vkGetPhysicalDeviceXcbPresentationSupportKHR.invokeExact(physicalDevice, queueFamilyIndex, connection, visual_id);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}