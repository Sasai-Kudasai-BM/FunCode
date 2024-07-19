package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMemoryHostPointerPropertiesEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkMemoryHostPointerPropertiesEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_MEMORY_HOST_POINTER_PROPERTIES_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int memoryTypeBits;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}