package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBindBufferMemoryInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBindBufferMemoryInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_BIND_BUFFER_MEMORY_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBuffer*")
	public long buffer;

	@NativeType("VkDeviceMemory*")
	public long memory;

	@NativeType("VkDeviceSize")
	public long memoryOffset;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}