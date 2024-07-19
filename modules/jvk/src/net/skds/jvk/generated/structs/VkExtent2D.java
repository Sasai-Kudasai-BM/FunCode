package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtent2D extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkExtent2D.class);

	@NativeType("uint32_t")
	public int width;

	@NativeType("uint32_t")
	public int height;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}