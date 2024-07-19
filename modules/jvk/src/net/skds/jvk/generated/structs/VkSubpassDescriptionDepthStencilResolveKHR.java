package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSubpassDescriptionDepthStencilResolveKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSubpassDescriptionDepthStencilResolveKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkResolveModeFlagBits")
	public int depthResolveMode;

	@NativeType("VkResolveModeFlagBits")
	public int stencilResolveMode;

	/**
	* optional
	*/
	@NativeType("VkAttachmentReference2*")
	public long pDepthStencilResolveAttachment;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}