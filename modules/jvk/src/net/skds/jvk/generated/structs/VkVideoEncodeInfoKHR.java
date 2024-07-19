package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkVideoPictureResourceKHR;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkVideoEncodeInfoKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkVideoEncodeInfoKHR.class);

	/**
	* values = VK_STRUCTURE_TYPE_VIDEO_ENCODE_INFO_KHR
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
	@NativeType("VkVideoEncodeFlagsKHR")
	public int flags;

	@NativeType("uint32_t")
	public int qualityLevel;

	@NativeType("VkBuffer*")
	public long dstBitstreamBuffer;

	@NativeType("VkDeviceSize")
	public long dstBitstreamBufferOffset;

	@NativeType("VkDeviceSize")
	public long dstBitstreamBufferMaxRange;

	@NativeType("VkVideoPictureResourceKHR")
	public VkVideoPictureResourceKHR srcPictureResource;

	@NativeType("VkVideoReferenceSlotKHR*")
	public long pSetupReferenceSlot;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int referenceSlotCount;

	@NativeType("VkVideoReferenceSlotKHR*")
	public long pReferenceSlots;

	@NativeType("uint32_t")
	public int precedingExternallyEncodedBytes;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}