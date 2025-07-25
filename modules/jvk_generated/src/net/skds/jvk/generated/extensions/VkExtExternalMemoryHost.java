package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkExtExternalMemoryHost {
	
	public static final int VK_STRUCTURE_TYPE_IMPORT_MEMORY_HOST_POINTER_INFO_EXT = 1000178000;
	public static final int VK_STRUCTURE_TYPE_MEMORY_HOST_POINTER_PROPERTIES_EXT = 1000178001;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_MEMORY_HOST_PROPERTIES_EXT = 1000178002;
	public static final int VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_ALLOCATION_BIT_EXT = 128;
	public static final int VK_EXTERNAL_MEMORY_HANDLE_TYPE_HOST_MAPPED_FOREIGN_MEMORY_BIT_EXT = 256;
	private static final MethodHandle vkGetMemoryHostPointerPropertiesEXT = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetMemoryHostPointerPropertiesEXT", INT, LONG, INT, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INVALID_EXTERNAL_HANDLE
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkGetMemoryHostPointerPropertiesEXT(@NativeType("VkDevice*") long device, @NativeType("VkExternalMemoryHandleTypeFlagBits") int handleType, @NativeType("void*") long pHostPointer, @NativeType("VkMemoryHostPointerPropertiesEXT*") long pMemoryHostPointerProperties) {
		try {
			return (int) vkGetMemoryHostPointerPropertiesEXT.invokeExact(device, handleType, pHostPointer, pMemoryHostPointerProperties);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}