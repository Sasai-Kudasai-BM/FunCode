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
* struct VkTransformMatrixKHR {
* 	float[3][4] matrix;
* };
*</pre>
**/
@AutoGenerated
public final class VkTransformMatrixKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(sequenceLayout(12, JAVA_FLOAT));
	private static final int MATRIX_OFFSET = 0;
	
	public VkTransformMatrixKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkTransformMatrixKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkTransformMatrixKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("float[3][4]")
	public float matrix(int i) {
		return (float) FLOAT_HANDLE.get(this.segment, this.offset + MATRIX_OFFSET + JAVA_FLOAT.byteSize() * i);
	}
	
	@NativeType("float[3][4]")
	public float[] matrixArray() {
		var array = new float[12];
		MemorySegment.copy(this.segment, FLOAT, this.offset + MATRIX_OFFSET, array, 0, array.length);
		return array;
	}
	
	@NativeType("float[3][4]")
	public VkTransformMatrixKHR matrix(int i, float value) {
		FLOAT_HANDLE.set(this.segment, this.offset + MATRIX_OFFSET + JAVA_FLOAT.byteSize() * i, value);
		return this;
	}
	
	@NativeType("float[3][4]")
	public VkTransformMatrixKHR matrix(float[] value) {
		MemorySegment.copy(value, 0, this.segment, FLOAT, this.offset + MATRIX_OFFSET, value.length);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkTransformMatrixKHR> {
		
		private static final StructConstructor<VkTransformMatrixKHR> CONSTRUCTOR = VkTransformMatrixKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkTransformMatrixKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkTransformMatrixKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkTransformMatrixKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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