package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineExecutablePropertiesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineExecutablePropertiesKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_PROPERTIES_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkShaderStageFlags")
	public int stages;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] name;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] description;

	@NativeType("uint32_t")
	public int subgroupSize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}