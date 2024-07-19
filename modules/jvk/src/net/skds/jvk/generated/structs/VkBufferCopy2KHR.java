package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBufferCopy2KHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBufferCopy2KHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_BUFFER_COPY_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDeviceSize")
	public long srcOffset;

	@NativeType("VkDeviceSize")
	public long dstOffset;

	@NativeType("VkDeviceSize")
	public long size;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}