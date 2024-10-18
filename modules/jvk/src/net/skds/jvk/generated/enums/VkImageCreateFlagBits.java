package net.skds.jvk.generated.enums;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageCreateFlagBits {


	/**
	* Image should support sparse backing
	*/
	public static final int VK_IMAGE_CREATE_SPARSE_BINDING_BIT = 1;

	/**
	* Image should support sparse backing with partial residency
	*/
	public static final int VK_IMAGE_CREATE_SPARSE_RESIDENCY_BIT = 2;

	/**
	* Image should support constant data access to physical memory ranges mapped into multiple locations of sparse images
	*/
	public static final int VK_IMAGE_CREATE_SPARSE_ALIASED_BIT = 4;

	/**
	* Allows image views to have different format than the base image
	*/
	public static final int VK_IMAGE_CREATE_MUTABLE_FORMAT_BIT = 8;

	/**
	* Allows creating image views with cube type from the created image
	*/
	public static final int VK_IMAGE_CREATE_CUBE_COMPATIBLE_BIT = 16;

	public static final int VK_IMAGE_CREATE_ALIAS_BIT = 1024;

	/**
	* Allows using VkBindImageMemoryDeviceGroupInfo::pSplitInstanceBindRegions when binding memory to the image
	*/
	public static final int VK_IMAGE_CREATE_SPLIT_INSTANCE_BIND_REGIONS_BIT = 64;

	/**
	* The 3D image can be viewed as a 2D or 2D array image
	*/
	public static final int VK_IMAGE_CREATE_2D_ARRAY_COMPATIBLE_BIT = 32;

	public static final int VK_IMAGE_CREATE_BLOCK_TEXEL_VIEW_COMPATIBLE_BIT = 128;

	public static final int VK_IMAGE_CREATE_EXTENDED_USAGE_BIT = 256;

	/**
	* Image requires protected memory
	*/
	public static final int VK_IMAGE_CREATE_PROTECTED_BIT = 2048;

	public static final int VK_IMAGE_CREATE_DISJOINT_BIT = 512;

	public static final int VK_IMAGE_CREATE_CORNER_SAMPLED_BIT_NV = 8192;

	public static final int VK_IMAGE_CREATE_SAMPLE_LOCATIONS_COMPATIBLE_DEPTH_BIT_EXT = 4096;

	public static final int VK_IMAGE_CREATE_SUBSAMPLED_BIT_EXT = 16384;

	public static final int VK_IMAGE_CREATE_RESERVED_16_BIT_AMD = 65536;

	public static final int VK_IMAGE_CREATE_RESERVED_18_BIT_EXT = 262144;

	/**
	* Image is created with a layout where individual slices are capable of being used as 2D images
	*/
	public static final int VK_IMAGE_CREATE_2D_VIEW_COMPATIBLE_BIT_EXT = 131072;

	public static final int VK_IMAGE_CREATE_FRAGMENT_DENSITY_MAP_OFFSET_BIT_QCOM = 32768;

}