package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkLayerProperties extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkLayerProperties.class);

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] layerName;

	@NativeType("uint32_t")
	public int specVersion;

	@NativeType("uint32_t")
	public int implementationVersion;

	@ArrayLength(256)
	@NativeType("char[256]")
	public byte[] description;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}