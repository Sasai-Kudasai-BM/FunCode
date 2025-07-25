package net.skds.jvk.generated.extensions;

import java.lang.invoke.MethodHandle;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;

import static net.skds.lib2.natives.LinkerUtils.*;

@AutoGenerated
public final class VkNvPartitionedAccelerationStructure {
	
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PARTITIONED_ACCELERATION_STRUCTURE_FEATURES_NV = 1000570000;
	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PARTITIONED_ACCELERATION_STRUCTURE_PROPERTIES_NV = 1000570001;
	public static final int VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET_PARTITIONED_ACCELERATION_STRUCTURE_NV = 1000570002;
	public static final int VK_STRUCTURE_TYPE_PARTITIONED_ACCELERATION_STRUCTURE_INSTANCES_INPUT_NV = 1000570003;
	public static final int VK_STRUCTURE_TYPE_BUILD_PARTITIONED_ACCELERATION_STRUCTURE_INFO_NV = 1000570004;
	public static final int VK_STRUCTURE_TYPE_PARTITIONED_ACCELERATION_STRUCTURE_FLAGS_NV = 1000570005;
	public static final int VK_DESCRIPTOR_TYPE_PARTITIONED_ACCELERATION_STRUCTURE_NV = 1000570000;
	public static final int VK_PARTITIONED_ACCELERATION_STRUCTURE_PARTITION_INDEX_GLOBAL_NV = 0;
	private static final MethodHandle vkGetPartitionedAccelerationStructuresBuildSizesNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkGetPartitionedAccelerationStructuresBuildSizesNV", VOID, LONG, LONG, LONG);
	
	@NativeType("void")
	public static void vkGetPartitionedAccelerationStructuresBuildSizesNV(@NativeType("VkDevice*") long device, @NativeType("VkPartitionedAccelerationStructureInstancesInputNV*") long pInfo, @NativeType("VkAccelerationStructureBuildSizesInfoKHR*") long pSizeInfo) {
		try {
			vkGetPartitionedAccelerationStructuresBuildSizesNV.invokeExact(device, pInfo, pSizeInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
	
	private static final MethodHandle vkCmdBuildPartitionedAccelerationStructuresNV = createHandle(VkDefinitions.LIBRARY_LOOKUP, "vkCmdBuildPartitionedAccelerationStructuresNV", VOID, LONG, LONG);
	
	@NativeType("void")
	public static void vkCmdBuildPartitionedAccelerationStructuresNV(/* external sync */ @NativeType("VkCommandBuffer*") long commandBuffer, @NativeType("VkBuildPartitionedAccelerationStructureInfoNV*") long pBuildInfo) {
		try {
			vkCmdBuildPartitionedAccelerationStructuresNV.invokeExact(commandBuffer, pBuildInfo);
		} catch (Throwable e) {
			throw new Error(e);
		}
	}
	
}