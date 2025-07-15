package net.skds.jvk.vulkan;

import net.skds.jvk.VkDefinitions;
import net.skds.jvk.generated.structs.*;

import java.util.UUID;

public record VkDeviceInfo(
		long handle,
		int apiVersion,
		int driverVersion,
		int vendorId,
		int deviceId,
		int deviceType,
		String deviceName,
		UUID pipelineCacheUUID,
		VkPhysicalDeviceLimits limits,
		VkPhysicalDeviceSparseProperties sparseProperties,
		VkMemoryInfo memory
) {

	public static VkMemoryInfo getMemInfo(VkPhysicalDeviceMemoryProperties properties) {
		int memoryTypeCount = properties.memoryTypeCount();
		VkMemoryTypeInfo[] memTypes = new VkMemoryTypeInfo[memoryTypeCount];
		for (int j = 0; j < memoryTypeCount; j++) {
			VkMemoryType t = properties.memoryTypes(j);
			int heapIndex = t.heapIndex();
			VkMemoryHeap heap = properties.memoryHeaps(heapIndex);

			VkMemoryTypeInfo memType = new VkMemoryTypeInfo(j, heap.size(), t.propertyFlags(), heapIndex, heap.flags());
			memTypes[j] = memType;
		}
		return new VkMemoryInfo(properties.memoryHeapCount(), memTypes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("=============== Device =============");

		sb.append("\ndeviceID: ").append(deviceId);
		sb.append("\ndeviceType: ").append(deviceType);
		sb.append("\napiVersion: ").append(VkDefinitions.getVersion(apiVersion));

		sb.append("\ndriverVersion: ").append(Integer.toUnsignedString(driverVersion, 16));
		sb.append("\nvendorID: ").append(vendorId);
		sb.append("\npipelineCacheUUID: ").append(pipelineCacheUUID);
		sb.append("\ndeviceName: ").append(deviceName);

		sb.append("\n===========  Memory  ========= ");
		for (int j = 0; j < memory.memoryTypes().length; j++) {
			sb.append("\n").append(memory.memoryTypes()[j]);
		}

		//listDeviceExtensions(d);
		return sb.append("\n====================================").toString();
	}
}
