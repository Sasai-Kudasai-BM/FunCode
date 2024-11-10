package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFramebufferAttachmentImageInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkFramebufferAttachmentImageInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_FRAMEBUFFER_ATTACHMENT_IMAGE_INFO
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

	@NativeType("VkImageUsageFlags")
	public int usage;

	@NativeType("uint32_t")
	public int width;

	@NativeType("uint32_t")
	public int height;

	@NativeType("uint32_t")
	public int layerCount;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int viewFormatCount;

	@NativeType("VkFormat*")
	public long pViewFormats;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}