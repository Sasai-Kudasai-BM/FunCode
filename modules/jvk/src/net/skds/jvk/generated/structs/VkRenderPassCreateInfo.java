package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRenderPassCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRenderPassCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 38;

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

	@NativeType("VkAttachmentDescription*")
	public long pAttachments;

	@NativeType("uint32_t")
	public int subpassCount;

	@NativeType("VkSubpassDescription*")
	public long pSubpasses;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int dependencyCount;

	@NativeType("VkSubpassDependency*")
	public long pDependencies;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}