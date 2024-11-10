package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceFloatControlsProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceFloatControlsProperties.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkShaderFloatControlsIndependence")
	public int denormBehaviorIndependence;

	@NativeType("VkShaderFloatControlsIndependence")
	public int roundingModeIndependence;

	@NativeType("VkBool32")
	public int shaderSignedZeroInfNanPreserveFloat16;

	@NativeType("VkBool32")
	public int shaderSignedZeroInfNanPreserveFloat32;

	@NativeType("VkBool32")
	public int shaderSignedZeroInfNanPreserveFloat64;

	@NativeType("VkBool32")
	public int shaderDenormPreserveFloat16;

	@NativeType("VkBool32")
	public int shaderDenormPreserveFloat32;

	@NativeType("VkBool32")
	public int shaderDenormPreserveFloat64;

	@NativeType("VkBool32")
	public int shaderDenormFlushToZeroFloat16;

	@NativeType("VkBool32")
	public int shaderDenormFlushToZeroFloat32;

	@NativeType("VkBool32")
	public int shaderDenormFlushToZeroFloat64;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTEFloat16;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTEFloat32;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTEFloat64;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTZFloat16;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTZFloat32;

	@NativeType("VkBool32")
	public int shaderRoundingModeRTZFloat64;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}