package net.skds.jvk.vulkan;

import net.skds.jvk.generated.enums.VkMemoryHeapFlagBits;
import net.skds.jvk.generated.enums.VkMemoryPropertyFlagBits;
import net.skds.lib2.utils.SKDSUtils;

import java.util.StringJoiner;

public record VkMemoryTypeInfo(int id, long size, int flags, int heapId, int heapFlags) {

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(", ", "[", "]");
		StringJoiner heapJoiner = new StringJoiner(", ", "[", "]");

		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT) != 0) {
			joiner.add("DEVICE_LOCAL");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT) != 0) {
			joiner.add("HOST_VISIBLE");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_COHERENT_BIT) != 0) {
			joiner.add("HOST_COHERENT");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_CACHED_BIT) != 0) {
			joiner.add("HOST_CACHED");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_LAZILY_ALLOCATED_BIT) != 0) {
			joiner.add("LAZILY_ALLOCATED");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_PROTECTED_BIT) != 0) {
			joiner.add("PROPERTY_PROTECTED");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_DEVICE_COHERENT_BIT_AMD) != 0) {
			joiner.add("DEVICE_COHERENT_AMD");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_DEVICE_UNCACHED_BIT_AMD) != 0) {
			joiner.add("DEVICE_UNCACHED_AMD");
		}
		if ((flags & VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_RDMA_CAPABLE_BIT_NV) != 0) {
			joiner.add("RDMA_CAPABLE_NV");
		}

		if ((heapFlags & VkMemoryHeapFlagBits.VK_MEMORY_HEAP_DEVICE_LOCAL_BIT) != 0) {
			heapJoiner.add("DEVICE_LOCAL");
		}
		if ((heapFlags & VkMemoryHeapFlagBits.VK_MEMORY_HEAP_MULTI_INSTANCE_BIT) != 0) {
			heapJoiner.add("MULTI_INSTANCE");
		}
		if ((heapFlags & VkMemoryHeapFlagBits.VK_MEMORY_HEAP_TILE_MEMORY_BIT_QCOM) != 0) {
			heapJoiner.add("TILE_MEMORY_QCOM");
		}

		return "VkMemoryTypeInfo{" + "size: " + SKDSUtils.memoryCompact(size) +
				", id: " + id +
				", heapId: " + heapId +
				", flags: " + joiner +
				", heapFlags: " + heapJoiner +
				"}";
	}
}
