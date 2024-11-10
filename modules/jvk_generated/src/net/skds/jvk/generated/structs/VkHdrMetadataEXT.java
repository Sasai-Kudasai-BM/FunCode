package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkXYColorEXT;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkHdrMetadataEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkHdrMetadataEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_HDR_METADATA_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkXYColorEXT")
	public VkXYColorEXT displayPrimaryRed;

	@NativeType("VkXYColorEXT")
	public VkXYColorEXT displayPrimaryGreen;

	@NativeType("VkXYColorEXT")
	public VkXYColorEXT displayPrimaryBlue;

	@NativeType("VkXYColorEXT")
	public VkXYColorEXT whitePoint;

	@NativeType("float")
	public float maxLuminance;

	@NativeType("float")
	public float minLuminance;

	@NativeType("float")
	public float maxContentLightLevel;

	@NativeType("float")
	public float maxFrameAverageLightLevel;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}