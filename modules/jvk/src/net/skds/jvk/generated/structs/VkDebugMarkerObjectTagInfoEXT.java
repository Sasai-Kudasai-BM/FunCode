package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkDebugMarkerObjectTagInfoEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkDebugMarkerObjectTagInfoEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_DEBUG_MARKER_OBJECT_TAG_INFO_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkDebugReportObjectTypeEXT")
	public int objectType;

	@NativeType("uint64_t")
	public long object;

	@NativeType("uint64_t")
	public long tagName;

	@NativeType("size_t")
	public long tagSize;

	@NativeType("void*")
	public long pTag;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}