package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDescriptorUpdateTemplateEntry extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDescriptorUpdateTemplateEntry.class);

	@NativeType("uint32_t")
	public int dstBinding;

	@NativeType("uint32_t")
	public int dstArrayElement;

	@NativeType("uint32_t")
	public int descriptorCount;

	@NativeType("VkDescriptorType")
	public int descriptorType;

	@NativeType("size_t")
	public long offset;

	@NativeType("size_t")
	public long stride;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}