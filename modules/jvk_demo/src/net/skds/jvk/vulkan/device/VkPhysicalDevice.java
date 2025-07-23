package net.skds.jvk.vulkan.device;

import net.skds.jvk.VkDefinitions;
import net.skds.jvk.generated.enums.VkPhysicalDeviceType;
import net.skds.jvk.generated.structs.*;
import net.skds.jvk.vulkan.device.memory.VkMemoryInfo;
import net.skds.jvk.vulkan.device.memory.VkMemoryTypeInfo;
import net.skds.jvk.vulkan.support.VkExtension;

import java.util.Map;
import java.util.UUID;

public record VkPhysicalDevice(
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
		VkMemoryInfo memory,
		VkQueueFamilyInfo[] queues,
		Map<String, VkExtension> extensions
) {

	public int selectOptimalMemoryType(int flags) {
		VkMemoryTypeInfo[] mts = memory.memoryTypes();
		for (int i = 0; i < mts.length; i++) {
			VkMemoryTypeInfo type = mts[i];
			if ((type.flags() & flags) == flags) {
				return i;
			}
		}
		return -1;
	}

	public int selectOptimalQueueFamily(int includeFlags, int excludeFlags, int count) {
		for (int i = 0; i < queues.length; i++) {
			VkQueueFamilyInfo type = queues[i];
			int f = type.queueFlags();
			if ((f & includeFlags) == includeFlags && (f & excludeFlags) == 0 && f >= count) {
				return i;
			}
		}
		return -1;
	}

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
		StringBuilder sb = new StringBuilder("\n=============== Device =============");

		sb.append("\ndeviceName: ").append(deviceName);
		sb.append("\napiVersion: ").append(VkDefinitions.getVersion(apiVersion));
		String type = switch (deviceType) {
			case VkPhysicalDeviceType.VK_PHYSICAL_DEVICE_TYPE_OTHER -> "OTHER";
			case VkPhysicalDeviceType.VK_PHYSICAL_DEVICE_TYPE_INTEGRATED_GPU -> "INTEGRATED_GPU";
			case VkPhysicalDeviceType.VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU -> "DISCRETE_GPU";
			case VkPhysicalDeviceType.VK_PHYSICAL_DEVICE_TYPE_VIRTUAL_GPU -> "VIRTUAL_GPU";
			case VkPhysicalDeviceType.VK_PHYSICAL_DEVICE_TYPE_CPU -> "CPU";
			default -> "UNKNOWN";
		};
		sb.append("\ndeviceType: ").append(type);
		sb.append("\ndeviceID: ").append(deviceId);
		sb.append("\ndriverVersion: ").append(Integer.toUnsignedString(driverVersion, 16));
		sb.append("\nvendorID: ").append(vendorId);
		sb.append("\npipelineCacheUUID: ").append(pipelineCacheUUID);

		sb.append("\n===========  Memory  =========");
		for (int j = 0; j < memory.memoryTypes().length; j++) {
			if (memory.memoryTypes()[j].flags() == 0) continue;
			sb.append("\n").append(memory.memoryTypes()[j]);
		}
		sb.append("\n=======  Queue Families  ======");
		for (int j = 0; j < queues.length; j++) {
			sb.append("\n").append(queues[j]);
		}
		sb.append("\n========  Extensions  ========\n");
		int n = 0;
		for (var ext : extensions.keySet()) {
			sb.append(ext).append(" \t");
			if (++n % 4 == 0) {
				sb.append("\n");
			}
		}

		//listDeviceExtensions(d);
		return sb.append("\n====================================").toString();
	}
}
