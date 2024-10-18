package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDevice16BitStorageFeatures extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDevice16BitStorageFeatures.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int storageBuffer16BitAccess;

	@NativeType("VkBool32")
	public int uniformAndStorageBuffer16BitAccess;

	@NativeType("VkBool32")
	public int storagePushConstant16;

	@NativeType("VkBool32")
	public int storageInputOutput16;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}