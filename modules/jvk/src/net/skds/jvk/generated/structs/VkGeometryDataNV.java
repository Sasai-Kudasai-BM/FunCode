package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;
import net.skds.jvk.generated.structs.VkGeometryTrianglesNV;
import net.skds.jvk.generated.structs.VkGeometryAABBNV;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkGeometryDataNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkGeometryDataNV.class);

	@NativeType("VkGeometryTrianglesNV")
	public VkGeometryTrianglesNV triangles;

	@NativeType("VkGeometryAABBNV")
	public VkGeometryAABBNV aabbs;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}