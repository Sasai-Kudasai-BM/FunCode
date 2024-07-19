package net.skds.jvk.generated.structs;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkGeometryTrianglesNV extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkGeometryTrianglesNV.class);

	/**
	* values = VK_STRUCTURE_TYPE_GEOMETRY_TRIANGLES_NV
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	/**
	* optional
	*/
	@NativeType("VkBuffer*")
	public long vertexData;

	@NativeType("VkDeviceSize")
	public long vertexOffset;

	@NativeType("uint32_t")
	public int vertexCount;

	@NativeType("VkDeviceSize")
	public long vertexStride;

	@NativeType("VkFormat")
	public int vertexFormat;

	/**
	* optional
	*/
	@NativeType("VkBuffer*")
	public long indexData;

	@NativeType("VkDeviceSize")
	public long indexOffset;

	@NativeType("uint32_t")
	public int indexCount;

	@NativeType("VkIndexType")
	public int indexType;

	/**
	* optional
	*/
	@NativeType("VkBuffer*")
	public long transformData;

	@NativeType("VkDeviceSize")
	public long transformOffset;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}