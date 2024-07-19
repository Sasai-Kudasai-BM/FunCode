package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkImageFormatProperties;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExternalImageFormatPropertiesNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkExternalImageFormatPropertiesNV.class);

	@NativeType("VkImageFormatProperties")
	public VkImageFormatProperties imageFormatProperties;

	/**
	* optional
	*/
	@NativeType("VkExternalMemoryFeatureFlagsNV")
	public int externalMemoryFeatures;

	/**
	* optional
	*/
	@NativeType("VkExternalMemoryHandleTypeFlagsNV")
	public int exportFromImportedHandleTypes;

	/**
	* optional
	*/
	@NativeType("VkExternalMemoryHandleTypeFlagsNV")
	public int compatibleHandleTypes;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}