package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExportSemaphoreWin32HandleInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkExportSemaphoreWin32HandleInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR
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
	@NativeType("SECURITY_ATTRIBUTES**")
	public long pAttributes;

	@NativeType("DWORD")
	public short dwAccess;

	@NativeType("LPCWSTR*")
	public long name;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}