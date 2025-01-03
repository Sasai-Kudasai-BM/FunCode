package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceRayTracingPipelinePropertiesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceRayTracingPipelinePropertiesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_PROPERTIES_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int shaderGroupHandleSize;

	@NativeType("uint32_t")
	public int maxRayRecursionDepth;

	@NativeType("uint32_t")
	public int maxShaderGroupStride;

	@NativeType("uint32_t")
	public int shaderGroupBaseAlignment;

	@NativeType("uint32_t")
	public int shaderGroupHandleCaptureReplaySize;

	@NativeType("uint32_t")
	public int maxRayDispatchInvocationCount;

	@NativeType("uint32_t")
	public int shaderGroupHandleAlignment;

	@NativeType("uint32_t")
	public int maxRayHitAttributeSize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}