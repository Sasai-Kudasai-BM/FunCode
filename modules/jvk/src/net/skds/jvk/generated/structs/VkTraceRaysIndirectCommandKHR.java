package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkTraceRaysIndirectCommandKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkTraceRaysIndirectCommandKHR.class);

	@NativeType("uint32_t")
	public int width;

	@NativeType("uint32_t")
	public int height;

	@NativeType("uint32_t")
	public int depth;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}