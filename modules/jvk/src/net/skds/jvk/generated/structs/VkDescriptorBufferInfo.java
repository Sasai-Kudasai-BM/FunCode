package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDescriptorBufferInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDescriptorBufferInfo.class);

	/**
	* optional
	*/
	@NativeType("VkBuffer*")
	public long buffer;

	@NativeType("VkDeviceSize")
	public long offset;

	@NativeType("VkDeviceSize")
	public long range;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}