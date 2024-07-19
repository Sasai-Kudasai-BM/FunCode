package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkRenderPassSubpassFeedbackInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkRenderPassSubpassFeedbackInfoEXT.class);

	@NativeType("VkSubpassMergeStatusEXT")
	public int subpassMergeStatus;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] description;

	@NativeType("uint32_t")
	public int postMergeIndex;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}