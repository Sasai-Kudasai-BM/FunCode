package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoDecodeH265PictureInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoDecodeH265PictureInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_DECODE_H265_PICTURE_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("StdVideoDecodeH265PictureInfo*")
	public long pStdPictureInfo;

	@NativeType("uint32_t")
	public int slicesCount;

	@NativeType("uint32_t*")
	public long pSlicesDataOffsets;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}