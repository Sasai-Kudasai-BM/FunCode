package net.skds.jvk.generated.enums;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAccessFlagBits {


	/**
	* Controls coherency of indirect command reads
	*/
	public static final int VK_ACCESS_INDIRECT_COMMAND_READ_BIT = 1;

	/**
	* Controls coherency of index reads
	*/
	public static final int VK_ACCESS_INDEX_READ_BIT = 2;

	/**
	* Controls coherency of vertex attribute reads
	*/
	public static final int VK_ACCESS_VERTEX_ATTRIBUTE_READ_BIT = 4;

	/**
	* Controls coherency of uniform buffer reads
	*/
	public static final int VK_ACCESS_UNIFORM_READ_BIT = 8;

	/**
	* Controls coherency of input attachment reads
	*/
	public static final int VK_ACCESS_INPUT_ATTACHMENT_READ_BIT = 16;

	/**
	* Controls coherency of shader reads
	*/
	public static final int VK_ACCESS_SHADER_READ_BIT = 32;

	/**
	* Controls coherency of shader writes
	*/
	public static final int VK_ACCESS_SHADER_WRITE_BIT = 64;

	/**
	* Controls coherency of color attachment reads
	*/
	public static final int VK_ACCESS_COLOR_ATTACHMENT_READ_BIT = 128;

	/**
	* Controls coherency of color attachment writes
	*/
	public static final int VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT = 256;

	/**
	* Controls coherency of depth/stencil attachment reads
	*/
	public static final int VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_READ_BIT = 512;

	/**
	* Controls coherency of depth/stencil attachment writes
	*/
	public static final int VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT = 1024;

	/**
	* Controls coherency of transfer reads
	*/
	public static final int VK_ACCESS_TRANSFER_READ_BIT = 2048;

	/**
	* Controls coherency of transfer writes
	*/
	public static final int VK_ACCESS_TRANSFER_WRITE_BIT = 4096;

	/**
	* Controls coherency of host reads
	*/
	public static final int VK_ACCESS_HOST_READ_BIT = 8192;

	/**
	* Controls coherency of host writes
	*/
	public static final int VK_ACCESS_HOST_WRITE_BIT = 16384;

	/**
	* Controls coherency of memory reads
	*/
	public static final int VK_ACCESS_MEMORY_READ_BIT = 32768;

	/**
	* Controls coherency of memory writes
	*/
	public static final int VK_ACCESS_MEMORY_WRITE_BIT = 65536;

	public static final int VK_ACCESS_NONE = 0;

	public static final int VK_ACCESS_TRANSFORM_FEEDBACK_WRITE_BIT_EXT = 33554432;

	public static final int VK_ACCESS_TRANSFORM_FEEDBACK_COUNTER_READ_BIT_EXT = 67108864;

	public static final int VK_ACCESS_TRANSFORM_FEEDBACK_COUNTER_WRITE_BIT_EXT = 134217728;

	/**
	* read access flag for reading conditional rendering predicate
	*/
	public static final int VK_ACCESS_CONDITIONAL_RENDERING_READ_BIT_EXT = 1048576;

	public static final int VK_ACCESS_COLOR_ATTACHMENT_READ_NONCOHERENT_BIT_EXT = 524288;

	public static final int VK_ACCESS_ACCELERATION_STRUCTURE_READ_BIT_KHR = 2097152;

	public static final int VK_ACCESS_ACCELERATION_STRUCTURE_WRITE_BIT_KHR = 4194304;

	public static final int VK_ACCESS_FRAGMENT_DENSITY_MAP_READ_BIT_EXT = 16777216;

	public static final int VK_ACCESS_FRAGMENT_SHADING_RATE_ATTACHMENT_READ_BIT_KHR = 8388608;

	public static final int VK_ACCESS_COMMAND_PREPROCESS_READ_BIT_NV = 131072;

	public static final int VK_ACCESS_COMMAND_PREPROCESS_WRITE_BIT_NV = 262144;

}