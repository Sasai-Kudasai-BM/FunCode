package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkMultisamplePropertiesEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkMultisamplePropertiesEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_MULTISAMPLE_PROPERTIES_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkExtent2D")
	public VkExtent2D maxSampleLocationGridSize;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}