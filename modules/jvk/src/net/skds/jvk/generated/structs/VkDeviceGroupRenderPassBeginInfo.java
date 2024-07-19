package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDeviceGroupRenderPassBeginInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDeviceGroupRenderPassBeginInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_DEVICE_GROUP_RENDER_PASS_BEGIN_INFO
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int deviceMask;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int deviceRenderAreaCount;

	@NativeType("VkRect2D*")
	public long pDeviceRenderAreas;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}