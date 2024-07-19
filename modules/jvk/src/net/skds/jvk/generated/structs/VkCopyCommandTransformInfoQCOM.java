package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkCopyCommandTransformInfoQCOM extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkCopyCommandTransformInfoQCOM.class);

	/**
	* values = VK_STRUCTURE_TYPE_COPY_COMMAND_TRANSFORM_INFO_QCOM
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkSurfaceTransformFlagBitsKHR")
	public int transform;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}