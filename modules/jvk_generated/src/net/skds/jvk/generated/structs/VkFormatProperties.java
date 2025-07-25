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
* struct VkFormatProperties {
* 	VkFormatFeatureFlags linearTilingFeatures;
* 	VkFormatFeatureFlags optimalTilingFeatures;
* 	VkFormatFeatureFlags bufferFeatures;
* };
*</pre>
**/
@AutoGenerated
public final class VkFormatProperties extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			JAVA_INT,
			JAVA_INT
	);
	private static final int LINEAR_TILING_FEATURES_OFFSET = 0;
	private static final int OPTIMAL_TILING_FEATURES_OFFSET = 4;
	private static final int BUFFER_FEATURES_OFFSET = 8;
	
	public VkFormatProperties() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkFormatProperties(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkFormatProperties(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** optional **/
	@NativeType("VkFormatFeatureFlags")
	public int linearTilingFeatures() {
		return (int) INT_HANDLE.get(this.segment, this.offset + LINEAR_TILING_FEATURES_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkFormatFeatureFlags")
	public VkFormatProperties linearTilingFeatures(int value) {
		INT_HANDLE.set(this.segment, this.offset + LINEAR_TILING_FEATURES_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkFormatFeatureFlags")
	public int optimalTilingFeatures() {
		return (int) INT_HANDLE.get(this.segment, this.offset + OPTIMAL_TILING_FEATURES_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkFormatFeatureFlags")
	public VkFormatProperties optimalTilingFeatures(int value) {
		INT_HANDLE.set(this.segment, this.offset + OPTIMAL_TILING_FEATURES_OFFSET, value);
		return this;
	}
	
	/** optional **/
	@NativeType("VkFormatFeatureFlags")
	public int bufferFeatures() {
		return (int) INT_HANDLE.get(this.segment, this.offset + BUFFER_FEATURES_OFFSET);
	}
	
	/** optional **/
	@NativeType("VkFormatFeatureFlags")
	public VkFormatProperties bufferFeatures(int value) {
		INT_HANDLE.set(this.segment, this.offset + BUFFER_FEATURES_OFFSET, value);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkFormatProperties> {
		
		private static final StructConstructor<VkFormatProperties> CONSTRUCTOR = VkFormatProperties::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkFormatProperties[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkFormatProperties[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkFormatProperties[size], CONSTRUCTOR, MEMORY_LAYOUT);
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