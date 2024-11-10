package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBufferCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBufferCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 12;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkBufferCreateFlags")
	public int flags;

	@NativeType("VkDeviceSize")
	public long size;

	@NativeType("VkBufferUsageFlags")
	public int usage;

	@NativeType("VkSharingMode")
	public int sharingMode;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int queueFamilyIndexCount;

	@NativeType("uint32_t*")
	public long pQueueFamilyIndices;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}