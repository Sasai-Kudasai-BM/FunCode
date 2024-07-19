package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrCopyCommands2 {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_COPY_BUFFER_INFO_2_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_COPY_IMAGE_INFO_2_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_COPY_BUFFER_TO_IMAGE_INFO_2_KHR = 2;

	public static final int VK_STRUCTURE_TYPE_COPY_IMAGE_TO_BUFFER_INFO_2_KHR = 3;

	public static final int VK_STRUCTURE_TYPE_BLIT_IMAGE_INFO_2_KHR = 4;

	public static final int VK_STRUCTURE_TYPE_RESOLVE_IMAGE_INFO_2_KHR = 5;

	public static final int VK_STRUCTURE_TYPE_BUFFER_COPY_2_KHR = 6;

	public static final int VK_STRUCTURE_TYPE_IMAGE_COPY_2_KHR = 7;

	public static final int VK_STRUCTURE_TYPE_IMAGE_BLIT_2_KHR = 8;

	public static final int VK_STRUCTURE_TYPE_BUFFER_IMAGE_COPY_2_KHR = 9;

	public static final int VK_STRUCTURE_TYPE_IMAGE_RESOLVE_2_KHR = 10;

	private static final MethodHandle vkCmdCopyBuffer2KHR = createHandle("vkCmdCopyBuffer2KHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdCopyBuffer2KHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkCopyBufferInfo2*") long pCopyBufferInfo) {
		try {
			vkCmdCopyBuffer2KHR.invokeExact(commandBuffer, pCopyBufferInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdCopyImage2KHR = createHandle("vkCmdCopyImage2KHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdCopyImage2KHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkCopyImageInfo2*") long pCopyImageInfo) {
		try {
			vkCmdCopyImage2KHR.invokeExact(commandBuffer, pCopyImageInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdCopyBufferToImage2KHR = createHandle("vkCmdCopyBufferToImage2KHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdCopyBufferToImage2KHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkCopyBufferToImageInfo2*") long pCopyBufferToImageInfo) {
		try {
			vkCmdCopyBufferToImage2KHR.invokeExact(commandBuffer, pCopyBufferToImageInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdCopyImageToBuffer2KHR = createHandle("vkCmdCopyImageToBuffer2KHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdCopyImageToBuffer2KHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkCopyImageToBufferInfo2*") long pCopyImageToBufferInfo) {
		try {
			vkCmdCopyImageToBuffer2KHR.invokeExact(commandBuffer, pCopyImageToBufferInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdBlitImage2KHR = createHandle("vkCmdBlitImage2KHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdBlitImage2KHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBlitImageInfo2*") long pBlitImageInfo) {
		try {
			vkCmdBlitImage2KHR.invokeExact(commandBuffer, pBlitImageInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdResolveImage2KHR = createHandle("vkCmdResolveImage2KHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdResolveImage2KHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkResolveImageInfo2*") long pResolveImageInfo) {
		try {
			vkCmdResolveImage2KHR.invokeExact(commandBuffer, pResolveImageInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}