package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkRect2D;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDisplayPresentInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDisplayPresentInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_DISPLAY_PRESENT_INFO_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkRect2D")
	public VkRect2D srcRect;

	@NativeType("VkRect2D")
	public VkRect2D dstRect;

	@NativeType("VkBool32")
	public int persistent;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}