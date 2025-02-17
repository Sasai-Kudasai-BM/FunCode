package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkVideoPictureResourceKHR;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoDecodeInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoDecodeInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_DECODE_INFO_KHR
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
	@NativeType("VkVideoDecodeFlagsKHR")
	public int flags;

	@NativeType("VkBuffer*")
	public long srcBuffer;

	@NativeType("VkDeviceSize")
	public long srcBufferOffset;

	@NativeType("VkDeviceSize")
	public long srcBufferRange;

	@NativeType("VkVideoPictureResourceKHR")
	public VkVideoPictureResourceKHR dstPictureResource;

	@NativeType("VkVideoReferenceSlotKHR*")
	public long pSetupReferenceSlot;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int referenceSlotCount;

	@NativeType("VkVideoReferenceSlotKHR*")
	public long pReferenceSlots;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}