package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMemoryType extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkMemoryType.class);

	/**
	* optional
	*/
	@NativeType("VkMemoryPropertyFlags")
	public int propertyFlags;

	@NativeType("uint32_t")
	public int heapIndex;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}