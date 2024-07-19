package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoEncodeH264ReferenceListsEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoEncodeH264ReferenceListsEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_REFERENCE_LISTS_EXT
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
	@NativeType("uint8_t")
	public byte referenceList0EntryCount;

	@NativeType("VkVideoEncodeH264DpbSlotInfoEXT*")
	public long pReferenceList0Entries;

	/**
	* optional
	*/
	@NativeType("uint8_t")
	public byte referenceList1EntryCount;

	@NativeType("VkVideoEncodeH264DpbSlotInfoEXT*")
	public long pReferenceList1Entries;

	@NativeType("StdVideoEncodeH264RefMemMgmtCtrlOperations*")
	public long pMemMgmtCtrlOperations;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}