package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDevice8BitStorageFeatures extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDevice8BitStorageFeatures.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_8BIT_STORAGE_FEATURES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int storageBuffer8BitAccess;

	@NativeType("VkBool32")
	public int uniformAndStorageBuffer8BitAccess;

	@NativeType("VkBool32")
	public int storagePushConstant8;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}