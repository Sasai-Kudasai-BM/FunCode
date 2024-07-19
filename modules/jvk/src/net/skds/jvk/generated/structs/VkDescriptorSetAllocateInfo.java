package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDescriptorSetAllocateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDescriptorSetAllocateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_DESCRIPTOR_SET_ALLOCATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDescriptorPool*")
	public long descriptorPool;

	@NativeType("uint32_t")
	public int descriptorSetCount;

	@NativeType("VkDescriptorSetLayout**")
	public long pSetLayouts;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}