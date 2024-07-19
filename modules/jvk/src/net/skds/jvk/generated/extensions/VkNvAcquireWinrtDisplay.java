package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkNvAcquireWinrtDisplay {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkAcquireWinrtDisplayNV = createHandle("vkAcquireWinrtDisplayNV", INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_DEVICE_LOST,VK_ERROR_INITIALIZATION_FAILED
	*/
	@NativeType("VkResult")
	public static int vkAcquireWinrtDisplayNV(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkDisplayKHR*") long display) {
		try {
			return (int) vkAcquireWinrtDisplayNV.invokeExact(physicalDevice, display);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetWinrtDisplayNV = createHandle("vkGetWinrtDisplayNV", INT, LONG, INT, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_DEVICE_LOST,VK_ERROR_INITIALIZATION_FAILED
	*/
	@NativeType("VkResult")
	public static int vkGetWinrtDisplayNV(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t") int deviceRelativeId, @NativeType("VkDisplayKHR**") long pDisplay) {
		try {
			return (int) vkGetWinrtDisplayNV.invokeExact(physicalDevice, deviceRelativeId, pDisplay);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}