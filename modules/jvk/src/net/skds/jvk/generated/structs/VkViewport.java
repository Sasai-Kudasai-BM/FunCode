package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkViewport extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkViewport.class);

	@NativeType("float")
	public float x;

	@NativeType("float")
	public float y;

	@NativeType("float")
	public float width;

	@NativeType("float")
	public float height;

	@NativeType("float")
	public float minDepth;

	@NativeType("float")
	public float maxDepth;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}