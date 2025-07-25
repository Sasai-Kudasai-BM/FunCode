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
* struct VkAndroidHardwareBufferFormatProperties2ANDROID {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkFormat format;
* 	// pad (4)
* 	uint64_t externalFormat;
* 	VkFormatFeatureFlags2 formatFeatures;
* 	VkComponentMapping samplerYcbcrConversionComponents;
* 	VkSamplerYcbcrModelConversion suggestedYcbcrModel;
* 	VkSamplerYcbcrRange suggestedYcbcrRange;
* 	VkChromaLocation suggestedXChromaOffset;
* 	VkChromaLocation suggestedYChromaOffset;
* };
*</pre>
**/
@AutoGenerated
public final class VkAndroidHardwareBufferFormatProperties2ANDROID extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			VkComponentMapping.MEMORY_LAYOUT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FORMAT_OFFSET = 16;
	private static final int EXTERNAL_FORMAT_OFFSET = 24;
	private static final int FORMAT_FEATURES_OFFSET = 32;
	private static final int SAMPLER_YCBCR_CONVERSION_COMPONENTS_OFFSET = 40;
	private static final int SUGGESTED_YCBCR_MODEL_OFFSET = 56;
	private static final int SUGGESTED_YCBCR_RANGE_OFFSET = 60;
	private static final int SUGGESTED_XCHROMA_OFFSET_OFFSET = 64;
	private static final int SUGGESTED_YCHROMA_OFFSET_OFFSET = 68;
	
	public VkAndroidHardwareBufferFormatProperties2ANDROID() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAndroidHardwareBufferFormatProperties2ANDROID(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAndroidHardwareBufferFormatProperties2ANDROID(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_2_ANDROID **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_2_ANDROID **/
	@NativeType("VkStructureType")
	public VkAndroidHardwareBufferFormatProperties2ANDROID sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_2_ANDROID **/
	@NativeType("VkStructureType")
	public VkAndroidHardwareBufferFormatProperties2ANDROID sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000129006);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkAndroidHardwareBufferFormatProperties2ANDROID pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFormat")
	public int format() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FORMAT_OFFSET);
	}
	
	@NativeType("VkFormat")
	public VkAndroidHardwareBufferFormatProperties2ANDROID format(int value) {
		INT_HANDLE.set(this.segment, this.offset + FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("uint64_t")
	public long externalFormat() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + EXTERNAL_FORMAT_OFFSET);
	}
	
	@NativeType("uint64_t")
	public VkAndroidHardwareBufferFormatProperties2ANDROID externalFormat(long value) {
		LONG_HANDLE.set(this.segment, this.offset + EXTERNAL_FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFormatFeatureFlags2")
	public long formatFeatures() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + FORMAT_FEATURES_OFFSET);
	}
	
	@NativeType("VkFormatFeatureFlags2")
	public VkAndroidHardwareBufferFormatProperties2ANDROID formatFeatures(long value) {
		LONG_HANDLE.set(this.segment, this.offset + FORMAT_FEATURES_OFFSET, value);
		return this;
	}
	
	@NativeType("VkComponentMapping")
	public VkComponentMapping samplerYcbcrConversionComponents() {
		return new VkComponentMapping(this.segment, this.offset + SAMPLER_YCBCR_CONVERSION_COMPONENTS_OFFSET);
	}
	
	@NativeType("VkSamplerYcbcrModelConversion")
	public int suggestedYcbcrModel() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SUGGESTED_YCBCR_MODEL_OFFSET);
	}
	
	@NativeType("VkSamplerYcbcrModelConversion")
	public VkAndroidHardwareBufferFormatProperties2ANDROID suggestedYcbcrModel(int value) {
		INT_HANDLE.set(this.segment, this.offset + SUGGESTED_YCBCR_MODEL_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSamplerYcbcrRange")
	public int suggestedYcbcrRange() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SUGGESTED_YCBCR_RANGE_OFFSET);
	}
	
	@NativeType("VkSamplerYcbcrRange")
	public VkAndroidHardwareBufferFormatProperties2ANDROID suggestedYcbcrRange(int value) {
		INT_HANDLE.set(this.segment, this.offset + SUGGESTED_YCBCR_RANGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkChromaLocation")
	public int suggestedXChromaOffset() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SUGGESTED_XCHROMA_OFFSET_OFFSET);
	}
	
	@NativeType("VkChromaLocation")
	public VkAndroidHardwareBufferFormatProperties2ANDROID suggestedXChromaOffset(int value) {
		INT_HANDLE.set(this.segment, this.offset + SUGGESTED_XCHROMA_OFFSET_OFFSET, value);
		return this;
	}
	
	@NativeType("VkChromaLocation")
	public int suggestedYChromaOffset() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SUGGESTED_YCHROMA_OFFSET_OFFSET);
	}
	
	@NativeType("VkChromaLocation")
	public VkAndroidHardwareBufferFormatProperties2ANDROID suggestedYChromaOffset(int value) {
		INT_HANDLE.set(this.segment, this.offset + SUGGESTED_YCHROMA_OFFSET_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkAndroidHardwareBufferFormatProperties2ANDROID> {
		
		private static final StructConstructor<VkAndroidHardwareBufferFormatProperties2ANDROID> CONSTRUCTOR = VkAndroidHardwareBufferFormatProperties2ANDROID::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkAndroidHardwareBufferFormatProperties2ANDROID[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkAndroidHardwareBufferFormatProperties2ANDROID[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkAndroidHardwareBufferFormatProperties2ANDROID[size], CONSTRUCTOR, MEMORY_LAYOUT);
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