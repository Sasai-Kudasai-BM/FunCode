package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSemaphoreSubmitInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSemaphoreSubmitInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_SEMAPHORE_SUBMIT_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkSemaphore*")
	public long semaphore;

	@NativeType("uint64_t")
	public long value;

	/**
	* optional
	*/
	@NativeType("VkPipelineStageFlags2")
	public long stageMask;

	@NativeType("uint32_t")
	public int deviceIndex;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}