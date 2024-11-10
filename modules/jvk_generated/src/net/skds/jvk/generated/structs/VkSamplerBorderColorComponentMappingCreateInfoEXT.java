package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.generated.structs.VkComponentMapping;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSamplerBorderColorComponentMappingCreateInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSamplerBorderColorComponentMappingCreateInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_SAMPLER_BORDER_COLOR_COMPONENT_MAPPING_CREATE_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkComponentMapping")
	public VkComponentMapping components;

	@NativeType("VkBool32")
	public int srgb;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}