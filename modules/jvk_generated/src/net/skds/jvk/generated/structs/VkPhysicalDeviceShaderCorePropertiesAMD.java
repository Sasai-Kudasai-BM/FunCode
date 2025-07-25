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
* struct VkPhysicalDeviceShaderCorePropertiesAMD {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t shaderEngineCount;
* 	uint32_t shaderArraysPerEngineCount;
* 	uint32_t computeUnitsPerShaderArray;
* 	uint32_t simdPerComputeUnit;
* 	uint32_t wavefrontsPerSimd;
* 	uint32_t wavefrontSize;
* 	uint32_t sgprsPerSimd;
* 	uint32_t minSgprAllocation;
* 	uint32_t maxSgprAllocation;
* 	uint32_t sgprAllocationGranularity;
* 	uint32_t vgprsPerSimd;
* 	uint32_t minVgprAllocation;
* 	uint32_t maxVgprAllocation;
* 	uint32_t vgprAllocationGranularity;
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceShaderCorePropertiesAMD extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SHADER_ENGINE_COUNT_OFFSET = 16;
	private static final int SHADER_ARRAYS_PER_ENGINE_COUNT_OFFSET = 20;
	private static final int COMPUTE_UNITS_PER_SHADER_ARRAY_OFFSET = 24;
	private static final int SIMD_PER_COMPUTE_UNIT_OFFSET = 28;
	private static final int WAVEFRONTS_PER_SIMD_OFFSET = 32;
	private static final int WAVEFRONT_SIZE_OFFSET = 36;
	private static final int SGPRS_PER_SIMD_OFFSET = 40;
	private static final int MIN_SGPR_ALLOCATION_OFFSET = 44;
	private static final int MAX_SGPR_ALLOCATION_OFFSET = 48;
	private static final int SGPR_ALLOCATION_GRANULARITY_OFFSET = 52;
	private static final int VGPRS_PER_SIMD_OFFSET = 56;
	private static final int MIN_VGPR_ALLOCATION_OFFSET = 60;
	private static final int MAX_VGPR_ALLOCATION_OFFSET = 64;
	private static final int VGPR_ALLOCATION_GRANULARITY_OFFSET = 68;
	
	public VkPhysicalDeviceShaderCorePropertiesAMD() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceShaderCorePropertiesAMD(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceShaderCorePropertiesAMD(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceShaderCorePropertiesAMD sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceShaderCorePropertiesAMD sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000185000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceShaderCorePropertiesAMD pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int shaderEngineCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ENGINE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD shaderEngineCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ENGINE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int shaderArraysPerEngineCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ARRAYS_PER_ENGINE_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD shaderArraysPerEngineCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ARRAYS_PER_ENGINE_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int computeUnitsPerShaderArray() {
		return (int) INT_HANDLE.get(this.segment, this.offset + COMPUTE_UNITS_PER_SHADER_ARRAY_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD computeUnitsPerShaderArray(int value) {
		INT_HANDLE.set(this.segment, this.offset + COMPUTE_UNITS_PER_SHADER_ARRAY_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int simdPerComputeUnit() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SIMD_PER_COMPUTE_UNIT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD simdPerComputeUnit(int value) {
		INT_HANDLE.set(this.segment, this.offset + SIMD_PER_COMPUTE_UNIT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int wavefrontsPerSimd() {
		return (int) INT_HANDLE.get(this.segment, this.offset + WAVEFRONTS_PER_SIMD_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD wavefrontsPerSimd(int value) {
		INT_HANDLE.set(this.segment, this.offset + WAVEFRONTS_PER_SIMD_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int wavefrontSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + WAVEFRONT_SIZE_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD wavefrontSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + WAVEFRONT_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int sgprsPerSimd() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SGPRS_PER_SIMD_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD sgprsPerSimd(int value) {
		INT_HANDLE.set(this.segment, this.offset + SGPRS_PER_SIMD_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int minSgprAllocation() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MIN_SGPR_ALLOCATION_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD minSgprAllocation(int value) {
		INT_HANDLE.set(this.segment, this.offset + MIN_SGPR_ALLOCATION_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxSgprAllocation() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_SGPR_ALLOCATION_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD maxSgprAllocation(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_SGPR_ALLOCATION_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int sgprAllocationGranularity() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SGPR_ALLOCATION_GRANULARITY_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD sgprAllocationGranularity(int value) {
		INT_HANDLE.set(this.segment, this.offset + SGPR_ALLOCATION_GRANULARITY_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int vgprsPerSimd() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VGPRS_PER_SIMD_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD vgprsPerSimd(int value) {
		INT_HANDLE.set(this.segment, this.offset + VGPRS_PER_SIMD_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int minVgprAllocation() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MIN_VGPR_ALLOCATION_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD minVgprAllocation(int value) {
		INT_HANDLE.set(this.segment, this.offset + MIN_VGPR_ALLOCATION_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxVgprAllocation() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_VGPR_ALLOCATION_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD maxVgprAllocation(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_VGPR_ALLOCATION_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int vgprAllocationGranularity() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VGPR_ALLOCATION_GRANULARITY_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceShaderCorePropertiesAMD vgprAllocationGranularity(int value) {
		INT_HANDLE.set(this.segment, this.offset + VGPR_ALLOCATION_GRANULARITY_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceShaderCorePropertiesAMD> {
		
		private static final StructConstructor<VkPhysicalDeviceShaderCorePropertiesAMD> CONSTRUCTOR = VkPhysicalDeviceShaderCorePropertiesAMD::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceShaderCorePropertiesAMD[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceShaderCorePropertiesAMD[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceShaderCorePropertiesAMD[size], CONSTRUCTOR, MEMORY_LAYOUT);
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