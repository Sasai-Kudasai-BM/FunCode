package net.skds.jvk.generated.structs;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.StructConstructor;
import net.skds.jvk.VkStructArray;
import net.skds.jvk.annotation.NativeType;
import net.skds.jvk.generated.unions.VkPipelineExecutableStatisticValueKHR;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static java.lang.foreign.ValueLayout.*;
import static net.skds.lib2.natives.LinkerUtils.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* struct VkPipelineExecutableStatisticKHR {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	char[256] name;
* 	char[256] description;
* 	VkPipelineExecutableStatisticFormatKHR format;
* 	// pad (4)
* 	VkPipelineExecutableStatisticValueKHR value;
* };
*</pre>
**/
@AutoGenerated
public final class VkPipelineExecutableStatisticKHR extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			sequenceLayout(256, JAVA_BYTE),
			sequenceLayout(256, JAVA_BYTE),
			JAVA_INT,
			paddingLayout(4),
			VkPipelineExecutableStatisticValueKHR.MEMORY_LAYOUT
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int NAME_OFFSET = 16;
	private static final int DESCRIPTION_OFFSET = 272;
	private static final int FORMAT_OFFSET = 528;
	private static final int VALUE_OFFSET = 536;
	
	public VkPipelineExecutableStatisticKHR() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineExecutableStatisticKHR(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPipelineExecutableStatisticKHR(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_STATISTIC_KHR **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_STATISTIC_KHR **/
	@NativeType("VkStructureType")
	public VkPipelineExecutableStatisticKHR sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_STATISTIC_KHR **/
	@NativeType("VkStructureType")
	public VkPipelineExecutableStatisticKHR sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000269004);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPipelineExecutableStatisticKHR pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("char[256]")
	public byte name(int i) {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + NAME_OFFSET + JAVA_BYTE.byteSize() * i);
	}
	
	@NativeType("char[256]")
	public byte[] nameArray() {
		var array = new byte[256];
		MemorySegment.copy(this.segment, BYTE, this.offset + NAME_OFFSET, array, 0, array.length);
		return array;
	}
	
	@NativeType("char[256]")
	public String name() {
		return this.segment.getString(this.offset + NAME_OFFSET);
	}
	
	@NativeType("char[256]")
	public VkPipelineExecutableStatisticKHR name(int i, byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + NAME_OFFSET + JAVA_BYTE.byteSize() * i, value);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPipelineExecutableStatisticKHR name(byte[] value) {
		MemorySegment.copy(value, 0, this.segment, BYTE, this.offset + NAME_OFFSET, value.length);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPipelineExecutableStatisticKHR name(String value) {
		this.segment.setString(this.offset + NAME_OFFSET, value);
		return this;
	}
	
	@NativeType("char[256]")
	public byte description(int i) {
		return (byte) BYTE_HANDLE.get(this.segment, this.offset + DESCRIPTION_OFFSET + JAVA_BYTE.byteSize() * i);
	}
	
	@NativeType("char[256]")
	public byte[] descriptionArray() {
		var array = new byte[256];
		MemorySegment.copy(this.segment, BYTE, this.offset + DESCRIPTION_OFFSET, array, 0, array.length);
		return array;
	}
	
	@NativeType("char[256]")
	public String description() {
		return this.segment.getString(this.offset + DESCRIPTION_OFFSET);
	}
	
	@NativeType("char[256]")
	public VkPipelineExecutableStatisticKHR description(int i, byte value) {
		BYTE_HANDLE.set(this.segment, this.offset + DESCRIPTION_OFFSET + JAVA_BYTE.byteSize() * i, value);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPipelineExecutableStatisticKHR description(byte[] value) {
		MemorySegment.copy(value, 0, this.segment, BYTE, this.offset + DESCRIPTION_OFFSET, value.length);
		return this;
	}
	
	@NativeType("char[256]")
	public VkPipelineExecutableStatisticKHR description(String value) {
		this.segment.setString(this.offset + DESCRIPTION_OFFSET, value);
		return this;
	}
	
	@NativeType("VkPipelineExecutableStatisticFormatKHR")
	public int format() {
		return (int) INT_HANDLE.get(this.segment, this.offset + FORMAT_OFFSET);
	}
	
	@NativeType("VkPipelineExecutableStatisticFormatKHR")
	public VkPipelineExecutableStatisticKHR format(int value) {
		INT_HANDLE.set(this.segment, this.offset + FORMAT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkPipelineExecutableStatisticValueKHR")
	public VkPipelineExecutableStatisticValueKHR value() {
		return new VkPipelineExecutableStatisticValueKHR(this.segment, this.offset + VALUE_OFFSET);
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPipelineExecutableStatisticKHR> {
		
		private static final StructConstructor<VkPipelineExecutableStatisticKHR> CONSTRUCTOR = VkPipelineExecutableStatisticKHR::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPipelineExecutableStatisticKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPipelineExecutableStatisticKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPipelineExecutableStatisticKHR[size], CONSTRUCTOR, MEMORY_LAYOUT);
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