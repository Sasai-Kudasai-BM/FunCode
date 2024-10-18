package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceImageDrmFormatModifierInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceImageDrmFormatModifierInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint64_t")
	public long drmFormatModifier;

	@NativeType("VkSharingMode")
	public int sharingMode;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int queueFamilyIndexCount;

	@NativeType("uint32_t*")
	public long pQueueFamilyIndices;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}