package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMvkMacosSurface {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_MACOS_SURFACE_CREATE_INFO_MVK = 0;

	private static final MethodHandle vkCreateMacOSSurfaceMVK = createHandle("vkCreateMacOSSurfaceMVK", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY,VK_ERROR_NATIVE_WINDOW_IN_USE_KHR
	*/
	@NativeType("VkResult")
	public static int vkCreateMacOSSurfaceMVK(@NativeType("VkInstance*") long instance, @NativeType("VkMacOSSurfaceCreateInfoMVK*") long pCreateInfo, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkSurfaceKHR**") long pSurface) {
		try {
			return (int) vkCreateMacOSSurfaceMVK.invokeExact(instance, pCreateInfo, pAllocator, pSurface);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}