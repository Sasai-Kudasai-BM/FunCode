package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkImportMemoryFdInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkImportMemoryFdInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_IMPORT_MEMORY_FD_INFO_KHR
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkExternalMemoryHandleTypeFlagBits")
	public int handleType;

	@NativeType("int")
	public short fd;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}