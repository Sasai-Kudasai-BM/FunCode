package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkExtFragmentDensityMapOffset {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_OFFSET_FEATURES_EXT = 1000425000;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_OFFSET_PROPERTIES_EXT = 1000425001;
	public static final int VK_STRUCTURE_TYPE_RENDER_PASS_FRAGMENT_DENSITY_MAP_OFFSET_END_INFO_EXT = 1000425002;
	public static final int VK_STRUCTURE_TYPE_RENDERING_END_INFO_EXT = 1000619003;
	public static final int VK_IMAGE_CREATE_FRAGMENT_DENSITY_MAP_OFFSET_BIT_EXT = 32768;
	private static final MethodHandle vkCmdEndRendering2EXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdEndRendering2EXT", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdEndRendering2EXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, /* optional */ @NativeType("VkRenderingEndInfoEXT*") long pRenderingEndInfo) {
		try {
			vkCmdEndRendering2EXT.invokeExact(commandBuffer, pRenderingEndInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}