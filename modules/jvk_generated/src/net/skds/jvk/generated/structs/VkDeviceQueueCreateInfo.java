package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDeviceQueueCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDeviceQueueCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 2;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkDeviceQueueCreateFlags")
	public int flags;

	@NativeType("uint32_t")
	public int queueFamilyIndex;

	@NativeType("uint32_t")
	public int queueCount;

	@NativeType("float*")
	public long pQueuePriorities;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}