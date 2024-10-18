package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtExtendedDynamicState {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	// Not promoted to 1.3

	/**
	* Not promoted to 1.3
	*/
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTENDED_DYNAMIC_STATE_FEATURES_EXT = 0;

	public static final int VK_DYNAMIC_STATE_CULL_MODE_EXT = 0;

	public static final int VK_DYNAMIC_STATE_FRONT_FACE_EXT = 1;

	public static final int VK_DYNAMIC_STATE_PRIMITIVE_TOPOLOGY_EXT = 2;

	public static final int VK_DYNAMIC_STATE_VIEWPORT_WITH_COUNT_EXT = 3;

	public static final int VK_DYNAMIC_STATE_SCISSOR_WITH_COUNT_EXT = 4;

	public static final int VK_DYNAMIC_STATE_VERTEX_INPUT_BINDING_STRIDE_EXT = 5;

	public static final int VK_DYNAMIC_STATE_DEPTH_TEST_ENABLE_EXT = 6;

	public static final int VK_DYNAMIC_STATE_DEPTH_WRITE_ENABLE_EXT = 7;

	public static final int VK_DYNAMIC_STATE_DEPTH_COMPARE_OP_EXT = 8;

	public static final int VK_DYNAMIC_STATE_DEPTH_BOUNDS_TEST_ENABLE_EXT = 9;

	public static final int VK_DYNAMIC_STATE_STENCIL_TEST_ENABLE_EXT = 10;

	public static final int VK_DYNAMIC_STATE_STENCIL_OP_EXT = 11;

	// Not promoted to 1.3

	private static final MethodHandle vkCmdSetCullModeEXT = createHandle("vkCmdSetCullModeEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetCullModeEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkCullModeFlags") /*optional*/ int cullMode) {
		try {
			vkCmdSetCullModeEXT.invokeExact(commandBuffer, cullMode);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetFrontFaceEXT = createHandle("vkCmdSetFrontFaceEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetFrontFaceEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkFrontFace") int frontFace) {
		try {
			vkCmdSetFrontFaceEXT.invokeExact(commandBuffer, frontFace);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetPrimitiveTopologyEXT = createHandle("vkCmdSetPrimitiveTopologyEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetPrimitiveTopologyEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkPrimitiveTopology") int primitiveTopology) {
		try {
			vkCmdSetPrimitiveTopologyEXT.invokeExact(commandBuffer, primitiveTopology);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetViewportWithCountEXT = createHandle("vkCmdSetViewportWithCountEXT", VOID, LONG, INT, LONG);

	@NativeType("void")
	public static void vkCmdSetViewportWithCountEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("uint32_t") int viewportCount, @NativeType("VkViewport*") long pViewports) {
		try {
			vkCmdSetViewportWithCountEXT.invokeExact(commandBuffer, viewportCount, pViewports);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetScissorWithCountEXT = createHandle("vkCmdSetScissorWithCountEXT", VOID, LONG, INT, LONG);

	@NativeType("void")
	public static void vkCmdSetScissorWithCountEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("uint32_t") int scissorCount, @NativeType("VkRect2D*") long pScissors) {
		try {
			vkCmdSetScissorWithCountEXT.invokeExact(commandBuffer, scissorCount, pScissors);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdBindVertexBuffers2EXT = createHandle("vkCmdBindVertexBuffers2EXT", VOID, LONG, INT, INT, LONG, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkCmdBindVertexBuffers2EXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("uint32_t") int firstBinding, @NativeType("uint32_t") int bindingCount, @NativeType("VkBuffer**") /*optional*/ long pBuffers, @NativeType("VkDeviceSize*") long pOffsets, @NativeType("VkDeviceSize*") /*optional*/ long pSizes, @NativeType("VkDeviceSize*") /*optional*/ long pStrides) {
		try {
			vkCmdBindVertexBuffers2EXT.invokeExact(commandBuffer, firstBinding, bindingCount, pBuffers, pOffsets, pSizes, pStrides);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetDepthTestEnableEXT = createHandle("vkCmdSetDepthTestEnableEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetDepthTestEnableEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBool32") int depthTestEnable) {
		try {
			vkCmdSetDepthTestEnableEXT.invokeExact(commandBuffer, depthTestEnable);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetDepthWriteEnableEXT = createHandle("vkCmdSetDepthWriteEnableEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetDepthWriteEnableEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBool32") int depthWriteEnable) {
		try {
			vkCmdSetDepthWriteEnableEXT.invokeExact(commandBuffer, depthWriteEnable);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetDepthCompareOpEXT = createHandle("vkCmdSetDepthCompareOpEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetDepthCompareOpEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkCompareOp") int depthCompareOp) {
		try {
			vkCmdSetDepthCompareOpEXT.invokeExact(commandBuffer, depthCompareOp);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetDepthBoundsTestEnableEXT = createHandle("vkCmdSetDepthBoundsTestEnableEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetDepthBoundsTestEnableEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBool32") int depthBoundsTestEnable) {
		try {
			vkCmdSetDepthBoundsTestEnableEXT.invokeExact(commandBuffer, depthBoundsTestEnable);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetStencilTestEnableEXT = createHandle("vkCmdSetStencilTestEnableEXT", VOID, LONG, INT);

	@NativeType("void")
	public static void vkCmdSetStencilTestEnableEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkBool32") int stencilTestEnable) {
		try {
			vkCmdSetStencilTestEnableEXT.invokeExact(commandBuffer, stencilTestEnable);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdSetStencilOpEXT = createHandle("vkCmdSetStencilOpEXT", VOID, LONG, INT, INT, INT, INT, INT);

	@NativeType("void")
	public static void vkCmdSetStencilOpEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkStencilFaceFlags") int faceMask, @NativeType("VkStencilOp") int failOp, @NativeType("VkStencilOp") int passOp, @NativeType("VkStencilOp") int depthFailOp, @NativeType("VkCompareOp") int compareOp) {
		try {
			vkCmdSetStencilOpEXT.invokeExact(commandBuffer, faceMask, failOp, passOp, depthFailOp, compareOp);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}