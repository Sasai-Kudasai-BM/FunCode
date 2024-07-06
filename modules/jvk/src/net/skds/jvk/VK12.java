package net.skds.jvk;
import net.skds.lib.utils.annotations.AutoGenerated;
import java.lang.invoke.MethodHandle;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;

@AutoGenerated
public sealed class VK12 extends VK11 permits VK13 {


	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_1_FEATURES = 49;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_1_PROPERTIES = 50;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_FEATURES = 51;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES = 52;

	// Promoted from VK_KHR_image_format_list (extension 148)

	public static final int VK_STRUCTURE_TYPE_IMAGE_FORMAT_LIST_CREATE_INFO = 0;

	// Promoted from VK_KHR_sampler_mirror_clamp_to_edge (extension 15)

	// No need to add an extnumber attribute, since this uses a core enum value

	// No need to add an extnumber attribute, since this uses a core enum value
	public static final int VK_SAMPLER_ADDRESS_MODE_MIRROR_CLAMP_TO_EDGE = 4;

	// Promoted from VK_KHR_draw_indirect_count (extension 170)

	private static final MethodHandle vkCmdDrawIndirectCount = createHandle("vkCmdDrawIndirectCount", VOID, LONG, LONG, LONG, LONG, LONG, INT, INT);

	@NativeType("void")
	public static void vkCmdDrawIndirectCount(@NativeType("VkCommandBuffer") /*external sync*/ long commandBuffer, @NativeType("VkBuffer") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkBuffer") long countBuffer, @NativeType("VkDeviceSize") long countBufferOffset, @NativeType("uint32_t") int maxDrawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndirectCount.invokeExact(commandBuffer, buffer, offset, countBuffer, countBufferOffset, maxDrawCount, stride);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdDrawIndexedIndirectCount = createHandle("vkCmdDrawIndexedIndirectCount", VOID, LONG, LONG, LONG, LONG, LONG, INT, INT);

	@NativeType("void")
	public static void vkCmdDrawIndexedIndirectCount(@NativeType("VkCommandBuffer") /*external sync*/ long commandBuffer, @NativeType("VkBuffer") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkBuffer") long countBuffer, @NativeType("VkDeviceSize") long countBufferOffset, @NativeType("uint32_t") int maxDrawCount, @NativeType("uint32_t") int stride) {
		try {
			vkCmdDrawIndexedIndirectCount.invokeExact(commandBuffer, buffer, offset, countBuffer, countBufferOffset, maxDrawCount, stride);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	// Promoted from VK_KHR_create_renderpass2 (extension 110)

	public static final int VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2 = 0;

	public static final int VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_2 = 1;

	public static final int VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_2 = 2;

	public static final int VK_STRUCTURE_TYPE_SUBPASS_DEPENDENCY_2 = 3;

	public static final int VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO_2 = 4;

	public static final int VK_STRUCTURE_TYPE_SUBPASS_BEGIN_INFO = 5;

	public static final int VK_STRUCTURE_TYPE_SUBPASS_END_INFO = 6;

	private static final MethodHandle vkCreateRenderPass2 = createHandle("vkCreateRenderPass2", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkCreateRenderPass2(@NativeType("VkDevice") long device, @NativeType("VkRenderPassCreateInfo2") long pCreateInfo, @NativeType("VkAllocationCallbacks") /*optional*/ long pAllocator, @NativeType("VkRenderPass") long pRenderPass) {
		try {
			return (int) vkCreateRenderPass2.invokeExact(device, pCreateInfo, pAllocator, pRenderPass);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdBeginRenderPass2 = createHandle("vkCmdBeginRenderPass2", VOID, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkCmdBeginRenderPass2(@NativeType("VkCommandBuffer") /*external sync*/ long commandBuffer, @NativeType("VkRenderPassBeginInfo") long pRenderPassBegin, @NativeType("VkSubpassBeginInfo") long pSubpassBeginInfo) {
		try {
			vkCmdBeginRenderPass2.invokeExact(commandBuffer, pRenderPassBegin, pSubpassBeginInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdNextSubpass2 = createHandle("vkCmdNextSubpass2", VOID, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkCmdNextSubpass2(@NativeType("VkCommandBuffer") /*external sync*/ long commandBuffer, @NativeType("VkSubpassBeginInfo") long pSubpassBeginInfo, @NativeType("VkSubpassEndInfo") long pSubpassEndInfo) {
		try {
			vkCmdNextSubpass2.invokeExact(commandBuffer, pSubpassBeginInfo, pSubpassEndInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdEndRenderPass2 = createHandle("vkCmdEndRenderPass2", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdEndRenderPass2(@NativeType("VkCommandBuffer") /*external sync*/ long commandBuffer, @NativeType("VkSubpassEndInfo") long pSubpassEndInfo) {
		try {
			vkCmdEndRenderPass2.invokeExact(commandBuffer, pSubpassEndInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	// Promoted from VK_KHR_8bit_storage (extension 178)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_8BIT_STORAGE_FEATURES = 0;

	// Promoted from VK_KHR_driver_properties (extension 197)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DRIVER_PROPERTIES = 0;

	public static final int VK_MAX_DRIVER_NAME_SIZE = 256;

	public static final int VK_MAX_DRIVER_INFO_SIZE = 256;

	// Promoted from VK_KHR_shader_atomic_int64 (extension 181)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES = 0;

	// Promoted from VK_KHR_shader_float16_int8 (extension 83)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_FLOAT16_INT8_FEATURES = 0;

	// Promoted from VK_KHR_shader_float_controls (extension 198)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES = 0;

	// Promoted from VK_EXT_descriptor_indexing (extension 162)

	public static final int VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO = 0;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES = 1;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES = 2;

	public static final int VK_STRUCTURE_TYPE_DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO = 3;

	public static final int VK_STRUCTURE_TYPE_DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_LAYOUT_SUPPORT = 4;

	public static final int VK_DESCRIPTOR_POOL_CREATE_UPDATE_AFTER_BIND_BIT = 2;

	public static final int VK_DESCRIPTOR_SET_LAYOUT_CREATE_UPDATE_AFTER_BIND_POOL_BIT = 2;

	public static final int VK_ERROR_FRAGMENTATION = 0;

	// Promoted from VK_KHR_depth_stencil_resolve (extension 200)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES = 0;

	public static final int VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE = 1;

	// Promoted from VK_EXT_scalar_block_layout (extension 222))

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SCALAR_BLOCK_LAYOUT_FEATURES = 0;

	// Promoted from VK_EXT_shader_viewport_index_layer, which has no API (extension 163)

	// Promoted from VK_EXT_separate_stencil_usage (extension 247)

	public static final int VK_STRUCTURE_TYPE_IMAGE_STENCIL_USAGE_CREATE_INFO = 0;

	// Promoted from VK_EXT_sampler_filter_minmax (extension 131)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SAMPLER_FILTER_MINMAX_PROPERTIES = 0;

	public static final int VK_STRUCTURE_TYPE_SAMPLER_REDUCTION_MODE_CREATE_INFO = 1;

	// Format can be used with min/max reduction filtering

	// Format can be used with min/max reduction filtering
	public static final int VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_MINMAX_BIT = 65536;

	// Promoted from VK_KHR_vulkan_memory_model (extension 212)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_MEMORY_MODEL_FEATURES = 0;

	// Promoted from VK_KHR_imageless_framebuffer (extension 109)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGELESS_FRAMEBUFFER_FEATURES = 0;

	public static final int VK_STRUCTURE_TYPE_FRAMEBUFFER_ATTACHMENTS_CREATE_INFO = 1;

	public static final int VK_STRUCTURE_TYPE_FRAMEBUFFER_ATTACHMENT_IMAGE_INFO = 2;

	public static final int VK_STRUCTURE_TYPE_RENDER_PASS_ATTACHMENT_BEGIN_INFO = 3;

	public static final int VK_FRAMEBUFFER_CREATE_IMAGELESS_BIT = 1;

	// Promoted from VK_KHR_uniform_buffer_standard_layout (extension 254)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_UNIFORM_BUFFER_STANDARD_LAYOUT_FEATURES = 0;

	// Promoted from VK_KHR_shader_subgroup_extended_types (extension 176)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_SUBGROUP_EXTENDED_TYPES_FEATURES = 0;

	// Promoted from VK_KHR_spirv_1_4 (extension 237)

	// Promoted from VK_KHR_separate_depth_stencil_layouts (extension 242)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SEPARATE_DEPTH_STENCIL_LAYOUTS_FEATURES = 0;

	public static final int VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_STENCIL_LAYOUT = 1;

	public static final int VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_STENCIL_LAYOUT = 2;

	public static final int VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_OPTIMAL = 0;

	public static final int VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_OPTIMAL = 1;

	public static final int VK_IMAGE_LAYOUT_STENCIL_ATTACHMENT_OPTIMAL = 2;

	public static final int VK_IMAGE_LAYOUT_STENCIL_READ_ONLY_OPTIMAL = 3;

	// Promoted from VK_EXT_host_query_reset (extension 262)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_HOST_QUERY_RESET_FEATURES = 0;

	private static final MethodHandle vkResetQueryPool = createHandle("vkResetQueryPool", VOID, LONG, LONG, INT, INT);

	@NativeType("void")
	public static void vkResetQueryPool(@NativeType("VkDevice") long device, @NativeType("VkQueryPool") long queryPool, @NativeType("uint32_t") int firstQuery, @NativeType("uint32_t") int queryCount) {
		try {
			vkResetQueryPool.invokeExact(device, queryPool, firstQuery, queryCount);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	// Promoted from VK_KHR_timeline_semaphore (extension 208)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TIMELINE_SEMAPHORE_FEATURES = 0;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TIMELINE_SEMAPHORE_PROPERTIES = 1;

	public static final int VK_STRUCTURE_TYPE_SEMAPHORE_TYPE_CREATE_INFO = 2;

	public static final int VK_STRUCTURE_TYPE_TIMELINE_SEMAPHORE_SUBMIT_INFO = 3;

	public static final int VK_STRUCTURE_TYPE_SEMAPHORE_WAIT_INFO = 4;

	public static final int VK_STRUCTURE_TYPE_SEMAPHORE_SIGNAL_INFO = 5;

	private static final MethodHandle vkGetSemaphoreCounterValue = createHandle("vkGetSemaphoreCounterValue", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	*/
	@NativeType("VkResult")
	public static int vkGetSemaphoreCounterValue(@NativeType("VkDevice") long device, @NativeType("VkSemaphore") long semaphore, @NativeType("uint64_t") long pValue) {
		try {
			return (int) vkGetSemaphoreCounterValue.invokeExact(device, semaphore, pValue);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkWaitSemaphores = createHandle("vkWaitSemaphores", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_TIMEOUT
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_DEVICE_LOST
	*/
	@NativeType("VkResult")
	public static int vkWaitSemaphores(@NativeType("VkDevice") long device, @NativeType("VkSemaphoreWaitInfo") long pWaitInfo, @NativeType("uint64_t") long timeout) {
		try {
			return (int) vkWaitSemaphores.invokeExact(device, pWaitInfo, timeout);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkSignalSemaphore = createHandle("vkSignalSemaphore", INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkSignalSemaphore(@NativeType("VkDevice") long device, @NativeType("VkSemaphoreSignalInfo") long pSignalInfo) {
		try {
			return (int) vkSignalSemaphore.invokeExact(device, pSignalInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	// Promoted from VK_KHR_buffer_device_address (extension 258)

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES = 0;

	public static final int VK_STRUCTURE_TYPE_BUFFER_DEVICE_ADDRESS_INFO = 1;

	public static final int VK_STRUCTURE_TYPE_BUFFER_OPAQUE_CAPTURE_ADDRESS_CREATE_INFO = 2;

	public static final int VK_STRUCTURE_TYPE_MEMORY_OPAQUE_CAPTURE_ADDRESS_ALLOCATE_INFO = 3;

	public static final int VK_STRUCTURE_TYPE_DEVICE_MEMORY_OPAQUE_CAPTURE_ADDRESS_INFO = 4;

	public static final int VK_BUFFER_USAGE_SHADER_DEVICE_ADDRESS_BIT = 131072;

	public static final int VK_BUFFER_CREATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT = 16;

	public static final int VK_MEMORY_ALLOCATE_DEVICE_ADDRESS_BIT = 2;

	public static final int VK_MEMORY_ALLOCATE_DEVICE_ADDRESS_CAPTURE_REPLAY_BIT = 4;

	public static final int VK_ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS = 0;

	private static final MethodHandle vkGetBufferDeviceAddress = createHandle("vkGetBufferDeviceAddress", LONG, LONG, LONG);

	@NativeType("VkDeviceAddress")
	public static long vkGetBufferDeviceAddress(@NativeType("VkDevice") long device, @NativeType("VkBufferDeviceAddressInfo") long pInfo) {
		try {
			return (long) vkGetBufferDeviceAddress.invokeExact(device, pInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetBufferOpaqueCaptureAddress = createHandle("vkGetBufferOpaqueCaptureAddress", LONG, LONG, LONG);

	@NativeType("uint64_t")
	public static long vkGetBufferOpaqueCaptureAddress(@NativeType("VkDevice") long device, @NativeType("VkBufferDeviceAddressInfo") long pInfo) {
		try {
			return (long) vkGetBufferOpaqueCaptureAddress.invokeExact(device, pInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetDeviceMemoryOpaqueCaptureAddress = createHandle("vkGetDeviceMemoryOpaqueCaptureAddress", LONG, LONG, LONG);

	@NativeType("uint64_t")
	public static long vkGetDeviceMemoryOpaqueCaptureAddress(@NativeType("VkDevice") long device, @NativeType("VkDeviceMemoryOpaqueCaptureAddressInfo") long pInfo) {
		try {
			return (long) vkGetDeviceMemoryOpaqueCaptureAddress.invokeExact(device, pInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}