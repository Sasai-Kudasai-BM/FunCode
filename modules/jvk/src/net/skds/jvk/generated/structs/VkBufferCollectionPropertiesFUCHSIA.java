package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkComponentMapping;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkSysmemColorSpaceFUCHSIA;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBufferCollectionPropertiesFUCHSIA extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBufferCollectionPropertiesFUCHSIA.class);

	/**
	* values = VK_STRUCTURE_TYPE_BUFFER_COLLECTION_PROPERTIES_FUCHSIA
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int memoryTypeBits;

	@NativeType("uint32_t")
	public int bufferCount;

	@NativeType("uint32_t")
	public int createInfoIndex;

	@NativeType("uint64_t")
	public long sysmemPixelFormat;

	@NativeType("VkFormatFeatureFlags")
	public int formatFeatures;

	@NativeType("VkSysmemColorSpaceFUCHSIA")
	public VkSysmemColorSpaceFUCHSIA sysmemColorSpaceIndex;

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