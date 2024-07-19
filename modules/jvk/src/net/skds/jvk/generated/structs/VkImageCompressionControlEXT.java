package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageCompressionControlEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImageCompressionControlEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_IMAGE_COMPRESSION_CONTROL_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkImageCompressionFlagsEXT")
	public int flags;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int compressionControlPlaneCount;

	@NativeType("VkImageCompressionFixedRateFlagsEXT*")
	public long pFixedRateFlags;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}