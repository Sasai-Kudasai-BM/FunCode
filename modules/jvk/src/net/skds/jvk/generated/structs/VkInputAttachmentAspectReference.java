package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkInputAttachmentAspectReference extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkInputAttachmentAspectReference.class);

	@NativeType("uint32_t")
	public int subpass;

	@NativeType("uint32_t")
	public int inputAttachmentIndex;

	@NativeType("VkImageAspectFlags")
	public int aspectMask;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}