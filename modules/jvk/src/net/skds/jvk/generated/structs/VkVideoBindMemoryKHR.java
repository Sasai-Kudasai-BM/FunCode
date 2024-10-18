package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoBindMemoryKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoBindMemoryKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_BIND_MEMORY_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int memoryBindIndex;

	@NativeType("VkDeviceMemory*")
	public long memory;

	@NativeType("VkDeviceSize")
	public long memoryOffset;

	@NativeType("VkDeviceSize")
	public long memorySize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}