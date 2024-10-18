package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAcquireProfilingLockInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAcquireProfilingLockInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_ACQUIRE_PROFILING_LOCK_INFO_KHR
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
	@NativeType("VkAcquireProfilingLockFlagsKHR")
	public int flags;

	@NativeType("uint64_t")
	public long timeout;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}