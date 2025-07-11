package net.skds.jvk.generated.enums;

import net.skds.lib2.annotations.AutoGenerated;

@AutoGenerated
public final class VkImageLayout {
	
	/** Implicit layout an image is when its contents are undefined due to various reasons (e.g. right after creation) **/
	public static final int VK_IMAGE_LAYOUT_UNDEFINED = 0;
	/** General layout when image can be used for any kind of access **/
	public static final int VK_IMAGE_LAYOUT_GENERAL = 1;
	/** Optimal layout when image is only used for color attachment read/write **/
	public static final int VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL = 2;
	/** Optimal layout when image is only used for depth/stencil attachment read/write **/
	public static final int VK_IMAGE_LAYOUT_DEPTH_STENCIL_ATTACHMENT_OPTIMAL = 3;
	/** Optimal layout when image is used for read only depth/stencil attachment and shader access **/
	public static final int VK_IMAGE_LAYOUT_DEPTH_STENCIL_READ_ONLY_OPTIMAL = 4;
	/** Optimal layout when image is used for read only shader access **/
	public static final int VK_IMAGE_LAYOUT_SHADER_READ_ONLY_OPTIMAL = 5;
	/** Optimal layout when image is used only as source of transfer operations **/
	public static final int VK_IMAGE_LAYOUT_TRANSFER_SRC_OPTIMAL = 6;
	/** Optimal layout when image is used only as destination of transfer operations **/
	public static final int VK_IMAGE_LAYOUT_TRANSFER_DST_OPTIMAL = 7;
	/** Initial layout used when the data is populated by the CPU **/
	public static final int VK_IMAGE_LAYOUT_PREINITIALIZED = 8;
	public static final int VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL = 0;
	public static final int VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL = 1;
	public static final int VK_IMAGE_LAYOUT_DEPTH_ATTACHMENT_OPTIMAL = 0;
	public static final int VK_IMAGE_LAYOUT_DEPTH_READ_ONLY_OPTIMAL = 1;
	public static final int VK_IMAGE_LAYOUT_STENCIL_ATTACHMENT_OPTIMAL = 2;
	public static final int VK_IMAGE_LAYOUT_STENCIL_READ_ONLY_OPTIMAL = 3;
	public static final int VK_IMAGE_LAYOUT_READ_ONLY_OPTIMAL = 0;
	public static final int VK_IMAGE_LAYOUT_ATTACHMENT_OPTIMAL = 1;
	public static final int VK_IMAGE_LAYOUT_PRESENT_SRC_KHR = 2;
	public static final int VK_IMAGE_LAYOUT_VIDEO_DECODE_DST_KHR = 0;
	public static final int VK_IMAGE_LAYOUT_VIDEO_DECODE_SRC_KHR = 1;
	public static final int VK_IMAGE_LAYOUT_VIDEO_DECODE_DPB_KHR = 2;
	public static final int VK_IMAGE_LAYOUT_SHARED_PRESENT_KHR = 0;
	public static final int VK_IMAGE_LAYOUT_FRAGMENT_DENSITY_MAP_OPTIMAL_EXT = 0;
	public static final int VK_IMAGE_LAYOUT_FRAGMENT_SHADING_RATE_ATTACHMENT_OPTIMAL_KHR = 3;
	public static final int VK_IMAGE_LAYOUT_VIDEO_ENCODE_DST_KHR = 0;
	public static final int VK_IMAGE_LAYOUT_VIDEO_ENCODE_SRC_KHR = 1;
	public static final int VK_IMAGE_LAYOUT_VIDEO_ENCODE_DPB_KHR = 2;
}