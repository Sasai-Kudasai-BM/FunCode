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
* struct VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 rayTracingMaintenance1;
* 	VkBool32 rayTracingPipelineTraceRaysIndirect2;
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int RAY_TRACING_MAINTENANCE1_OFFSET = 16;
	private static final int RAY_TRACING_PIPELINE_TRACE_RAYS_INDIRECT2_OFFSET = 20;
	
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_MAINTENANCE_1_FEATURES_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_MAINTENANCE_1_FEATURES_KHR **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_MAINTENANCE_1_FEATURES_KHR **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000386000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean rayTracingMaintenance1() {
		return (int) INT_HANDLE.get(this.segment, this.offset + RAY_TRACING_MAINTENANCE1_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR rayTracingMaintenance1(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + RAY_TRACING_MAINTENANCE1_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean rayTracingPipelineTraceRaysIndirect2() {
		return (int) INT_HANDLE.get(this.segment, this.offset + RAY_TRACING_PIPELINE_TRACE_RAYS_INDIRECT2_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR rayTracingPipelineTraceRaysIndirect2(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + RAY_TRACING_PIPELINE_TRACE_RAYS_INDIRECT2_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR> {
		
		private static final StructConstructor<VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR> CONSTRUCTOR = VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceRayTracingMaintenance1FeaturesKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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