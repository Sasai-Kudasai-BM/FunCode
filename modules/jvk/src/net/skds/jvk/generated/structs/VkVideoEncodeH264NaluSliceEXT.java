package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoEncodeH264NaluSliceEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoEncodeH264NaluSliceEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_NALU_SLICE_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int mbCount;

	/**
	* optional
	*/
	@NativeType("VkVideoEncodeH264ReferenceListsEXT*")
	public long pReferenceFinalLists;

	@NativeType("StdVideoEncodeH264SliceHeader*")
	public long pSliceHeaderStd;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}