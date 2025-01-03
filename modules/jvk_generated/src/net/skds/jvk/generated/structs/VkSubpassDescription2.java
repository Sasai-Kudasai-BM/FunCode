package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSubpassDescription2 extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSubpassDescription2.class);

	/**
	* values = VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_2
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
	@NativeType("VkSubpassDescriptionFlags")
	public int flags;

	@NativeType("VkPipelineBindPoint")
	public int pipelineBindPoint;

	@NativeType("uint32_t")
	public int viewMask;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int inputAttachmentCount;

	@NativeType("VkAttachmentReference2*")
	public long pInputAttachments;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int colorAttachmentCount;

	@NativeType("VkAttachmentReference2*")
	public long pColorAttachments;

	/**
	* optional
	*/
	@NativeType("VkAttachmentReference2*")
	public long pResolveAttachments;

	/**
	* optional
	*/
	@NativeType("VkAttachmentReference2*")
	public long pDepthStencilAttachment;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int preserveAttachmentCount;

	@NativeType("uint32_t*")
	public long pPreserveAttachments;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}