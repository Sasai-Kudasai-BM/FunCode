package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrPerformanceQuery {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_QUERY_TYPE_PERFORMANCE_QUERY_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PERFORMANCE_QUERY_FEATURES_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PERFORMANCE_QUERY_PROPERTIES_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_QUERY_POOL_PERFORMANCE_CREATE_INFO_KHR = 2;

	public static final int VK_STRUCTURE_TYPE_PERFORMANCE_QUERY_SUBMIT_INFO_KHR = 3;

	public static final int VK_STRUCTURE_TYPE_ACQUIRE_PROFILING_LOCK_INFO_KHR = 4;

	public static final int VK_STRUCTURE_TYPE_PERFORMANCE_COUNTER_KHR = 5;

	public static final int VK_STRUCTURE_TYPE_PERFORMANCE_COUNTER_DESCRIPTION_KHR = 6;

	private static final MethodHandle vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR = createHandle("vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR", INT, LONG, INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INITIALIZATION_FAILED
	*/
	@NativeType("VkResult")
	public static int vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t") int queueFamilyIndex, @NativeType("uint32_t*") /*optional*/ long pCounterCount, @NativeType("VkPerformanceCounterKHR*") /*optional*/ long pCounters, @NativeType("VkPerformanceCounterDescriptionKHR*") /*optional*/ long pCounterDescriptions) {
		try {
			return (int) vkEnumeratePhysicalDeviceQueueFamilyPerformanceQueryCountersKHR.invokeExact(physicalDevice, queueFamilyIndex, pCounterCount, pCounters, pCounterDescriptions);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR = createHandle("vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR", VOID, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkQueryPoolPerformanceCreateInfoKHR*") long pPerformanceQueryCreateInfo, @NativeType("uint32_t*") long pNumPasses) {
		try {
			vkGetPhysicalDeviceQueueFamilyPerformanceQueryPassesKHR.invokeExact(physicalDevice, pPerformanceQueryCreateInfo, pNumPasses);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkAcquireProfilingLockKHR = createHandle("vkAcquireProfilingLockKHR", INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_TIMEOUT
	*/
	@NativeType("VkResult")
	public static int vkAcquireProfilingLockKHR(@NativeType("VkDevice*") long device, @NativeType("VkAcquireProfilingLockInfoKHR*") long pInfo) {
		try {
			return (int) vkAcquireProfilingLockKHR.invokeExact(device, pInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkReleaseProfilingLockKHR = createHandle("vkReleaseProfilingLockKHR", VOID, LONG);

	@NativeType("void")
	public static void vkReleaseProfilingLockKHR(@NativeType("VkDevice*") long device) {
		try {
			vkReleaseProfilingLockKHR.invokeExact(device);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}