package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkScreenSurfaceCreateInfoQNX extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkScreenSurfaceCreateInfoQNX.class);

	/**
	* values = VK_STRUCTURE_TYPE_SCREEN_SURFACE_CREATE_INFO_QNX
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkScreenSurfaceCreateFlagsQNX")
	public int flags;

	@NativeType("_screen_context**")
	public long context;

	@NativeType("_screen_window**")
	public long window;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}