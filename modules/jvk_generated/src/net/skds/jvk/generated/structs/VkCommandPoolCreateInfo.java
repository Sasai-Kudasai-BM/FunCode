package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkCommandPoolCreateInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkCommandPoolCreateInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_COMMAND_POOL_CREATE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 39;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkCommandPoolCreateFlags")
	public int flags;

	@NativeType("uint32_t")
	public int queueFamilyIndex;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}