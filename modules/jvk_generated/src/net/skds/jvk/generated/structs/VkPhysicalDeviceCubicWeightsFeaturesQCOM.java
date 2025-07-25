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
* struct VkPhysicalDeviceCubicWeightsFeaturesQCOM {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 selectableCubicWeights;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceCubicWeightsFeaturesQCOM extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SELECTABLE_CUBIC_WEIGHTS_OFFSET = 16;
	
	public VkPhysicalDeviceCubicWeightsFeaturesQCOM() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceCubicWeightsFeaturesQCOM(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceCubicWeightsFeaturesQCOM(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CUBIC_WEIGHTS_FEATURES_QCOM **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CUBIC_WEIGHTS_FEATURES_QCOM **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceCubicWeightsFeaturesQCOM sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CUBIC_WEIGHTS_FEATURES_QCOM **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceCubicWeightsFeaturesQCOM sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000519001);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceCubicWeightsFeaturesQCOM pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean selectableCubicWeights() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SELECTABLE_CUBIC_WEIGHTS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceCubicWeightsFeaturesQCOM selectableCubicWeights(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + SELECTABLE_CUBIC_WEIGHTS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceCubicWeightsFeaturesQCOM> {
		
		private static final StructConstructor<VkPhysicalDeviceCubicWeightsFeaturesQCOM> CONSTRUCTOR = VkPhysicalDeviceCubicWeightsFeaturesQCOM::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceCubicWeightsFeaturesQCOM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceCubicWeightsFeaturesQCOM[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceCubicWeightsFeaturesQCOM[size], CONSTRUCTOR, MEMORY_LAYOUT);
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