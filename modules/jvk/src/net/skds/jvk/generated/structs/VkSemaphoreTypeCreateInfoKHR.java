package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSemaphoreTypeCreateInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSemaphoreTypeCreateInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_SEMAPHORE_TYPE_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkSemaphoreType")
	public int semaphoreType;

	@NativeType("uint64_t")
	public long initialValue;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}