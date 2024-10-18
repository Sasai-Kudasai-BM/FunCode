package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.jvk.generated.structs.VkOffset2D;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDisplayPlaneCapabilitiesKHR extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDisplayPlaneCapabilitiesKHR.class);

	/**
	* optional
	*/
	@NativeType("VkDisplayPlaneAlphaFlagsKHR")
	public int supportedAlpha;

	@NativeType("VkOffset2D")
	public VkOffset2D minSrcPosition;

	@NativeType("VkOffset2D")
	public VkOffset2D maxSrcPosition;

	@NativeType("VkExtent2D")
	public VkExtent2D minSrcExtent;

	@NativeType("VkExtent2D")
	public VkExtent2D maxSrcExtent;

	@NativeType("VkOffset2D")
	public VkOffset2D minDstPosition;

	@NativeType("VkOffset2D")
	public VkOffset2D maxDstPosition;

	@NativeType("VkExtent2D")
	public VkExtent2D minDstExtent;

	@NativeType("VkExtent2D")
	public VkExtent2D maxDstExtent;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}