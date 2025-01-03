package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtImageDrmFormatModifier {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_ERROR_INVALID_DRM_FORMAT_MODIFIER_PLANE_LAYOUT_EXT = 0;

	public static final int VK_STRUCTURE_TYPE_DRM_FORMAT_MODIFIER_PROPERTIES_LIST_EXT = 0;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT = 2;

	public static final int VK_STRUCTURE_TYPE_IMAGE_DRM_FORMAT_MODIFIER_LIST_CREATE_INFO_EXT = 3;

	public static final int VK_STRUCTURE_TYPE_IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT = 4;

	public static final int VK_STRUCTURE_TYPE_IMAGE_DRM_FORMAT_MODIFIER_PROPERTIES_EXT = 5;

	public static final int VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT = 0;

	public static final int VK_IMAGE_ASPECT_MEMORY_PLANE_0_BIT_EXT = 128;

	public static final int VK_IMAGE_ASPECT_MEMORY_PLANE_1_BIT_EXT = 256;

	public static final int VK_IMAGE_ASPECT_MEMORY_PLANE_2_BIT_EXT = 512;

	public static final int VK_IMAGE_ASPECT_MEMORY_PLANE_3_BIT_EXT = 1024;

	private static final MethodHandle vkGetImageDrmFormatModifierPropertiesEXT = createHandle("vkGetImageDrmFormatModifierPropertiesEXT", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetImageDrmFormatModifierPropertiesEXT(@NativeType("VkDevice*") long device, @NativeType("VkImage*") long image, @NativeType("VkImageDrmFormatModifierPropertiesEXT*") long pProperties) {
		try {
			return (int) vkGetImageDrmFormatModifierPropertiesEXT.invokeExact(device, image, pProperties);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	public static final int VK_STRUCTURE_TYPE_DRM_FORMAT_MODIFIER_PROPERTIES_LIST_2_EXT = 6;
}