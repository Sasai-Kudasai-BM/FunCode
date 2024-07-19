package net.skds.jvk.generated.enums;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPeerMemoryFeatureFlagBitsKHR {


	/**
	* Can read with vkCmdCopy commands
	*/
	public static final int VK_PEER_MEMORY_FEATURE_COPY_SRC_BIT = 1;

	/**
	* Can write with vkCmdCopy commands
	*/
	public static final int VK_PEER_MEMORY_FEATURE_COPY_DST_BIT = 2;

	/**
	* Can read with any access type/command
	*/
	public static final int VK_PEER_MEMORY_FEATURE_GENERIC_SRC_BIT = 4;

	/**
	* Can write with and access type/command
	*/
	public static final int VK_PEER_MEMORY_FEATURE_GENERIC_DST_BIT = 8;

}