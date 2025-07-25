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
* struct VkAabbPositionsKHR {
* 	float minX;
* 	float minY;
* 	float minZ;
* 	float maxX;
* 	float maxY;
* 	float maxZ;
* };
*</pre>
**/
@AutoGenerated
public final class VkAabbPositionsNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT,
			JAVA_FLOAT
	);
	private static final int MIN_X_OFFSET = 0;
	private static final int MIN_Y_OFFSET = 4;
	private static final int MIN_Z_OFFSET = 8;
	private static final int MAX_X_OFFSET = 12;
	private static final int MAX_Y_OFFSET = 16;
	private static final int MAX_Z_OFFSET = 20;
	
	public VkAabbPositionsNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAabbPositionsNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkAabbPositionsNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("float")
	public float minX() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MIN_X_OFFSET);
	}
	
	@NativeType("float")
	public VkAabbPositionsNV minX(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MIN_X_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float minY() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MIN_Y_OFFSET);
	}
	
	@NativeType("float")
	public VkAabbPositionsNV minY(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MIN_Y_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float minZ() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MIN_Z_OFFSET);
	}
	
	@NativeType("float")
	public VkAabbPositionsNV minZ(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MIN_Z_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float maxX() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MAX_X_OFFSET);
	}
	
	@NativeType("float")
	public VkAabbPositionsNV maxX(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MAX_X_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float maxY() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MAX_Y_OFFSET);
	}
	
	@NativeType("float")
	public VkAabbPositionsNV maxY(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MAX_Y_OFFSET, value);
		return this;
	}
	
	@NativeType("float")
	public float maxZ() {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MAX_Z_OFFSET);
	}
	
	@NativeType("float")
	public VkAabbPositionsNV maxZ(float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MAX_Z_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkAabbPositionsNV> {
		
		private static final StructConstructor<VkAabbPositionsNV> CONSTRUCTOR = VkAabbPositionsNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkAabbPositionsNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkAabbPositionsNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkAabbPositionsNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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