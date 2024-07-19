package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRayTracingPipelineInterfaceCreateInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRayTracingPipelineInterfaceCreateInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_RAY_TRACING_PIPELINE_INTERFACE_CREATE_INFO_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int maxPipelineRayPayloadSize;

	@NativeType("uint32_t")
	public int maxPipelineRayHitAttributeSize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}