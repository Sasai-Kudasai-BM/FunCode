package net.skds.jvk.generated.structs;
import net.skds.jvk.generated.structs.VkSampleLocationsInfoEXT;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAttachmentSampleLocationsEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAttachmentSampleLocationsEXT.class);

	@NativeType("uint32_t")
	public int attachmentIndex;

	@NativeType("VkSampleLocationsInfoEXT")
	public VkSampleLocationsInfoEXT sampleLocationsInfo;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}