package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineCreationFeedbackCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineCreationFeedbackCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_PIPELINE_CREATION_FEEDBACK_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkPipelineCreationFeedback*")
	public long pPipelineCreationFeedback;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int pipelineStageCreationFeedbackCount;

	@NativeType("VkPipelineCreationFeedback*")
	public long pPipelineStageCreationFeedbacks;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}