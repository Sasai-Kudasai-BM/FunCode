package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDrawIndexedIndirectCommand extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDrawIndexedIndirectCommand.class);

	@NativeType("uint32_t")
	public int indexCount;

	@NativeType("uint32_t")
	public int instanceCount;

	@NativeType("uint32_t")
	public int firstIndex;

	@NativeType("int32_t")
	public int vertexOffset;

	@NativeType("uint32_t")
	public int firstInstance;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}