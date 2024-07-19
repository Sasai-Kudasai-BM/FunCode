package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBlitImageInfo2KHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBlitImageInfo2KHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_BLIT_IMAGE_INFO_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkImage*")
	public long srcImage;

	@NativeType("VkImageLayout")
	public int srcImageLayout;

	@NativeType("VkImage*")
	public long dstImage;

	@NativeType("VkImageLayout")
	public int dstImageLayout;

	@NativeType("uint32_t")
	public int regionCount;

	@NativeType("VkImageBlit2*")
	public long pRegions;

	@NativeType("VkFilter")
	public int filter;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}