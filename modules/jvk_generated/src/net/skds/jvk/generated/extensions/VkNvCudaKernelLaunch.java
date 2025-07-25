package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkNvCudaKernelLaunch {
	
	public static final int VK_STRUCTURE_TYPE_CUDA_MODULE_CREATE_INFO_NV = 1000307000;
	public static final int VK_STRUCTURE_TYPE_CUDA_FUNCTION_CREATE_INFO_NV = 1000307001;
	public static final int VK_STRUCTURE_TYPE_CUDA_LAUNCH_INFO_NV = 1000307002;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CUDA_KERNEL_LAUNCH_FEATURES_NV = 1000307003;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CUDA_KERNEL_LAUNCH_PROPERTIES_NV = 1000307004;
	public static final int VK_OBJECT_TYPE_CUDA_MODULE_NV = 1000307000;
	public static final int VK_OBJECT_TYPE_CUDA_FUNCTION_NV = 1000307001;
	private static final MethodHandle vkCreateCudaModuleNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateCudaModuleNV", INT, LONG, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_INITIALIZATION_FAILED,VK_ERROR_OUT_OF_HOST_MEMORY
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkCreateCudaModuleNV(@NativeType("VkDevice*") long device, @NativeType("VkCudaModuleCreateInfoNV*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkCudaModuleNV**") long pModule) {
		try {
			return (int) vkCreateCudaModuleNV.invokeExact(device, pCreateInfo, pAllocator, pModule);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkGetCudaModuleCacheNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetCudaModuleCacheNV", INT, LONG, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS,VK_INCOMPLETE
	* errorcodes = VK_ERROR_INITIALIZATION_FAILED
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkGetCudaModuleCacheNV(@NativeType("VkDevice*") long device, @NativeType("VkCudaModuleNV*") long module, /* optional */ @NativeType("size_t*") long pCacheSize, /* optional */ @NativeType("void*") long pCacheData) {
		try {
			return (int) vkGetCudaModuleCacheNV.invokeExact(device, module, pCacheSize, pCacheData);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCreateCudaFunctionNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateCudaFunctionNV", INT, LONG, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_INITIALIZATION_FAILED,VK_ERROR_OUT_OF_HOST_MEMORY
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkCreateCudaFunctionNV(@NativeType("VkDevice*") long device, @NativeType("VkCudaFunctionCreateInfoNV*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkCudaFunctionNV**") long pFunction) {
		try {
			return (int) vkCreateCudaFunctionNV.invokeExact(device, pCreateInfo, pAllocator, pFunction);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkDestroyCudaModuleNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyCudaModuleNV", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkDestroyCudaModuleNV(@NativeType("VkDevice*") long device, @NativeType("VkCudaModuleNV*") long module, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyCudaModuleNV.invokeExact(device, module, pAllocator);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkDestroyCudaFunctionNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyCudaFunctionNV", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkDestroyCudaFunctionNV(@NativeType("VkDevice*") long device, @NativeType("VkCudaFunctionNV*") long function, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyCudaFunctionNV.invokeExact(device, function, pAllocator);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdCudaLaunchKernelNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdCudaLaunchKernelNV", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdCudaLaunchKernelNV(@NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkCudaLaunchInfoNV*") long pLaunchInfo) {
		try {
			vkCmdCudaLaunchKernelNV.invokeExact(commandBuffer, pLaunchInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	public static final int VK_DEBUG_REPORT_OBJECT_TYPE_CUDA_MODULE_NV_EXT = 1000307000;
	public static final int VK_DEBUG_REPORT_OBJECT_TYPE_CUDA_FUNCTION_NV_EXT = 1000307001;
}