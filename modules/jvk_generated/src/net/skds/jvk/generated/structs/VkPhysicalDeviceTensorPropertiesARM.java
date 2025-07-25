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
* struct VkPhysicalDeviceTensorPropertiesARM {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	uint32_t maxTensorDimensionCount;
* 	// pad (4)
* 	uint64_t maxTensorElements;
* 	uint64_t maxPerDimensionTensorElements;
* 	int64_t maxTensorStride;
* 	uint64_t maxTensorSize;
* 	uint32_t maxTensorShaderAccessArrayLength;
* 	uint32_t maxTensorShaderAccessSize;
* 	uint32_t maxDescriptorSetStorageTensors;
* 	uint32_t maxPerStageDescriptorSetStorageTensors;
* 	uint32_t maxDescriptorSetUpdateAfterBindStorageTensors;
* 	uint32_t maxPerStageDescriptorUpdateAfterBindStorageTensors;
* 	VkBool32 shaderStorageTensorArrayNonUniformIndexingNative;
* 	VkShaderStageFlags shaderTensorSupportedStages;
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceTensorPropertiesARM extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
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
	private static final int MAX_TENSOR_DIMENSION_COUNT_OFFSET = 16;
	private static final int MAX_TENSOR_ELEMENTS_OFFSET = 24;
	private static final int MAX_PER_DIMENSION_TENSOR_ELEMENTS_OFFSET = 32;
	private static final int MAX_TENSOR_STRIDE_OFFSET = 40;
	private static final int MAX_TENSOR_SIZE_OFFSET = 48;
	private static final int MAX_TENSOR_SHADER_ACCESS_ARRAY_LENGTH_OFFSET = 56;
	private static final int MAX_TENSOR_SHADER_ACCESS_SIZE_OFFSET = 60;
	private static final int MAX_DESCRIPTOR_SET_STORAGE_TENSORS_OFFSET = 64;
	private static final int MAX_PER_STAGE_DESCRIPTOR_SET_STORAGE_TENSORS_OFFSET = 68;
	private static final int MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_TENSORS_OFFSET = 72;
	private static final int MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_TENSORS_OFFSET = 76;
	private static final int SHADER_STORAGE_TENSOR_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET = 80;
	private static final int SHADER_TENSOR_SUPPORTED_STAGES_OFFSET = 84;
	
	public VkPhysicalDeviceTensorPropertiesARM() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceTensorPropertiesARM(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceTensorPropertiesARM(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TENSOR_PROPERTIES_ARM **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TENSOR_PROPERTIES_ARM **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceTensorPropertiesARM sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TENSOR_PROPERTIES_ARM **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceTensorPropertiesARM sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000460004);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceTensorPropertiesARM pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxTensorDimensionCount() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_TENSOR_DIMENSION_COUNT_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceTensorPropertiesARM maxTensorDimensionCount(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_TENSOR_DIMENSION_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long maxTensorElements() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_TENSOR_ELEMENTS_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPhysicalDeviceTensorPropertiesARM maxTensorElements(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_TENSOR_ELEMENTS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long maxPerDimensionTensorElements() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_PER_DIMENSION_TENSOR_ELEMENTS_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPhysicalDeviceTensorPropertiesARM maxPerDimensionTensorElements(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_PER_DIMENSION_TENSOR_ELEMENTS_OFFSET, value);
		return this;
	}
	
	@NativeType("int64_t")
	public long maxTensorStride() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_TENSOR_STRIDE_OFFSET);
	}
	
	@NativeType("int64_t")
	public VkPhysicalDeviceTensorPropertiesARM maxTensorStride(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_TENSOR_STRIDE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long maxTensorSize() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + MAX_TENSOR_SIZE_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkPhysicalDeviceTensorPropertiesARM maxTensorSize(long value) {
		LONG_HANDLE.set(this.segment, this.offset + MAX_TENSOR_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxTensorShaderAccessArrayLength() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_TENSOR_SHADER_ACCESS_ARRAY_LENGTH_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceTensorPropertiesARM maxTensorShaderAccessArrayLength(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_TENSOR_SHADER_ACCESS_ARRAY_LENGTH_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxTensorShaderAccessSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_TENSOR_SHADER_ACCESS_SIZE_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceTensorPropertiesARM maxTensorShaderAccessSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_TENSOR_SHADER_ACCESS_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetStorageTensors() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_STORAGE_TENSORS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceTensorPropertiesARM maxDescriptorSetStorageTensors(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_STORAGE_TENSORS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorSetStorageTensors() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_SET_STORAGE_TENSORS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceTensorPropertiesARM maxPerStageDescriptorSetStorageTensors(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_SET_STORAGE_TENSORS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxDescriptorSetUpdateAfterBindStorageTensors() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_TENSORS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceTensorPropertiesARM maxDescriptorSetUpdateAfterBindStorageTensors(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_DESCRIPTOR_SET_UPDATE_AFTER_BIND_STORAGE_TENSORS_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int maxPerStageDescriptorUpdateAfterBindStorageTensors() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_TENSORS_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPhysicalDeviceTensorPropertiesARM maxPerStageDescriptorUpdateAfterBindStorageTensors(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAX_PER_STAGE_DESCRIPTOR_UPDATE_AFTER_BIND_STORAGE_TENSORS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderStorageTensorArrayNonUniformIndexingNative() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_STORAGE_TENSOR_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceTensorPropertiesARM shaderStorageTensorArrayNonUniformIndexingNative(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_STORAGE_TENSOR_ARRAY_NON_UNIFORM_INDEXING_NATIVE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkShaderStageFlags")
	public int shaderTensorSupportedStages() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_TENSOR_SUPPORTED_STAGES_OFFSET);
	}
	
	@NativeType("VkShaderStageFlags")
	public VkPhysicalDeviceTensorPropertiesARM shaderTensorSupportedStages(int value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_TENSOR_SUPPORTED_STAGES_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceTensorPropertiesARM> {
		
		private static final StructConstructor<VkPhysicalDeviceTensorPropertiesARM> CONSTRUCTOR = VkPhysicalDeviceTensorPropertiesARM::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceTensorPropertiesARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceTensorPropertiesARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceTensorPropertiesARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
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