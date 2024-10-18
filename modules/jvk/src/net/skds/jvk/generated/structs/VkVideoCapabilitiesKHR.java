package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkExtensionProperties;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoCapabilitiesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoCapabilitiesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_CAPABILITIES_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkVideoCapabilityFlagsKHR")
	public int capabilityFlags;

	@NativeType("VkDeviceSize")
	public long minBitstreamBufferOffsetAlignment;

	@NativeType("VkDeviceSize")
	public long minBitstreamBufferSizeAlignment;

	@NativeType("VkExtent2D")
	public VkExtent2D videoPictureExtentGranularity;

	@NativeType("VkExtent2D")
	public VkExtent2D minExtent;

	@NativeType("VkExtent2D")
	public VkExtent2D maxExtent;

	@NativeType("uint32_t")
	public int maxReferencePicturesSlotsCount;

	@NativeType("uint32_t")
	public int maxReferencePicturesActiveCount;

	@NativeType("VkExtensionProperties")
	public VkExtensionProperties stdHeaderVersion;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}