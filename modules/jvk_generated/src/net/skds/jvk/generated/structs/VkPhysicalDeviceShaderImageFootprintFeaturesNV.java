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
* struct VkPhysicalDeviceShaderImageFootprintFeaturesNV {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 imageFootprint;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceShaderImageFootprintFeaturesNV extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int IMAGE_FOOTPRINT_OFFSET = 16;
	
	public VkPhysicalDeviceShaderImageFootprintFeaturesNV() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceShaderImageFootprintFeaturesNV(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceShaderImageFootprintFeaturesNV(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_IMAGE_FOOTPRINT_FEATURES_NV **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_IMAGE_FOOTPRINT_FEATURES_NV **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceShaderImageFootprintFeaturesNV sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_IMAGE_FOOTPRINT_FEATURES_NV **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceShaderImageFootprintFeaturesNV sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000204000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceShaderImageFootprintFeaturesNV pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean imageFootprint() {
		return (int) INT_HANDLE.get(this.segment, this.offset + IMAGE_FOOTPRINT_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceShaderImageFootprintFeaturesNV imageFootprint(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + IMAGE_FOOTPRINT_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceShaderImageFootprintFeaturesNV> {
		
		private static final StructConstructor<VkPhysicalDeviceShaderImageFootprintFeaturesNV> CONSTRUCTOR = VkPhysicalDeviceShaderImageFootprintFeaturesNV::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceShaderImageFootprintFeaturesNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceShaderImageFootprintFeaturesNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceShaderImageFootprintFeaturesNV[size], CONSTRUCTOR, MEMORY_LAYOUT);
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