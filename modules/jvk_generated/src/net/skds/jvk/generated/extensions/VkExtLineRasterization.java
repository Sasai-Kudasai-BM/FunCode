package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkExtLineRasterization {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_LINE_RASTERIZATION_FEATURES_EXT = 1000259000;
	public static final int VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_LINE_STATE_CREATE_INFO_EXT = 1000259001;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_LINE_RASTERIZATION_PROPERTIES_EXT = 1000259002;
	public static final int VK_DYNAMIC_STATE_LINE_STIPPLE_EXT = 1000259000;
	public static final int VK_LINE_RASTERIZATION_MODE_DEFAULT_EXT = 0;
	public static final int VK_LINE_RASTERIZATION_MODE_RECTANGULAR_EXT = 1;
	public static final int VK_LINE_RASTERIZATION_MODE_BRESENHAM_EXT = 2;
	public static final int VK_LINE_RASTERIZATION_MODE_RECTANGULAR_SMOOTH_EXT = 3;
	private static final MethodHandle vkCmdSetLineStippleEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetLineStippleEXT", VOID, LONG, INT, SHORT);
	
	@NativeType("void")
	public static void vkCmdSetLineStippleEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int lineStippleFactor, @NativeType("uint16_t") short lineStipplePattern) {
		try {
			vkCmdSetLineStippleEXT.invokeExact(commandBuffer, lineStippleFactor, lineStipplePattern);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}