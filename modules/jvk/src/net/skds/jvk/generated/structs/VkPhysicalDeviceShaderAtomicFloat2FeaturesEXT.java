package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int shaderBufferFloat16Atomics;

	@NativeType("VkBool32")
	public int shaderBufferFloat16AtomicAdd;

	@NativeType("VkBool32")
	public int shaderBufferFloat16AtomicMinMax;

	@NativeType("VkBool32")
	public int shaderBufferFloat32AtomicMinMax;

	@NativeType("VkBool32")
	public int shaderBufferFloat64AtomicMinMax;

	@NativeType("VkBool32")
	public int shaderSharedFloat16Atomics;

	@NativeType("VkBool32")
	public int shaderSharedFloat16AtomicAdd;

	@NativeType("VkBool32")
	public int shaderSharedFloat16AtomicMinMax;

	@NativeType("VkBool32")
	public int shaderSharedFloat32AtomicMinMax;

	@NativeType("VkBool32")
	public int shaderSharedFloat64AtomicMinMax;

	@NativeType("VkBool32")
	public int shaderImageFloat32AtomicMinMax;

	@NativeType("VkBool32")
	public int sparseImageFloat32AtomicMinMax;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}