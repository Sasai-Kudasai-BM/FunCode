package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoEncodeH264VclFrameInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoEncodeH264VclFrameInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_VCL_FRAME_INFO_EXT
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
	@NativeType("VkVideoEncodeH264ReferenceListsEXT*")
	public long pReferenceFinalLists;

	@NativeType("uint32_t")
	public int naluSliceEntryCount;

	@NativeType("VkVideoEncodeH264NaluSliceEXT*")
	public long pNaluSliceEntries;

	@NativeType("StdVideoEncodeH264PictureInfo*")
	public long pCurrentPictureInfo;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}