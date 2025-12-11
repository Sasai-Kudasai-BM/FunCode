package net.skds.jvk.vulkan.device;

public record VkDevice(
		long handle,
		VkQueue[] queues,
		VkPhysicalDevice info
) {
}
