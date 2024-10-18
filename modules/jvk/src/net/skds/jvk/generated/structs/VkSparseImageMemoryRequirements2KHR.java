package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkSparseImageMemoryRequirements;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSparseImageMemoryRequirements2KHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSparseImageMemoryRequirements2KHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_SPARSE_IMAGE_MEMORY_REQUIREMENTS_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkSparseImageMemoryRequirements")
	public VkSparseImageMemoryRequirements memoryRequirements;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}