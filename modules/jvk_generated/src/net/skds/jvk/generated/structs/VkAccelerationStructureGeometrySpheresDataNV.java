package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.jvk.generated.unions.VkDeviceOrHostAddressConstKHR;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static java.lang.foreign.ValueLayout.*;
import static net.skds.lib2.natives.LinkerUtils.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkAccelerationStructureGeometrySpheresDataNV {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkFormat vertexFormat;
* 	// pad (4)
* 	VkDeviceOrHostAddressConstKHR vertexData;
* 	VkDeviceSize vertexStride;
* 	VkFormat radiusFormat;
* 	// pad (4)
* 	VkDeviceOrHostAddressConstKHR radiusData;
* 	VkDeviceSize radiusStride;
* 	VkIndexType indexType;
* 	// pad (4)
* 	VkDeviceOrHostAddressConstKHR indexData;
* 	VkDeviceSize indexStride;
* };
*</pre>
**/
@AutoGenerated
public final class VkAccelerationStructureGeometrySpheresDataNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			VkDeviceOrHostAddressConstKHR.MEMORY_LAYOUT,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			VkDeviceOrHostAddressConstKHR.MEMORY_LAYOUT,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			VkDeviceOrHostAddressConstKHR.MEMORY_LAYOUT,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int VERTEX_FORMAT_OFFSET = 16;
	private static final int VERTEX_DATA_OFFSET = 24;
	private static final int VERTEX_STRIDE_OFFSET = 32;
	private static final int RADIUS_FORMAT_OFFSET = 40;
	private static final int RADIUS_DATA_OFFSET = 48;
	private static final int RADIUS_STRIDE_OFFSET = 56;
	private static final int INDEX_TYPE_OFFSET = 64;
	private static final int INDEX_DATA_OFFSET = 72;
	private static final int INDEX_STRIDE_OFFSET = 80;
	
	public VkAccelerationStructureGeometrySpheresDataNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAccelerationStructureGeometrySpheresDataNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAccelerationStructureGeometrySpheresDataNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_GEOMETRY_SPHERES_DATA_NV **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_GEOMETRY_SPHERES_DATA_NV **/
	@NativeType("VkStructureType")
	public VkAccelerationStructureGeometrySpheresDataNV sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_GEOMETRY_SPHERES_DATA_NV **/
	@NativeType("VkStructureType")
	public VkAccelerationStructureGeometrySpheresDataNV sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000429010);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkAccelerationStructureGeometrySpheresDataNV pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFormat")
	public int vertexFormat() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VERTEX_FORMAT_OFFSET);
	}
	
	@NativeType("VkFormat")
	public VkAccelerationStructureGeometrySpheresDataNV vertexFormat(int value) {
		INT_HANDLE.set(this.segment, this.offset + VERTEX_FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceOrHostAddressConstKHR")
	public VkDeviceOrHostAddressConstKHR vertexData() {
		return new VkDeviceOrHostAddressConstKHR(this.segment, this.offset + VERTEX_DATA_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public long vertexStride() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + VERTEX_STRIDE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkAccelerationStructureGeometrySpheresDataNV vertexStride(long value) {
		LONG_HANDLE.set(this.segment, this.offset + VERTEX_STRIDE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFormat")
	public int radiusFormat() {
		return (int) INT_HANDLE.get(this.segment, this.offset + RADIUS_FORMAT_OFFSET);
	}
	
	@NativeType("VkFormat")
	public VkAccelerationStructureGeometrySpheresDataNV radiusFormat(int value) {
		INT_HANDLE.set(this.segment, this.offset + RADIUS_FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceOrHostAddressConstKHR")
	public VkDeviceOrHostAddressConstKHR radiusData() {
		return new VkDeviceOrHostAddressConstKHR(this.segment, this.offset + RADIUS_DATA_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public long radiusStride() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + RADIUS_STRIDE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkAccelerationStructureGeometrySpheresDataNV radiusStride(long value) {
		LONG_HANDLE.set(this.segment, this.offset + RADIUS_STRIDE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkIndexType")
	public int indexType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + INDEX_TYPE_OFFSET);
	}
	
	@NativeType("VkIndexType")
	public VkAccelerationStructureGeometrySpheresDataNV indexType(int value) {
		INT_HANDLE.set(this.segment, this.offset + INDEX_TYPE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkDeviceOrHostAddressConstKHR")
	public VkDeviceOrHostAddressConstKHR indexData() {
		return new VkDeviceOrHostAddressConstKHR(this.segment, this.offset + INDEX_DATA_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public long indexStride() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + INDEX_STRIDE_OFFSET);
	}
	
	@NativeType("VkDeviceSize")
	public VkAccelerationStructureGeometrySpheresDataNV indexStride(long value) {
		LONG_HANDLE.set(this.segment, this.offset + INDEX_STRIDE_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkAccelerationStructureGeometrySpheresDataNV> {
		
		private static final StructConstructor<VkAccelerationStructureGeometrySpheresDataNV> CONSTRUCTOR = VkAccelerationStructureGeometrySpheresDataNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkAccelerationStructureGeometrySpheresDataNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkAccelerationStructureGeometrySpheresDataNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkAccelerationStructureGeometrySpheresDataNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
	}
	
	@Override
	public int getAlignment() {
		return (int) MEMORY_LAYOUT.byteAlignment();
	}
	
	@Override
	public int getSize() {
		return (int) MEMORY_LAYOUT.byteSize();
	}
	
}