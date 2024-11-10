package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkHuaweiInvocationMask {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_INVOCATION_MASK_FEATURES_HUAWEI = 0;

	public static final long VK_ACCESS_2_INVOCATION_MASK_READ_BIT_HUAWEI = 549755813888L;

	public static final int VK_IMAGE_USAGE_INVOCATION_MASK_BIT_HUAWEI = 262144;

	public static final long VK_PIPELINE_STAGE_2_INVOCATION_MASK_BIT_HUAWEI = 1099511627776L;

	private static final MethodHandle vkCmdBindInvocationMaskHUAWEI = createHandle("vkCmdBindInvocationMaskHUAWEI", VOID, LONG, LONG, INT);

	@NativeType("void")
	public static void vkCmdBindInvocationMaskHUAWEI(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkImageView*") /*optional*/ long imageView, @NativeType("VkImageLayout") int imageLayout) {
		try {
			vkCmdBindInvocationMaskHUAWEI.invokeExact(commandBuffer, imageView, imageLayout);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}