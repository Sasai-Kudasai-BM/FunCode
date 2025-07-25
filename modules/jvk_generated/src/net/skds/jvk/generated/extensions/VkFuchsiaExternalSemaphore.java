package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkFuchsiaExternalSemaphore {
	
	public static final int VK_STRUCTURE_TYPE_IMPORT_SEMAPHORE_ZIRCON_HANDLE_INFO_FUCHSIA = 1000365000;
	public static final int VK_STRUCTURE_TYPE_SEMAPHORE_GET_ZIRCON_HANDLE_INFO_FUCHSIA = 1000365001;
	public static final int VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_ZIRCON_EVENT_BIT_FUCHSIA = 128;
	private static final MethodHandle vkImportSemaphoreZirconHandleFUCHSIA = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkImportSemaphoreZirconHandleFUCHSIA", INT, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INVALID_EXTERNAL_HANDLE
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkImportSemaphoreZirconHandleFUCHSIA(@NativeType("VkDevice*") long device, @NativeType("VkImportSemaphoreZirconHandleInfoFUCHSIA*") long pImportSemaphoreZirconHandleInfo) {
		try {
			return (int) vkImportSemaphoreZirconHandleFUCHSIA.invokeExact(device, pImportSemaphoreZirconHandleInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetSemaphoreZirconHandleFUCHSIA = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetSemaphoreZirconHandleFUCHSIA", INT, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_TOO_MANY_OBJECTS,VK_ERROR_OUT_OF_HOST_MEMORY
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkGetSemaphoreZirconHandleFUCHSIA(@NativeType("VkDevice*") long device, @NativeType("VkSemaphoreGetZirconHandleInfoFUCHSIA*") long pGetZirconHandleInfo, @NativeType("zx_handle_t**") long pZirconHandle) {
		try {
			return (int) vkGetSemaphoreZirconHandleFUCHSIA.invokeExact(device, pGetZirconHandleInfo, pZirconHandle);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}