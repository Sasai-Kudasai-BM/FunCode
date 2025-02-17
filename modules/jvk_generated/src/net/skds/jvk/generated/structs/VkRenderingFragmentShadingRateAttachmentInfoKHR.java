package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRenderingFragmentShadingRateAttachmentInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRenderingFragmentShadingRateAttachmentInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_RENDERING_FRAGMENT_SHADING_RATE_ATTACHMENT_INFO_KHR
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
	@NativeType("VkImageView*")
	public long imageView;

	@NativeType("VkImageLayout")
	public int imageLayout;

	@NativeType("VkExtent2D")
	public VkExtent2D shadingRateAttachmentTexelSize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}