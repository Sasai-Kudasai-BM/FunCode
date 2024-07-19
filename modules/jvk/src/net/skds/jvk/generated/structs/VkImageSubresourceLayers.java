package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImageSubresourceLayers extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImageSubresourceLayers.class);

	@NativeType("VkImageAspectFlags")
	public int aspectMask;

	@NativeType("uint32_t")
	public int mipLevel;

	@NativeType("uint32_t")
	public int baseArrayLayer;

	@NativeType("uint32_t")
	public int layerCount;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}