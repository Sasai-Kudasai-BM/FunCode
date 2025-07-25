package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkKhrPerformanceQuery {
	
	public static final int VK_QUERY_TYPE_PERFORMANCE_QUERY_KHR = 1000116000;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PERFORMANCE_QUERY_FEATURES_KHR = 1000116000;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PERFORMANCE_QUERY_PROPERTIES_KHR = 1000116001;
	public static final int VK_STRUCTURE_TYPE_QUERY_POOL_PERFORMANCE_CREATE_INFO_KHR = 1000116002;
	public static final int VK_STRUCTURE_TYPE_PERFORMANCE_QUERY_SUBMIT_INFO_KHR = 1000116003;
	public static final int VK_STRUCTURE_TYPE_ACQUIRE_PROFILING_LOCK_INFO_KHR = 1000116004;
	public static final int VK_STRUCTURE_TYPE_PERFORMANCE_COUNTER_KHR = 1000116005;
	public static final int VK_STRUCTURE_TYPE_PERFORMANCE_COUNTER_DESCRIPTION_KHR = 1000116006;
	private static final MethodHandle vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR", INT, LONG, INT, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INITIALIZATION_FAILED
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t") int queueFamilyIndex, /* optional */ @NativeType("uint32_t*") long pCounterCount, /* optional */ @NativeType("VkPerformanceCounterKHR*") long pCounters, /* optional */ @NativeType("VkPerformanceCounterDescriptionKHR*") long pCounterDescriptions) {
		try {
			return (int) vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR.invokeExact(physicalDevice, queueFamilyIndex, pCounterCount, pCounters, pCounterDescriptions);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkQueryPoolPerformanceCreateInfoKHR*") long pPerformanceQueryCreateInfo, @NativeType("uint32_t*") long pNumPasses) {
		try {
			vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR.invokeExact(physicalDevice, pPerformanceQueryCreateInfo, pNumPasses);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkAcquireProfilingLockKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkAcquireProfilingLockKHR", INT, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_TIMEOUT
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkAcquireProfilingLockKHR(@NativeType("VkDevice*") long device, @NativeType("VkAcquireProfilingLockInfoKHR*") long pInfo) {
		try {
			return (int) vkAcquireProfilingLockKHR.invokeExact(device, pInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkReleaseProfilingLockKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkReleaseProfilingLockKHR", VOID, LONG);
	
	@NativeType("void")
	public static void vkReleaseProfilingLockKHR(@NativeType("VkDevice*") long device) {
		try {
			vkReleaseProfilingLockKHR.invokeExact(device);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}