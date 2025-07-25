package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkKhrMaintenance1 {
	
	public static final int VK_ERROR_OUT_OF_POOL_MEMORY_KHR = 1000069000;
	public static final int VK_FORMAT_FEATURE_TRANSFER_SRC_BIT_KHR = 16384;
	public static final int VK_FORMAT_FEATURE_TRANSFER_DST_BIT_KHR = 32768;
	public static final int VK_IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT_KHR = 32;
	private static final MethodHandle vkTrimCommandPoolKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkTrimCommandPoolKHR", VOID, LONG, LONG, INT);
	
	@NativeType("void")
	public static void vkTrimCommandPoolKHR(@NativeType("VkDevice*") long device, /* external sync */ @NativeType("VkCommandPool*") long commandPool, /* optional */ @NativeType("VkCommandPoolTrimFlags") int flags) {
		try {
			vkTrimCommandPoolKHR.invokeExact(device, commandPool, flags);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}