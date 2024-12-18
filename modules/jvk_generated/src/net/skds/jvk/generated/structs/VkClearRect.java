package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkRect2D;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkClearRect extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkClearRect.class);

	@NativeType("VkRect2D")
	public VkRect2D rect;

	@NativeType("uint32_t")
	public int baseArrayLayer;

	@NativeType("uint32_t")
	public int layerCount;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}