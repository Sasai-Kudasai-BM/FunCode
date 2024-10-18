package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMemoryRequirements extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkMemoryRequirements.class);

	@NativeType("VkDeviceSize")
	public long size;

	@NativeType("VkDeviceSize")
	public long alignment;

	@NativeType("uint32_t")
	public int memoryTypeBits;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}