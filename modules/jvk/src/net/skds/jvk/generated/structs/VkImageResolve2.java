package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkOffset3D;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkExtent3D;
import net.skds.jvk.generated.structs.VkImageSubresourceLayers;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageResolve2 extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImageResolve2.class);

	/**
	* values = VK_STRUCTURE_TYPE_IMAGE_RESOLVE_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkImageSubresourceLayers")
	public VkImageSubresourceLayers srcSubresource;

	@NativeType("VkOffset3D")
	public VkOffset3D srcOffset;

	@NativeType("VkImageSubresourceLayers")
	public VkImageSubresourceLayers dstSubresource;

	@NativeType("VkOffset3D")
	public VkOffset3D dstOffset;

	@NativeType("VkExtent3D")
	public VkExtent3D extent;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}