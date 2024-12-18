package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkAccelerationStructureInfoNV;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAccelerationStructureCreateInfoNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAccelerationStructureCreateInfoNV.class);

	/**
	* values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_CREATE_INFO_NV
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDeviceSize")
	public long compactedSize;

	@NativeType("VkAccelerationStructureInfoNV")
	public VkAccelerationStructureInfoNV info;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}