package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.jvk.generated.structs.VkOffset2D;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRectLayerKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRectLayerKHR.class);

	@NativeType("VkOffset2D")
	public VkOffset2D offset;

	@NativeType("VkExtent2D")
	public VkExtent2D extent;

	@NativeType("uint32_t")
	public int layer;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}