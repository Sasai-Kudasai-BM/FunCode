package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrExternalMemoryFd {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_IMPORT_MEMORY_FD_INFO_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_MEMORY_FD_PROPERTIES_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_MEMORY_GET_FD_INFO_KHR = 2;

	private static final MethodHandle vkGetMemoryFdKHR = createHandle("vkGetMemoryFdKHR", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_TOO_MANY_OBJECTS,VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetMemoryFdKHR(@NativeType("VkDevice*") long device, @NativeType("VkMemoryGetFdInfoKHR*") long pGetFdInfo, @NativeType("int*") long pFd) {
		try {
			return (int) vkGetMemoryFdKHR.invokeExact(device, pGetFdInfo, pFd);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetMemoryFdPropertiesKHR = createHandle("vkGetMemoryFdPropertiesKHR", INT, LONG, INT, SHORT, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INVALID_EXTERNAL_HANDLE
	*/
	@NativeType("VkResult")
	public static int vkGetMemoryFdPropertiesKHR(@NativeType("VkDevice*") long device, @NativeType("VkExternalMemoryHandleTypeFlagBits") int handleType, @NativeType("int") short fd, @NativeType("VkMemoryFdPropertiesKHR*") long pMemoryFdProperties) {
		try {
			return (int) vkGetMemoryFdPropertiesKHR.invokeExact(device, handleType, fd, pMemoryFdProperties);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}