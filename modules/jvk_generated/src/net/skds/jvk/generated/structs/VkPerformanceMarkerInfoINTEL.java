package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPerformanceMarkerInfoINTEL extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPerformanceMarkerInfoINTEL.class);

	/**
	* values = VK_STRUCTURE_TYPE_PERFORMANCE_MARKER_INFO_INTEL
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("uint64_t")
	public long marker;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}