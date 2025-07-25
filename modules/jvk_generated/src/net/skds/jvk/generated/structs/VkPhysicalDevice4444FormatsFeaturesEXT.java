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
* struct VkPhysicalDevice4444FormatsFeaturesEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 formatA4R4G4B4;
* 	VkBool32 formatA4B4G4R4;
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDevice4444FormatsFeaturesEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FORMAT_A4_R4_G4_B4_OFFSET = 16;
	private static final int FORMAT_A4_B4_G4_R4_OFFSET = 20;
	
	public VkPhysicalDevice4444FormatsFeaturesEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDevice4444FormatsFeaturesEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDevice4444FormatsFeaturesEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_4444_FORMATS_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_4444_FORMATS_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDevice4444FormatsFeaturesEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_4444_FORMATS_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDevice4444FormatsFeaturesEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000340000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDevice4444FormatsFeaturesEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean formatA4R4G4B4() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FORMAT_A4_R4_G4_B4_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevice4444FormatsFeaturesEXT formatA4R4G4B4(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + FORMAT_A4_R4_G4_B4_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean formatA4B4G4R4() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FORMAT_A4_B4_G4_R4_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDevice4444FormatsFeaturesEXT formatA4B4G4R4(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + FORMAT_A4_B4_G4_R4_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDevice4444FormatsFeaturesEXT> {
		
		private static final StructConstructor<VkPhysicalDevice4444FormatsFeaturesEXT> CONSTRUCTOR = VkPhysicalDevice4444FormatsFeaturesEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDevice4444FormatsFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDevice4444FormatsFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDevice4444FormatsFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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