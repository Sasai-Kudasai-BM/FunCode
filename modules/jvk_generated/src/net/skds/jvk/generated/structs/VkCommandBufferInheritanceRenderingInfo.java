package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkCommandBufferInheritanceRenderingInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkCommandBufferInheritanceRenderingInfo.class);

	/**
	* values = VK_STRUCTURE_TYPE_COMMAND_BUFFER_INHERITANCE_RENDERING_INFO
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
	@NativeType("VkRenderingFlags")
	public int flags;

	@NativeType("uint32_t")
	public int viewMask;

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int colorAttachmentCount;

	@NativeType("VkFormat*")
	public long pColorAttachmentFormats;

	@NativeType("VkFormat")
	public int depthAttachmentFormat;

	@NativeType("VkFormat")
	public int stencilAttachmentFormat;

	/**
	* optional
	*/
	@NativeType("VkSampleCountFlagBits")
	public int rasterizationSamples;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}