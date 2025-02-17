package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExternalMemoryProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkExternalMemoryProperties.class);

	@NativeType("VkExternalMemoryFeatureFlags")
	public int externalMemoryFeatures;

	/**
	* optional
	*/
	@NativeType("VkExternalMemoryHandleTypeFlags")
	public int exportFromImportedHandleTypes;

	@NativeType("VkExternalMemoryHandleTypeFlags")
	public int compatibleHandleTypes;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}