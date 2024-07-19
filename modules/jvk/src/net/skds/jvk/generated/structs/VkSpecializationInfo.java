package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkSpecializationInfo extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkSpecializationInfo.class);

	/**
	* optional
	*/
	@NativeType("uint32_t")
	public int mapEntryCount;

	@NativeType("VkSpecializationMapEntry*")
	public long pMapEntries;

	/**
	* optional
	*/
	@NativeType("size_t")
	public long dataSize;

	@NativeType("void*")
	public long pData;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}