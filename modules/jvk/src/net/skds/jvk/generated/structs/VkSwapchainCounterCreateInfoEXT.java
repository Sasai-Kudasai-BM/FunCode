package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSwapchainCounterCreateInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSwapchainCounterCreateInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_SWAPCHAIN_COUNTER_CREATE_INFO_EXT
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
	@NativeType("VkSurfaceCounterFlagsEXT")
	public int surfaceCounters;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}