package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkPhysicalDeviceProperties;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceProperties2 extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceProperties2.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PROPERTIES_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkPhysicalDeviceProperties")
	public VkPhysicalDeviceProperties properties;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}