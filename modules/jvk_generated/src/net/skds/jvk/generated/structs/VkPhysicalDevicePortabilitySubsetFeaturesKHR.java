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
* struct VkPhysicalDevicePortabilitySubsetFeaturesKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 constantAlphaColorBlendFactors;
* 	VkBool32 events;
* 	VkBool32 imageViewFormatReinterpretation;
* 	VkBool32 imageViewFormatSwizzle;
* 	VkBool32 imageView2DOn3DImage;
* 	VkBool32 multisampleArrayImage;
* 	VkBool32 mutableComparisonSamplers;
* 	VkBool32 pointPolygons;
* 	VkBool32 samplerMipLodBias;
* 	VkBool32 separateStencilMaskRef;
* 	VkBool32 shaderSampleRateInterpolationFunctions;
* 	VkBool32 tessellationIsolines;
* 	VkBool32 tessellationPointMode;
* 	VkBool32 triangleFans;
* 	VkBool32 vertexAttributeAccessBeyondStride;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDevicePortabilitySubsetFeaturesKHR extends CStruct {
	
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
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int CONSTANT_ALPHA_COLOR_BLEND_FACTORS_OFFSET = 16;
	private static final int EVENTS_OFFSET = 20;
	private static final int IMAGE_VIEW_FORMAT_REINTERPRETATION_OFFSET = 24;
	private static final int IMAGE_VIEW_FORMAT_SWIZZLE_OFFSET = 28;
	private static final int IMAGE_VIEW2_DON3_DIMAGE_OFFSET = 32;
	private static final int MULTISAMPLE_ARRAY_IMAGE_OFFSET = 36;
	private static final int MUTABLE_COMPARISON_SAMPLERS_OFFSET = 40;
	private static final int POINT_POLYGONS_OFFSET = 44;
	private static final int SAMPLER_MIP_LOD_BIAS_OFFSET = 48;
	private static final int SEPARATE_STENCIL_MASK_REF_OFFSET = 52;
	private static final int SHADER_SAMPLE_RATE_INTERPOLATION_FUNCTIONS_OFFSET = 56;
	private static final int TESSELLATION_ISOLINES_OFFSET = 60;
	private static final int TESSELLATION_POINT_MODE_OFFSET = 64;
	private static final int TRIANGLE_FANS_OFFSET = 68;
	private static final int VERTEX_ATTRIBUTE_ACCESS_BEYOND_STRIDE_OFFSET = 72;
	
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PORTABILITY_SUBSET_FEATURES_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PORTABILITY_SUBSET_FEATURES_KHR **/
	@NativeType("VkStructureType")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PORTABILITY_SUBSET_FEATURES_KHR **/
	@NativeType("VkStructureType")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000163000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean constantAlphaColorBlendFactors() {
		return (int) INT_HANDLE.get(this.segment, this.offset + CONSTANT_ALPHA_COLOR_BLEND_FACTORS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR constantAlphaColorBlendFactors(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + CONSTANT_ALPHA_COLOR_BLEND_FACTORS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean events() {
		return (int) INT_HANDLE.get(this.segment, this.offset + EVENTS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR events(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + EVENTS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean imageViewFormatReinterpretation() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IMAGE_VIEW_FORMAT_REINTERPRETATION_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR imageViewFormatReinterpretation(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + IMAGE_VIEW_FORMAT_REINTERPRETATION_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean imageViewFormatSwizzle() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IMAGE_VIEW_FORMAT_SWIZZLE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR imageViewFormatSwizzle(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + IMAGE_VIEW_FORMAT_SWIZZLE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean imageView2DOn3DImage() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IMAGE_VIEW2_DON3_DIMAGE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR imageView2DOn3DImage(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + IMAGE_VIEW2_DON3_DIMAGE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean multisampleArrayImage() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MULTISAMPLE_ARRAY_IMAGE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR multisampleArrayImage(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + MULTISAMPLE_ARRAY_IMAGE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean mutableComparisonSamplers() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MUTABLE_COMPARISON_SAMPLERS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR mutableComparisonSamplers(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + MUTABLE_COMPARISON_SAMPLERS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean pointPolygons() {
		return (int) INT_HANDLE.get(this.segment, this.offset + POINT_POLYGONS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR pointPolygons(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + POINT_POLYGONS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean samplerMipLodBias() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SAMPLER_MIP_LOD_BIAS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR samplerMipLodBias(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SAMPLER_MIP_LOD_BIAS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean separateStencilMaskRef() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SEPARATE_STENCIL_MASK_REF_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR separateStencilMaskRef(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SEPARATE_STENCIL_MASK_REF_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean shaderSampleRateInterpolationFunctions() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHADER_SAMPLE_RATE_INTERPOLATION_FUNCTIONS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR shaderSampleRateInterpolationFunctions(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SHADER_SAMPLE_RATE_INTERPOLATION_FUNCTIONS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean tessellationIsolines() {
		return (int) INT_HANDLE.get(this.segment, this.offset + TESSELLATION_ISOLINES_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR tessellationIsolines(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + TESSELLATION_ISOLINES_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean tessellationPointMode() {
		return (int) INT_HANDLE.get(this.segment, this.offset + TESSELLATION_POINT_MODE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR tessellationPointMode(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + TESSELLATION_POINT_MODE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean triangleFans() {
		return (int) INT_HANDLE.get(this.segment, this.offset + TRIANGLE_FANS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR triangleFans(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + TRIANGLE_FANS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean vertexAttributeAccessBeyondStride() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VERTEX_ATTRIBUTE_ACCESS_BEYOND_STRIDE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevicePortabilitySubsetFeaturesKHR vertexAttributeAccessBeyondStride(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + VERTEX_ATTRIBUTE_ACCESS_BEYOND_STRIDE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDevicePortabilitySubsetFeaturesKHR> {
		
		private static final StructConstructor<VkPhysicalDevicePortabilitySubsetFeaturesKHR> CONSTRUCTOR = VkPhysicalDevicePortabilitySubsetFeaturesKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDevicePortabilitySubsetFeaturesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDevicePortabilitySubsetFeaturesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDevicePortabilitySubsetFeaturesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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