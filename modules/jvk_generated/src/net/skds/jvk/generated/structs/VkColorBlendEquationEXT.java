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
* struct VkColorBlendEquationEXT {
* 	VkBlendFactor srcColorBlendFactor;
* 	VkBlendFactor dstColorBlendFactor;
* 	VkBlendOp colorBlendOp;
* 	VkBlendFactor srcAlphaBlendFactor;
* 	VkBlendFactor dstAlphaBlendFactor;
* 	VkBlendOp alphaBlendOp;
* };
*</pre>
**/
@AutoGenerated
public final class VkColorBlendEquationEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT
	);
	private static final int SRC_COLOR_BLEND_FACTOR_OFFSET = 0;
	private static final int DST_COLOR_BLEND_FACTOR_OFFSET = 4;
	private static final int COLOR_BLEND_OP_OFFSET = 8;
	private static final int SRC_ALPHA_BLEND_FACTOR_OFFSET = 12;
	private static final int DST_ALPHA_BLEND_FACTOR_OFFSET = 16;
	private static final int ALPHA_BLEND_OP_OFFSET = 20;
	
	public VkColorBlendEquationEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkColorBlendEquationEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkColorBlendEquationEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("VkBlendFactor")
	public int srcColorBlendFactor() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SRC_COLOR_BLEND_FACTOR_OFFSET);
	}
	
	@NativeType("VkBlendFactor")
	public VkColorBlendEquationEXT srcColorBlendFactor(int value) {
		INT_HANDLE.set(this.segment, this.offset + SRC_COLOR_BLEND_FACTOR_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBlendFactor")
	public int dstColorBlendFactor() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DST_COLOR_BLEND_FACTOR_OFFSET);
	}
	
	@NativeType("VkBlendFactor")
	public VkColorBlendEquationEXT dstColorBlendFactor(int value) {
		INT_HANDLE.set(this.segment, this.offset + DST_COLOR_BLEND_FACTOR_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBlendOp")
	public int colorBlendOp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + COLOR_BLEND_OP_OFFSET);
	}
	
	@NativeType("VkBlendOp")
	public VkColorBlendEquationEXT colorBlendOp(int value) {
		INT_HANDLE.set(this.segment, this.offset + COLOR_BLEND_OP_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBlendFactor")
	public int srcAlphaBlendFactor() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SRC_ALPHA_BLEND_FACTOR_OFFSET);
	}
	
	@NativeType("VkBlendFactor")
	public VkColorBlendEquationEXT srcAlphaBlendFactor(int value) {
		INT_HANDLE.set(this.segment, this.offset + SRC_ALPHA_BLEND_FACTOR_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBlendFactor")
	public int dstAlphaBlendFactor() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DST_ALPHA_BLEND_FACTOR_OFFSET);
	}
	
	@NativeType("VkBlendFactor")
	public VkColorBlendEquationEXT dstAlphaBlendFactor(int value) {
		INT_HANDLE.set(this.segment, this.offset + DST_ALPHA_BLEND_FACTOR_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBlendOp")
	public int alphaBlendOp() {
		return (int) INT_HANDLE.get(this.segment, this.offset + ALPHA_BLEND_OP_OFFSET);
	}
	
	@NativeType("VkBlendOp")
	public VkColorBlendEquationEXT alphaBlendOp(int value) {
		INT_HANDLE.set(this.segment, this.offset + ALPHA_BLEND_OP_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkColorBlendEquationEXT> {
		
		private static final StructConstructor<VkColorBlendEquationEXT> CONSTRUCTOR = VkColorBlendEquationEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkColorBlendEquationEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkColorBlendEquationEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkColorBlendEquationEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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