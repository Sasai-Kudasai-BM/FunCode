package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSubmitInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSubmitInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_SUBMIT_INFO
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
	@NativeType("uint32_t")
	public int waitSemaphoreCount;

	@NativeType("VkSemaphore**")
	public long pWaitSemaphores;

	@NativeType("VkPipelineStageFlags*")
	public long pWaitDstStageMask;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int commandBufferCount;

	@NativeType("VkCommandBuffer**")
	public long pCommandBuffers;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int signalSemaphoreCount;

	@NativeType("VkSemaphore**")
	public long pSignalSemaphores;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}