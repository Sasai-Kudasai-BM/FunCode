package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBufferViewCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBufferViewCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_BUFFER_VIEW_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 13;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkBufferViewCreateFlags")
	public int flags;

	@NativeType("VkBuffer*")
	public long buffer;

	@NativeType("VkFormat")
	public int format;

	@NativeType("VkDeviceSize")
	public long offset;

	@NativeType("VkDeviceSize")
	public long range;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}