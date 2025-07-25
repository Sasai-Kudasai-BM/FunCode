package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkKhrDeviceGroupCreation {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_GROUP_PROPERTIES_KHR = 1000070000;
	public static final int VK_STRUCTURE_TYPE_DEVICE_GROUP_DEVICE_CREATE_INFO_KHR = 1000070001;
	public static final int VK_MAX_DEVICE_GROUP_SIZE_KHR = 32;
	private static final MethodHandle vkEnumeratePhysicalDeviceGroupsKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkEnumeratePhysicalDeviceGroupsKHR", INT, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INITIALIZATION_FAILED
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkEnumeratePhysicalDeviceGroupsKHR(@NativeType("VkInstance*") long instance, /* optional */ @NativeType("uint32_t*") long pPhysicalDeviceGroupCount, /* optional */ @NativeType("VkPhysicalDeviceGroupProperties*") long pPhysicalDeviceGroupProperties) {
		try {
			return (int) vkEnumeratePhysicalDeviceGroupsKHR.invokeExact(instance, pPhysicalDeviceGroupCount, pPhysicalDeviceGroupProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	public static final int VK_MEMORY_HEAP_MULTI_INSTANCE_BIT_KHR = 2;
}