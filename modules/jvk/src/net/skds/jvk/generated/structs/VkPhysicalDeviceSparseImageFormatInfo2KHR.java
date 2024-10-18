package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceSparseImageFormatInfo2KHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceSparseImageFormatInfo2KHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkFormat")
	public int format;

	@NativeType("VkImageType")
	public int type;

	@NativeType("VkSampleCountFlagBits")
	public int samples;

	@NativeType("VkImageUsageFlags")
	public int usage;

	@NativeType("VkImageTiling")
	public int tiling;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}