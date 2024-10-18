package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.generated.structs.VkComponentMapping;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAndroidHardwareBufferFormatPropertiesANDROID extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAndroidHardwareBufferFormatPropertiesANDROID.class);

	/**
	* values = VK_STRUCTURE_TYPE_ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_ANDROID
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkFormat")
	public int format;

	@NativeType("uint64_t")
	public long externalFormat;

	@NativeType("VkFormatFeatureFlags")
	public int formatFeatures;

	@NativeType("VkComponentMapping")
	public VkComponentMapping samplerYcbcrConversionComponents;

	@NativeType("VkSamplerYcbcrModelConversion")
	public int suggestedYcbcrModel;

	@NativeType("VkSamplerYcbcrRange")
	public int suggestedYcbcrRange;

	@NativeType("VkChromaLocation")
	public int suggestedXChromaOffset;

	@NativeType("VkChromaLocation")
	public int suggestedYChromaOffset;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}