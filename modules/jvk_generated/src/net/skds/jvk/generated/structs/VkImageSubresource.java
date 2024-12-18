package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageSubresource extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImageSubresource.class);

	@NativeType("VkImageAspectFlags")
	public int aspectMask;

	@NativeType("uint32_t")
	public int mipLevel;

	@NativeType("uint32_t")
	public int arrayLayer;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}