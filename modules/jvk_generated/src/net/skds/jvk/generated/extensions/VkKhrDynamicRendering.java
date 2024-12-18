package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrDynamicRendering {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkCmdBeginRenderingKHR = createHandle("vkCmdBeginRenderingKHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdBeginRenderingKHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkRenderingInfo*") long pRenderingInfo) {
		try {
			vkCmdBeginRenderingKHR.invokeExact(commandBuffer, pRenderingInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdEndRenderingKHR = createHandle("vkCmdEndRenderingKHR", VOID, LONG);

	@NativeType("void")
	public static void vkCmdEndRenderingKHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer) {
		try {
			vkCmdEndRenderingKHR.invokeExact(commandBuffer);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	public static final int VK_STRUCTURE_TYPE_RENDERING_INFO_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_RENDERING_ATTACHMENT_INFO_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_PIPELINE_RENDERING_CREATE_INFO_KHR = 2;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DYNAMIC_RENDERING_FEATURES_KHR = 3;

	public static final int VK_STRUCTURE_TYPE_COMMAND_BUFFER_INHERITANCE_RENDERING_INFO_KHR = 4;

	public static final int VK_ATTACHMENT_STORE_OP_NONE_KHR = 0;

	public static final int VK_PIPELINE_CREATE_RENDERING_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR = 2097152;

	// Backwards-compatible alias containing a typo

	/**
	* Backwards-compatible alias containing a typo
	*/
	public static final int VK_PIPELINE_RASTERIZATION_STATE_CREATE_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR = 2097152;

	public static final int VK_STRUCTURE_TYPE_RENDERING_FRAGMENT_SHADING_RATE_ATTACHMENT_INFO_KHR = 6;

	public static final int VK_PIPELINE_CREATE_RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_BIT_EXT = 4194304;

	// Backwards-compatible alias containing a typo

	/**
	* Backwards-compatible alias containing a typo
	*/
	public static final int VK_PIPELINE_RASTERIZATION_STATE_CREATE_FRAGMENT_DENSITY_MAP_ATTACHMENT_BIT_EXT = 4194304;

	public static final int VK_STRUCTURE_TYPE_RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_INFO_EXT = 7;

	public static final int VK_STRUCTURE_TYPE_ATTACHMENT_SAMPLE_COUNT_INFO_AMD = 8;

	public static final int VK_STRUCTURE_TYPE_ATTACHMENT_SAMPLE_COUNT_INFO_NV = 8;

	public static final int VK_STRUCTURE_TYPE_MULTIVIEW_PER_VIEW_ATTRIBUTES_INFO_NVX = 9;
}