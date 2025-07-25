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
* struct VkSamplerYcbcrConversionCreateInfo {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkFormat format;
* 	VkSamplerYcbcrModelConversion ycbcrModel;
* 	VkSamplerYcbcrRange ycbcrRange;
* 	VkComponentMapping components;
* 	VkChromaLocation xChromaOffset;
* 	VkChromaLocation yChromaOffset;
* 	VkFilter chromaFilter;
* 	VkBool32 forceExplicitReconstruction;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkSamplerYcbcrConversionCreateInfo extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			VkComponentMapping.MEMORY_LAYOUT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FORMAT_OFFSET = 16;
	private static final int YCBCR_MODEL_OFFSET = 20;
	private static final int YCBCR_RANGE_OFFSET = 24;
	private static final int COMPONENTS_OFFSET = 28;
	private static final int X_CHROMA_OFFSET_OFFSET = 44;
	private static final int Y_CHROMA_OFFSET_OFFSET = 48;
	private static final int CHROMA_FILTER_OFFSET = 52;
	private static final int FORCE_EXPLICIT_RECONSTRUCTION_OFFSET = 56;
	
	public VkSamplerYcbcrConversionCreateInfo() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSamplerYcbcrConversionCreateInfo(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSamplerYcbcrConversionCreateInfo(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_CREATE_INFO **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_CREATE_INFO **/
	@NativeType("VkStructureType")
	public VkSamplerYcbcrConversionCreateInfo sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_CREATE_INFO **/
	@NativeType("VkStructureType")
	public VkSamplerYcbcrConversionCreateInfo sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000156000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkSamplerYcbcrConversionCreateInfo pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFormat")
	public int format() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FORMAT_OFFSET);
	}
	
	@NativeType("VkFormat")
	public VkSamplerYcbcrConversionCreateInfo format(int value) {
		INT_HANDLE.set(this.segment, this.offset + FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSamplerYcbcrModelConversion")
	public int ycbcrModel() {
		return (int) INT_HANDLE.get(this.segment, this.offset + YCBCR_MODEL_OFFSET);
	}
	
	@NativeType("VkSamplerYcbcrModelConversion")
	public VkSamplerYcbcrConversionCreateInfo ycbcrModel(int value) {
		INT_HANDLE.set(this.segment, this.offset + YCBCR_MODEL_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSamplerYcbcrRange")
	public int ycbcrRange() {
		return (int) INT_HANDLE.get(this.segment, this.offset + YCBCR_RANGE_OFFSET);
	}
	
	@NativeType("VkSamplerYcbcrRange")
	public VkSamplerYcbcrConversionCreateInfo ycbcrRange(int value) {
		INT_HANDLE.set(this.segment, this.offset + YCBCR_RANGE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkComponentMapping")
	public VkComponentMapping components() {
		return new VkComponentMapping(this.segment, this.offset + COMPONENTS_OFFSET);
	}
	
	@NativeType("VkChromaLocation")
	public int xChromaOffset() {
		return (int) INT_HANDLE.get(this.segment, this.offset + X_CHROMA_OFFSET_OFFSET);
	}
	
	@NativeType("VkChromaLocation")
	public VkSamplerYcbcrConversionCreateInfo xChromaOffset(int value) {
		INT_HANDLE.set(this.segment, this.offset + X_CHROMA_OFFSET_OFFSET, value);
		return this;
	}
	
	@NativeType("VkChromaLocation")
	public int yChromaOffset() {
		return (int) INT_HANDLE.get(this.segment, this.offset + Y_CHROMA_OFFSET_OFFSET);
	}
	
	@NativeType("VkChromaLocation")
	public VkSamplerYcbcrConversionCreateInfo yChromaOffset(int value) {
		INT_HANDLE.set(this.segment, this.offset + Y_CHROMA_OFFSET_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFilter")
	public int chromaFilter() {
		return (int) INT_HANDLE.get(this.segment, this.offset + CHROMA_FILTER_OFFSET);
	}
	
	@NativeType("VkFilter")
	public VkSamplerYcbcrConversionCreateInfo chromaFilter(int value) {
		INT_HANDLE.set(this.segment, this.offset + CHROMA_FILTER_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean forceExplicitReconstruction() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FORCE_EXPLICIT_RECONSTRUCTION_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkSamplerYcbcrConversionCreateInfo forceExplicitReconstruction(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + FORCE_EXPLICIT_RECONSTRUCTION_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkSamplerYcbcrConversionCreateInfo> {
		
		private static final StructConstructor<VkSamplerYcbcrConversionCreateInfo> CONSTRUCTOR = VkSamplerYcbcrConversionCreateInfo::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkSamplerYcbcrConversionCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkSamplerYcbcrConversionCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkSamplerYcbcrConversionCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
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