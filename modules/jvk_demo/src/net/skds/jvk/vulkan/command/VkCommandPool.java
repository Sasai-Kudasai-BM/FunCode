package net.skds.jvk.vulkan.command;

public record VkCommandPool(long handle, long device, VkCommandBuffer[] buffers) {
}
