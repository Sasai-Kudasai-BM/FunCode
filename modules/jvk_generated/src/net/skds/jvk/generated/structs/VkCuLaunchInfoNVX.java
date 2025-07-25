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
* struct VkCuLaunchInfoNVX {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkCuFunctionNVX* function;
* 	uint32_t gridDimX;
* 	uint32_t gridDimY;
* 	uint32_t gridDimZ;
* 	uint32_t blockDimX;
* 	uint32_t blockDimY;
* 	uint32_t blockDimZ;
* 	uint32_t sharedMemBytes;
* 	// pad (4)
* 	size_t paramCount;
* 	void* pParams;
* 	size_t extraCount;
* 	void* pExtras;
* };
*</pre>
**/
@AutoGenerated
public final class VkCuLaunchInfoNVX extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int FUNCTION_OFFSET = 16;
	private static final int GRID_DIM_X_OFFSET = 24;
	private static final int GRID_DIM_Y_OFFSET = 28;
	private static final int GRID_DIM_Z_OFFSET = 32;
	private static final int BLOCK_DIM_X_OFFSET = 36;
	private static final int BLOCK_DIM_Y_OFFSET = 40;
	private static final int BLOCK_DIM_Z_OFFSET = 44;
	private static final int SHARED_MEM_BYTES_OFFSET = 48;
	private static final int PARAM_COUNT_OFFSET = 56;
	private static final int P_PARAMS_OFFSET = 64;
	private static final int EXTRA_COUNT_OFFSET = 72;
	private static final int P_EXTRAS_OFFSET = 80;
	
	public VkCuLaunchInfoNVX() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkCuLaunchInfoNVX(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkCuLaunchInfoNVX(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_CU_LAUNCH_INFO_NVX **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_CU_LAUNCH_INFO_NVX **/
	@NativeType("VkStructureType")
	public VkCuLaunchInfoNVX sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_CU_LAUNCH_INFO_NVX **/
	@NativeType("VkStructureType")
	public VkCuLaunchInfoNVX sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000029002);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkCuLaunchInfoNVX pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkCuFunctionNVX*")
	public long function() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + FUNCTION_OFFSET);
	}
	
	@NativeType("VkCuFunctionNVX*")
	public VkCuLaunchInfoNVX function(long value) {
		LONG_HANDLE.set(this.segment, this.offset + FUNCTION_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int gridDimX() {
		return (int) INT_HANDLE.get(this.segment, this.offset + GRID_DIM_X_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkCuLaunchInfoNVX gridDimX(int value) {
		INT_HANDLE.set(this.segment, this.offset + GRID_DIM_X_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int gridDimY() {
		return (int) INT_HANDLE.get(this.segment, this.offset + GRID_DIM_Y_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkCuLaunchInfoNVX gridDimY(int value) {
		INT_HANDLE.set(this.segment, this.offset + GRID_DIM_Y_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int gridDimZ() {
		return (int) INT_HANDLE.get(this.segment, this.offset + GRID_DIM_Z_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkCuLaunchInfoNVX gridDimZ(int value) {
		INT_HANDLE.set(this.segment, this.offset + GRID_DIM_Z_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int blockDimX() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BLOCK_DIM_X_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkCuLaunchInfoNVX blockDimX(int value) {
		INT_HANDLE.set(this.segment, this.offset + BLOCK_DIM_X_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int blockDimY() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BLOCK_DIM_Y_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkCuLaunchInfoNVX blockDimY(int value) {
		INT_HANDLE.set(this.segment, this.offset + BLOCK_DIM_Y_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int blockDimZ() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BLOCK_DIM_Z_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkCuLaunchInfoNVX blockDimZ(int value) {
		INT_HANDLE.set(this.segment, this.offset + BLOCK_DIM_Z_OFFSET, value);
		return this;
	}
	
	@NativeType("uint32_t")
	public int sharedMemBytes() {
		return (int) INT_HANDLE.get(this.segment, this.offset + SHARED_MEM_BYTES_OFFSET);
	}
	
	@NativeType("uint32_t")
	public VkCuLaunchInfoNVX sharedMemBytes(int value) {
		INT_HANDLE.set(this.segment, this.offset + SHARED_MEM_BYTES_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("size_t")
	public long paramCount() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + PARAM_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("size_t")
	public VkCuLaunchInfoNVX paramCount(long value) {
		LONG_HANDLE.set(this.segment, this.offset + PARAM_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("void*")
	public long pParams() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_PARAMS_OFFSET);
	}
	
	@NativeType("void*")
	public VkCuLaunchInfoNVX pParams(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_PARAMS_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("size_t")
	public long extraCount() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + EXTRA_COUNT_OFFSET);
	}
	
	/** optional **/
	@NativeType("size_t")
	public VkCuLaunchInfoNVX extraCount(long value) {
		LONG_HANDLE.set(this.segment, this.offset + EXTRA_COUNT_OFFSET, value);
		return this;
	}
	
	@NativeType("void*")
	public long pExtras() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_EXTRAS_OFFSET);
	}
	
	@NativeType("void*")
	public VkCuLaunchInfoNVX pExtras(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_EXTRAS_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkCuLaunchInfoNVX> {
		
		private static final StructConstructor<VkCuLaunchInfoNVX> CONSTRUCTOR = VkCuLaunchInfoNVX::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkCuLaunchInfoNVX[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkCuLaunchInfoNVX[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkCuLaunchInfoNVX[size], CONSTRUCTOR, MEMORY_LAYOUT);
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