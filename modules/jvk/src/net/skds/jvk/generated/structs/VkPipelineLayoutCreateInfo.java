package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineLayoutCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineLayoutCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 30;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkPipelineLayoutCreateFlags")
	public int flags;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int setLayoutCount;

	/**
	* optional
	*/
	@NativeType("VkDescriptorSetLayout**")
	public long pSetLayouts;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int pushConstantRangeCount;

	@NativeType("VkPushConstantRange*")
	public long pPushConstantRanges;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}