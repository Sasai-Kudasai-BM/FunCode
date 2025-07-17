package net.skds.jvk.vulkan.device;

public record VkQueue(
		long handle,
		int index,
		int familyIndex
) {
}
