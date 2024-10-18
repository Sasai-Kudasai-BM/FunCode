package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMappedMemoryRange extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkMappedMemoryRange.class);

	/**
	* values = VK_STRUCTURE_TYPE_MAPPED_MEMORY_RANGE
	*/
	@NativeType("VkStructureType")
	public int sType = 6;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDeviceMemory*")
	public long memory;

	@NativeType("VkDeviceSize")
	public long offset;

	@NativeType("VkDeviceSize")
	public long size;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}