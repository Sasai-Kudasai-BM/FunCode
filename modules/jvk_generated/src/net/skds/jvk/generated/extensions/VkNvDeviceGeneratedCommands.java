package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkNvDeviceGeneratedCommands {
	
	/*
	
	                    This extension requires buffer_device_address functionality.
	                    VK_EXT_buffer_device_address is also acceptable, but since it is deprecated the KHR version is preferred.
	                
	*/
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_NV = 1000277000;
	public static final int VK_STRUCTURE_TYPE_GRAPHICS_SHADER_GROUP_CREATE_INFO_NV = 1000277001;
	public static final int VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_SHADER_GROUPS_CREATE_INFO_NV = 1000277002;
	public static final int VK_STRUCTURE_TYPE_INDIRECT_COMMANDS_LAYOUT_TOKEN_NV = 1000277003;
	public static final int VK_STRUCTURE_TYPE_INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NV = 1000277004;
	public static final int VK_STRUCTURE_TYPE_GENERATED_COMMANDS_INFO_NV = 1000277005;
	public static final int VK_STRUCTURE_TYPE_GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_NV = 1000277006;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_FEATURES_NV = 1000277007;
	public static final int VK_PIPELINE_CREATE_INDIRECT_BINDABLE_BIT_NV = 262144;
	public static final int VK_PIPELINE_STAGE_COMMAND_PREPROCESS_BIT_NV = 131072;
	public static final int VK_ACCESS_COMMAND_PREPROCESS_READ_BIT_NV = 131072;
	public static final int VK_ACCESS_COMMAND_PREPROCESS_WRITE_BIT_NV = 262144;
	public static final int VK_OBJECT_TYPE_INDIRECT_COMMANDS_LAYOUT_NV = 1000277000;
	private static final MethodHandle vkGetGeneratedCommandsMemoryRequirementsNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetGeneratedCommandsMemoryRequirementsNV", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetGeneratedCommandsMemoryRequirementsNV(@NativeType("VkDevice*") long device, @NativeType("VkGeneratedCommandsMemoryRequirementsInfoNV*") long pInfo, @NativeType("VkMemoryRequirements2*") long pMemoryRequirements) {
		try {
			vkGetGeneratedCommandsMemoryRequirementsNV.invokeExact(device, pInfo, pMemoryRequirements);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdPreprocessGeneratedCommandsNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdPreprocessGeneratedCommandsNV", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdPreprocessGeneratedCommandsNV(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkGeneratedCommandsInfoNV*") long pGeneratedCommandsInfo) {
		try {
			vkCmdPreprocessGeneratedCommandsNV.invokeExact(commandBuffer, pGeneratedCommandsInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdExecuteGeneratedCommandsNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdExecuteGeneratedCommandsNV", VOID, LONG, BOOLEAN, LONG);
	
	@NativeType("void")
	public static void vkCmdExecuteGeneratedCommandsNV(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBool32") boolean isPreprocessed, @NativeType("VkGeneratedCommandsInfoNV*") long pGeneratedCommandsInfo) {
		try {
			vkCmdExecuteGeneratedCommandsNV.invokeExact(commandBuffer, isPreprocessed ? (int) 1 : (int) 0, pGeneratedCommandsInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdBindPipelineShaderGroupNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBindPipelineShaderGroupNV", VOID, LONG, INT, LONG, INT);
	
	@NativeType("void")
	public static void vkCmdBindPipelineShaderGroupNV(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkPipelineBindPoint") int pipelineBindPoint, @NativeType("VkPipeline*") long pipeline, @NativeType("uint32_t") int groupIndex) {
		try {
			vkCmdBindPipelineShaderGroupNV.invokeExact(commandBuffer, pipelineBindPoint, pipeline, groupIndex);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCreateIndirectCommandsLayoutNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCreateIndirectCommandsLayoutNV", INT, LONG, LONG, LONG, LONG);
	
	/**
	*<pre>
	* successcodes = VK_SUCCESS
	* errorcodes = VK_ERROR_OUT_OF_HOST_MEMORY,VK_ERROR_OUT_OF_DEVICE_MEMORY
	*</pre>
	**/
	@NativeType("VkResult")
	public static int vkCreateIndirectCommandsLayoutNV(@NativeType("VkDevice*") long device, @NativeType("VkIndirectCommandsLayoutCreateInfoNV*") long pCreateInfo, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator, @NativeType("VkIndirectCommandsLayoutNV**") long pIndirectCommandsLayout) {
		try {
			return (int) vkCreateIndirectCommandsLayoutNV.invokeExact(device, pCreateInfo, pAllocator, pIndirectCommandsLayout);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkDestroyIndirectCommandsLayoutNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkDestroyIndirectCommandsLayoutNV", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkDestroyIndirectCommandsLayoutNV(@NativeType("VkDevice*") long device, /* optional, external sync */ @NativeType("VkIndirectCommandsLayoutNV*") long indirectCommandsLayout, /* optional */ @NativeType("VkAllocationCallbacks*") long pAllocator) {
		try {
			vkDestroyIndirectCommandsLayoutNV.invokeExact(device, indirectCommandsLayout, pAllocator);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}