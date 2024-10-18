package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoDecodeH264SessionParametersCreateInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoDecodeH264SessionParametersCreateInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_DECODE_H264_SESSION_PARAMETERS_CREATE_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int maxSpsStdCount;

	@NativeType("uint32_t")
	public int maxPpsStdCount;

	/**
	* optional
	*/
	@NativeType("VkVideoDecodeH264SessionParametersAddInfoEXT*")
	public long pParametersAddInfo;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}