package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkDisplayPropertiesKHR;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDisplayProperties2KHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDisplayProperties2KHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_DISPLAY_PROPERTIES_2_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDisplayPropertiesKHR")
	public VkDisplayPropertiesKHR displayProperties;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}