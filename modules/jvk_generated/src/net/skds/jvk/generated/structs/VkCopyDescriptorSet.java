package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkCopyDescriptorSet extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkCopyDescriptorSet.class);

	/**
	* values = VK_STRUCTURE_TYPE_COPY_DESCRIPTOR_SET
	*/
	@NativeType("VkStructureType")
	public int sType = 36;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDescriptorSet*")
	public long srcSet;

	@NativeType("uint32_t")
	public int srcBinding;

	@NativeType("uint32_t")
	public int srcArrayElement;

	@NativeType("VkDescriptorSet*")
	public long dstSet;

	@NativeType("uint32_t")
	public int dstBinding;

	@NativeType("uint32_t")
	public int dstArrayElement;

	@NativeType("uint32_t")
	public int descriptorCount;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}