package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkBindSparseInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkBindSparseInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_BIND_SPARSE_INFO
	*/
	@NativeType("VkStructureType")
	public int sType = 7;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int waitSemaphoreCount;

	@NativeType("VkSemaphore**")
	public long pWaitSemaphores;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int bufferBindCount;

	@NativeType("VkSparseBufferMemoryBindInfo*")
	public long pBufferBinds;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int imageOpaqueBindCount;

	@NativeType("VkSparseImageOpaqueMemoryBindInfo*")
	public long pImageOpaqueBinds;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int imageBindCount;

	@NativeType("VkSparseImageMemoryBindInfo*")
	public long pImageBinds;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int signalSemaphoreCount;

	@NativeType("VkSemaphore**")
	public long pSignalSemaphores;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}