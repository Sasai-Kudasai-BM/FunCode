package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDescriptorSetLayoutSupportKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDescriptorSetLayoutSupportKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_DESCRIPTOR_SET_LAYOUT_SUPPORT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkBool32")
	public int supported;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}