package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_NV
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint32_t")
	public int maxGraphicsShaderGroupCount;

	@NativeType("uint32_t")
	public int maxIndirectSequenceCount;

	@NativeType("uint32_t")
	public int maxIndirectCommandsTokenCount;

	@NativeType("uint32_t")
	public int maxIndirectCommandsStreamCount;

	@NativeType("uint32_t")
	public int maxIndirectCommandsTokenOffset;

	@NativeType("uint32_t")
	public int maxIndirectCommandsStreamStride;

	@NativeType("uint32_t")
	public int minSequencesCountBufferOffsetAlignment;

	@NativeType("uint32_t")
	public int minSequencesIndexBufferOffsetAlignment;

	@NativeType("uint32_t")
	public int minIndirectCommandsBufferOffsetAlignment;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}