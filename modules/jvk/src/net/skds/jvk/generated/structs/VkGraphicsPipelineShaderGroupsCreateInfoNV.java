package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkGraphicsPipelineShaderGroupsCreateInfoNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkGraphicsPipelineShaderGroupsCreateInfoNV.class);

	/**
	* values = VK_STRUCTURE_TYPE_GRAPHICS_PIPELINE_SHADER_GROUPS_CREATE_INFO_NV
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
	@NativeType("uint32_t")
	public int groupCount;

	@NativeType("VkGraphicsShaderGroupCreateInfoNV*")
	public long pGroups;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int pipelineCount;

	@NativeType("VkPipeline**")
	public long pPipelines;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}