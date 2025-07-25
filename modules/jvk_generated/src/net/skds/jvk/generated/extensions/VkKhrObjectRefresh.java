package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkKhrObjectRefresh {
	
	public static final int VK_STRUCTURE_TYPE_REFRESH_OBJECT_LIST_KHR = 1000308000;
	private static final MethodHandle vkCmdRefreshObjectsKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdRefreshObjectsKHR", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdRefreshObjectsKHR(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkRefreshObjectListKHR*") long pRefreshObjects) {
		try {
			vkCmdRefreshObjectsKHR.invokeExact(commandBuffer, pRefreshObjects);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetPhysicalDeviceRefreshableObjectTypesKHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPhysicalDeviceRefreshableObjectTypesKHR", INT, LONG, LONG, LONG);
	
	/** successcodes = VK_SUCCESS,VK_INCOMPLETE **/
	@NativeType("VkResult")
	public static int vkGetPhysicalDeviceRefreshableObjectTypesKHR(@NativeType("VkPhysicalDevice*") long physicalDevice, /* optional */ @NativeType("uint32_t*") long pRefreshableObjectTypeCount, /* optional */ @NativeType("VkObjectType*") long pRefreshableObjectTypes) {
		try {
			return (int) vkGetPhysicalDeviceRefreshableObjectTypesKHR.invokeExact(physicalDevice, pRefreshableObjectTypeCount, pRefreshableObjectTypes);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}