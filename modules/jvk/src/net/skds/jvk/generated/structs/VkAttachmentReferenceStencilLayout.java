package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAttachmentReferenceStencilLayout extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAttachmentReferenceStencilLayout.class);

	/**
	* values = VK_STRUCTURE_TYPE_ATTACHMENT_REFERENCE_STENCIL_LAYOUT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkImageLayout")
	public int stencilLayout;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}