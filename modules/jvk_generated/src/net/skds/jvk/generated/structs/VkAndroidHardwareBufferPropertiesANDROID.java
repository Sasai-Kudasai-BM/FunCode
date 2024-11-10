package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAndroidHardwareBufferPropertiesANDROID extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAndroidHardwareBufferPropertiesANDROID.class);

	/**
	* values = VK_STRUCTURE_TYPE_ANDROID_HARDWARE_BUFFER_PROPERTIES_ANDROID
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDeviceSize")
	public long allocationSize;

	@NativeType("uint32_t")
	public int memoryTypeBits;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}