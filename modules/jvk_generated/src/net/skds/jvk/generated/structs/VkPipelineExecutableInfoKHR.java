package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineExecutableInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineExecutableInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_INFO_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkPipeline*")
	public long pipeline;

	@NativeType("uint32_t")
	public int executableIndex;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}