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
* struct VkSamplerCreateInfo {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkSamplerCreateFlags flags;
* 	VkFilter magFilter;
* 	VkFilter minFilter;
* 	VkSamplerMipmapMode mipmapMode;
* 	VkSamplerAddressMode addressModeU;
* 	VkSamplerAddressMode addressModeV;
* 	VkSamplerAddressMode addressModeW;
* 	float mipLodBias;
* 	VkBool32 anisotropyEnable;
* 	float maxAnisotropy;
* 	VkBool32 compareEnable;
* 	VkCompareOp compareOp;
* 	float minLod;
* 	float maxLod;
* 	VkBorderColor borderColor;
* 	VkBool32 unnormalizedCoordinates;
* };
*</pre>
**/
@AutoGenerated
public final class VkSamplerCreateInfo extends CStruct {
	
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
			JAVA_FLOAT,
			JAVA_INT,
			JAVA_FLOAT,
			JAVA_INT,
			JAVA_INT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FLAGS_OFFSET = 16;
	private static final int MAG_FILTER_OFFSET = 20;
	private static final int MIN_FILTER_OFFSET = 24;
	private static final int MIPMAP_MODE_OFFSET = 28;
	private static final int ADDRESS_MODE_U_OFFSET = 32;
	private static final int ADDRESS_MODE_V_OFFSET = 36;
	private static final int ADDRESS_MODE_W_OFFSET = 40;
	private static final int MIP_LOD_BIAS_OFFSET = 44;
	private static final int ANISOTROPY_ENABLE_OFFSET = 48;
	private static final int MAX_ANISOTROPY_OFFSET = 52;
	private static final int COMPARE_ENABLE_OFFSET = 56;
	private static final int COMPARE_OP_OFFSET = 60;
	private static final int MIN_LOD_OFFSET = 64;
	private static final int MAX_LOD_OFFSET = 68;
	private static final int BORDER_COLOR_OFFSET = 72;
	private static final int UNNORMALIZED_COORDINATES_OFFSET = 76;
	
	public VkSamplerCreateInfo() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSamplerCreateInfo(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSamplerCreateInfo(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO **/
	@NativeType("VkStructureType")
	public VkSamplerCreateInfo sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO **/
	@NativeType("VkStructureType")
	public VkSamplerCreateInfo sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 31);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkSamplerCreateInfo pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkSamplerCreateFlags")
	public int flags() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FLAGS_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkSamplerCreateFlags")
	public VkSamplerCreateInfo flags(int value) {
		INT_HANDLE.set(this.segment, this.offset + FLAGS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFilter")
	public int magFilter() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MAG_FILTER_OFFSET);
	}
	
	@NativeType("VkFilter")
	public VkSamplerCreateInfo magFilter(int value) {
		INT_HANDLE.set(this.segment, this.offset + MAG_FILTER_OFFSET, value);
		return this;
	}
	
	@NativeType("VkFilter")
	public int minFilter() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MIN_FILTER_OFFSET);
	}
	
	@NativeType("VkFilter")
	public VkSamplerCreateInfo minFilter(int value) {
		INT_HANDLE.set(this.segment, this.offset + MIN_FILTER_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSamplerMipmapMode")
	public int mipmapMode() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MIPMAP_MODE_OFFSET);
	}
	
	@NativeType("VkSamplerMipmapMode")
	public VkSamplerCreateInfo mipmapMode(int value) {
		INT_HANDLE.set(this.segment, this.offset + MIPMAP_MODE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSamplerAddressMode")
	public int addressModeU() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ADDRESS_MODE_U_OFFSET);
	}
	
	@NativeType("VkSamplerAddressMode")
	public VkSamplerCreateInfo addressModeU(int value) {
		INT_HANDLE.set(this.segment, this.offset + ADDRESS_MODE_U_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSamplerAddressMode")
	public int addressModeV() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ADDRESS_MODE_V_OFFSET);
	}
	
	@NativeType("VkSamplerAddressMode")
	public VkSamplerCreateInfo addressModeV(int value) {
		INT_HANDLE.set(this.segment, this.offset + ADDRESS_MODE_V_OFFSET, value);
		return this;
	}
	
	@NativeType("VkSamplerAddressMode")
	public int addressModeW() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ADDRESS_MODE_W_OFFSET);
	}
	
	@NativeType("VkSamplerAddressMode")
	public VkSamplerCreateInfo addressModeW(int value) {
		INT_HANDLE.set(this.segment, this.offset + ADDRESS_MODE_W_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float mipLodBias() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MIP_LOD_BIAS_OFFSET);
	}
	
	@NativeType("float")
	public VkSamplerCreateInfo mipLodBias(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MIP_LOD_BIAS_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean anisotropyEnable() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ANISOTROPY_ENABLE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkSamplerCreateInfo anisotropyEnable(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + ANISOTROPY_ENABLE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("float")
	public float maxAnisotropy() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MAX_ANISOTROPY_OFFSET);
	}
	
	@NativeType("float")
	public VkSamplerCreateInfo maxAnisotropy(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MAX_ANISOTROPY_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean compareEnable() {
		return (int) INT_HANDLE.get(this.segment, this.offset + COMPARE_ENABLE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkSamplerCreateInfo compareEnable(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + COMPARE_ENABLE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkCompareOp")
	public int compareOp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + COMPARE_OP_OFFSET);
	}
	
	@NativeType("VkCompareOp")
	public VkSamplerCreateInfo compareOp(int value) {
		INT_HANDLE.set(this.segment, this.offset + COMPARE_OP_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float minLod() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MIN_LOD_OFFSET);
	}
	
	@NativeType("float")
	public VkSamplerCreateInfo minLod(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MIN_LOD_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float maxLod() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MAX_LOD_OFFSET);
	}
	
	@NativeType("float")
	public VkSamplerCreateInfo maxLod(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MAX_LOD_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBorderColor")
	public int borderColor() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BORDER_COLOR_OFFSET);
	}
	
	@NativeType("VkBorderColor")
	public VkSamplerCreateInfo borderColor(int value) {
		INT_HANDLE.set(this.segment, this.offset + BORDER_COLOR_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean unnormalizedCoordinates() {
		return (int) INT_HANDLE.get(this.segment, this.offset + UNNORMALIZED_COORDINATES_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkSamplerCreateInfo unnormalizedCoordinates(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + UNNORMALIZED_COORDINATES_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkSamplerCreateInfo> {
		
		private static final StructConstructor<VkSamplerCreateInfo> CONSTRUCTOR = VkSamplerCreateInfo::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkSamplerCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkSamplerCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkSamplerCreateInfo[size], CONSTRUCTOR, MEMORY_LAYOUT);
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