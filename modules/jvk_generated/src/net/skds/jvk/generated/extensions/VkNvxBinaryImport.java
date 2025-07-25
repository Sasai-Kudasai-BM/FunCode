package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkNvxBinaryImport {
	
	public static final int VK_STRUCTURE_TYPE_CU_MODULE_CREATE_INFO_NVX = 1000029000;
	public static final int VK_STRUCTURE_TYPE_CU_FUNCTION_CREATE_INFO_NVX = 1000029001;
	public static final int VK_STRUCTURE_TYPE_CU_LAUNCH_INFO_NVX = 1000029002;
	public static final int VK_STRUCTURE_TYPE_CU_MODULE_TEXTURING_MODE_CREATE_INFO_NVX = 1000029004;
	public static final int VK_OBJECT_TYPE_CU_MODULE_NVX = 1000029000;
	public static final int VK_OBJECT_TYPE_CU_FUNCTION_NVX = 1000029001;
	private static final MethodHandle vkCreateCuModuleNVX = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateCuModuleNVX", INT, LONG, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INITIALIZATION_FAILED
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkCreateCuModuleNVX(@NativeType("VkDevice*") long device, @NativeType("VkCuModuleCreateInfoNVX*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkCuModuleNVX**") long pModule) {
		try {
			return (int) vkCreateCuModuleNVX.invokeExact(device, pCreateInfo, pAllocator, pModule);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCreateCuFunctionNVX = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateCuFunctionNVX", INT, LONG, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_INITIALIZATION_FAILED
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkCreateCuFunctionNVX(@NativeType("VkDevice*") long device, @NativeType("VkCuFunctionCreateInfoNVX*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkCuFunctionNVX**") long pFunction) {
		try {
			return (int) vkCreateCuFunctionNVX.invokeExact(device, pCreateInfo, pAllocator, pFunction);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkDestroyCuModuleNVX = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyCuModuleNVX", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkDestroyCuModuleNVX(@NativeType("VkDevice*") long device, @NativeType("VkCuModuleNVX*") long module, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyCuModuleNVX.invokeExact(device, module, pAllocator);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkDestroyCuFunctionNVX = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyCuFunctionNVX", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkDestroyCuFunctionNVX(@NativeType("VkDevice*") long device, @NativeType("VkCuFunctionNVX*") long function, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyCuFunctionNVX.invokeExact(device, function, pAllocator);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdCuLaunchKernelNVX = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdCuLaunchKernelNVX", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdCuLaunchKernelNVX(@NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkCuLaunchInfoNVX*") long pLaunchInfo) {
		try {
			vkCmdCuLaunchKernelNVX.invokeExact(commandBuffer, pLaunchInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	public static final int VK_DEBUG_REPORT_OBJECT_TYPE_CU_MODULE_NVX_EXT = 1000029000;
	public static final int VK_DEBUG_REPORT_OBJECT_TYPE_CU_FUNCTION_NVX_EXT = 1000029001;
}