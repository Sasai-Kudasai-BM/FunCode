package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAttachmentDescription2KHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAttachmentDescription2KHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2
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
	@NativeType("VkAttachmentDescriptionFlags")
	public int flags;

	@NativeType("VkFormat")
	public int format;

	@NativeType("VkSampleCountFlagBits")
	public int samples;

	@NativeType("VkAttachmentLoadOp")
	public int loadOp;

	@NativeType("VkAttachmentStoreOp")
	public int storeOp;

	@NativeType("VkAttachmentLoadOp")
	public int stencilLoadOp;

	@NativeType("VkAttachmentStoreOp")
	public int stencilStoreOp;

	@NativeType("VkImageLayout")
	public int initialLayout;

	@NativeType("VkImageLayout")
	public int finalLayout;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}