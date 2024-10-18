package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoEncodeH264RateControlInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoEncodeH264RateControlInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int gopFrameCount;

	@NativeType("uint32_t")
	public int idrPeriod;

	@NativeType("uint32_t")
	public int consecutiveBFrameCount;

	@NativeType("VkVideoEncodeH264RateControlStructureFlagBitsEXT")
	public int rateControlStructure;

	@NativeType("uint8_t")
	public byte temporalLayerCount;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}