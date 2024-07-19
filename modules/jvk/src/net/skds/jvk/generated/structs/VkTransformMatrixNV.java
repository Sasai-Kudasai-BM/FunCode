package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkTransformMatrixNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkTransformMatrixNV.class);

	@ArrayLength(12)
	@NativeType("float[12]")
	public float[] matrix;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}