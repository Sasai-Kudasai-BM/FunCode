package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkImageFormatProperties;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageFormatProperties2 extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImageFormatProperties2.class);

	/**
	* values = VK_STRUCTURE_TYPE_IMAGE_FORMAT_PROPERTIES_2
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkImageFormatProperties")
	public VkImageFormatProperties imageFormatProperties;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}