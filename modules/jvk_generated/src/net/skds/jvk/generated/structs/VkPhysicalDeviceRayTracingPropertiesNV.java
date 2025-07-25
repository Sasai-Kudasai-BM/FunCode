package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static java.lang.foreign.ValueLayout.*;
import static net.skds.lib2.natives.LinkerUtils.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkPhysicalDeviceRayTracingPropertiesNV {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t shaderGroupHandleSize;
* 	uint32_t maxRecursionDepth;
* 	uint32_t maxShaderGroupStride;
* 	uint32_t shaderGroupBaseAlignment;
* 	uint64_t maxGeometryCount;
* 	uint64_t maxInstanceCount;
* 	uint64_t maxTriangleCount;
* 	uint32_t maxDescriptorSetAccelerationStructures;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceRayTracingPropertiesNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SHADER_GROUP_HANDLE_SIZE_OFFSET = 16;
	private static final int MAX_RECURSION_DEPTH_OFFSET = 20;
	private static final int MAX_SHADER_GROUP_STRIDE_OFFSET = 24;
	private static final int SHADER_GROUP_BASE_ALIGNMENT_OFFSET = 28;
	private static final int MAX_GEOMETRY_COUNT_OFFSET = 32;
	private static final int MAX_INSTANCE_COUNT_OFFSET = 40;
	private static final int MAX_TRIANGLE_COUNT_OFFSET = 48;
	private static final int MAX_DESCRIPTOR_SET_ACCELERATION_STRUCTURES_OFFSET = 56;
	
	public VkPhysicalDeviceRayTracingPropertiesNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceRayTracingPropertiesNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceRayTracingPropertiesNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceRayTracingPropertiesNV sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceRayTracingPropertiesNV sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000165009);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceRayTracingPropertiesNV pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int shaderGroupHandleSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_GROUP_HANDLE_SIZE_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceRayTracingPropertiesNV shaderGroupHandleSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_GROUP_HANDLE_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxRecursionDepth() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_RECURSION_DEPTH_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceRayTracingPropertiesNV maxRecursionDepth(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_RECURSION_DEPTH_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxShaderGroupStride() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_SHADER_GROUP_STRIDE_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceRayTracingPropertiesNV maxShaderGroupStride(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_SHADER_GROUP_STRIDE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int shaderGroupBaseAlignment() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_GROUP_BASE_ALIGNMENT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceRayTracingPropertiesNV shaderGroupBaseAlignment(int value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_GROUP_BASE_ALIGNMENT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long maxGeometryCount() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_GEOMETRY_COUNT_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPhysicalDeviceRayTracingPropertiesNV maxGeometryCount(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_GEOMETRY_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long maxInstanceCount() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_INSTANCE_COUNT_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPhysicalDeviceRayTracingPropertiesNV maxInstanceCount(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_INSTANCE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long maxTriangleCount() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_TRIANGLE_COUNT_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPhysicalDeviceRayTracingPropertiesNV maxTriangleCount(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_TRIANGLE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetAccelerationStructures() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_ACCELERATION_STRUCTURES_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceRayTracingPropertiesNV maxDescriptorSetAccelerationStructures(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_ACCELERATION_STRUCTURES_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceRayTracingPropertiesNV> {
		
		private static final StructConstructor<VkPhysicalDeviceRayTracingPropertiesNV> CONSTRUCTOR = VkPhysicalDeviceRayTracingPropertiesNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceRayTracingPropertiesNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceRayTracingPropertiesNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceRayTracingPropertiesNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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