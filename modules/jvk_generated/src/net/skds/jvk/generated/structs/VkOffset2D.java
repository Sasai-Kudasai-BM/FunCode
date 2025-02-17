package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkOffset2D extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkOffset2D.class);

	@NativeType("int32_t")
	public int x;

	@NativeType("int32_t")
	public int y;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}