package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineColorBlendStateCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineColorBlendStateCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO
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
	@NativeType("VkPipelineColorBlendStateCreateFlags")
	public int flags;

	@NativeType("VkBool32")
	public int logicOpEnable;

	@NativeType("VkLogicOp")
	public int logicOp;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int attachmentCount;

	@NativeType("VkPipelineColorBlendAttachmentState*")
	public long pAttachments;

	@ArrayLength(16)
	@NativeType("float[16]")
	public float[] blendConstants;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}