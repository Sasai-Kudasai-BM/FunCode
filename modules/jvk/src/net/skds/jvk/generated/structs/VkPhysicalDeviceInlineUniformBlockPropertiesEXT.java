package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceInlineUniformBlockPropertiesEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceInlineUniformBlockPropertiesEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int maxInlineUniformBlockSize;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorInlineUniformBlocks;

	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks;

	@NativeType("uint32_t")
	public int maxDescriptorSetInlineUniformBlocks;

	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindInlineUniformBlocks;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}