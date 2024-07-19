package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDisplayModeParametersKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDisplayModeParametersKHR.class);

	@NativeType("VkExtent2D")
	public VkExtent2D visibleRegion;

	@NativeType("uint32_t")
	public int refreshRate;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}