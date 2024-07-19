package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkNvScissorExclusive {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV = 0;

	public static final int VK_DYNAMIC_STATE_EXCLUSIVE_SCISSOR_NV = 1;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXCLUSIVE_SCISSOR_FEATURES_NV = 2;

	private static final MethodHandle vkCmdSetExclusiveScissorNV = createHandle("vkCmdSetExclusiveScissorNV", VOID, LONG, INT, INT, LONG);

	@NativeType("void")
	public static void vkCmdSetExclusiveScissorNV(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("uint32_t") int firstExclusiveScissor, @NativeType("uint32_t") int exclusiveScissorCount, @NativeType("VkRect2D*") long pExclusiveScissors) {
		try {
			vkCmdSetExclusiveScissorNV.invokeExact(commandBuffer, firstExclusiveScissor, exclusiveScissorCount, pExclusiveScissors);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}