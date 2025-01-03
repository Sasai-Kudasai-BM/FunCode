package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBindIndexBufferIndirectCommandNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBindIndexBufferIndirectCommandNV.class);

	@NativeType("VkDeviceAddress")
	public long bufferAddress;

	@NativeType("uint32_t")
	public int size;

	@NativeType("VkIndexType")
	public int indexType;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}