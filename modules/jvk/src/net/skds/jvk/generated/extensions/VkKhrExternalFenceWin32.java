package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrExternalFenceWin32 {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_IMPORT_FENCE_WIN32_HANDLE_INFO_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_EXPORT_FENCE_WIN32_HANDLE_INFO_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_FENCE_GET_WIN32_HANDLE_INFO_KHR = 2;

	private static final MethodHandle vkImportFenceWin32HandleKHR = createHandle("vkImportFenceWin32HandleKHR", INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INVALID_EXTERNAL_HANDLE
	*/
	@NativeType("VkResult")
	public static int vkImportFenceWin32HandleKHR(@NativeType("VkDevice*") long device, @NativeType("VkImportFenceWin32HandleInfoKHR*") long pImportFenceWin32HandleInfo) {
		try {
			return (int) vkImportFenceWin32HandleKHR.invokeExact(device, pImportFenceWin32HandleInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetFenceWin32HandleKHR = createHandle("vkGetFenceWin32HandleKHR", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_TOO_MANY_OBJECTS,VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetFenceWin32HandleKHR(@NativeType("VkDevice*") long device, @NativeType("VkFenceGetWin32HandleInfoKHR*") long pGetWin32HandleInfo, @NativeType("HANDLE**") long pHandle) {
		try {
			return (int) vkGetFenceWin32HandleKHR.invokeExact(device, pGetWin32HandleInfo, pHandle);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}