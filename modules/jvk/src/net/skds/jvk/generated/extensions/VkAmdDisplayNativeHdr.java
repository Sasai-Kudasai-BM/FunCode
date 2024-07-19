package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAmdDisplayNativeHdr {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_DISPLAY_NATIVE_HDR_SURFACE_CAPABILITIES_AMD = 0;

	public static final int VK_STRUCTURE_TYPE_SWAPCHAIN_DISPLAY_NATIVE_HDR_CREATE_INFO_AMD = 1;

	public static final int VK_COLOR_SPACE_DISPLAY_NATIVE_AMD = 0;

	private static final MethodHandle vkSetLocalDimmingAMD = createHandle("vkSetLocalDimmingAMD", VOID, LONG, LONG, INT);

	@NativeType("void")
	public static void vkSetLocalDimmingAMD(@NativeType("VkDevice*") long device, @NativeType("VkSwapchainKHR*") long swapChain, @NativeType("VkBool32") int localDimmingEnable) {
		try {
			vkSetLocalDimmingAMD.invokeExact(device, swapChain, localDimmingEnable);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}