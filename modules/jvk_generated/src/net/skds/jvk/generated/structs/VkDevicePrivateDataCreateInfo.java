package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDevicePrivateDataCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDevicePrivateDataCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_DEVICE_PRIVATE_DATA_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int privateDataSlotRequestCount;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}