package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFramebufferMixedSamplesCombinationNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkFramebufferMixedSamplesCombinationNV.class);

	/**
	* values = VK_STRUCTURE_TYPE_FRAMEBUFFER_MIXED_SAMPLES_COMBINATION_NV
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkCoverageReductionModeNV")
	public int coverageReductionMode;

	@NativeType("VkSampleCountFlagBits")
	public int rasterizationSamples;

	@NativeType("VkSampleCountFlags")
	public int depthStencilSamples;

	@NativeType("VkSampleCountFlags")
	public int colorSamples;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}