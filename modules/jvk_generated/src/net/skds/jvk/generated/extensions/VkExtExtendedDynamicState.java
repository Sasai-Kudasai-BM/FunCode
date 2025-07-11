package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.SafeLinker.*;

@AutoGenerated
public final class VkExtExtendedDynamicState {
	
	// Not promoted to 1.3
	
	/** Not promoted to 1.3 **/
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
	private static final MethodHandle vkCmdSetCullModeEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetCullModeEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetCullModeEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, /* optional */ @NativeType("VkCullModeFlags") int cullMode) {
		try {
			vkCmdSetCullModeEXT.invokeExact(commandBuffer, cullMode);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetFrontFaceEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetFrontFaceEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetFrontFaceEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkFrontFace") int frontFace) {
		try {
			vkCmdSetFrontFaceEXT.invokeExact(commandBuffer, frontFace);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetPrimitiveTopologyEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetPrimitiveTopologyEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetPrimitiveTopologyEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkPrimitiveTopology") int primitiveTopology) {
		try {
			vkCmdSetPrimitiveTopologyEXT.invokeExact(commandBuffer, primitiveTopology);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetViewportWithCountEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetViewportWithCountEXT", VOID, LONG, INT, LONG);
	
	@NativeType("void")
	public static void vkCmdSetViewportWithCountEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int viewportCount, @NativeType("VkViewport*") long pViewports) {
		try {
			vkCmdSetViewportWithCountEXT.invokeExact(commandBuffer, viewportCount, pViewports);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetScissorWithCountEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetScissorWithCountEXT", VOID, LONG, INT, LONG);
	
	@NativeType("void")
	public static void vkCmdSetScissorWithCountEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int scissorCount, @NativeType("VkRect2D*") long pScissors) {
		try {
			vkCmdSetScissorWithCountEXT.invokeExact(commandBuffer, scissorCount, pScissors);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdBindVertexBuffers2EXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBindVertexBuffers2EXT", VOID, LONG, INT, INT, LONG, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdBindVertexBuffers2EXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("uint32_t") int firstBinding, @NativeType("uint32_t") int bindingCount, /* optional */ @NativeType("VkBuffer**") long pBuffers, @NativeType("VkDeviceSize*") long pOffsets, /* optional */ @NativeType("VkDeviceSize*") long pSizes, /* optional */ @NativeType("VkDeviceSize*") long pStrides) {
		try {
			vkCmdBindVertexBuffers2EXT.invokeExact(commandBuffer, firstBinding, bindingCount, pBuffers, pOffsets, pSizes, pStrides);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetDepthTestEnableEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetDepthTestEnableEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetDepthTestEnableEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBool32") int depthTestEnable) {
		try {
			vkCmdSetDepthTestEnableEXT.invokeExact(commandBuffer, depthTestEnable);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetDepthWriteEnableEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetDepthWriteEnableEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetDepthWriteEnableEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBool32") int depthWriteEnable) {
		try {
			vkCmdSetDepthWriteEnableEXT.invokeExact(commandBuffer, depthWriteEnable);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetDepthCompareOpEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetDepthCompareOpEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetDepthCompareOpEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkCompareOp") int depthCompareOp) {
		try {
			vkCmdSetDepthCompareOpEXT.invokeExact(commandBuffer, depthCompareOp);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetDepthBoundsTestEnableEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetDepthBoundsTestEnableEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetDepthBoundsTestEnableEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBool32") int depthBoundsTestEnable) {
		try {
			vkCmdSetDepthBoundsTestEnableEXT.invokeExact(commandBuffer, depthBoundsTestEnable);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetStencilTestEnableEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetStencilTestEnableEXT", VOID, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdSetStencilTestEnableEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBool32") int stencilTestEnable) {
		try {
			vkCmdSetStencilTestEnableEXT.invokeExact(commandBuffer, stencilTestEnable);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdSetStencilOpEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdSetStencilOpEXT", VOID, LONG, INT, INT, INT, INT, INT);
	
	@NativeType("void")
	public static void vkCmdSetStencilOpEXT(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkStencilFaceFlags") int faceMask, @NativeType("VkStencilOp") int failOp, @NativeType("VkStencilOp") int passOp, @NativeType("VkStencilOp") int depthFailOp, @NativeType("VkCompareOp") int compareOp) {
		try {
			vkCmdSetStencilOpEXT.invokeExact(commandBuffer, faceMask, failOp, passOp, depthFailOp, compareOp);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}