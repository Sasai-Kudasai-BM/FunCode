package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineRasterizationStateCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineRasterizationStateCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 23;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkPipelineRasterizationStateCreateFlags")
	public int flags;

	@NativeType("VkBool32")
	public int depthClampEnable;

	@NativeType("VkBool32")
	public int rasterizerDiscardEnable;

	@NativeType("VkPolygonMode")
	public int polygonMode;

	/**
	* optional
	*/
	@NativeType("VkCullModeFlags")
	public int cullMode;

	@NativeType("VkFrontFace")
	public int frontFace;

	@NativeType("VkBool32")
	public int depthBiasEnable;

	@NativeType("float")
	public float depthBiasConstantFactor;

	@NativeType("float")
	public float depthBiasClamp;

	@NativeType("float")
	public float depthBiasSlopeFactor;

	@NativeType("float")
	public float lineWidth;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}