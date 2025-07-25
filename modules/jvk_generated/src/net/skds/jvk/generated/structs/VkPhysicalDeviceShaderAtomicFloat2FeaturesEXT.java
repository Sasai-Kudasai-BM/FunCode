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
* struct VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 shaderBufferFloat16Atomics;
* 	VkBool32 shaderBufferFloat16AtomicAdd;
* 	VkBool32 shaderBufferFloat16AtomicMinMax;
* 	VkBool32 shaderBufferFloat32AtomicMinMax;
* 	VkBool32 shaderBufferFloat64AtomicMinMax;
* 	VkBool32 shaderSharedFloat16Atomics;
* 	VkBool32 shaderSharedFloat16AtomicAdd;
* 	VkBool32 shaderSharedFloat16AtomicMinMax;
* 	VkBool32 shaderSharedFloat32AtomicMinMax;
* 	VkBool32 shaderSharedFloat64AtomicMinMax;
* 	VkBool32 shaderImageFloat32AtomicMinMax;
* 	VkBool32 sparseImageFloat32AtomicMinMax;
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT extends CStruct {
	
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
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SHADER_BUFFER_FLOAT16_ATOMICS_OFFSET = 16;
	private static final int SHADER_BUFFER_FLOAT16_ATOMIC_ADD_OFFSET = 20;
	private static final int SHADER_BUFFER_FLOAT16_ATOMIC_MIN_MAX_OFFSET = 24;
	private static final int SHADER_BUFFER_FLOAT32_ATOMIC_MIN_MAX_OFFSET = 28;
	private static final int SHADER_BUFFER_FLOAT64_ATOMIC_MIN_MAX_OFFSET = 32;
	private static final int SHADER_SHARED_FLOAT16_ATOMICS_OFFSET = 36;
	private static final int SHADER_SHARED_FLOAT16_ATOMIC_ADD_OFFSET = 40;
	private static final int SHADER_SHARED_FLOAT16_ATOMIC_MIN_MAX_OFFSET = 44;
	private static final int SHADER_SHARED_FLOAT32_ATOMIC_MIN_MAX_OFFSET = 48;
	private static final int SHADER_SHARED_FLOAT64_ATOMIC_MIN_MAX_OFFSET = 52;
	private static final int SHADER_IMAGE_FLOAT32_ATOMIC_MIN_MAX_OFFSET = 56;
	private static final int SPARSE_IMAGE_FLOAT32_ATOMIC_MIN_MAX_OFFSET = 60;
	
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000273000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderBufferFloat16Atomics() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_BUFFER_FLOAT16_ATOMICS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat16Atomics(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_BUFFER_FLOAT16_ATOMICS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderBufferFloat16AtomicAdd() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_BUFFER_FLOAT16_ATOMIC_ADD_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat16AtomicAdd(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_BUFFER_FLOAT16_ATOMIC_ADD_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderBufferFloat16AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_BUFFER_FLOAT16_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat16AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_BUFFER_FLOAT16_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderBufferFloat32AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_BUFFER_FLOAT32_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat32AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_BUFFER_FLOAT32_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderBufferFloat64AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_BUFFER_FLOAT64_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat64AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_BUFFER_FLOAT64_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSharedFloat16Atomics() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SHARED_FLOAT16_ATOMICS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat16Atomics(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SHARED_FLOAT16_ATOMICS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSharedFloat16AtomicAdd() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SHARED_FLOAT16_ATOMIC_ADD_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat16AtomicAdd(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SHARED_FLOAT16_ATOMIC_ADD_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSharedFloat16AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SHARED_FLOAT16_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat16AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SHARED_FLOAT16_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSharedFloat32AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SHARED_FLOAT32_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat32AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SHARED_FLOAT32_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSharedFloat64AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SHARED_FLOAT64_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat64AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SHARED_FLOAT64_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderImageFloat32AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_IMAGE_FLOAT32_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderImageFloat32AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_IMAGE_FLOAT32_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean sparseImageFloat32AtomicMinMax() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SPARSE_IMAGE_FLOAT32_ATOMIC_MIN_MAX_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT sparseImageFloat32AtomicMinMax(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SPARSE_IMAGE_FLOAT32_ATOMIC_MIN_MAX_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT> {
		
		private static final StructConstructor<VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT> CONSTRUCTOR = VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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