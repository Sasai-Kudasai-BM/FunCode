package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineColorBlendAttachmentState extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineColorBlendAttachmentState.class);

	@NativeType("VkBool32")
	public int blendEnable;

	@NativeType("VkBlendFactor")
	public int srcColorBlendFactor;

	@NativeType("VkBlendFactor")
	public int dstColorBlendFactor;

	@NativeType("VkBlendOp")
	public int colorBlendOp;

	@NativeType("VkBlendFactor")
	public int srcAlphaBlendFactor;

	@NativeType("VkBlendFactor")
	public int dstAlphaBlendFactor;

	@NativeType("VkBlendOp")
	public int alphaBlendOp;

	/**
	* optional
	*/
	@NativeType("VkColorComponentFlags")
	public int colorWriteMask;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}