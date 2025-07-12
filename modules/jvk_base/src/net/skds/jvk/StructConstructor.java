package net.skds.jvk;

import net.skds.lib2.natives.struct.CStruct;

import java.lang.foreign.MemorySegment;

@FunctionalInterface
public interface StructConstructor<T extends CStruct> {
	T create(MemorySegment segment, long offset);
}