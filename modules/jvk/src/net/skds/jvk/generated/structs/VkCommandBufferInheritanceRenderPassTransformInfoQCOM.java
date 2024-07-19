package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkRect2D;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkCommandBufferInheritanceRenderPassTransformInfoQCOM extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkCommandBufferInheritanceRenderPassTransformInfoQCOM.class);

	/**
	* values = VK_STRUCTURE_TYPE_COMMAND_BUFFER_INHERITANCE_RENDER_PASS_TRANSFORM_INFO_QCOM
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

	@NativeType("VkRect2D")
	public VkRect2D renderArea;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}