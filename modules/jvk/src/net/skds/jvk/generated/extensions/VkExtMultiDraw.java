package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtMultiDraw {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MULTI_DRAW_FEATURES_EXT = 0;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MULTI_DRAW_PROPERTIES_EXT = 1;

	private static final MethodHandle vkCmdDrawMultiEXT = createHandle("vkCmdDrawMultiEXT", VOID, LONG, INT, LONG, INT, INT, INT);

	@NativeType("void")
	public static void vkCmdDrawMultiEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("uint32_t") /*optional*/ int drawCount, @NativeType("VkMultiDrawInfoEXT*") long pVertexInfo, @NativeType("uint32_t") int instanceCount, @NativeType("uint32_t") int firstInstance, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawMultiEXT.invokeExact(commandBuffer, drawCount, pVertexInfo, instanceCount, firstInstance, stride);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdDrawMultiIndexedEXT = createHandle("vkCmdDrawMultiIndexedEXT", VOID, LONG, INT, LONG, INT, INT, INT, LONG);

	@NativeType("void")
	public static void vkCmdDrawMultiIndexedEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("uint32_t") /*optional*/ int drawCount, @NativeType("VkMultiDrawIndexedInfoEXT*") long pIndexInfo, @NativeType("uint32_t") int instanceCount, @NativeType("uint32_t") int firstInstance, @NativeType("uint32_t") int stride, @NativeType("int32_t*") /*optional*/ long pVertexOffset) {
		try {
			vkCmdDrawMultiIndexedEXT.invokeExact(commandBuffer, drawCount, pIndexInfo, instanceCount, firstInstance, stride, pVertexOffset);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}