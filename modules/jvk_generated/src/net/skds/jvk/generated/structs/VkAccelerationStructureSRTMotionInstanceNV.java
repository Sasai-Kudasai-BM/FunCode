package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.jvk.generated.structs.VkSRTDataNV;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkAccelerationStructureSRTMotionInstanceNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkAccelerationStructureSRTMotionInstanceNV.class);

	@NativeType("VkSRTDataNV")
	public VkSRTDataNV transformT0;

	@NativeType("VkSRTDataNV")
	public VkSRTDataNV transformT1;

	@NativeType("uint32_t")
	public int instanceCustomIndex;

	@NativeType("uint32_t")
	public int mask;

	@NativeType("uint32_t")
	public int instanceShaderBindingTableRecordOffset;

	/**
	* optional
	*/
	@NativeType("VkGeometryInstanceFlagsKHR")
	public int flags;

	@NativeType("uint64_t")
	public long accelerationStructureReference;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}