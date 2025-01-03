package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceSparseProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceSparseProperties.class);

	@NativeType("VkBool32")
	public int residencyStandard2DBlockShape;

	@NativeType("VkBool32")
	public int residencyStandard2DMultisampleBlockShape;

	@NativeType("VkBool32")
	public int residencyStandard3DBlockShape;

	@NativeType("VkBool32")
	public int residencyAlignedMipSize;

	@NativeType("VkBool32")
	public int residencyNonResidentStrict;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}