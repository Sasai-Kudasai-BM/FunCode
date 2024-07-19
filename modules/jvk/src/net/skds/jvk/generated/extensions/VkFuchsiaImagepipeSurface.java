package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFuchsiaImagepipeSurface {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_IMAGEPIPE_SURFACE_CREATE_INFO_FUCHSIA = 0;

	private static final MethodHandle vkCreateImagePipeSurfaceFUCHSIA = createHandle("vkCreateImagePipeSurfaceFUCHSIA", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkCreateImagePipeSurfaceFUCHSIA(@NativeType("VkInstance*") long instance, @NativeType("VkImagePipeSurfaceCreateInfoFUCHSIA*") long pCreateInfo, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkSurfaceKHR**") long pSurface) {
		try {
			return (int) vkCreateImagePipeSurfaceFUCHSIA.invokeExact(instance, pCreateInfo, pAllocator, pSurface);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}