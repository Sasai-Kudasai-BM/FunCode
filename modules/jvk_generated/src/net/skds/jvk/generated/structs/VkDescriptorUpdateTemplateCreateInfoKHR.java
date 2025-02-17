package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDescriptorUpdateTemplateCreateInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDescriptorUpdateTemplateCreateInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO
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
	@NativeType("VkDescriptorUpdateTemplateCreateFlags")
	public int flags;

	@NativeType("uint32_t")
	public int descriptorUpdateEntryCount;

	@NativeType("VkDescriptorUpdateTemplateEntry*")
	public long pDescriptorUpdateEntries;

	@NativeType("VkDescriptorUpdateTemplateType")
	public int templateType;

	@NativeType("VkDescriptorSetLayout*")
	public long descriptorSetLayout;

	@NativeType("VkPipelineBindPoint")
	public int pipelineBindPoint;

	@NativeType("VkPipelineLayout*")
	public long pipelineLayout;

	@NativeType("uint32_t")
	public int set;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}