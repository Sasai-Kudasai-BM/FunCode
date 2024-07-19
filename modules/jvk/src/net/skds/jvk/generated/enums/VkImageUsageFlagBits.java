package net.skds.jvk.generated.enums;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageUsageFlagBits {


	/**
	* Can be used as a source of transfer operations
	*/
	public static final int VK_IMAGE_USAGE_TRANSFER_SRC_BIT = 1;

	/**
	* Can be used as a destination of transfer operations
	*/
	public static final int VK_IMAGE_USAGE_TRANSFER_DST_BIT = 2;

	/**
	* Can be sampled from (SAMPLED_IMAGE and COMBINED_IMAGE_SAMPLER descriptor types)
	*/
	public static final int VK_IMAGE_USAGE_SAMPLED_BIT = 4;

	/**
	* Can be used as storage image (STORAGE_IMAGE descriptor type)
	*/
	public static final int VK_IMAGE_USAGE_STORAGE_BIT = 8;

	/**
	* Can be used as framebuffer color attachment
	*/
	public static final int VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT = 16;

	/**
	* Can be used as framebuffer depth/stencil attachment
	*/
	public static final int VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT = 32;

	/**
	* Image data not needed outside of rendering
	*/
	public static final int VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT = 64;

	/**
	* Can be used as framebuffer input attachment
	*/
	public static final int VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT = 128;

}