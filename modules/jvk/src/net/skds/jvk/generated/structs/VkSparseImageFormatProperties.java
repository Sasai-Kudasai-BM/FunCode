package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkExtent3D;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSparseImageFormatProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSparseImageFormatProperties.class);

	/**
	* optional
	*/
	@NativeType("VkImageAspectFlags")
	public int aspectMask;

	@NativeType("VkExtent3D")
	public VkExtent3D imageGranularity;

	/**
	* optional
	*/
	@NativeType("VkSparseImageFormatFlags")
	public int flags;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}