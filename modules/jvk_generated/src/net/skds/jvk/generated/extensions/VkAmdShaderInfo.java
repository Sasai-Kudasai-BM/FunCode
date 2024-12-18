package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAmdShaderInfo {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	private static final MethodHandle vkGetShaderInfoAMD = createHandle("vkGetShaderInfoAMD", INT, LONG, LONG, INT, INT, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_FEATURE_NOT_PRESENT,VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetShaderInfoAMD(@NativeType("VkDevice*") long device, @NativeType("VkPipeline*") long pipeline, @NativeType("VkShaderStageFlagBits") int shaderStage, @NativeType("VkShaderInfoTypeAMD") int infoType, @NativeType("size_t*") /*optional*/ long pInfoSize, @NativeType("void*") /*optional*/ long pInfo) {
		try {
			return (int) vkGetShaderInfoAMD.invokeExact(device, pipeline, shaderStage, infoType, pInfoSize, pInfo);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}