package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMultiDrawIndexedInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkMultiDrawIndexedInfoEXT.class);

	@NativeType("uint32_t")
	public int firstIndex;

	@NativeType("uint32_t")
	public int indexCount;

	@NativeType("int32_t")
	public int vertexOffset;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}