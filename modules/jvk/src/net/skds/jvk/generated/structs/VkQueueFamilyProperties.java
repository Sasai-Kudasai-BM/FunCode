package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkExtent3D;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkQueueFamilyProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkQueueFamilyProperties.class);

	/**
	* optional
	*/
	@NativeType("VkQueueFlags")
	public int queueFlags;

	@NativeType("uint32_t")
	public int queueCount;

	@NativeType("uint32_t")
	public int timestampValidBits;

	@NativeType("VkExtent3D")
	public VkExtent3D minImageTransferGranularity;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}