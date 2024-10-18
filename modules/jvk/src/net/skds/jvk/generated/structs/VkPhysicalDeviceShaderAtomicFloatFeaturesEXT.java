package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceShaderAtomicFloatFeaturesEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_FEATURES_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int shaderBufferFloat32Atomics;

	@NativeType("VkBool32")
	public int shaderBufferFloat32AtomicAdd;

	@NativeType("VkBool32")
	public int shaderBufferFloat64Atomics;

	@NativeType("VkBool32")
	public int shaderBufferFloat64AtomicAdd;

	@NativeType("VkBool32")
	public int shaderSharedFloat32Atomics;

	@NativeType("VkBool32")
	public int shaderSharedFloat32AtomicAdd;

	@NativeType("VkBool32")
	public int shaderSharedFloat64Atomics;

	@NativeType("VkBool32")
	public int shaderSharedFloat64AtomicAdd;

	@NativeType("VkBool32")
	public int shaderImageFloat32Atomics;

	@NativeType("VkBool32")
	public int shaderImageFloat32AtomicAdd;

	@NativeType("VkBool32")
	public int sparseImageFloat32Atomics;

	@NativeType("VkBool32")
	public int sparseImageFloat32AtomicAdd;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}