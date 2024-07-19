package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtDebugReport {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT = 0;

	// Backwards-compatible alias containing a typo

	/**
	* Backwards-compatible alias containing a typo
	*/
	public static final int VK_STRUCTURE_TYPE_DEBUG_REPORT_CREATE_INFO_EXT = 0;

	public static final int VK_ERROR_VALIDATION_FAILED_EXT = 1;

	public static final int VK_OBJECT_TYPE_DEBUG_REPORT_CALLBACK_EXT = 0;

	private static final MethodHandle vkCreateDebugReportCallbackEXT = createHandle("vkCreateDebugReportCallbackEXT", INT, LONG, LONG, LONG, LONG);

	/**
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY
	*/
	@NativeType("VkResult")
	public static int vkCreateDebugReportCallbackEXT(@NativeType("VkInstance*") long instance, @NativeType("VkDebugReportCallbackCreateInfoEXT*") long pCreateInfo, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator, @NativeType("VkDebugReportCallbackEXT**") long pCallback) {
		try {
			return (int) vkCreateDebugReportCallbackEXT.invokeExact(instance, pCreateInfo, pAllocator, pCallback);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkDestroyDebugReportCallbackEXT = createHandle("vkDestroyDebugReportCallbackEXT", VOID, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkDestroyDebugReportCallbackEXT(@NativeType("VkInstance*") long instance, @NativeType("VkDebugReportCallbackEXT*") /*optional, external sync*/ long callback, @NativeType("VkAllocationCallbacks*") /*optional*/ long pAllocator) {
		try {
			vkDestroyDebugReportCallbackEXT.invokeExact(instance, callback, pAllocator);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkDebugReportMessageEXT = createHandle("vkDebugReportMessageEXT", VOID, LONG, INT, INT, LONG, LONG, INT, LONG, LONG);

	@NativeType("void")
	public static void vkDebugReportMessageEXT(@NativeType("VkInstance*") long instance, @NativeType("VkDebugReportFlagsEXT") int flags, @NativeType("VkDebugReportObjectTypeEXT") int objectType, @NativeType("uint64_t") long object, @NativeType("size_t") long location, @NativeType("int32_t") int messageCode, @NativeType("char*") long pLayerPrefix, @NativeType("char*") long pMessage) {
		try {
			vkDebugReportMessageEXT.invokeExact(instance, flags, objectType, object, location, messageCode, pLayerPrefix, pMessage);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	// This duplicates definitions in other extensions, below

	public static final int VK_DEBUG_REPORT_OBJECT_TYPE_SAMPLER_YCBCR_CONVERSION_EXT = 0;

	public static final int VK_DEBUG_REPORT_OBJECT_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_EXT = 0;
}