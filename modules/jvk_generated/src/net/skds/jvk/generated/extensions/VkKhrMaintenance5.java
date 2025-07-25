package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkKhrMaintenance5 {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_5_FEATURES_KHR = 1000470000;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_5_PROPERTIES_KHR = 1000470001;
	public static final int VK_STRUCTURE_TYPE_RENDERING_AREA_INFO_KHR = 1000470003;
	public static final int VK_STRUCTURE_TYPE_DEVICE_IMAGE_SUBRESOURCE_INFO_KHR = 1000470004;
	public static final int VK_FORMAT_A1B5G5R5_UNORM_PACK16_KHR = 1000470000;
	public static final int VK_FORMAT_A8_UNORM_KHR = 1000470001;
	private static final MethodHandle vkCmdBindIndexBuffer2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBindIndexBuffer2KHR", VOID, LONG, LONG, LONG, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdBindIndexBuffer2KHR(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, /* optional */ @NativeType("VkBuffer*") long buffer, @NativeType("VkDeviceSize") long offset, @NativeType("VkDeviceSize") long size, @NativeType("VkIndexType") int indexType) {
		try {
			vkCmdBindIndexBuffer2KHR.invokeExact(commandBuffer, buffer, offset, size, indexType);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetRenderingAreaGranularityKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetRenderingAreaGranularityKHR", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetRenderingAreaGranularityKHR(@NativeType("VkDevice*") long device, @NativeType("VkRenderingAreaInfo*") long pRenderingAreaInfo, @NativeType("VkExtent2D*") long pGranularity) {
		try {
			vkGetRenderingAreaGranularityKHR.invokeExact(device, pRenderingAreaInfo, pGranularity);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetDeviceImageSubresourceLayoutKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetDeviceImageSubresourceLayoutKHR", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetDeviceImageSubresourceLayoutKHR(@NativeType("VkDevice*") long device, @NativeType("VkDeviceImageSubresourceInfo*") long pInfo, @NativeType("VkSubresourceLayout2*") long pLayout) {
		try {
			vkGetDeviceImageSubresourceLayoutKHR.invokeExact(device, pInfo, pLayout);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetImageSubresourceLayout2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetImageSubresourceLayout2KHR", VOID, LONG, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetImageSubresourceLayout2KHR(@NativeType("VkDevice*") long device, @NativeType("VkImage*") long image, @NativeType("VkImageSubresource2*") long pSubresource, @NativeType("VkSubresourceLayout2*") long pLayout) {
		try {
			vkGetImageSubresourceLayout2KHR.invokeExact(device, image, pSubresource, pLayout);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	public static final int VK_STRUCTURE_TYPE_SUBRESOURCE_LAYOUT_2_KHR = 1000338002;
	public static final int VK_STRUCTURE_TYPE_IMAGE_SUBRESOURCE_2_KHR = 1000338003;
	
	// Split off new 64-bit flags separately, for the moment
	
	public static final long VK_PIPELINE_CREATE_2_DISABLE_OPTIMIZATION_BIT_KHR = 1L;
	public static final long VK_PIPELINE_CREATE_2_ALLOW_DERIVATIVES_BIT_KHR = 2L;
	public static final long VK_PIPELINE_CREATE_2_DERIVATIVE_BIT_KHR = 4L;
	public static final long VK_PIPELINE_CREATE_2_VIEW_INDEX_FROM_DEVICE_INDEX_BIT_KHR = 8L;
	public static final long VK_PIPELINE_CREATE_2_DISPATCH_BASE_BIT_KHR = 16L;
	public static final long VK_BUFFER_USAGE_2_TRANSFER_SRC_BIT_KHR = 1L;
	public static final long VK_BUFFER_USAGE_2_TRANSFER_DST_BIT_KHR = 2L;
	public static final long VK_BUFFER_USAGE_2_UNIFORM_TEXEL_BUFFER_BIT_KHR = 4L;
	public static final long VK_BUFFER_USAGE_2_STORAGE_TEXEL_BUFFER_BIT_KHR = 8L;
	public static final long VK_BUFFER_USAGE_2_UNIFORM_BUFFER_BIT_KHR = 16L;
	public static final long VK_BUFFER_USAGE_2_STORAGE_BUFFER_BIT_KHR = 32L;
	public static final long VK_BUFFER_USAGE_2_INDEX_BUFFER_BIT_KHR = 64L;
	public static final long VK_BUFFER_USAGE_2_VERTEX_BUFFER_BIT_KHR = 128L;
	public static final long VK_BUFFER_USAGE_2_INDIRECT_BUFFER_BIT_KHR = 256L;
	public static final int VK_STRUCTURE_TYPE_PIPELINE_CREATE_FLAGS_2_CREATE_INFO_KHR = 1000470005;
	public static final int VK_STRUCTURE_TYPE_BUFFER_USAGE_FLAGS_2_CREATE_INFO_KHR = 1000470006;
	public static final long VK_PIPELINE_CREATE_2_DEFER_COMPILE_BIT_NV = 32L;
	public static final long VK_PIPELINE_CREATE_2_CAPTURE_STATISTICS_BIT_KHR = 64L;
	public static final long VK_PIPELINE_CREATE_2_CAPTURE_INTERNAL_REPRESENTATIONS_BIT_KHR = 128L;
	public static final long VK_PIPELINE_CREATE_2_FAIL_ON_PIPELINE_COMPILE_REQUIRED_BIT_KHR = 256L;
	public static final long VK_PIPELINE_CREATE_2_EARLY_RETURN_ON_FAILURE_BIT_KHR = 512L;
	public static final long VK_PIPELINE_CREATE_2_LINK_TIME_OPTIMIZATION_BIT_EXT = 1024L;
	public static final long VK_PIPELINE_CREATE_2_RETAIN_LINK_TIME_OPTIMIZATION_INFO_BIT_EXT = 8388608L;
	public static final long VK_PIPELINE_CREATE_2_LIBRARY_BIT_KHR = 2048L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_SKIP_TRIANGLES_BIT_KHR = 4096L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_SKIP_AABBS_BIT_KHR = 8192L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_ANY_HIT_SHADERS_BIT_KHR = 16384L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_CLOSEST_HIT_SHADERS_BIT_KHR = 32768L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_MISS_SHADERS_BIT_KHR = 65536L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_NO_NULL_INTERSECTION_SHADERS_BIT_KHR = 131072L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_SHADER_GROUP_HANDLE_CAPTURE_REPLAY_BIT_KHR = 524288L;
	public static final long VK_PIPELINE_CREATE_2_INDIRECT_BINDABLE_BIT_NV = 262144L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_ALLOW_MOTION_BIT_NV = 1048576L;
	public static final long VK_PIPELINE_CREATE_2_RENDERING_FRAGMENT_SHADING_RATE_ATTACHMENT_BIT_KHR = 2097152L;
	public static final long VK_PIPELINE_CREATE_2_RENDERING_FRAGMENT_DENSITY_MAP_ATTACHMENT_BIT_EXT = 4194304L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_OPACITY_MICROMAP_BIT_EXT = 16777216L;
	public static final long VK_PIPELINE_CREATE_2_COLOR_ATTACHMENT_FEEDBACK_LOOP_BIT_EXT = 33554432L;
	public static final long VK_PIPELINE_CREATE_2_DEPTH_STENCIL_ATTACHMENT_FEEDBACK_LOOP_BIT_EXT = 67108864L;
	public static final long VK_PIPELINE_CREATE_2_NO_PROTECTED_ACCESS_BIT_EXT = 134217728L;
	public static final long VK_PIPELINE_CREATE_2_PROTECTED_ACCESS_ONLY_BIT_EXT = 1073741824L;
	public static final long VK_PIPELINE_CREATE_2_RAY_TRACING_DISPLACEMENT_MICROMAP_BIT_NV = 268435456L;
	public static final long VK_PIPELINE_CREATE_2_DESCRIPTOR_BUFFER_BIT_EXT = 536870912L;
	public static final long VK_BUFFER_USAGE_2_CONDITIONAL_RENDERING_BIT_EXT = 512L;
	public static final long VK_BUFFER_USAGE_2_SHADER_BINDING_TABLE_BIT_KHR = 1024L;
	public static final long VK_BUFFER_USAGE_2_RAY_TRACING_BIT_NV = 1024L;
	public static final long VK_BUFFER_USAGE_2_TRANSFORM_FEEDBACK_BUFFER_BIT_EXT = 2048L;
	public static final long VK_BUFFER_USAGE_2_TRANSFORM_FEEDBACK_COUNTER_BUFFER_BIT_EXT = 4096L;
	public static final long VK_BUFFER_USAGE_2_VIDEO_DECODE_SRC_BIT_KHR = 8192L;
	public static final long VK_BUFFER_USAGE_2_VIDEO_DECODE_DST_BIT_KHR = 16384L;
	public static final long VK_BUFFER_USAGE_2_VIDEO_ENCODE_DST_BIT_KHR = 32768L;
	public static final long VK_BUFFER_USAGE_2_VIDEO_ENCODE_SRC_BIT_KHR = 65536L;
	public static final long VK_BUFFER_USAGE_2_SHADER_DEVICE_ADDRESS_BIT_KHR = 131072L;
	public static final long VK_BUFFER_USAGE_2_ACCELERATION_STRUCTURE_BUILD_INPUT_READ_ONLY_BIT_KHR = 524288L;
	public static final long VK_BUFFER_USAGE_2_ACCELERATION_STRUCTURE_STORAGE_BIT_KHR = 1048576L;
	public static final long VK_BUFFER_USAGE_2_SAMPLER_DESCRIPTOR_BUFFER_BIT_EXT = 2097152L;
	public static final long VK_BUFFER_USAGE_2_RESOURCE_DESCRIPTOR_BUFFER_BIT_EXT = 4194304L;
	public static final long VK_BUFFER_USAGE_2_PUSH_DESCRIPTORS_DESCRIPTOR_BUFFER_BIT_EXT = 67108864L;
	public static final long VK_BUFFER_USAGE_2_MICROMAP_BUILD_INPUT_READ_ONLY_BIT_EXT = 8388608L;
	public static final long VK_BUFFER_USAGE_2_MICROMAP_STORAGE_BIT_EXT = 16777216L;
	public static final long VK_PIPELINE_CREATE_2_DISALLOW_OPACITY_MICROMAP_BIT_ARM = 137438953472L;
}