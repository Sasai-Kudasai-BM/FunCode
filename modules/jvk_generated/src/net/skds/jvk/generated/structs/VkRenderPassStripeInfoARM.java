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
* struct VkRenderPassStripeInfoARM {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkRect2D stripeArea;
* };
*</pre>
**/
@AutoGenerated
public final class VkRenderPassStripeInfoARM extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			VkRect2D.MEMORY_LAYOUT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int STRIPE_AREA_OFFSET = 16;
	
	public VkRenderPassStripeInfoARM() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRenderPassStripeInfoARM(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkRenderPassStripeInfoARM(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_RENDER_PASS_STRIPE_INFO_ARM **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_RENDER_PASS_STRIPE_INFO_ARM **/
	@NativeType("VkStructureType")
	public VkRenderPassStripeInfoARM sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_RENDER_PASS_STRIPE_INFO_ARM **/
	@NativeType("VkStructureType")
	public VkRenderPassStripeInfoARM sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000424003);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkRenderPassStripeInfoARM pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkRect2D")
	public VkRect2D stripeArea() {
		return new VkRect2D(this.segment, this.offset + STRIPE_AREA_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkRenderPassStripeInfoARM> {
		
		private static final StructConstructor<VkRenderPassStripeInfoARM> CONSTRUCTOR = VkRenderPassStripeInfoARM::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkRenderPassStripeInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkRenderPassStripeInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkRenderPassStripeInfoARM[size], CONSTRUCTOR, MEMORY_LAYOUT);
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