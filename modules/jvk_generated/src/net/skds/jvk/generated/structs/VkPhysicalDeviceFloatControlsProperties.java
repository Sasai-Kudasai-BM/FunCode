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
* struct VkPhysicalDeviceFloatControlsProperties {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkShaderFloatControlsIndependence denormBehaviorIndependence;
* 	VkShaderFloatControlsIndependence roundingModeIndependence;
* 	VkBool32 shaderSignedZeroInfNanPreserveFloat16;
* 	VkBool32 shaderSignedZeroInfNanPreserveFloat32;
* 	VkBool32 shaderSignedZeroInfNanPreserveFloat64;
* 	VkBool32 shaderDenormPreserveFloat16;
* 	VkBool32 shaderDenormPreserveFloat32;
* 	VkBool32 shaderDenormPreserveFloat64;
* 	VkBool32 shaderDenormFlushToZeroFloat16;
* 	VkBool32 shaderDenormFlushToZeroFloat32;
* 	VkBool32 shaderDenormFlushToZeroFloat64;
* 	VkBool32 shaderRoundingModeRTEFloat16;
* 	VkBool32 shaderRoundingModeRTEFloat32;
* 	VkBool32 shaderRoundingModeRTEFloat64;
* 	VkBool32 shaderRoundingModeRTZFloat16;
* 	VkBool32 shaderRoundingModeRTZFloat32;
* 	VkBool32 shaderRoundingModeRTZFloat64;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceFloatControlsProperties extends CStruct {
	
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
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int DENORM_BEHAVIOR_INDEPENDENCE_OFFSET = 16;
	private static final int ROUNDING_MODE_INDEPENDENCE_OFFSET = 20;
	private static final int SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT16_OFFSET = 24;
	private static final int SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT32_OFFSET = 28;
	private static final int SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT64_OFFSET = 32;
	private static final int SHADER_DENORM_PRESERVE_FLOAT16_OFFSET = 36;
	private static final int SHADER_DENORM_PRESERVE_FLOAT32_OFFSET = 40;
	private static final int SHADER_DENORM_PRESERVE_FLOAT64_OFFSET = 44;
	private static final int SHADER_DENORM_FLUSH_TO_ZERO_FLOAT16_OFFSET = 48;
	private static final int SHADER_DENORM_FLUSH_TO_ZERO_FLOAT32_OFFSET = 52;
	private static final int SHADER_DENORM_FLUSH_TO_ZERO_FLOAT64_OFFSET = 56;
	private static final int SHADER_ROUNDING_MODE_RTEFLOAT16_OFFSET = 60;
	private static final int SHADER_ROUNDING_MODE_RTEFLOAT32_OFFSET = 64;
	private static final int SHADER_ROUNDING_MODE_RTEFLOAT64_OFFSET = 68;
	private static final int SHADER_ROUNDING_MODE_RTZFLOAT16_OFFSET = 72;
	private static final int SHADER_ROUNDING_MODE_RTZFLOAT32_OFFSET = 76;
	private static final int SHADER_ROUNDING_MODE_RTZFLOAT64_OFFSET = 80;
	
	public VkPhysicalDeviceFloatControlsProperties() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceFloatControlsProperties(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceFloatControlsProperties(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceFloatControlsProperties sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceFloatControlsProperties sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000197000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceFloatControlsProperties pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public int denormBehaviorIndependence() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DENORM_BEHAVIOR_INDEPENDENCE_OFFSET);
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public VkPhysicalDeviceFloatControlsProperties denormBehaviorIndependence(int value) {
		INT_HANDLE.set(this.segment, this.offset + DENORM_BEHAVIOR_INDEPENDENCE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public int roundingModeIndependence() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ROUNDING_MODE_INDEPENDENCE_OFFSET);
	}
	
	@NativeType("VkShaderFloatControlsIndependence")
	public VkPhysicalDeviceFloatControlsProperties roundingModeIndependence(int value) {
		INT_HANDLE.set(this.segment, this.offset + ROUNDING_MODE_INDEPENDENCE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSignedZeroInfNanPreserveFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderSignedZeroInfNanPreserveFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSignedZeroInfNanPreserveFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderSignedZeroInfNanPreserveFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSignedZeroInfNanPreserveFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderSignedZeroInfNanPreserveFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SIGNED_ZERO_INF_NAN_PRESERVE_FLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormPreserveFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderDenormPreserveFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormPreserveFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderDenormPreserveFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormPreserveFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderDenormPreserveFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_PRESERVE_FLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormFlushToZeroFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderDenormFlushToZeroFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormFlushToZeroFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderDenormFlushToZeroFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderDenormFlushToZeroFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderDenormFlushToZeroFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_DENORM_FLUSH_TO_ZERO_FLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTEFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderRoundingModeRTEFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTEFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderRoundingModeRTEFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTEFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderRoundingModeRTEFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTEFLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTZFloat16() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT16_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderRoundingModeRTZFloat16(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT16_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTZFloat32() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT32_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderRoundingModeRTZFloat32(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT32_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderRoundingModeRTZFloat64() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT64_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceFloatControlsProperties shaderRoundingModeRTZFloat64(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_ROUNDING_MODE_RTZFLOAT64_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceFloatControlsProperties> {
		
		private static final StructConstructor<VkPhysicalDeviceFloatControlsProperties> CONSTRUCTOR = VkPhysicalDeviceFloatControlsProperties::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceFloatControlsProperties[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceFloatControlsProperties[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceFloatControlsProperties[size], CONSTRUCTOR, MEMORY_LAYOUT);
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