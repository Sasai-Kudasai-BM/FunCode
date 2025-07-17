package net.skds.jvk.vulkan.device;

import net.skds.jvk.generated.enums.VkQueueFlagBits;
import net.skds.jvk.generated.structs.VkExtent3D;

import java.util.StringJoiner;

public record VkQueueFamilyInfo(
		int index,
		int queueFlags,
		int queueCount,
		int timestampValidBits,
		VkExtent3D minImageTransferGranularity
) {

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(", ", "[", "]");

		if ((queueFlags & VkQueueFlagBits.VK_QUEUE_GRAPHICS_BIT) != 0) {
			joiner.add("GRAPHICS");
		}
		if ((queueFlags & VkQueueFlagBits.VK_QUEUE_COMPUTE_BIT) != 0) {
			joiner.add("COMPUTE");
		}
		if ((queueFlags & VkQueueFlagBits.VK_QUEUE_TRANSFER_BIT) != 0) {
			joiner.add("TRANSFER");
		}
		if ((queueFlags & VkQueueFlagBits.VK_QUEUE_SPARSE_BINDING_BIT) != 0) {
			joiner.add("SPARSE_BINDING");
		}

		return "VkQueueFamilyInfo{" + "count: " + queueCount +
				", flags: " + joiner +
				"}";
	}
}
