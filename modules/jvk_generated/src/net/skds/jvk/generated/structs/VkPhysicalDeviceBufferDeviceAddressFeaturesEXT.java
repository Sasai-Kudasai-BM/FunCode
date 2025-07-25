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
* struct VkPhysicalDeviceBufferDeviceAddressFeaturesEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 bufferDeviceAddress;
* 	VkBool32 bufferDeviceAddressCaptureReplay;
* 	VkBool32 bufferDeviceAddressMultiDevice;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceBufferDeviceAddressFeaturesEXT extends CStruct {
	
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
	private static final int BUFFER_DEVICE_ADDRESS_OFFSET = 16;
	private static final int BUFFER_DEVICE_ADDRESS_CAPTURE_REPLAY_OFFSET = 20;
	private static final int BUFFER_DEVICE_ADDRESS_MULTI_DEVICE_OFFSET = 24;
	
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000244000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean bufferDeviceAddress() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BUFFER_DEVICE_ADDRESS_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT bufferDeviceAddress(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + BUFFER_DEVICE_ADDRESS_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean bufferDeviceAddressCaptureReplay() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BUFFER_DEVICE_ADDRESS_CAPTURE_REPLAY_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT bufferDeviceAddressCaptureReplay(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + BUFFER_DEVICE_ADDRESS_CAPTURE_REPLAY_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean bufferDeviceAddressMultiDevice() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BUFFER_DEVICE_ADDRESS_MULTI_DEVICE_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT bufferDeviceAddressMultiDevice(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + BUFFER_DEVICE_ADDRESS_MULTI_DEVICE_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceBufferDeviceAddressFeaturesEXT> {
		
		private static final StructConstructor<VkPhysicalDeviceBufferDeviceAddressFeaturesEXT> CONSTRUCTOR = VkPhysicalDeviceBufferDeviceAddressFeaturesEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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