package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFramebufferAttachmentsCreateInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkFramebufferAttachmentsCreateInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_FRAMEBUFFER_ATTACHMENTS_CREATE_INFO
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
	@NativeType("uint32_t")
	public int attachmentImageInfoCount;

	@NativeType("VkFramebufferAttachmentImageInfo*")
	public long pAttachmentImageInfos;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}