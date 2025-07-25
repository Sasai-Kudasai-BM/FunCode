package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkExtColorWriteEnable {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_COLOR_WRITE_ENABLE_FEATURES_EXT = 1000381000;
	public static final int VK_STRUCTURE_TYPE_PIPELINE_COLOR_WRITE_CREATE_INFO_EXT = 1000381001;
	public static final int VK_DYNAMIC_STATE_COLOR_WRITE_ENABLE_EXT = 1000381000;
	private static final MethodHandle vkCmdSetColorWriteEnableEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetColorWriteEnableEXT", VOID, LONG, INT, LONG);
	
	@NativeType("void")
	public static void vkCmdSetColorWriteEnableEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int attachmentCount, @NativeType("VkBool32*") long pColorWriteEnables) {
		try {
			vkCmdSetColorWriteEnableEXT.invokeExact(commandBuffer, attachmentCount, pColorWriteEnables);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}