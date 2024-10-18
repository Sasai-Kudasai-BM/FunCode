package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkFragmentShadingRateAttachmentInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkFragmentShadingRateAttachmentInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_FRAGMENT_SHADING_RATE_ATTACHMENT_INFO_KHR
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
	@NativeType("VkAttachmentReference2*")
	public long pFragmentShadingRateAttachment;

	@NativeType("VkExtent2D")
	public VkExtent2D shadingRateAttachmentTexelSize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}