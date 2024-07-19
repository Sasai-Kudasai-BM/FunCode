package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVertexInputBindingDivisorDescriptionEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVertexInputBindingDivisorDescriptionEXT.class);

	@NativeType("uint32_t")
	public int binding;

	@NativeType("uint32_t")
	public int divisor;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}