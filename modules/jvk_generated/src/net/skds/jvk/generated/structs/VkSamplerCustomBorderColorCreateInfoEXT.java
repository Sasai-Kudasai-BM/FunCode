package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSamplerCustomBorderColorCreateInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSamplerCustomBorderColorCreateInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_SAMPLER_CUSTOM_BORDER_COLOR_CREATE_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@ArrayLength(4)
	@NativeType("VkClearColorValue")
	public byte[] customBorderColor;

	@NativeType("VkFormat")
	public int format;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}