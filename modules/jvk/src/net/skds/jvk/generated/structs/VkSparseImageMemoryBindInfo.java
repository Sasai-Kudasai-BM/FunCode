package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSparseImageMemoryBindInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSparseImageMemoryBindInfo.class);

	@NativeType("VkImage*")
	public long image;

	@NativeType("uint32_t")
	public int bindCount;

	@NativeType("VkSparseImageMemoryBind*")
	public long pBinds;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}