package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSemaphoreSignalInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSemaphoreSignalInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_SEMAPHORE_SIGNAL_INFO
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


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}