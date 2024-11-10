package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoDecodeH265SessionParametersAddInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoDecodeH265SessionParametersAddInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_DECODE_H265_SESSION_PARAMETERS_ADD_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int vpsStdCount;

	/**
	* optional
	*/
	@NativeType("StdVideoH265VideoParameterSet*")
	public long pVpsStd;

	@NativeType("uint32_t")
	public int spsStdCount;

	/**
	* optional
	*/
	@NativeType("StdVideoH265SequenceParameterSet*")
	public long pSpsStd;

	@NativeType("uint32_t")
	public int ppsStdCount;

	/**
	* optional
	*/
	@NativeType("StdVideoH265PictureParameterSet*")
	public long pPpsStd;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}