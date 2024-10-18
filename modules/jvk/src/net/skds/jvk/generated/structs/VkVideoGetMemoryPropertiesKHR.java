package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoGetMemoryPropertiesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoGetMemoryPropertiesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_GET_MEMORY_PROPERTIES_KHR
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

	@NativeType("VkMemoryRequirements2*")
	public long pMemoryRequirements;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}