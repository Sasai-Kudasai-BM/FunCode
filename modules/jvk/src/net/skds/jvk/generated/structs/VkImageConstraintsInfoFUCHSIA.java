package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkBufferCollectionConstraintsInfoFUCHSIA;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageConstraintsInfoFUCHSIA extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImageConstraintsInfoFUCHSIA.class);

	/**
	* values = VK_STRUCTURE_TYPE_IMAGE_CONSTRAINTS_INFO_FUCHSIA
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int formatConstraintsCount;

	@NativeType("VkImageFormatConstraintsInfoFUCHSIA*")
	public long pFormatConstraints;

	@NativeType("VkBufferCollectionConstraintsInfoFUCHSIA")
	public VkBufferCollectionConstraintsInfoFUCHSIA bufferCollectionConstraints;

	/**
	* optional
	*/
	@NativeType("VkImageConstraintsInfoFlagsFUCHSIA")
	public int flags;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}