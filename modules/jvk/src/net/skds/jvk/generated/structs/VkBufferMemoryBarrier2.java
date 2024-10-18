package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBufferMemoryBarrier2 extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBufferMemoryBarrier2.class);

	/**
	* values = VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkPipelineStageFlags2")
	public long srcStageMask;

	/**
	* optional
	*/
	@NativeType("VkAccessFlags2")
	public long srcAccessMask;

	/**
	* optional
	*/
	@NativeType("VkPipelineStageFlags2")
	public long dstStageMask;

	/**
	* optional
	*/
	@NativeType("VkAccessFlags2")
	public long dstAccessMask;

	@NativeType("uint32_t")
	public int srcQueueFamilyIndex;

	@NativeType("uint32_t")
	public int dstQueueFamilyIndex;

	@NativeType("VkBuffer*")
	public long buffer;

	@NativeType("VkDeviceSize")
	public long offset;

	@NativeType("VkDeviceSize")
	public long size;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}