package net.skds.jvk.vulkan.device;

public record VkDevice(
		long handle,
		VkQueue[] queues,
		VkDeviceInfo info
) {
}
