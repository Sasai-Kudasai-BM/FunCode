package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkSparseImageFormatProperties;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSparseImageMemoryRequirements extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSparseImageMemoryRequirements.class);

	@NativeType("VkSparseImageFormatProperties")
	public VkSparseImageFormatProperties formatProperties;

	@NativeType("uint32_t")
	public int imageMipTailFirstLod;

	@NativeType("VkDeviceSize")
	public long imageMipTailSize;

	@NativeType("VkDeviceSize")
	public long imageMipTailOffset;

	@NativeType("VkDeviceSize")
	public long imageMipTailStride;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}