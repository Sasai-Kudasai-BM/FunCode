package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRayTracingShaderGroupCreateInfoNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRayTracingShaderGroupCreateInfoNV.class);

	/**
	* values = VK_STRUCTURE_TYPE_RAY_TRACING_SHADER_GROUP_CREATE_INFO_NV
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkRayTracingShaderGroupTypeKHR")
	public int type;

	@NativeType("uint32_t")
	public int generalShader;

	@NativeType("uint32_t")
	public int closestHitShader;

	@NativeType("uint32_t")
	public int anyHitShader;

	@NativeType("uint32_t")
	public int intersectionShader;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}