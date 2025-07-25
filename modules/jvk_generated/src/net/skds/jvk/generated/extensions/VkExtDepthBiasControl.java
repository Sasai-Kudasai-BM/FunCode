package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkExtDepthBiasControl {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEPTH_BIAS_CONTROL_FEATURES_EXT = 1000283000;
	public static final int VK_STRUCTURE_TYPE_DEPTH_BIAS_INFO_EXT = 1000283001;
	public static final int VK_STRUCTURE_TYPE_DEPTH_BIAS_REPRESENTATION_INFO_EXT = 1000283002;
	private static final MethodHandle vkCmdSetDepthBias2EXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetDepthBias2EXT", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdSetDepthBias2EXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkDepthBiasInfoEXT*") long pDepthBiasInfo) {
		try {
			vkCmdSetDepthBias2EXT.invokeExact(commandBuffer, pDepthBiasInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}