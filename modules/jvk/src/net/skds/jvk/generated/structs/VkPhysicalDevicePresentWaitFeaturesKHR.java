package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDevicePresentWaitFeaturesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDevicePresentWaitFeaturesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_WAIT_FEATURES_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int presentWait;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}