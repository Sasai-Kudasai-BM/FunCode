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
* struct VkPipelineCacheHeaderVersionOne {
* 	uint32_t headerSize;
* 	VkPipelineCacheHeaderVersion headerVersion;
* 	uint32_t vendorID;
* 	uint32_t deviceID;
* 	uint8_t[16] pipelineCacheUUID;
* };
*</pre>
**/
@AutoGenerated
public final class VkPipelineCacheHeaderVersionOne extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			sequenceLayout(16, JAVA_BYTE)
	);
	private static final int HEADER_SIZE_OFFSET = 0;
	private static final int HEADER_VERSION_OFFSET = 4;
	private static final int VENDOR_ID_OFFSET = 8;
	private static final int DEVICE_ID_OFFSET = 12;
	private static final int PIPELINE_CACHE_UUID_OFFSET = 16;
	
	public VkPipelineCacheHeaderVersionOne() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCacheHeaderVersionOne(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineCacheHeaderVersionOne(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("uint32_t")
	public int headerSize() {
		return (int) INT_HANDLE.get(this.segment, this.offset + HEADER_SIZE_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPipelineCacheHeaderVersionOne headerSize(int value) {
		INT_HANDLE.set(this.segment, this.offset + HEADER_SIZE_OFFSET, value);
		return this;
	}
	
	@NativeType("VkPipelineCacheHeaderVersion")
	public int headerVersion() {
		return (int) INT_HANDLE.get(this.segment, this.offset + HEADER_VERSION_OFFSET);
	}
	
	@NativeType("VkPipelineCacheHeaderVersion")
	public VkPipelineCacheHeaderVersionOne headerVersion(int value) {
		INT_HANDLE.set(this.segment, this.offset + HEADER_VERSION_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int vendorID() {
		return (int) INT_HANDLE.get(this.segment, this.offset + VENDOR_ID_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPipelineCacheHeaderVersionOne vendorID(int value) {
		INT_HANDLE.set(this.segment, this.offset + VENDOR_ID_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int deviceID() {
		return (int) INT_HANDLE.get(this.segment, this.offset + DEVICE_ID_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkPipelineCacheHeaderVersionOne deviceID(int value) {
		INT_HANDLE.set(this.segment, this.offset + DEVICE_ID_OFFSET, value);
		return this;
	}
	
	@NativeType("uint8_t[16]")
	public byte pipelineCacheUUID(int i) {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + PIPELINE_CACHE_UUID_OFFSET + JAVA_BYTE.byteSize() * i);
	}
	
	@NativeType("uint8_t[16]")
	public byte[] pipelineCacheUUIDArray() {
		var array = new byte[16];
		MemorySegment.copy(this.segment, BYTE, this.offset + PIPELINE_CACHE_UUID_OFFSET, array, 0, array.length);
		return array;
	}
	
	@NativeType("uint8_t[16]")
	public VkPipelineCacheHeaderVersionOne pipelineCacheUUID(int i, byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + PIPELINE_CACHE_UUID_OFFSET + JAVA_BYTE.byteSize() * i, value);
		return this;
	}
	
	@NativeType("uint8_t[16]")
	public VkPipelineCacheHeaderVersionOne pipelineCacheUUID(byte[] value) {
		MemorySegment.copy(value, 0, this.segment, BYTE, this.offset + PIPELINE_CACHE_UUID_OFFSET, value.length);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPipelineCacheHeaderVersionOne> {
		
		private static final StructConstructor<VkPipelineCacheHeaderVersionOne> CONSTRUCTOR = VkPipelineCacheHeaderVersionOne::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPipelineCacheHeaderVersionOne[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPipelineCacheHeaderVersionOne[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPipelineCacheHeaderVersionOne[size], CONSTRUCTOR, MEMORY_LAYOUT);
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