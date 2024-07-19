package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkCoarseSampleLocationNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkCoarseSampleLocationNV.class);

	@NativeType("uint32_t")
	public int pixelX;

	@NativeType("uint32_t")
	public int pixelY;

	@NativeType("uint32_t")
	public int sample;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}