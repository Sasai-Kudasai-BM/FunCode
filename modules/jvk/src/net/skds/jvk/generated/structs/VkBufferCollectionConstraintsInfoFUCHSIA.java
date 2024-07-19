package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBufferCollectionConstraintsInfoFUCHSIA extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBufferCollectionConstraintsInfoFUCHSIA.class);

	/**
	* values = VK_STRUCTURE_TYPE_BUFFER_COLLECTION_CONSTRAINTS_INFO_FUCHSIA
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int minBufferCount;

	@NativeType("uint32_t")
	public int maxBufferCount;

	@NativeType("uint32_t")
	public int minBufferCountForCamping;

	@NativeType("uint32_t")
	public int minBufferCountForDedicatedSlack;

	@NativeType("uint32_t")
	public int minBufferCountForSharedSlack;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}