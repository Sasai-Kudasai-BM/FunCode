package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineExecutableInternalRepresentationKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineExecutableInternalRepresentationKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_INTERNAL_REPRESENTATION_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] name;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] description;

	@NativeType("VkBool32")
	public int isText;

	@NativeType("size_t")
	public long dataSize;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pData;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}