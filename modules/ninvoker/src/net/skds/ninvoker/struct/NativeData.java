package net.skds.ninvoker.struct;

import net.skds.lib2.unsafe.MemoryStack;

public interface NativeData {

	int size();

	long address();

	void delegate(long address);

	long alloc();

	long alloc(MemoryStack stack);

	long allocPut(MemoryStack stack);

	long cAlloc();

	void free();

	void get();

	void put();
}
