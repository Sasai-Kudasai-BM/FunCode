package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSamplerReductionModeCreateInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSamplerReductionModeCreateInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_SAMPLER_REDUCTION_MODE_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkSamplerReductionMode")
	public int reductionMode;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}