package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkKhrGetPhysicalDeviceProperties2 {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FEATURES_2_KHR = 1000059000;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PROPERTIES_2_KHR = 1000059001;
	public static final int VK_STRUCTURE_TYPE_FORMAT_PROPERTIES_2_KHR = 1000059002;
	public static final int VK_STRUCTURE_TYPE_IMAGE_FORMAT_PROPERTIES_2_KHR = 1000059003;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2_KHR = 1000059004;
	public static final int VK_STRUCTURE_TYPE_QUEUE_FAMILY_PROPERTIES_2_KHR = 1000059005;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MEMORY_PROPERTIES_2_KHR = 1000059006;
	public static final int VK_STRUCTURE_TYPE_SPARSE_IMAGE_FORMAT_PROPERTIES_2_KHR = 1000059007;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2_KHR = 1000059008;
	private static final MethodHandle vkGetPhysicalDeviceFeatures2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceFeatures2KHR", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetPhysicalDeviceFeatures2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceFeatures2*") long pFeatures) {
		try {
			vkGetPhysicalDeviceFeatures2KHR.invokeExact(physicalDevice, pFeatures);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceProperties2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceProperties2KHR", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetPhysicalDeviceProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceProperties2*") long pProperties) {
		try {
			vkGetPhysicalDeviceProperties2KHR.invokeExact(physicalDevice, pProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceFormatProperties2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceFormatProperties2KHR", VOID, LONG, INT, LONG);
	
	@NativeType("void")
	public static void vkGetPhysicalDeviceFormatProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkFormat") int format, @NativeType("VkFormatProperties2*") long pFormatProperties) {
		try {
			vkGetPhysicalDeviceFormatProperties2KHR.invokeExact(physicalDevice, format, pFormatProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceImageFormatProperties2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceImageFormatProperties2KHR", INT, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_FORMAT_NOT_SUPPORTED,VK_ERROR_IMAGE_USAGE_NOT_SUPPORTED_KHR,VK_ERROR_VIDEO_PROFILE_OPERATION_NOT_SUPPORTED_KHR,VK_ERROR_VIDEO_PROFILE_FORMAT_NOT_SUPPORTED_KHR,VK_ERROR_VIDEO_PICTURE_LAYOUT_NOT_SUPPORTED_KHR,VK_ERROR_VIDEO_PROFILE_CODEC_NOT_SUPPORTED_KHR
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkGetPhysicalDeviceImageFormatProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceImageFormatInfo2*") long pImageFormatInfo, @NativeType("VkImageFormatProperties2*") long pImageFormatProperties) {
		try {
			return (int) vkGetPhysicalDeviceImageFormatProperties2KHR.invokeExact(physicalDevice, pImageFormatInfo, pImageFormatProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceQueueFamilyProperties2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceQueueFamilyProperties2KHR", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetPhysicalDeviceQueueFamilyProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, /* optional */ @NativeType("uint32_t*") long pQueueFamilyPropertyCount, /* optional */ @NativeType("VkQueueFamilyProperties2*") long pQueueFamilyProperties) {
		try {
			vkGetPhysicalDeviceQueueFamilyProperties2KHR.invokeExact(physicalDevice, pQueueFamilyPropertyCount, pQueueFamilyProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceMemoryProperties2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceMemoryProperties2KHR", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetPhysicalDeviceMemoryProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceMemoryProperties2*") long pMemoryProperties) {
		try {
			vkGetPhysicalDeviceMemoryProperties2KHR.invokeExact(physicalDevice, pMemoryProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceSparseImageFormatProperties2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceSparseImageFormatProperties2KHR", VOID, LONG, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetPhysicalDeviceSparseImageFormatProperties2KHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceSparseImageFormatInfo2*") long pFormatInfo, /* optional */ @NativeType("uint32_t*") long pPropertyCount, /* optional */ @NativeType("VkSparseImageFormatProperties2*") long pProperties) {
		try {
			vkGetPhysicalDeviceSparseImageFormatProperties2KHR.invokeExact(physicalDevice, pFormatInfo, pPropertyCount, pProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}