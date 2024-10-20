package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPresentTimeGOOGLE extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPresentTimeGOOGLE.class);

	@NativeType("uint32_t")
	public int presentID;

	@NativeType("uint64_t")
	public long desiredPresentTime;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}