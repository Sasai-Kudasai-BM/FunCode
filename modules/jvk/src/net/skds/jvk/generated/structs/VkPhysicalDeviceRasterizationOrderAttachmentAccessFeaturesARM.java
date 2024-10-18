package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceRasterizationOrderAttachmentAccessFeaturesARM extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceRasterizationOrderAttachmentAccessFeaturesARM.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RASTERIZATION_ORDER_ATTACHMENT_ACCESS_FEATURES_ARM
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int rasterizationOrderColorAttachmentAccess;

	@NativeType("VkBool32")
	public int rasterizationOrderDepthAttachmentAccess;

	@NativeType("VkBool32")
	public int rasterizationOrderStencilAttachmentAccess;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}