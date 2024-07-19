package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPresentInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPresentInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PRESENT_INFO_KHR
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

	@NativeType("uint32_t")
	public int swapchainCount;

	@NativeType("VkSwapchainKHR**")
	public long pSwapchains;

	@NativeType("uint32_t*")
	public long pImageIndices;

	/**
	* optional
	*/
	@NativeType("VkResult*")
	public long pResults;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}