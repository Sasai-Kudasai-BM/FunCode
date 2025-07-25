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
* struct VkPhysicalDeviceMeshShaderFeaturesEXT {
* 	VkStructureType sType;
* 	// pad (4)
* 	void* pNext;
* 	VkBool32 taskShader;
* 	VkBool32 meshShader;
* 	VkBool32 multiviewMeshShader;
* 	VkBool32 primitiveFragmentShadingRateMeshShader;
* 	VkBool32 meshShaderQueries;
* 	// pad (4)
* };
*</pre>
**/
@AutoGenerated
public final class VkPhysicalDeviceMeshShaderFeaturesEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = structLayout(
			JAVA_INT,
			paddingLayout(4),
			JAVA_LONG,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			JAVA_INT,
			paddingLayout(4)
	);
	private static final int S_TYPE_OFFSET = 0;
	private static final int P_NEXT_OFFSET = 8;
	private static final int TASK_SHADER_OFFSET = 16;
	private static final int MESH_SHADER_OFFSET = 20;
	private static final int MULTIVIEW_MESH_SHADER_OFFSET = 24;
	private static final int PRIMITIVE_FRAGMENT_SHADING_RATE_MESH_SHADER_OFFSET = 28;
	private static final int MESH_SHADER_QUERIES_OFFSET = 32;
	
	public VkPhysicalDeviceMeshShaderFeaturesEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceMeshShaderFeaturesEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkPhysicalDeviceMeshShaderFeaturesEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MESH_SHADER_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public int sType() {
		return (int) INT_HANDLE.get(this.segment, this.offset + S_TYPE_OFFSET);
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MESH_SHADER_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceMeshShaderFeaturesEXT sType(int value) {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, value);
		return this;
	}
	
	/** values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MESH_SHADER_FEATURES_EXT **/
	@NativeType("VkStructureType")
	public VkPhysicalDeviceMeshShaderFeaturesEXT sType$Default() {
		INT_HANDLE.set(this.segment, this.offset + S_TYPE_OFFSET, 1000328000);
		return this;
	}
	
	/** optional **/
	@NativeType("void*")
	public long pNext() {
		return (long) LONG_HANDLE.get(this.segment, this.offset + P_NEXT_OFFSET);
	}
	
	/** optional **/
	@NativeType("void*")
	public VkPhysicalDeviceMeshShaderFeaturesEXT pNext(long value) {
		LONG_HANDLE.set(this.segment, this.offset + P_NEXT_OFFSET, value);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean taskShader() {
		return (int) INT_HANDLE.get(this.segment, this.offset + TASK_SHADER_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceMeshShaderFeaturesEXT taskShader(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + TASK_SHADER_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean meshShader() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MESH_SHADER_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceMeshShaderFeaturesEXT meshShader(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + MESH_SHADER_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean multiviewMeshShader() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MULTIVIEW_MESH_SHADER_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceMeshShaderFeaturesEXT multiviewMeshShader(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + MULTIVIEW_MESH_SHADER_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean primitiveFragmentShadingRateMeshShader() {
		return (int) INT_HANDLE.get(this.segment, this.offset + PRIMITIVE_FRAGMENT_SHADING_RATE_MESH_SHADER_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceMeshShaderFeaturesEXT primitiveFragmentShadingRateMeshShader(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + PRIMITIVE_FRAGMENT_SHADING_RATE_MESH_SHADER_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	@NativeType("VkBool32")
	public boolean meshShaderQueries() {
		return (int) INT_HANDLE.get(this.segment, this.offset + MESH_SHADER_QUERIES_OFFSET) != 0;
	}
	
	@NativeType("VkBool32")
	public VkPhysicalDeviceMeshShaderFeaturesEXT meshShaderQueries(boolean value) {
		INT_HANDLE.set(this.segment, this.offset + MESH_SHADER_QUERIES_OFFSET, value ? (int) 1 : (int) 0);
		return this;
	}
	
	
	@AutoGenerated
	public static final class Array extends VkStructArray<VkPhysicalDeviceMeshShaderFeaturesEXT> {
		
		private static final StructConstructor<VkPhysicalDeviceMeshShaderFeaturesEXT> CONSTRUCTOR = VkPhysicalDeviceMeshShaderFeaturesEXT::new;
		
		public Array(int size) {
			super(Arena.ofAuto(), new VkPhysicalDeviceMeshShaderFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(Arena arena, int size) {
			super(arena, new VkPhysicalDeviceMeshShaderFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
		}
		
		public Array(MemorySegment segment, long offset, int size) {
			super(segment, offset, new VkPhysicalDeviceMeshShaderFeaturesEXT[size], CONSTRUCTOR, MEMORY_LAYOUT);
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