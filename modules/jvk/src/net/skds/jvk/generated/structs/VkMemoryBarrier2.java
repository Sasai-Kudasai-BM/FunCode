package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMemoryBarrier2 extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkMemoryBarrier2.class);

	/**
	* values = VK_STRUCTURE_TYPE_MEMORY_BARRIER_2
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


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}