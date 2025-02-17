package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtDirectfbSurface {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_DIRECTFB_SURFACE_CREATE_INFO_EXT = 0;

	private static final MethodHandle vkCreateDirectFBSurfaceEXT = createHandle("vkCreateDirectFBSurfaceEXT", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkCreateDirectFBSurfaceEXT(@NativeType("VkInstance*") long instance, @NativeType("VkDirectFBSurfaceCreateInfoEXT*") long pCreateInfo, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkSurfaceKHR**") long pSurface) {
		try {
			return (int) vkCreateDirectFBSurfaceEXT.invokeExact(instance, pCreateInfo, pAllocator, pSurface);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetPhysicalDeviceDirectFBPresentationSupportEXT = createHandle("vkGetPhysicalDeviceDirectFBPresentationSupportEXT", INT, LONG, INT, LONG);

	@NativeType("VkBool32")
	public static int vkGetPhysicalDeviceDirectFBPresentationSupportEXT(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t") int queueFamilyIndex, @NativeType("IDirectFB**") long dfb) {
		try {
			return (int) vkGetPhysicalDeviceDirectFBPresentationSupportEXT.invokeExact(physicalDevice, queueFamilyIndex, dfb);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}