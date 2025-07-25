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
* struct VkSwapchainPresentScalingCreateInfoKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkPresentScalingFlagsKHR scalingBehavior;
* 	VkPresentGravityFlagsKHR presentGravityX;
* 	VkPresentGravityFlagsKHR presentGravityY;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkSwapchainPresentScalingCreateInfoEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int SCALING_BEHAVIOR_OFFSET = 16;
	private static final int PRESENT_GRAVITY_X_OFFSET = 20;
	private static final int PRESENT_GRAVITY_Y_OFFSET = 24;
	
	public VkSwapchainPresentScalingCreateInfoEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSwapchainPresentScalingCreateInfoEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkSwapchainPresentScalingCreateInfoEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_SWAPCHAIN_PRESENT_SCALING_CREATE_INFO_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_SWAPCHAIN_PRESENT_SCALING_CREATE_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkSwapchainPresentScalingCreateInfoEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_SWAPCHAIN_PRESENT_SCALING_CREATE_INFO_KHR **/
	@NativeType("VkStructureType")
	public VkSwapchainPresentScalingCreateInfoEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000275004);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkSwapchainPresentScalingCreateInfoEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkPresentScalingFlagsKHR")
	public int scalingBehavior() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SCALING_BEHAVIOR_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkPresentScalingFlagsKHR")
	public VkSwapchainPresentScalingCreateInfoEXT scalingBehavior(int value) {
		INT_HANDLE.set(this.segment, this.offset + SCALING_BEHAVIOR_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkPresentGravityFlagsKHR")
	public int presentGravityX() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PRESENT_GRAVITY_X_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkPresentGravityFlagsKHR")
	public VkSwapchainPresentScalingCreateInfoEXT presentGravityX(int value) {
		INT_HANDLE.set(this.segment, this.offset + PRESENT_GRAVITY_X_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkPresentGravityFlagsKHR")
	public int presentGravityY() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PRESENT_GRAVITY_Y_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkPresentGravityFlagsKHR")
	public VkSwapchainPresentScalingCreateInfoEXT presentGravityY(int value) {
		INT_HANDLE.set(this.segment, this.offset + PRESENT_GRAVITY_Y_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkSwapchainPresentScalingCreateInfoEXT> {
		
		private static final StructConstructor<VkSwapchainPresentScalingCreateInfoEXT> CONSTRUCTOR = VkSwapchainPresentScalingCreateInfoEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkSwapchainPresentScalingCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkSwapchainPresentScalingCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkSwapchainPresentScalingCreateInfoEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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