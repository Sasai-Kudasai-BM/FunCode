package net.skds.jvk.generated.enums;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFormatFeatureFlagBits {


	/**
	* Format can be used for sampled images (SAMPLED_IMAGE and COMBINED_IMAGE_SAMPLER descriptor types)
	*/
	public static final int VK_FORMAT_FEATURE_SAMPLED_IMAGE_BIT = 1;

	/**
	* Format can be used for storage images (STORAGE_IMAGE descriptor type)
	*/
	public static final int VK_FORMAT_FEATURE_STORAGE_IMAGE_BIT = 2;

	/**
	* Format supports atomic operations in case it is used for storage images
	*/
	public static final int VK_FORMAT_FEATURE_STORAGE_IMAGE_ATOMIC_BIT = 4;

	/**
	* Format can be used for uniform texel buffers (TBOs)
	*/
	public static final int VK_FORMAT_FEATURE_UNIFORM_TEXEL_BUFFER_BIT = 8;

	/**
	* Format can be used for storage texel buffers (IBOs)
	*/
	public static final int VK_FORMAT_FEATURE_STORAGE_TEXEL_BUFFER_BIT = 16;

	/**
	* Format supports atomic operations in case it is used for storage texel buffers
	*/
	public static final int VK_FORMAT_FEATURE_STORAGE_TEXEL_BUFFER_ATOMIC_BIT = 32;

	/**
	* Format can be used for vertex buffers (VBOs)
	*/
	public static final int VK_FORMAT_FEATURE_VERTEX_BUFFER_BIT = 64;

	/**
	* Format can be used for color attachment images
	*/
	public static final int VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BIT = 128;

	/**
	* Format supports blending in case it is used for color attachment images
	*/
	public static final int VK_FORMAT_FEATURE_COLOR_ATTACHMENT_BLEND_BIT = 256;

	/**
	* Format can be used for depth/stencil attachment images
	*/
	public static final int VK_FORMAT_FEATURE_DEPTH_STENCIL_ATTACHMENT_BIT = 512;

	/**
	* Format can be used as the source image of blits with vkCmdBlitImage
	*/
	public static final int VK_FORMAT_FEATURE_BLIT_SRC_BIT = 1024;

	/**
	* Format can be used as the destination image of blits with vkCmdBlitImage
	*/
	public static final int VK_FORMAT_FEATURE_BLIT_DST_BIT = 2048;

	/**
	* Format can be filtered with VK_FILTER_LINEAR when being sampled
	*/
	public static final int VK_FORMAT_FEATURE_SAMPLED_IMAGE_FILTER_LINEAR_BIT = 4096;

}