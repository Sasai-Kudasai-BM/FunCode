package net.skds.jvk.test;

import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;

import java.lang.invoke.MethodHandle;

import static net.skds.lib2.natives.SafeLinker.*;

public class VK10 {

	// Header boilerplate
	// Fundamental types used by many commands and structures
	// API constants

	public static final int VK_ATTACHMENT_UNUSED = 0;
	public static final int VK_FALSE = 0;
	public static final float VK_LOD_CLAMP_NONE = 1000.0F;
	public static final int VK_QUEUE_FAMILY_IGNORED = 0;
	public static final int VK_REMAINING_ARRAY_LAYERS = 0;
	public static final int VK_REMAINING_MIP_LEVELS = 0;
	public static final int VK_SUBPASS_EXTERNAL = 0;
	public static final int VK_TRUE = 1;
	public static final long VK_WHOLE_SIZE = 0L;
	public static final int VK_MAX_MEMORY_TYPES = 32;
	public static final int VK_MAX_PHYSICAL_DEVICE_NAME_SIZE = 256;
	public static final int VK_UUID_SIZE = 16;
	public static final int VK_MAX_EXTENSION_NAME_SIZE = 256;
	public static final int VK_MAX_DESCRIPTION_SIZE = 256;
	// The maximum number of unique memory heaps, each of which supporting 1 or more memory types
	public static final int VK_MAX_MEMORY_HEAPS = 16;

	// These types are part of the API, though not directly used in API commands or data structures
	// API version macros
	// Device initialization

	private static final MethodHandle vkCreateInstance = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateInstance", INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INITIALIZATION_FAILED,VK_ERROR_LAYER_NOT_PRESENT,VK_ERROR_EXTENSION_NOT_PRESENT,VK_ERROR_INCOMPATIBLE_DRIVER
	 **/
	@NativeType("VkResult")
	public static int vkCreateInstance(@NativeType("VkInstanceCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkInstance**") long pInstance) {
		try {
			return (int) vkCreateInstance.invokeExact(pCreateInfo, pAllocator, pInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyInstance = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyInstance", VOID, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyInstance(/* optional, external sync */ @NativeType("VkInstance*") long instance, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyInstance.invokeExact(instance, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkEnumeratePhysicalDevices = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEnumeratePhysicalDevices", INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_INCOMPLETE
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INITIALIZATION_FAILED
	 **/
	@NativeType("VkResult")
	public static int vkEnumeratePhysicalDevices(@NativeType("VkInstance*") long instance, /* optional */ @NativeType("uint32_t*") long pPhysicalDeviceCount, /* optional */ @NativeType("VkPhysicalDevice**") long pPhysicalDevices) {
		try {
			return (int) vkEnumeratePhysicalDevices.invokeExact(instance, pPhysicalDeviceCount, pPhysicalDevices);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPhysicalDeviceFeatures = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceFeatures", VOID, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetPhysicalDeviceFeatures(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceFeatures*") long pFeatures) {
		try {
			vkGetPhysicalDeviceFeatures.invokeExact(physicalDevice, pFeatures);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPhysicalDeviceFormatProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceFormatProperties", VOID, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetPhysicalDeviceFormatProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkFormat") int format, @NativeType("VkFormatProperties*") long pFormatProperties) {
		try {
			vkGetPhysicalDeviceFormatProperties.invokeExact(physicalDevice, format, pFormatProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPhysicalDeviceImageFormatProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceImageFormatProperties", INT, LONG, INT, INT, INT, INT, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_FORMAT_NOT_SUPPORTED
	 **/
	@NativeType("VkResult")
	public static int vkGetPhysicalDeviceImageFormatProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkFormat") int format, @NativeType("VkImageType") int type, @NativeType("VkImageTiling") int tiling, @NativeType("VkImageUsageFlags") int usage, /* optional */ @NativeType("VkImageCreateFlags") int flags, @NativeType("VkImageFormatProperties*") long pImageFormatProperties) {
		try {
			return (int) vkGetPhysicalDeviceImageFormatProperties.invokeExact(physicalDevice, format, type, tiling, usage, flags, pImageFormatProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPhysicalDeviceProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceProperties", VOID, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetPhysicalDeviceProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceProperties*") long pProperties) {
		try {
			vkGetPhysicalDeviceProperties.invokeExact(physicalDevice, pProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPhysicalDeviceQueueFamilyProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceQueueFamilyProperties", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetPhysicalDeviceQueueFamilyProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, /* optional */ @NativeType("uint32_t*") long pQueueFamilyPropertyCount, /* optional */ @NativeType("VkQueueFamilyProperties*") long pQueueFamilyProperties) {
		try {
			vkGetPhysicalDeviceQueueFamilyProperties.invokeExact(physicalDevice, pQueueFamilyPropertyCount, pQueueFamilyProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPhysicalDeviceMemoryProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceMemoryProperties", VOID, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetPhysicalDeviceMemoryProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkPhysicalDeviceMemoryProperties*") long pMemoryProperties) {
		try {
			vkGetPhysicalDeviceMemoryProperties.invokeExact(physicalDevice, pMemoryProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetInstanceProcAddr = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetInstanceProcAddr", LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("PFN_vkVoidFunction*")
	public static long vkGetInstanceProcAddr(/* optional */ @NativeType("VkInstance*") long instance, @NativeType("char*") long pName) {
		try {
			return (long) vkGetInstanceProcAddr.invokeExact(instance, pName);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetDeviceProcAddr = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetDeviceProcAddr", LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("PFN_vkVoidFunction*")
	public static long vkGetDeviceProcAddr(@NativeType("VkDevice*") long device, @NativeType("char*") long pName) {
		try {
			return (long) vkGetDeviceProcAddr.invokeExact(device, pName);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Device commands
	// Will add VkDeviceCreateFlagBits when bits are defined in the future
	// VkDeviceQueueCreateFlagBits was added later

	private static final MethodHandle vkCreateDevice = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateDevice", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INITIALIZATION_FAILED,VK_ERROR_EXTENSION_NOT_PRESENT,VK_ERROR_FEATURE_NOT_PRESENT,VK_ERROR_TOO_MANY_OBJECTS,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkCreateDevice(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkDeviceCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkDevice**") long pDevice) {
		try {
			return (int) vkCreateDevice.invokeExact(physicalDevice, pCreateInfo, pAllocator, pDevice);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyDevice = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyDevice", VOID, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyDevice(/* optional, external sync */ @NativeType("VkDevice*") long device, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyDevice.invokeExact(device, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Extension discovery commands

	private static final MethodHandle vkEnumerateInstanceExtensionProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEnumerateInstanceExtensionProperties", INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_INCOMPLETE
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_LAYER_NOT_PRESENT
	 **/
	@NativeType("VkResult")
	public static int vkEnumerateInstanceExtensionProperties(/* optional */ @NativeType("char*") long pLayerName, /* optional */ @NativeType("uint32_t*") long pPropertyCount, /* optional */ @NativeType("VkExtensionProperties*") long pProperties) {
		try {
			return (int) vkEnumerateInstanceExtensionProperties.invokeExact(pLayerName, pPropertyCount, pProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkEnumerateDeviceExtensionProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEnumerateDeviceExtensionProperties", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_INCOMPLETE
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_LAYER_NOT_PRESENT
	 **/
	@NativeType("VkResult")
	public static int vkEnumerateDeviceExtensionProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, /* optional */ @NativeType("char*") long pLayerName, /* optional */ @NativeType("uint32_t*") long pPropertyCount, /* optional */ @NativeType("VkExtensionProperties*") long pProperties) {
		try {
			return (int) vkEnumerateDeviceExtensionProperties.invokeExact(physicalDevice, pLayerName, pPropertyCount, pProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Layer discovery commands

	private static final MethodHandle vkEnumerateInstanceLayerProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEnumerateInstanceLayerProperties", INT, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_INCOMPLETE
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkEnumerateInstanceLayerProperties(/* optional */ @NativeType("uint32_t*") long pPropertyCount, /* optional */ @NativeType("VkLayerProperties*") long pProperties) {
		try {
			return (int) vkEnumerateInstanceLayerProperties.invokeExact(pPropertyCount, pProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkEnumerateDeviceLayerProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEnumerateDeviceLayerProperties", INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_INCOMPLETE
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkEnumerateDeviceLayerProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, /* optional */ @NativeType("uint32_t*") long pPropertyCount, /* optional */ @NativeType("VkLayerProperties*") long pProperties) {
		try {
			return (int) vkEnumerateDeviceLayerProperties.invokeExact(physicalDevice, pPropertyCount, pProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Queue commands

	private static final MethodHandle vkGetDeviceQueue = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetDeviceQueue", VOID, LONG, INT, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetDeviceQueue(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int queueFamilyIndex, @NativeType("uint32_t") int queueIndex, @NativeType("VkQueue**") long pQueue) {
		try {
			vkGetDeviceQueue.invokeExact(device, queueFamilyIndex, queueIndex, pQueue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkQueueSubmit = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkQueueSubmit", INT, LONG, INT, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkQueueSubmit(/* external sync */ @NativeType("VkQueue*") long queue, /* optional */ @NativeType("uint32_t") int submitCount, @NativeType("VkSubmitInfo*") long pSubmits, /* optional, external sync */ @NativeType("VkFence*") long fence) {
		try {
			return (int) vkQueueSubmit.invokeExact(queue, submitCount, pSubmits, fence);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkQueueWaitIdle = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkQueueWaitIdle", INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkQueueWaitIdle(/* external sync */ @NativeType("VkQueue*") long queue) {
		try {
			return (int) vkQueueWaitIdle.invokeExact(queue);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDeviceWaitIdle = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDeviceWaitIdle", INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkDeviceWaitIdle(@NativeType("VkDevice*") long device) {
		try {
			return (int) vkDeviceWaitIdle.invokeExact(device);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Memory commands

	private static final MethodHandle vkAllocateMemory = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkAllocateMemory", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INVALID_EXTERNAL_HANDLE,VK_ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS_KHR
	 **/
	@NativeType("VkResult")
	public static int vkAllocateMemory(@NativeType("VkDevice*") long device, @NativeType("VkMemoryAllocateInfo*") long pAllocateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkDeviceMemory**") long pMemory) {
		try {
			return (int) vkAllocateMemory.invokeExact(device, pAllocateInfo, pAllocator, pMemory);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkFreeMemory = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkFreeMemory", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkFreeMemory(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkDeviceMemory*") long memory, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkFreeMemory.invokeExact(device, memory, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkMapMemory = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkMapMemory", INT, LONG, LONG, LONG, LONG, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_MEMORY_MAP_FAILED
	 **/
	@NativeType("VkResult")
	public static int vkMapMemory(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkDeviceMemory*") long memory, @NativeType("VkDeviceSize") long offset, @NativeType("VkDeviceSize") long size, /* optional */ @NativeType("VkMemoryMapFlags") int flags, /* optional */ @NativeType("void*") long ppData) {
		try {
			return (int) vkMapMemory.invokeExact(device, memory, offset, size, flags, ppData);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkUnmapMemory = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkUnmapMemory", VOID, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkUnmapMemory(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkDeviceMemory*") long memory) {
		try {
			vkUnmapMemory.invokeExact(device, memory);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkFlushMappedMemoryRanges = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkFlushMappedMemoryRanges", INT, LONG, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkFlushMappedMemoryRanges(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int memoryRangeCount, @NativeType("VkMappedMemoryRange*") long pMemoryRanges) {
		try {
			return (int) vkFlushMappedMemoryRanges.invokeExact(device, memoryRangeCount, pMemoryRanges);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkInvalidateMappedMemoryRanges = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkInvalidateMappedMemoryRanges", INT, LONG, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkInvalidateMappedMemoryRanges(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int memoryRangeCount, @NativeType("VkMappedMemoryRange*") long pMemoryRanges) {
		try {
			return (int) vkInvalidateMappedMemoryRanges.invokeExact(device, memoryRangeCount, pMemoryRanges);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetDeviceMemoryCommitment = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetDeviceMemoryCommitment", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetDeviceMemoryCommitment(@NativeType("VkDevice*") long device, @NativeType("VkDeviceMemory*") long memory, @NativeType("VkDeviceSize*") long pCommittedMemoryInBytes) {
		try {
			vkGetDeviceMemoryCommitment.invokeExact(device, memory, pCommittedMemoryInBytes);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Memory management API commands

	private static final MethodHandle vkBindBufferMemory = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkBindBufferMemory", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS_KHR
	 **/
	@NativeType("VkResult")
	public static int vkBindBufferMemory(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceMemory*") long memory, @NativeType("VkDeviceSize") long memoryOffset) {
		try {
			return (int) vkBindBufferMemory.invokeExact(device, buffer, memory, memoryOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkBindImageMemory = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkBindImageMemory", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkBindImageMemory(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkImage*") long image, @NativeType("VkDeviceMemory*") long memory, @NativeType("VkDeviceSize") long memoryOffset) {
		try {
			return (int) vkBindImageMemory.invokeExact(device, image, memory, memoryOffset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetBufferMemoryRequirements = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetBufferMemoryRequirements", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetBufferMemoryRequirements(@NativeType("VkDevice*") long device, @NativeType("VkBuffer*") long buffer, @NativeType("VkMemoryRequirements*") long pMemoryRequirements) {
		try {
			vkGetBufferMemoryRequirements.invokeExact(device, buffer, pMemoryRequirements);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetImageMemoryRequirements = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetImageMemoryRequirements", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetImageMemoryRequirements(@NativeType("VkDevice*") long device, @NativeType("VkImage*") long image, @NativeType("VkMemoryRequirements*") long pMemoryRequirements) {
		try {
			vkGetImageMemoryRequirements.invokeExact(device, image, pMemoryRequirements);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Sparse resource memory management API commands

	private static final MethodHandle vkGetImageSparseMemoryRequirements = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetImageSparseMemoryRequirements", VOID, LONG, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetImageSparseMemoryRequirements(@NativeType("VkDevice*") long device, @NativeType("VkImage*") long image, /* optional */ @NativeType("uint32_t*") long pSparseMemoryRequirementCount, /* optional */ @NativeType("VkSparseImageMemoryRequirements*") long pSparseMemoryRequirements) {
		try {
			vkGetImageSparseMemoryRequirements.invokeExact(device, image, pSparseMemoryRequirementCount, pSparseMemoryRequirements);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPhysicalDeviceSparseImageFormatProperties = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceSparseImageFormatProperties", VOID, LONG, INT, INT, INT, INT, INT, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetPhysicalDeviceSparseImageFormatProperties(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkFormat") int format, @NativeType("VkImageType") int type, @NativeType("VkSampleCountFlagBits") int samples, @NativeType("VkImageUsageFlags") int usage, @NativeType("VkImageTiling") int tiling, /* optional */ @NativeType("uint32_t*") long pPropertyCount, /* optional */ @NativeType("VkSparseImageFormatProperties*") long pProperties) {
		try {
			vkGetPhysicalDeviceSparseImageFormatProperties.invokeExact(physicalDevice, format, type, samples, usage, tiling, pPropertyCount, pProperties);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkQueueBindSparse = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkQueueBindSparse", INT, LONG, INT, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkQueueBindSparse(/* external sync */ @NativeType("VkQueue*") long queue, /* optional */ @NativeType("uint32_t") int bindInfoCount, @NativeType("VkBindSparseInfo*") long pBindInfo, /* optional, external sync */ @NativeType("VkFence*") long fence) {
		try {
			return (int) vkQueueBindSparse.invokeExact(queue, bindInfoCount, pBindInfo, fence);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Fence commands

	private static final MethodHandle vkCreateFence = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateFence", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateFence(@NativeType("VkDevice*") long device, @NativeType("VkFenceCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkFence**") long pFence) {
		try {
			return (int) vkCreateFence.invokeExact(device, pCreateInfo, pAllocator, pFence);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyFence = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyFence", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyFence(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkFence*") long fence, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyFence.invokeExact(device, fence, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkResetFences = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkResetFences", INT, LONG, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkResetFences(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int fenceCount, /* external sync */ @NativeType("VkFence**") long pFences) {
		try {
			return (int) vkResetFences.invokeExact(device, fenceCount, pFences);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetFenceStatus = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetFenceStatus", INT, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_NOT_READY
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkGetFenceStatus(@NativeType("VkDevice*") long device, @NativeType("VkFence*") long fence) {
		try {
			return (int) vkGetFenceStatus.invokeExact(device, fence);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkWaitForFences = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkWaitForFences", INT, LONG, INT, LONG, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_TIMEOUT
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkWaitForFences(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int fenceCount, @NativeType("VkFence**") long pFences, @NativeType("VkBool32") int waitAll, @NativeType("uint64_t") long timeout) {
		try {
			return (int) vkWaitForFences.invokeExact(device, fenceCount, pFences, waitAll, timeout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Queue semaphore commands
	// Will add VkSemaphoreCreateFlagBits when bits are defined in the future

	private static final MethodHandle vkCreateSemaphore = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateSemaphore", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateSemaphore(@NativeType("VkDevice*") long device, @NativeType("VkSemaphoreCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkSemaphore**") long pSemaphore) {
		try {
			return (int) vkCreateSemaphore.invokeExact(device, pCreateInfo, pAllocator, pSemaphore);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroySemaphore = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroySemaphore", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroySemaphore(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkSemaphore*") long semaphore, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroySemaphore.invokeExact(device, semaphore, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Event commands

	private static final MethodHandle vkCreateEvent = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateEvent", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateEvent(@NativeType("VkDevice*") long device, @NativeType("VkEventCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkEvent**") long pEvent) {
		try {
			return (int) vkCreateEvent.invokeExact(device, pCreateInfo, pAllocator, pEvent);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyEvent = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyEvent", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyEvent(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkEvent*") long event, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyEvent.invokeExact(device, event, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetEventStatus = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetEventStatus", INT, LONG, LONG);

	/**
	 * successcodes = VK_EVENT_SET,VK_EVENT_RESET
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkGetEventStatus(@NativeType("VkDevice*") long device, @NativeType("VkEvent*") long event) {
		try {
			return (int) vkGetEventStatus.invokeExact(device, event);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkSetEvent = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkSetEvent", INT, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkSetEvent(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkEvent*") long event) {
		try {
			return (int) vkSetEvent.invokeExact(device, event);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkResetEvent = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkResetEvent", INT, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkResetEvent(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkEvent*") long event) {
		try {
			return (int) vkResetEvent.invokeExact(device, event);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Query commands
	// Will add VkQueryPoolCreateFlagBits when bits are defined in the future

	private static final MethodHandle vkCreateQueryPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateQueryPool", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateQueryPool(@NativeType("VkDevice*") long device, @NativeType("VkQueryPoolCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkQueryPool**") long pQueryPool) {
		try {
			return (int) vkCreateQueryPool.invokeExact(device, pCreateInfo, pAllocator, pQueryPool);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyQueryPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyQueryPool", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyQueryPool(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkQueryPool*") long queryPool, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyQueryPool.invokeExact(device, queryPool, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetQueryPoolResults = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetQueryPoolResults", INT, LONG, LONG, INT, INT, LONG, LONG, LONG, INT);

	/**
	 * successcodes = VK_SUCCESS,VK_NOT_READY
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	 **/
	@NativeType("VkResult")
	public static int vkGetQueryPoolResults(@NativeType("VkDevice*") long device, @NativeType("VkQueryPool*") long queryPool, @NativeType("uint32_t") int firstQuery, @NativeType("uint32_t") int queryCount, @NativeType("size_t") long dataSize, @NativeType("void*") long pData, @NativeType("VkDeviceSize") long stride, /* optional */ @NativeType("VkQueryResultFlags") int flags) {
		try {
			return (int) vkGetQueryPoolResults.invokeExact(device, queryPool, firstQuery, queryCount, dataSize, pData, stride, flags);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Buffer commands

	private static final MethodHandle vkCreateBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateBuffer", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS_KHR
	 **/
	@NativeType("VkResult")
	public static int vkCreateBuffer(@NativeType("VkDevice*") long device, @NativeType("VkBufferCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkBuffer**") long pBuffer) {
		try {
			return (int) vkCreateBuffer.invokeExact(device, pCreateInfo, pAllocator, pBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyBuffer", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyBuffer(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkBuffer*") long buffer, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyBuffer.invokeExact(device, buffer, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Buffer view commands
	// Will add VkBufferViewFlagBits when bits are defined in the future

	private static final MethodHandle vkCreateBufferView = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateBufferView", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateBufferView(@NativeType("VkDevice*") long device, @NativeType("VkBufferViewCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkBufferView**") long pView) {
		try {
			return (int) vkCreateBufferView.invokeExact(device, pCreateInfo, pAllocator, pView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyBufferView = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyBufferView", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyBufferView(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkBufferView*") long bufferView, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyBufferView.invokeExact(device, bufferView, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Image commands

	private static final MethodHandle vkCreateImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateImage", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_COMPRESSION_EXHAUSTED_EXT
	 **/
	@NativeType("VkResult")
	public static int vkCreateImage(@NativeType("VkDevice*") long device, @NativeType("VkImageCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkImage**") long pImage) {
		try {
			return (int) vkCreateImage.invokeExact(device, pCreateInfo, pAllocator, pImage);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyImage", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyImage(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkImage*") long image, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyImage.invokeExact(device, image, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetImageSubresourceLayout = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetImageSubresourceLayout", VOID, LONG, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetImageSubresourceLayout(@NativeType("VkDevice*") long device, @NativeType("VkImage*") long image, @NativeType("VkImageSubresource*") long pSubresource, @NativeType("VkSubresourceLayout*") long pLayout) {
		try {
			vkGetImageSubresourceLayout.invokeExact(device, image, pSubresource, pLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Image view commands

	private static final MethodHandle vkCreateImageView = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateImageView", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateImageView(@NativeType("VkDevice*") long device, @NativeType("VkImageViewCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkImageView**") long pView) {
		try {
			return (int) vkCreateImageView.invokeExact(device, pCreateInfo, pAllocator, pView);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyImageView = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyImageView", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyImageView(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkImageView*") long imageView, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyImageView.invokeExact(device, imageView, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Shader commands

	private static final MethodHandle vkCreateShaderModule = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateShaderModule", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INVALID_SHADER_NV
	 **/
	@NativeType("VkResult")
	public static int vkCreateShaderModule(@NativeType("VkDevice*") long device, @NativeType("VkShaderModuleCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkShaderModule**") long pShaderModule) {
		try {
			return (int) vkCreateShaderModule.invokeExact(device, pCreateInfo, pAllocator, pShaderModule);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyShaderModule = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyShaderModule", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyShaderModule(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkShaderModule*") long shaderModule, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyShaderModule.invokeExact(device, shaderModule, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Pipeline Cache commands
	// VkPipelineCacheCreateFlagBits was added later

	private static final MethodHandle vkCreatePipelineCache = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreatePipelineCache", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreatePipelineCache(@NativeType("VkDevice*") long device, @NativeType("VkPipelineCacheCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkPipelineCache**") long pPipelineCache) {
		try {
			return (int) vkCreatePipelineCache.invokeExact(device, pCreateInfo, pAllocator, pPipelineCache);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyPipelineCache = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyPipelineCache", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyPipelineCache(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkPipelineCache*") long pipelineCache, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyPipelineCache.invokeExact(device, pipelineCache, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetPipelineCacheData = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPipelineCacheData", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_INCOMPLETE
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkGetPipelineCacheData(@NativeType("VkDevice*") long device, @NativeType("VkPipelineCache*") long pipelineCache, /* optional */ @NativeType("size_t*") long pDataSize, /* optional */ @NativeType("void*") long pData) {
		try {
			return (int) vkGetPipelineCacheData.invokeExact(device, pipelineCache, pDataSize, pData);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkMergePipelineCaches = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkMergePipelineCaches", INT, LONG, LONG, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkMergePipelineCaches(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkPipelineCache*") long dstCache, @NativeType("uint32_t") int srcCacheCount, @NativeType("VkPipelineCache**") long pSrcCaches) {
		try {
			return (int) vkMergePipelineCaches.invokeExact(device, dstCache, srcCacheCount, pSrcCaches);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Pipeline commands
	// Will add VkPipeline*StateFlagBits when bits are defined in the future
	// Will add VkPipelineLayoutCreateFlagBits when bits are defined in the future
	// Will add VkPipelineMultisampleStateCreateFlagBits when bits are defined in the future
	// Will add VkPipelineRasterizationStateCreateFlagBits when bits are defined in the future
	// Will add VkPipelineTessellationStateCreateFlagBits when bits are defined in the future
	// Will add VkPipelineVertexInputStateCreateFlagBits when bits are defined in the future
	// Will add VkPipelineViewportStateCreateFlagBits when bits are defined in the future

	private static final MethodHandle vkCreateGraphicsPipelines = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateGraphicsPipelines", INT, LONG, LONG, INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_PIPELINE_COMPILE_REQUIRED_EXT
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INVALID_SHADER_NV
	 **/
	@NativeType("VkResult")
	public static int vkCreateGraphicsPipelines(@NativeType("VkDevice*") long device, /* optional */ @NativeType("VkPipelineCache*") long pipelineCache, @NativeType("uint32_t") int createInfoCount, @NativeType("VkGraphicsPipelineCreateInfo*") long pCreateInfos, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkPipeline**") long pPipelines) {
		try {
			return (int) vkCreateGraphicsPipelines.invokeExact(device, pipelineCache, createInfoCount, pCreateInfos, pAllocator, pPipelines);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCreateComputePipelines = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateComputePipelines", INT, LONG, LONG, INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS,VK_PIPELINE_COMPILE_REQUIRED_EXT
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INVALID_SHADER_NV
	 **/
	@NativeType("VkResult")
	public static int vkCreateComputePipelines(@NativeType("VkDevice*") long device, /* optional */ @NativeType("VkPipelineCache*") long pipelineCache, @NativeType("uint32_t") int createInfoCount, @NativeType("VkComputePipelineCreateInfo*") long pCreateInfos, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkPipeline**") long pPipelines) {
		try {
			return (int) vkCreateComputePipelines.invokeExact(device, pipelineCache, createInfoCount, pCreateInfos, pAllocator, pPipelines);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyPipeline = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyPipeline", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyPipeline(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkPipeline*") long pipeline, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyPipeline.invokeExact(device, pipeline, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Pipeline layout commands

	private static final MethodHandle vkCreatePipelineLayout = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreatePipelineLayout", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreatePipelineLayout(@NativeType("VkDevice*") long device, @NativeType("VkPipelineLayoutCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkPipelineLayout**") long pPipelineLayout) {
		try {
			return (int) vkCreatePipelineLayout.invokeExact(device, pCreateInfo, pAllocator, pPipelineLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyPipelineLayout = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyPipelineLayout", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyPipelineLayout(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkPipelineLayout*") long pipelineLayout, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyPipelineLayout.invokeExact(device, pipelineLayout, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Sampler commands

	private static final MethodHandle vkCreateSampler = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateSampler", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateSampler(@NativeType("VkDevice*") long device, @NativeType("VkSamplerCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkSampler**") long pSampler) {
		try {
			return (int) vkCreateSampler.invokeExact(device, pCreateInfo, pAllocator, pSampler);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroySampler = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroySampler", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroySampler(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkSampler*") long sampler, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroySampler.invokeExact(device, sampler, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Descriptor set commands

	private static final MethodHandle vkCreateDescriptorSetLayout = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateDescriptorSetLayout", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateDescriptorSetLayout(@NativeType("VkDevice*") long device, @NativeType("VkDescriptorSetLayoutCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkDescriptorSetLayout**") long pSetLayout) {
		try {
			return (int) vkCreateDescriptorSetLayout.invokeExact(device, pCreateInfo, pAllocator, pSetLayout);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyDescriptorSetLayout = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyDescriptorSetLayout", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyDescriptorSetLayout(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkDescriptorSetLayout*") long descriptorSetLayout, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyDescriptorSetLayout.invokeExact(device, descriptorSetLayout, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCreateDescriptorPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateDescriptorPool", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_FRAGMENTATION_EXT
	 **/
	@NativeType("VkResult")
	public static int vkCreateDescriptorPool(@NativeType("VkDevice*") long device, @NativeType("VkDescriptorPoolCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkDescriptorPool**") long pDescriptorPool) {
		try {
			return (int) vkCreateDescriptorPool.invokeExact(device, pCreateInfo, pAllocator, pDescriptorPool);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyDescriptorPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyDescriptorPool", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyDescriptorPool(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkDescriptorPool*") long descriptorPool, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyDescriptorPool.invokeExact(device, descriptorPool, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkResetDescriptorPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkResetDescriptorPool", INT, LONG, LONG, INT);

	/**
	 * successcodes = VK_SUCCESS
	 **/
	@NativeType("VkResult")
	public static int vkResetDescriptorPool(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkDescriptorPool*") long descriptorPool, /* optional */ @NativeType("VkDescriptorPoolResetFlags") int flags) {
		try {
			return (int) vkResetDescriptorPool.invokeExact(device, descriptorPool, flags);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkAllocateDescriptorSets = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkAllocateDescriptorSets", INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_FRAGMENTED_POOL,VK_ERROR_OUT_OF_POOL_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkAllocateDescriptorSets(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkDescriptorSetAllocateInfo*") long pAllocateInfo, @NativeType("VkDescriptorSet**") long pDescriptorSets) {
		try {
			return (int) vkAllocateDescriptorSets.invokeExact(device, pAllocateInfo, pDescriptorSets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkFreeDescriptorSets = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkFreeDescriptorSets", INT, LONG, LONG, INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 **/
	@NativeType("VkResult")
	public static int vkFreeDescriptorSets(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkDescriptorPool*") long descriptorPool, @NativeType("uint32_t") int descriptorSetCount, /* external sync */ @NativeType("VkDescriptorSet**") long pDescriptorSets) {
		try {
			return (int) vkFreeDescriptorSets.invokeExact(device, descriptorPool, descriptorSetCount, pDescriptorSets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkUpdateDescriptorSets = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkUpdateDescriptorSets", VOID, LONG, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkUpdateDescriptorSets(@NativeType("VkDevice*") long device, /* optional */ @NativeType("uint32_t") int descriptorWriteCount, /* external sync */ @NativeType("VkWriteDescriptorSet*") long pDescriptorWrites, /* optional */ @NativeType("uint32_t") int descriptorCopyCount, /* external sync */ @NativeType("VkCopyDescriptorSet*") long pDescriptorCopies) {
		try {
			vkUpdateDescriptorSets.invokeExact(device, descriptorWriteCount, pDescriptorWrites, descriptorCopyCount, pDescriptorCopies);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Pass commands

	private static final MethodHandle vkCreateFramebuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateFramebuffer", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateFramebuffer(@NativeType("VkDevice*") long device, @NativeType("VkFramebufferCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkFramebuffer**") long pFramebuffer) {
		try {
			return (int) vkCreateFramebuffer.invokeExact(device, pCreateInfo, pAllocator, pFramebuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyFramebuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyFramebuffer", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyFramebuffer(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkFramebuffer*") long framebuffer, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyFramebuffer.invokeExact(device, framebuffer, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCreateRenderPass = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateRenderPass", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateRenderPass(@NativeType("VkDevice*") long device, @NativeType("VkRenderPassCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkRenderPass**") long pRenderPass) {
		try {
			return (int) vkCreateRenderPass.invokeExact(device, pCreateInfo, pAllocator, pRenderPass);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyRenderPass = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyRenderPass", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyRenderPass(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkRenderPass*") long renderPass, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyRenderPass.invokeExact(device, renderPass, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkGetRenderAreaGranularity = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetRenderAreaGranularity", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkGetRenderAreaGranularity(@NativeType("VkDevice*") long device, @NativeType("VkRenderPass*") long renderPass, @NativeType("VkExtent2D*") long pGranularity) {
		try {
			vkGetRenderAreaGranularity.invokeExact(device, renderPass, pGranularity);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Command pool commands

	private static final MethodHandle vkCreateCommandPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateCommandPool", INT, LONG, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkCreateCommandPool(@NativeType("VkDevice*") long device, @NativeType("VkCommandPoolCreateInfo*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkCommandPool**") long pCommandPool) {
		try {
			return (int) vkCreateCommandPool.invokeExact(device, pCreateInfo, pAllocator, pCommandPool);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkDestroyCommandPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyCommandPool", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkDestroyCommandPool(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkCommandPool*") long commandPool, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyCommandPool.invokeExact(device, commandPool, pAllocator);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkResetCommandPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkResetCommandPool", INT, LONG, LONG, INT);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkResetCommandPool(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkCommandPool*") long commandPool, /* optional */ @NativeType("VkCommandPoolResetFlags") int flags) {
		try {
			return (int) vkResetCommandPool.invokeExact(device, commandPool, flags);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Command buffer commands

	private static final MethodHandle vkAllocateCommandBuffers = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkAllocateCommandBuffers", INT, LONG, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkAllocateCommandBuffers(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkCommandBufferAllocateInfo*") long pAllocateInfo, @NativeType("VkCommandBuffer**") long pCommandBuffers) {
		try {
			return (int) vkAllocateCommandBuffers.invokeExact(device, pAllocateInfo, pCommandBuffers);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkFreeCommandBuffers = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkFreeCommandBuffers", VOID, LONG, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkFreeCommandBuffers(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkCommandPool*") long commandPool, @NativeType("uint32_t") int commandBufferCount, /* external sync */ @NativeType("VkCommandBuffer**") long pCommandBuffers) {
		try {
			vkFreeCommandBuffers.invokeExact(device, commandPool, commandBufferCount, pCommandBuffers);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkBeginCommandBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkBeginCommandBuffer", INT, LONG, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkBeginCommandBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkCommandBufferBeginInfo*") long pBeginInfo) {
		try {
			return (int) vkBeginCommandBuffer.invokeExact(commandBuffer, pBeginInfo);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkEndCommandBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEndCommandBuffer", INT, LONG);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkEndCommandBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer) {
		try {
			return (int) vkEndCommandBuffer.invokeExact(commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkResetCommandBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkResetCommandBuffer", INT, LONG, INT);

	/**
	 * successcodes = VK_SUCCESS
	 * errorcodes = VK_ERROR_OUT_OF_DEVICE_MEMORY
	 **/
	@NativeType("VkResult")
	public static int vkResetCommandBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, /* optional */ @NativeType("VkCommandBufferResetFlags") int flags) {
		try {
			return (int) vkResetCommandBuffer.invokeExact(commandBuffer, flags);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	// Command buffer building commands

	private static final MethodHandle vkCmdBindPipeline = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBindPipeline", VOID, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdBindPipeline(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkPipelineBindPoint") int pipelineBindPoint, @NativeType("VkPipeline*") long pipeline) {
		try {
			vkCmdBindPipeline.invokeExact(commandBuffer, pipelineBindPoint, pipeline);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetViewport = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetViewport", VOID, LONG, INT, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetViewport(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int firstViewport, @NativeType("uint32_t") int viewportCount, @NativeType("VkViewport*") long pViewports) {
		try {
			vkCmdSetViewport.invokeExact(commandBuffer, firstViewport, viewportCount, pViewports);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetScissor = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetScissor", VOID, LONG, INT, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetScissor(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int firstScissor, @NativeType("uint32_t") int scissorCount, @NativeType("VkRect2D*") long pScissors) {
		try {
			vkCmdSetScissor.invokeExact(commandBuffer, firstScissor, scissorCount, pScissors);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetLineWidth = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetLineWidth", VOID, LONG, FLOAT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetLineWidth(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("float") float lineWidth) {
		try {
			vkCmdSetLineWidth.invokeExact(commandBuffer, lineWidth);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetDepthBias = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetDepthBias", VOID, LONG, FLOAT, FLOAT, FLOAT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetDepthBias(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("float") float depthBiasConstantFactor, @NativeType("float") float depthBiasClamp, @NativeType("float") float depthBiasSlopeFactor) {
		try {
			vkCmdSetDepthBias.invokeExact(commandBuffer, depthBiasConstantFactor, depthBiasClamp, depthBiasSlopeFactor);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetBlendConstants = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetBlendConstants", VOID, LONG, FLOAT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetBlendConstants(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("float") float blendConstants) {
		try {
			vkCmdSetBlendConstants.invokeExact(commandBuffer, blendConstants);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetDepthBounds = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetDepthBounds", VOID, LONG, FLOAT, FLOAT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetDepthBounds(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("float") float minDepthBounds, @NativeType("float") float maxDepthBounds) {
		try {
			vkCmdSetDepthBounds.invokeExact(commandBuffer, minDepthBounds, maxDepthBounds);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetStencilCompareMask = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetStencilCompareMask", VOID, LONG, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetStencilCompareMask(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkStencilFaceFlags") int faceMask, @NativeType("uint32_t") int compareMask) {
		try {
			vkCmdSetStencilCompareMask.invokeExact(commandBuffer, faceMask, compareMask);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetStencilWriteMask = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetStencilWriteMask", VOID, LONG, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetStencilWriteMask(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkStencilFaceFlags") int faceMask, @NativeType("uint32_t") int writeMask) {
		try {
			vkCmdSetStencilWriteMask.invokeExact(commandBuffer, faceMask, writeMask);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetStencilReference = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetStencilReference", VOID, LONG, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetStencilReference(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkStencilFaceFlags") int faceMask, @NativeType("uint32_t") int reference) {
		try {
			vkCmdSetStencilReference.invokeExact(commandBuffer, faceMask, reference);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdBindDescriptorSets = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBindDescriptorSets", VOID, LONG, INT, LONG, INT, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdBindDescriptorSets(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkPipelineBindPoint") int pipelineBindPoint, @NativeType("VkPipelineLayout*") long layout, @NativeType("uint32_t") int firstSet, @NativeType("uint32_t") int descriptorSetCount, /* optional */ @NativeType("VkDescriptorSet**") long pDescriptorSets, /* optional */ @NativeType("uint32_t") int dynamicOffsetCount, @NativeType("uint32_t*") long pDynamicOffsets) {
		try {
			vkCmdBindDescriptorSets.invokeExact(commandBuffer, pipelineBindPoint, layout, firstSet, descriptorSetCount, pDescriptorSets, dynamicOffsetCount, pDynamicOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdBindIndexBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBindIndexBuffer", VOID, LONG, LONG, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdBindIndexBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkIndexType") int indexType) {
		try {
			vkCmdBindIndexBuffer.invokeExact(commandBuffer, buffer, offset, indexType);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdBindVertexBuffers = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBindVertexBuffers", VOID, LONG, INT, INT, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdBindVertexBuffers(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int firstBinding, @NativeType("uint32_t") int bindingCount, /* optional */ @NativeType("VkBuffer**") long pBuffers, @NativeType("VkDeviceSize*") long pOffsets) {
		try {
			vkCmdBindVertexBuffers.invokeExact(commandBuffer, firstBinding, bindingCount, pBuffers, pOffsets);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdDraw = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdDraw", VOID, LONG, INT, INT, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdDraw(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int vertexCount, @NativeType("uint32_t") int instanceCount, @NativeType("uint32_t") int firstVertex, @NativeType("uint32_t") int firstInstance) {
		try {
			vkCmdDraw.invokeExact(commandBuffer, vertexCount, instanceCount, firstVertex, firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdDrawIndexed = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdDrawIndexed", VOID, LONG, INT, INT, INT, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdDrawIndexed(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int indexCount, @NativeType("uint32_t") int instanceCount, @NativeType("uint32_t") int firstIndex, @NativeType("int32_t") int vertexOffset, @NativeType("uint32_t") int firstInstance) {
		try {
			vkCmdDrawIndexed.invokeExact(commandBuffer, indexCount, instanceCount, firstIndex, vertexOffset, firstInstance);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdDrawIndirect = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdDrawIndirect", VOID, LONG, LONG, LONG, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdDrawIndirect(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("uint32_t") int drawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndirect.invokeExact(commandBuffer, buffer, offset, drawCount, stride);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdDrawIndexedIndirect = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdDrawIndexedIndirect", VOID, LONG, LONG, LONG, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdDrawIndexedIndirect(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("uint32_t") int drawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndexedIndirect.invokeExact(commandBuffer, buffer, offset, drawCount, stride);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdDispatch = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdDispatch", VOID, LONG, INT, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdDispatch(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int groupCountX, @NativeType("uint32_t") int groupCountY, @NativeType("uint32_t") int groupCountZ) {
		try {
			vkCmdDispatch.invokeExact(commandBuffer, groupCountX, groupCountY, groupCountZ);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdDispatchIndirect = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdDispatchIndirect", VOID, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdDispatchIndirect(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset) {
		try {
			vkCmdDispatchIndirect.invokeExact(commandBuffer, buffer, offset);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdCopyBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdCopyBuffer", VOID, LONG, LONG, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdCopyBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long srcBuffer, @NativeType("VkBuffer*") long dstBuffer, @NativeType("uint32_t") int regionCount, @NativeType("VkBufferCopy*") long pRegions) {
		try {
			vkCmdCopyBuffer.invokeExact(commandBuffer, srcBuffer, dstBuffer, regionCount, pRegions);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdCopyImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdCopyImage", VOID, LONG, LONG, INT, LONG, INT, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdCopyImage(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkImage*") long srcImage, @NativeType("VkImageLayout") int srcImageLayout, @NativeType("VkImage*") long dstImage, @NativeType("VkImageLayout") int dstImageLayout, @NativeType("uint32_t") int regionCount, @NativeType("VkImageCopy*") long pRegions) {
		try {
			vkCmdCopyImage.invokeExact(commandBuffer, srcImage, srcImageLayout, dstImage, dstImageLayout, regionCount, pRegions);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdBlitImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBlitImage", VOID, LONG, LONG, INT, LONG, INT, INT, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdBlitImage(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkImage*") long srcImage, @NativeType("VkImageLayout") int srcImageLayout, @NativeType("VkImage*") long dstImage, @NativeType("VkImageLayout") int dstImageLayout, @NativeType("uint32_t") int regionCount, @NativeType("VkImageBlit*") long pRegions, @NativeType("VkFilter") int filter) {
		try {
			vkCmdBlitImage.invokeExact(commandBuffer, srcImage, srcImageLayout, dstImage, dstImageLayout, regionCount, pRegions, filter);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdCopyBufferToImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdCopyBufferToImage", VOID, LONG, LONG, LONG, INT, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdCopyBufferToImage(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long srcBuffer, @NativeType("VkImage*") long dstImage, @NativeType("VkImageLayout") int dstImageLayout, @NativeType("uint32_t") int regionCount, @NativeType("VkBufferImageCopy*") long pRegions) {
		try {
			vkCmdCopyBufferToImage.invokeExact(commandBuffer, srcBuffer, dstImage, dstImageLayout, regionCount, pRegions);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdCopyImageToBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdCopyImageToBuffer", VOID, LONG, LONG, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdCopyImageToBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkImage*") long srcImage, @NativeType("VkImageLayout") int srcImageLayout, @NativeType("VkBuffer*") long dstBuffer, @NativeType("uint32_t") int regionCount, @NativeType("VkBufferImageCopy*") long pRegions) {
		try {
			vkCmdCopyImageToBuffer.invokeExact(commandBuffer, srcImage, srcImageLayout, dstBuffer, regionCount, pRegions);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdUpdateBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdUpdateBuffer", VOID, LONG, LONG, LONG, LONG, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdUpdateBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long dstBuffer, @NativeType("VkDeviceSize") long dstOffset, @NativeType("VkDeviceSize") long dataSize, @NativeType("void*") long pData) {
		try {
			vkCmdUpdateBuffer.invokeExact(commandBuffer, dstBuffer, dstOffset, dataSize, pData);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdFillBuffer = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdFillBuffer", VOID, LONG, LONG, LONG, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdFillBuffer(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuffer*") long dstBuffer, @NativeType("VkDeviceSize") long dstOffset, @NativeType("VkDeviceSize") long size, @NativeType("uint32_t") int data) {
		try {
			vkCmdFillBuffer.invokeExact(commandBuffer, dstBuffer, dstOffset, size, data);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdClearColorImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdClearColorImage", VOID, LONG, LONG, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdClearColorImage(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkImage*") long image, @NativeType("VkImageLayout") int imageLayout, @NativeType("VkClearColorValue*") long pColor, @NativeType("uint32_t") int rangeCount, @NativeType("VkImageSubresourceRange*") long pRanges) {
		try {
			vkCmdClearColorImage.invokeExact(commandBuffer, image, imageLayout, pColor, rangeCount, pRanges);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdClearDepthStencilImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdClearDepthStencilImage", VOID, LONG, LONG, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdClearDepthStencilImage(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkImage*") long image, @NativeType("VkImageLayout") int imageLayout, @NativeType("VkClearDepthStencilValue*") long pDepthStencil, @NativeType("uint32_t") int rangeCount, @NativeType("VkImageSubresourceRange*") long pRanges) {
		try {
			vkCmdClearDepthStencilImage.invokeExact(commandBuffer, image, imageLayout, pDepthStencil, rangeCount, pRanges);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdClearAttachments = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdClearAttachments", VOID, LONG, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdClearAttachments(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int attachmentCount, @NativeType("VkClearAttachment*") long pAttachments, @NativeType("uint32_t") int rectCount, @NativeType("VkClearRect*") long pRects) {
		try {
			vkCmdClearAttachments.invokeExact(commandBuffer, attachmentCount, pAttachments, rectCount, pRects);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdResolveImage = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdResolveImage", VOID, LONG, LONG, INT, LONG, INT, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdResolveImage(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkImage*") long srcImage, @NativeType("VkImageLayout") int srcImageLayout, @NativeType("VkImage*") long dstImage, @NativeType("VkImageLayout") int dstImageLayout, @NativeType("uint32_t") int regionCount, @NativeType("VkImageResolve*") long pRegions) {
		try {
			vkCmdResolveImage.invokeExact(commandBuffer, srcImage, srcImageLayout, dstImage, dstImageLayout, regionCount, pRegions);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdSetEvent = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetEvent", VOID, LONG, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdSetEvent(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkEvent*") long event, /* optional */ @NativeType("VkPipelineStageFlags") int stageMask) {
		try {
			vkCmdSetEvent.invokeExact(commandBuffer, event, stageMask);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdResetEvent = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdResetEvent", VOID, LONG, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdResetEvent(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkEvent*") long event, /* optional */ @NativeType("VkPipelineStageFlags") int stageMask) {
		try {
			vkCmdResetEvent.invokeExact(commandBuffer, event, stageMask);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdWaitEvents = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdWaitEvents", VOID, LONG, INT, LONG, INT, INT, INT, LONG, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdWaitEvents(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int eventCount, @NativeType("VkEvent**") long pEvents, /* optional */ @NativeType("VkPipelineStageFlags") int srcStageMask, /* optional */ @NativeType("VkPipelineStageFlags") int dstStageMask, /* optional */ @NativeType("uint32_t") int memoryBarrierCount, @NativeType("VkMemoryBarrier*") long pMemoryBarriers, /* optional */ @NativeType("uint32_t") int bufferMemoryBarrierCount, @NativeType("VkBufferMemoryBarrier*") long pBufferMemoryBarriers, /* optional */ @NativeType("uint32_t") int imageMemoryBarrierCount, @NativeType("VkImageMemoryBarrier*") long pImageMemoryBarriers) {
		try {
			vkCmdWaitEvents.invokeExact(commandBuffer, eventCount, pEvents, srcStageMask, dstStageMask, memoryBarrierCount, pMemoryBarriers, bufferMemoryBarrierCount, pBufferMemoryBarriers, imageMemoryBarrierCount, pImageMemoryBarriers);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdPipelineBarrier = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdPipelineBarrier", VOID, LONG, INT, INT, INT, INT, LONG, INT, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdPipelineBarrier(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, /* optional */ @NativeType("VkPipelineStageFlags") int srcStageMask, /* optional */ @NativeType("VkPipelineStageFlags") int dstStageMask, /* optional */ @NativeType("VkDependencyFlags") int dependencyFlags, /* optional */ @NativeType("uint32_t") int memoryBarrierCount, @NativeType("VkMemoryBarrier*") long pMemoryBarriers, /* optional */ @NativeType("uint32_t") int bufferMemoryBarrierCount, @NativeType("VkBufferMemoryBarrier*") long pBufferMemoryBarriers, /* optional */ @NativeType("uint32_t") int imageMemoryBarrierCount, @NativeType("VkImageMemoryBarrier*") long pImageMemoryBarriers) {
		try {
			vkCmdPipelineBarrier.invokeExact(commandBuffer, srcStageMask, dstStageMask, dependencyFlags, memoryBarrierCount, pMemoryBarriers, bufferMemoryBarrierCount, pBufferMemoryBarriers, imageMemoryBarrierCount, pImageMemoryBarriers);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdBeginQuery = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBeginQuery", VOID, LONG, LONG, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdBeginQuery(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkQueryPool*") long queryPool, @NativeType("uint32_t") int query, /* optional */ @NativeType("VkQueryControlFlags") int flags) {
		try {
			vkCmdBeginQuery.invokeExact(commandBuffer, queryPool, query, flags);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdEndQuery = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdEndQuery", VOID, LONG, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdEndQuery(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkQueryPool*") long queryPool, @NativeType("uint32_t") int query) {
		try {
			vkCmdEndQuery.invokeExact(commandBuffer, queryPool, query);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdResetQueryPool = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdResetQueryPool", VOID, LONG, LONG, INT, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdResetQueryPool(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkQueryPool*") long queryPool, @NativeType("uint32_t") int firstQuery, @NativeType("uint32_t") int queryCount) {
		try {
			vkCmdResetQueryPool.invokeExact(commandBuffer, queryPool, firstQuery, queryCount);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdWriteTimestamp = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdWriteTimestamp", VOID, LONG, INT, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdWriteTimestamp(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkPipelineStageFlagBits") int pipelineStage, @NativeType("VkQueryPool*") long queryPool, @NativeType("uint32_t") int query) {
		try {
			vkCmdWriteTimestamp.invokeExact(commandBuffer, pipelineStage, queryPool, query);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdCopyQueryPoolResults = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdCopyQueryPoolResults", VOID, LONG, LONG, INT, INT, LONG, LONG, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdCopyQueryPoolResults(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkQueryPool*") long queryPool, @NativeType("uint32_t") int firstQuery, @NativeType("uint32_t") int queryCount, @NativeType("VkBuffer*") long dstBuffer, @NativeType("VkDeviceSize") long dstOffset, @NativeType("VkDeviceSize") long stride, /* optional */ @NativeType("VkQueryResultFlags") int flags) {
		try {
			vkCmdCopyQueryPoolResults.invokeExact(commandBuffer, queryPool, firstQuery, queryCount, dstBuffer, dstOffset, stride, flags);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdPushConstants = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdPushConstants", VOID, LONG, LONG, INT, INT, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdPushConstants(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkPipelineLayout*") long layout, @NativeType("VkShaderStageFlags") int stageFlags, @NativeType("uint32_t") int offset, @NativeType("uint32_t") int size, @NativeType("void*") long pValues) {
		try {
			vkCmdPushConstants.invokeExact(commandBuffer, layout, stageFlags, offset, size, pValues);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdBeginRenderPass = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBeginRenderPass", VOID, LONG, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdBeginRenderPass(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkRenderPassBeginInfo*") long pRenderPassBegin, @NativeType("VkSubpassContents") int contents) {
		try {
			vkCmdBeginRenderPass.invokeExact(commandBuffer, pRenderPassBegin, contents);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdNextSubpass = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdNextSubpass", VOID, LONG, INT);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdNextSubpass(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkSubpassContents") int contents) {
		try {
			vkCmdNextSubpass.invokeExact(commandBuffer, contents);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdEndRenderPass = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdEndRenderPass", VOID, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdEndRenderPass(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer) {
		try {
			vkCmdEndRenderPass.invokeExact(commandBuffer);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	private static final MethodHandle vkCmdExecuteCommands = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdExecuteCommands", VOID, LONG, INT, LONG);

	/**
	 *
	 **/
	@NativeType("void")
	public static void vkCmdExecuteCommands(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int commandBufferCount, @NativeType("VkCommandBuffer**") long pCommandBuffers) {
		try {
			vkCmdExecuteCommands.invokeExact(commandBuffer, commandBufferCount, pCommandBuffers);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}