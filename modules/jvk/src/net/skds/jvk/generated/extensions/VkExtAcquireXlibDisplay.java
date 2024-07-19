package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtAcquireXlibDisplay {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkAcquireXlibDisplayEXT = createHandle("vkAcquireXlibDisplayEXT", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INITIALIZATION_FAILED
	*/
	@NativeType("VkResult")
	public static int vkAcquireXlibDisplayEXT(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("Display**") long dpy, @NativeType("VkDisplayKHR*") long display) {
		try {
			return (int) vkAcquireXlibDisplayEXT.invokeExact(physicalDevice, dpy, display);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetRandROutputDisplayEXT = createHandle("vkGetRandROutputDisplayEXT", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetRandROutputDisplayEXT(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("Display**") long dpy, @NativeType("RROutput*") long rrOutput, @NativeType("VkDisplayKHR**") long pDisplay) {
		try {
			return (int) vkGetRandROutputDisplayEXT.invokeExact(physicalDevice, dpy, rrOutput, pDisplay);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}