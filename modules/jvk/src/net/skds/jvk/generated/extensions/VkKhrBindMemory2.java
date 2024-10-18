package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrBindMemory2 {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkBindBufferMemory2KHR = createHandle("vkBindBufferMemory2KHR", INT, LONG, INT, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_INVALID_OPAQUE_CAPTURE_ADDRESS_KHR
	*/
	@NativeType("VkResult")
	public static int vkBindBufferMemory2KHR(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int bindInfoCount, @NativeType("VkBindBufferMemoryInfo*") long pBindInfos) {
		try {
			return (int) vkBindBufferMemory2KHR.invokeExact(device, bindInfoCount, pBindInfos);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkBindImageMemory2KHR = createHandle("vkBindImageMemory2KHR", INT, LONG, INT, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkBindImageMemory2KHR(@NativeType("VkDevice*") long device, @NativeType("uint32_t") int bindInfoCount, @NativeType("VkBindImageMemoryInfo*") long pBindInfos) {
		try {
			return (int) vkBindImageMemory2KHR.invokeExact(device, bindInfoCount, pBindInfos);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	public static final int VK_STRUCTURE_TYPE_BIND_BUFFER_MEMORY_INFO_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_BIND_IMAGE_MEMORY_INFO_KHR = 1;

	public static final int VK_IMAGE_CREATE_ALIAS_BIT_KHR = 1024;
}