package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceAccelerationStructurePropertiesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceAccelerationStructurePropertiesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_PROPERTIES_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint64_t")
	public long maxGeometryCount;

	@NativeType("uint64_t")
	public long maxInstanceCount;

	@NativeType("uint64_t")
	public long maxPrimitiveCount;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorAccelerationStructures;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindAccelerationStructures;

	@NativeType("uint32_t")
	public int maxDescriptorSetAccelerationStructures;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindAccelerationStructures;

	@NativeType("uint32_t")
	public int minAccelerationStructureScratchOffsetAlignment;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}