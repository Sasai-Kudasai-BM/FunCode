package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceDepthStencilResolveProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceDepthStencilResolveProperties.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkResolveModeFlags")
	public int supportedDepthResolveModes;

	@NativeType("VkResolveModeFlags")
	public int supportedStencilResolveModes;

	@NativeType("VkBool32")
	public int independentResolveNone;

	@NativeType("VkBool32")
	public int independentResolve;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}