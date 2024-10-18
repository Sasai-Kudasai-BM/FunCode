package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrExternalSemaphoreWin32 {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_IMPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_D3D12_FENCE_SUBMIT_INFO_KHR = 2;

	public static final int VK_STRUCTURE_TYPE_SEMAPHORE_GET_WIN32_HANDLE_INFO_KHR = 3;

	private static final MethodHandle vkImportSemaphoreWin32HandleKHR = createHandle("vkImportSemaphoreWin32HandleKHR", INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INVALID_EXTERNAL_HANDLE
	*/
	@NativeType("VkResult")
	public static int vkImportSemaphoreWin32HandleKHR(@NativeType("VkDevice*") long device, @NativeType("VkImportSemaphoreWin32HandleInfoKHR*") long pImportSemaphoreWin32HandleInfo) {
		try {
			return (int) vkImportSemaphoreWin32HandleKHR.invokeExact(device, pImportSemaphoreWin32HandleInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetSemaphoreWin32HandleKHR = createHandle("vkGetSemaphoreWin32HandleKHR", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_TOO_MANY_OBJECTS,VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetSemaphoreWin32HandleKHR(@NativeType("VkDevice*") long device, @NativeType("VkSemaphoreGetWin32HandleInfoKHR*") long pGetWin32HandleInfo, @NativeType("HANDLE**") long pHandle) {
		try {
			return (int) vkGetSemaphoreWin32HandleKHR.invokeExact(device, pGetWin32HandleInfo, pHandle);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}