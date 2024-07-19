package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkExtent3D;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImageCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_IMAGE_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkImageCreateFlags")
	public int flags;

	@NativeType("VkImageType")
	public int imageType;

	@NativeType("VkFormat")
	public int format;

	@NativeType("VkExtent3D")
	public VkExtent3D extent;

	@NativeType("uint32_t")
	public int mipLevels;

	@NativeType("uint32_t")
	public int arrayLayers;

	@NativeType("VkSampleCountFlagBits")
	public int samples;

	@NativeType("VkImageTiling")
	public int tiling;

	@NativeType("VkImageUsageFlags")
	public int usage;

	@NativeType("VkSharingMode")
	public int sharingMode;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int queueFamilyIndexCount;

	@NativeType("uint32_t*")
	public long pQueueFamilyIndices;

	@NativeType("VkImageLayout")
	public int initialLayout;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}