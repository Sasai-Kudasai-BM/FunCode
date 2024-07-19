package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrVideoEncodeQueue {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final long VK_PIPELINE_STAGE_2_VIDEO_ENCODE_BIT_KHR = 134217728L;

	public static final long VK_ACCESS_2_VIDEO_ENCODE_READ_BIT_KHR = 137438953472L;

	public static final long VK_ACCESS_2_VIDEO_ENCODE_WRITE_BIT_KHR = 274877906944L;

	public static final int VK_STRUCTURE_TYPE_VIDEO_ENCODE_INFO_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_VIDEO_ENCODE_RATE_CONTROL_INFO_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_VIDEO_ENCODE_RATE_CONTROL_LAYER_INFO_KHR = 2;

	public static final int VK_STRUCTURE_TYPE_VIDEO_ENCODE_CAPABILITIES_KHR = 3;

	public static final int VK_QUEUE_VIDEO_ENCODE_BIT_KHR = 64;

	public static final int VK_BUFFER_USAGE_VIDEO_ENCODE_DST_BIT_KHR = 32768;

	public static final int VK_BUFFER_USAGE_VIDEO_ENCODE_SRC_BIT_KHR = 65536;

	public static final int VK_IMAGE_USAGE_VIDEO_ENCODE_DST_BIT_KHR = 8192;

	public static final int VK_IMAGE_USAGE_VIDEO_ENCODE_SRC_BIT_KHR = 16384;

	public static final int VK_IMAGE_USAGE_VIDEO_ENCODE_DPB_BIT_KHR = 32768;

	public static final int VK_FORMAT_FEATURE_VIDEO_ENCODE_INPUT_BIT_KHR = 134217728;

	public static final int VK_FORMAT_FEATURE_VIDEO_ENCODE_DPB_BIT_KHR = 268435456;

	public static final int VK_IMAGE_LAYOUT_VIDEO_ENCODE_DST_KHR = 0;

	public static final int VK_IMAGE_LAYOUT_VIDEO_ENCODE_SRC_KHR = 1;

	public static final int VK_IMAGE_LAYOUT_VIDEO_ENCODE_DPB_KHR = 2;

	public static final int VK_QUERY_TYPE_VIDEO_ENCODE_BITSTREAM_BUFFER_RANGE_KHR = 0;

	private static final MethodHandle vkCmdEncodeVideoKHR = createHandle("vkCmdEncodeVideoKHR", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdEncodeVideoKHR(@NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkVideoEncodeInfoKHR*") long pEncodeInfo) {
		try {
			vkCmdEncodeVideoKHR.invokeExact(commandBuffer, pEncodeInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	public static final long VK_FORMAT_FEATURE_2_VIDEO_ENCODE_INPUT_BIT_KHR = 134217728L;

	public static final long VK_FORMAT_FEATURE_2_VIDEO_ENCODE_DPB_BIT_KHR = 268435456L;
}