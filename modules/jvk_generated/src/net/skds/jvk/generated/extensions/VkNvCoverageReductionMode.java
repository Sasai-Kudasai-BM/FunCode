package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkNvCoverageReductionMode {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_COVERAGE_REDUCTION_MODE_FEATURES_NV = 0;

	public static final int VK_STRUCTURE_TYPE_PIPELINE_COVERAGE_REDUCTION_STATE_CREATE_INFO_NV = 1;

	public static final int VK_STRUCTURE_TYPE_FRAMEBUFFER_MIXED_SAMPLES_COMBINATION_NV = 2;

	private static final MethodHandle vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV = createHandle("vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV", INT, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV(@NativeType("VkPhysicalDevice*") long physicalDevice, @NativeType("uint32_t*") /*optional*/ long pCombinationCount, @NativeType("VkFramebufferMixedSamplesCombinationNV*") /*optional*/ long pCombinations) {
		try {
			return (int) vkGetPhysicalDeviceSupportedFramebufferMixedSamplesCombinationsNV.invokeExact(physicalDevice, pCombinationCount, pCombinations);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}