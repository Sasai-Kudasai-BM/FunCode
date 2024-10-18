package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceShaderIntegerFunctions2FeaturesINTEL extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceShaderIntegerFunctions2FeaturesINTEL.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_INTEGER_FUNCTIONS_2_FEATURES_INTEL
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int shaderIntegerFunctions2;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}