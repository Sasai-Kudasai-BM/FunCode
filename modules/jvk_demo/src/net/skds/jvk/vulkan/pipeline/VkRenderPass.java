package net.skds.jvk.vulkan.pipeline;

import net.skds.jvk.VkCleanable;
import net.skds.jvk.generated.VK10;

public record VkRenderPass(long device, long handle, VkRenderPassBuilder builder) implements VkCleanable {
	@Override
	public void vkClean(long pAllocator) {
		VK10.vkDestroyRenderPass(device, handle, pAllocator);
	}
}
