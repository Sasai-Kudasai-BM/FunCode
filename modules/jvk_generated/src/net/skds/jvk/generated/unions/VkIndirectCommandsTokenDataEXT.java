package net.skds.jvk.generated.unions;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.struct.CStruct;

import static java.lang.foreign.ValueLayout.*;
import static net.skds.lib2.natives.LinkerUtils.*;
import static java.lang.foreign.MemoryLayout.*;

/**
*<pre>
* C definition:
* union VkIndirectCommandsTokenDataEXT {
* 	VkIndirectCommandsPushConstantTokenEXT*;
* 	VkIndirectCommandsVertexBufferTokenEXT*;
* 	VkIndirectCommandsIndexBufferTokenEXT*;
* 	VkIndirectCommandsExecutionSetTokenEXT*;
* };
*</pre>
**/
@AutoGenerated
public final class VkIndirectCommandsTokenDataEXT extends CStruct {
	
	public static final MemoryLayout MEMORY_LAYOUT = unionLayout(
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG,
			JAVA_LONG
	);
	
	public VkIndirectCommandsTokenDataEXT() {
		this.segment = Arena.ofAuto().allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkIndirectCommandsTokenDataEXT(Arena arena) {
		this.segment = arena.allocate(MEMORY_LAYOUT.byteSize());
	}
	
	public VkIndirectCommandsTokenDataEXT(MemorySegment segment, long offset) {
		super(segment, offset);
	}
	
	
	@NativeType("VkIndirectCommandsPushConstantTokenEXT*")
	public long asLong() {
		return (long) LONG_HANDLE.get(this.segment, this.offset);
	}
	
	@NativeType("VkIndirectCommandsPushConstantTokenEXT*")
	public VkIndirectCommandsTokenDataEXT asLong(long value) {
		LONG_HANDLE.set(this.segment, this.offset, value);
		return this;
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