package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAmdDrawIndirectCount {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkCmdDrawIndirectCountAMD = createHandle("vkCmdDrawIndirectCountAMD", VOID, LONG, LONG, LONG, LONG, LONG, INT, INT);

	@NativeType("void")
	public static void vkCmdDrawIndirectCountAMD(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkBuffer*") long countBuffer, @NativeType("VkDeviceSize") long countBufferOffset, @NativeType("uint32_t") int maxDrawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndirectCountAMD.invokeExact(commandBuffer, buffer, offset, countBuffer, countBufferOffset, maxDrawCount, stride);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdDrawIndexedIndirectCountAMD = createHandle("vkCmdDrawIndexedIndirectCountAMD", VOID, LONG, LONG, LONG, LONG, LONG, INT, INT);

	@NativeType("void")
	public static void vkCmdDrawIndexedIndirectCountAMD(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkBuffer*") long countBuffer, @NativeType("VkDeviceSize") long countBufferOffset, @NativeType("uint32_t") int maxDrawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndexedIndirectCountAMD.invokeExact(commandBuffer, buffer, offset, countBuffer, countBufferOffset, maxDrawCount, stride);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}