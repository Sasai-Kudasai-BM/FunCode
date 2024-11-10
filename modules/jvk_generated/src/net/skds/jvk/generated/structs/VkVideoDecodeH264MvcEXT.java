package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoDecodeH264MvcEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoDecodeH264MvcEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_DECODE_H264_MVC_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("StdVideoDecodeH264Mvc*")
	public long pStdMvc;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}