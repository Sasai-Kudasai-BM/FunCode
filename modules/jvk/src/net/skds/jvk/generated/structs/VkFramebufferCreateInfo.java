package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFramebufferCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkFramebufferCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO
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
	@NativeType("VkFramebufferCreateFlags")
	public int flags;

	@NativeType("VkRenderPass*")
	public long renderPass;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int attachmentCount;

	@NativeType("VkImageView**")
	public long pAttachments;

	@NativeType("uint32_t")
	public int width;

	@NativeType("uint32_t")
	public int height;

	@NativeType("uint32_t")
	public int layers;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}