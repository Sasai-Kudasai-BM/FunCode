package net.skds.jvk;


import net.skds.jvk.platform.VKPlatformFeatures;

import java.lang.foreign.SymbolLookup;

@SuppressWarnings("unused")
public class VkDefinitions {

	public static final SymbolLookup LIBRARY_LOOKUP = VKPlatformFeatures.getInstance().getLibrary();
	public static final boolean INITIALIZED = LIBRARY_LOOKUP != null;

	public static final String VK_API_NAME = "vulkan";

	public static final int VK_HEADER_VERSION = 322;

	public static final int VK_API_VERSION_1_0 = vkMakeApiVersion(0, 1, 0, 0);
	public static final int VK_API_VERSION_1_1 = vkMakeApiVersion(0, 1, 1, 0);
	public static final int VK_API_VERSION_1_2 = vkMakeApiVersion(0, 1, 2, 0);
	public static final int VK_API_VERSION_1_3 = vkMakeApiVersion(0, 1, 3, 0);
	public static final int VK_API_VERSION_1_4 = vkMakeApiVersion(0, 1, 4, 0);
	public static final int VK_HEADER_VERSION_COMPLETE = vkMakeApiVersion(0, 1, 4, VK_HEADER_VERSION);
	public static final int VK_USE_64_BIT_PTR_DEFINES = 1;
	public static final long VK_NULL_HANDLE = 0;


	public static int vkMakeApiVersion(int variant, int major, int minor, int patch) {
		return (variant << 29) | (major << 22) | (minor << 12) | patch;
	}

	public static int vkApiVersionVariant(int version) {
		return version >> 29;
	}

	public static int vkApiVersionMajor(int version) {
		return (version >> 22) & 0x7F;
	}

	public static int vkApiVersionMinor(int version) {
		return (version >> 12) & 0x3FF;
	}

	public static int vkApiVersionPatch(int version) {
		return version & 0xFFF;
	}


	public static String getVersion(int version) {
		return vkApiVersionMajor(version) + "."
				+ vkApiVersionMinor(version) + "."
				+ vkApiVersionPatch(version);
	}

	public static int getExtEnumValue(int extNumber, int value) {
		return 1000000000 + 1000 * (extNumber - 1) + value;
	}

	public static String getErr(int err) {
		return switch (err) {
			case VkResult.VK_SUCCESS -> "VK_SUCCESS";
			case VkResult.VK_NOT_READY -> "VK_NOT_READY";
			case VkResult.VK_TIMEOUT -> "VK_TIMEOUT";
			case VkResult.VK_EVENT_SET -> "VK_EVENT_SET";
			case VkResult.VK_EVENT_RESET -> "VK_EVENT_RESET";
			case VkResult.VK_INCOMPLETE -> "VK_INCOMPLETE";
			case VkResult.VK_ERROR_OUT_OF_HOST_MEMORY -> "VK_ERROR_OUT_OF_HOST_MEMORY";
			case VkResult.VK_ERROR_OUT_OF_DEVICE_MEMORY -> "VK_ERROR_OUT_OF_DEVICE_MEMORY";
			case VkResult.VK_ERROR_INITIALIZATION_FAILED -> "VK_ERROR_INITIALIZATION_FAILED";
			case VkResult.VK_ERROR_DEVICE_LOST -> "VK_ERROR_DEVICE_LOST";
			case VkResult.VK_ERROR_MEMORY_MAP_FAILED -> "VK_ERROR_MEMORY_MAP_FAILED";
			case VkResult.VK_ERROR_LAYER_NOT_PRESENT -> "VK_ERROR_LAYER_NOT_PRESENT";
			case VkResult.VK_ERROR_EXTENSION_NOT_PRESENT -> "VK_ERROR_EXTENSION_NOT_PRESENT";
			case VkResult.VK_ERROR_FEATURE_NOT_PRESENT -> "VK_ERROR_FEATURE_NOT_PRESENT";
			case VkResult.VK_ERROR_INCOMPATIBLE_DRIVER -> "VK_ERROR_INCOMPATIBLE_DRIVER";
			case VkResult.VK_ERROR_TOO_MANY_OBJECTS -> "VK_ERROR_TOO_MANY_OBJECTS";
			case VkResult.VK_ERROR_FORMAT_NOT_SUPPORTED -> "VK_ERROR_FORMAT_NOT_SUPPORTED";
			case VkResult.VK_ERROR_FRAGMENTED_POOL -> "VK_ERROR_FRAGMENTED_POOL";
			case VkResult.VK_ERROR_UNKNOWN -> "VK_ERROR_UNKNOWN";

			default -> "unknown";
		};
	}


	public static VkDeviceTypeE getDeviceType(int type) {
		return VkDeviceTypeE.values()[type];
	}

}
