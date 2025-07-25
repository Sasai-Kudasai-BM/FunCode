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
* struct VkSRTDataNV {
* 	float sx;
* 	float a;
* 	float b;
* 	float pvx;
* 	float sy;
* 	float c;
* 	float pvy;
* 	float sz;
* 	float pvz;
* 	float qx;
* 	float qy;
* 	float qz;
* 	float qw;
* 	float tx;
* 	float ty;
* 	float tz;
* };
*</pre>
**/
@AutoGenerated
public final class VkSRTDataNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT
	);
	private static final int SX_OFFSET = 0;
	private static final int A_OFFSET = 4;
	private static final int B_OFFSET = 8;
	private static final int PVX_OFFSET = 12;
	private static final int SY_OFFSET = 16;
	private static final int C_OFFSET = 20;
	private static final int PVY_OFFSET = 24;
	private static final int SZ_OFFSET = 28;
	private static final int PVZ_OFFSET = 32;
	private static final int QX_OFFSET = 36;
	private static final int QY_OFFSET = 40;
	private static final int QZ_OFFSET = 44;
	private static final int QW_OFFSET = 48;
	private static final int TX_OFFSET = 52;
	private static final int TY_OFFSET = 56;
	private static final int TZ_OFFSET = 60;
	
	public VkSRTDataNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSRTDataNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSRTDataNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("float")
	public float sx() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + SX_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV sx(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + SX_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float a() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + A_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV a(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + A_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float b() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + B_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV b(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + B_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float pvx() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + PVX_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV pvx(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + PVX_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float sy() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + SY_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV sy(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + SY_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float c() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + C_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV c(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + C_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float pvy() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + PVY_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV pvy(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + PVY_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float sz() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + SZ_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV sz(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + SZ_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float pvz() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + PVZ_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV pvz(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + PVZ_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float qx() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + QX_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV qx(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + QX_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float qy() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + QY_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV qy(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + QY_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float qz() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + QZ_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV qz(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + QZ_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float qw() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + QW_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV qw(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + QW_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float tx() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + TX_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV tx(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + TX_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float ty() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + TY_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV ty(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + TY_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float tz() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + TZ_OFFSET);
	}
	
	@NativeType("float")
	public VkSRTDataNV tz(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + TZ_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkSRTDataNV> {
		
		private static final StructConstructor<VkSRTDataNV> CONSTRUCTOR = VkSRTDataNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkSRTDataNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkSRTDataNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkSRTDataNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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