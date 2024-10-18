package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSpecializationMapEntry extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSpecializationMapEntry.class);

	@NativeType("uint32_t")
	public int constantID;

	@NativeType("uint32_t")
	public int offset;

	@NativeType("size_t")
	public long size;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}