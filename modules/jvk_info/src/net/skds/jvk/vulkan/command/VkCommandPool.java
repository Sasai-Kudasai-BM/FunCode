package net.skds.jvk.vulkan.command;

import net.skds.jvk.VkCleanable;

import static net.skds.jvk.generated.VK10.vkDestroyCommandPool;

public record VkCommandPool(long handle, long device, VkCommandBuffer[] buffers) implements VkCleanable {
	@Override
	public void vkClean(long pAllocator) {
		vkDestroyCommandPool(device, handle, pAllocator);
	}
}
