package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPipelineCacheHeaderVersionOne extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPipelineCacheHeaderVersionOne.class);

	@NativeType("uint32_t")
	public int headerSize;

	@NativeType("VkPipelineCacheHeaderVersion")
	public int headerVersion;

	@NativeType("uint32_t")
	public int vendorID;

	@NativeType("uint32_t")
	public int deviceID;

	@ArrayLength(16)
	@NativeType("uint8_t[16]")
	public byte[] pipelineCacheUUID;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}