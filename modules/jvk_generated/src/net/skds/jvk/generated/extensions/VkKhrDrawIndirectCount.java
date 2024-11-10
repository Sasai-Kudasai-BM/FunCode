package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrDrawIndirectCount {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkCmdDrawIndirectCountKHR = createHandle("vkCmdDrawIndirectCountKHR", VOID, LONG, LONG, LONG, LONG, LONG, INT, INT);

	@NativeType("void")
	public static void vkCmdDrawIndirectCountKHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkBuffer*") long countBuffer, @NativeType("VkDeviceSize") long countBufferOffset, @NativeType("uint32_t") int maxDrawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndirectCountKHR.invokeExact(commandBuffer, buffer, offset, countBuffer, countBufferOffset, maxDrawCount, stride);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdDrawIndexedIndirectCountKHR = createHandle("vkCmdDrawIndexedIndirectCountKHR", VOID, LONG, LONG, LONG, LONG, LONG, INT, INT);

	@NativeType("void")
	public static void vkCmdDrawIndexedIndirectCountKHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkBuffer*") long countBuffer, @NativeType("VkDeviceSize") long countBufferOffset, @NativeType("uint32_t") int maxDrawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndexedIndirectCountKHR.invokeExact(commandBuffer, buffer, offset, countBuffer, countBufferOffset, maxDrawCount, stride);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}