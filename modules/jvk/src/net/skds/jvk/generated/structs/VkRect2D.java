package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkOffset2D;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRect2D extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRect2D.class);

	@NativeType("VkOffset2D")
	public VkOffset2D offset;

	@NativeType("VkExtent2D")
	public VkExtent2D extent;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}