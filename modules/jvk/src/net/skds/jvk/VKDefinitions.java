package net.skds.jvk;

public class VKDefinitions {

	public static final int VK_HEADER_VERSION = 216;

	public static final int VK_API_VERSION_1_0 = vkMakeApiVersion(0, 1, 0, 0);
	public static final int VK_API_VERSION_1_1 = vkMakeApiVersion(0, 1, 1, 0);
	public static final int VK_API_VERSION_1_2 = vkMakeApiVersion(0, 1, 2, 0);
	public static final int VK_API_VERSION_1_3 = vkMakeApiVersion(0, 1, 3, 0);
	public static final int VK_HEADER_VERSION_COMPLETE = vkMakeApiVersion(0, 1, 3, VK_HEADER_VERSION);
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


}
