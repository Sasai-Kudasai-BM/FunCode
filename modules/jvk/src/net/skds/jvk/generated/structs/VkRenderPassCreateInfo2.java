package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRenderPassCreateInfo2 extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRenderPassCreateInfo2.class);

	/**
	* values = VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO_2
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
	@NativeType("VkRenderPassCreateFlags")
	public int flags;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int attachmentCount;

	@NativeType("VkAttachmentDescription2*")
	public long pAttachments;

	@NativeType("uint32_t")
	public int subpassCount;

	@NativeType("VkSubpassDescription2*")
	public long pSubpasses;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int dependencyCount;

	@NativeType("VkSubpassDependency2*")
	public long pDependencies;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int correlatedViewMaskCount;

	@NativeType("uint32_t*")
	public long pCorrelatedViewMasks;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}