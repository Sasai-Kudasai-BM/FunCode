package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtDirectModeDisplay {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkReleaseDisplayEXT = createHandle("vkReleaseDisplayEXT", INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	*/
	@NativeType("VkResult")
	public static int vkReleaseDisplayEXT(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("VkDisplayKHR*") long display) {
		try {
			return (int) vkReleaseDisplayEXT.invokeExact(physicalDevice, display);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}