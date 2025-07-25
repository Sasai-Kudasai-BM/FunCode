package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkKhrRayTracingMaintenance1 {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_MAINTENANCE_1_FEATURES_KHR = 1000386000;
	public static final int VK_QUERY_TYPE_ACCELERATION_STRUCTURE_SERIALIZATION_BOTTOM_LEVEL_POINTERS_KHR = 1000386000;
	public static final int VK_QUERY_TYPE_ACCELERATION_STRUCTURE_SIZE_KHR = 1000386001;
	public static final long VK_PIPELINE_STAGE_2_ACCELERATION_STRUCTURE_COPY_BIT_KHR = 268435456L;
	public static final long VK_ACCESS_2_SHADER_BINDING_TABLE_READ_BIT_KHR = 1099511627776L;
	private static final MethodHandle vkCmdTraceRaysIndirect2KHR = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdTraceRaysIndirect2KHR", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdTraceRaysIndirect2KHR(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkDeviceAddress") long indirectDeviceAddress) {
		try {
			vkCmdTraceRaysIndirect2KHR.invokeExact(commandBuffer, indirectDeviceAddress);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	public static final int VK_INDIRECT_COMMANDS_TOKEN_TYPE_TRACE_RAYS2_EXT = 1000386004;
}