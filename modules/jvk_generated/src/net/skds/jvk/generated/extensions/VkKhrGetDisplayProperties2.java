package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrGetDisplayProperties2 {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_DISPLAY_PROPERTIES_2_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_DISPLAY_PLANE_PROPERTIES_2_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_DISPLAY_MODE_PROPERTIES_2_KHR = 2;

	public static final int VK_STRUCTURE_TYPE_DISPLAY_PLANE_INFO_2_KHR = 3;

	public static final int VK_STRUCTURE_TYPE_DISPLAY_PLANE_CAPABILITIES_2_KHR = 4;

	private static final MethodHandle vkGetPhysicalDeviceDisplayProperties2KHR = createHandle("vkGetPhysicalDeviceDisplayProperties2KHR", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetPhysicalDeviceDisplayProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t*") /*optional*/ long pPropertyCount, @NativeType("VkDisplayProperties2KHR*") /*optional*/ long pProperties) {
		try {
			return (int) vkGetPhysicalDeviceDisplayProperties2KHR.invokeExact(physicalDevice, pPropertyCount, pProperties);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetPhysicalDeviceDisplayPlaneProperties2KHR = createHandle("vkGetPhysicalDeviceDisplayPlaneProperties2KHR", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetPhysicalDeviceDisplayPlaneProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t*") /*optional*/ long pPropertyCount, @NativeType("VkDisplayPlaneProperties2KHR*") /*optional*/ long pProperties) {
		try {
			return (int) vkGetPhysicalDeviceDisplayPlaneProperties2KHR.invokeExact(physicalDevice, pPropertyCount, pProperties);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetDisplayModeProperties2KHR = createHandle("vkGetDisplayModeProperties2KHR", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetDisplayModeProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkDisplayKHR*") long display, @NativeType("uint32_t*") /*optional*/ long pPropertyCount, @NativeType("VkDisplayModeProperties2KHR*") /*optional*/ long pProperties) {
		try {
			return (int) vkGetDisplayModeProperties2KHR.invokeExact(physicalDevice, display, pPropertyCount, pProperties);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetDisplayPlaneCapabilities2KHR = createHandle("vkGetDisplayPlaneCapabilities2KHR", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetDisplayPlaneCapabilities2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkDisplayPlaneInfo2KHR*") long pDisplayPlaneInfo, @NativeType("VkDisplayPlaneCapabilities2KHR*") long pCapabilities) {
		try {
			return (int) vkGetDisplayPlaneCapabilities2KHR.invokeExact(physicalDevice, pDisplayPlaneInfo, pCapabilities);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}