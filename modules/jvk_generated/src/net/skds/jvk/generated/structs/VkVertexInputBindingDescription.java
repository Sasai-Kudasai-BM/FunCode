package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVertexInputBindingDescription extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVertexInputBindingDescription.class);

	@NativeType("uint32_t")
	public int binding;

	@NativeType("uint32_t")
	public int stride;

	@NativeType("VkVertexInputRate")
	public int inputRate;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}