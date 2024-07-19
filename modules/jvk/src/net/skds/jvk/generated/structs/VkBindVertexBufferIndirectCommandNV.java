package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBindVertexBufferIndirectCommandNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBindVertexBufferIndirectCommandNV.class);

	@NativeType("VkDeviceAddress")
	public long bufferAddress;

	@NativeType("uint32_t")
	public int size;

	@NativeType("uint32_t")
	public int stride;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}