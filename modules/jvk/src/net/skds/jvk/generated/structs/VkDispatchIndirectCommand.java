package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDispatchIndirectCommand extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDispatchIndirectCommand.class);

	@NativeType("uint32_t")
	public int x;

	@NativeType("uint32_t")
	public int y;

	@NativeType("uint32_t")
	public int z;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}