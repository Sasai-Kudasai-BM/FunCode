package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImagePipeSurfaceCreateInfoFUCHSIA extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImagePipeSurfaceCreateInfoFUCHSIA.class);

	/**
	* values = VK_STRUCTURE_TYPE_IMAGEPIPE_SURFACE_CREATE_INFO_FUCHSIA
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
	@NativeType("VkImagePipeSurfaceCreateFlagsFUCHSIA")
	public int flags;

	@NativeType("zx_handle_t*")
	public long imagePipeHandle;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}