package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static net.skds.lib2.natives.SafeLinker.*;
import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkMultiviewPerViewAttributesInfoNVX {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 perViewAttributes;
* 	VkBool32 perViewAttributesPositionXOnly;
* };
*</pre>
**/
@AutoGenerated
public final class VkMultiviewPerViewAttributesInfoNVX extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int PER_VIEW_ATTRIBUTES_OFFSET = 16;
	private static final int PER_VIEW_ATTRIBUTES_POSITION_XONLY_OFFSET = 20;
	
	public VkMultiviewPerViewAttributesInfoNVX() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMultiviewPerViewAttributesInfoNVX(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkMultiviewPerViewAttributesInfoNVX(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_MULTIVIEW_PER_VIEW_ATTRIBUTES_INFO_NVX **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_MULTIVIEW_PER_VIEW_ATTRIBUTES_INFO_NVX **/
	@NativeType("VkStructureType")
	public VkMultiviewPerViewAttributesInfoNVX sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_MULTIVIEW_PER_VIEW_ATTRIBUTES_INFO_NVX **/
	@NativeType("VkStructureType")
	public VkMultiviewPerViewAttributesInfoNVX sType$Default() {
		INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET, 9);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkMultiviewPerViewAttributesInfoNVX pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public int perViewAttributes() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PER_VIEW_ATTRIBUTES_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkMultiviewPerViewAttributesInfoNVX perViewAttributes(int value) {
		INT_HANDLE.set(this.segment, this.offset + PER_VIEW_ATTRIBUTES_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public int perViewAttributesPositionXOnly() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PER_VIEW_ATTRIBUTES_POSITION_XONLY_OFFSET);
	}
	
	@NativeType("VkBool32")
	public VkMultiviewPerViewAttributesInfoNVX perViewAttributesPositionXOnly(int value) {
		INT_HANDLE.set(this.segment, this.offset + PER_VIEW_ATTRIBUTES_POSITION_XONLY_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkMultiviewPerViewAttributesInfoNVX> {
		
		private static final StructConstructor<VkMultiviewPerViewAttributesInfoNVX> CONSTRUCTOR = VkMultiviewPerViewAttributesInfoNVX::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkMultiviewPerViewAttributesInfoNVX[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkMultiviewPerViewAttributesInfoNVX[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkMultiviewPerViewAttributesInfoNVX[size], CONSTRUCTOR, MEMORY_LAYOUT);
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