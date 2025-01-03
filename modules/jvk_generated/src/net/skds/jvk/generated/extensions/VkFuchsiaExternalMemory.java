package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFuchsiaExternalMemory {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_IMPORT_MEMORY_ZIRCON_HANDLE_INFO_FUCHSIA = 0;

	public static final int VK_STRUCTURE_TYPE_MEMORY_ZIRCON_HANDLE_PROPERTIES_FUCHSIA = 1;

	public static final int VK_STRUCTURE_TYPE_MEMORY_GET_ZIRCON_HANDLE_INFO_FUCHSIA = 2;

	public static final int VK_EXTERNAL_MEMORY_HANDLE_TYPE_ZIRCON_VMO_BIT_FUCHSIA = 2048;

	private static final MethodHandle vkGetMemoryZirconHandleFUCHSIA = createHandle("vkGetMemoryZirconHandleFUCHSIA", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_TOO_MANY_OBJECTS,VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetMemoryZirconHandleFUCHSIA(@NativeType("VkDevice*") long device, @NativeType("VkMemoryGetZirconHandleInfoFUCHSIA*") long pGetZirconHandleInfo, @NativeType("zx_handle_t**") long pZirconHandle) {
		try {
			return (int) vkGetMemoryZirconHandleFUCHSIA.invokeExact(device, pGetZirconHandleInfo, pZirconHandle);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetMemoryZirconHandlePropertiesFUCHSIA = createHandle("vkGetMemoryZirconHandlePropertiesFUCHSIA", INT, LONG, INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_INVALID_EXTERNAL_HANDLE
	*/
	@NativeType("VkResult")
	public static int vkGetMemoryZirconHandlePropertiesFUCHSIA(@NativeType("VkDevice*") long device, @NativeType("VkExternalMemoryHandleTypeFlagBits") int handleType, @NativeType("zx_handle_t*") long zirconHandle, @NativeType("VkMemoryZirconHandlePropertiesFUCHSIA*") long pMemoryZirconHandleProperties) {
		try {
			return (int) vkGetMemoryZirconHandlePropertiesFUCHSIA.invokeExact(device, handleType, zirconHandle, pMemoryZirconHandleProperties);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}