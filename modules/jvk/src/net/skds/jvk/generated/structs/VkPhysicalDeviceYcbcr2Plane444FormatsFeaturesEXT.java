package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceYcbcr2Plane444FormatsFeaturesEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceYcbcr2Plane444FormatsFeaturesEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_YCBCR_2_PLANE_444_FORMATS_FEATURES_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int ycbcr2plane444Formats;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}