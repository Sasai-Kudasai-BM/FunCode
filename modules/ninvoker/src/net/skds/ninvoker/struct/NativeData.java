package net.skds.ninvoker.struct;

public interface NativeData {

	int size();

	long address();

	void delegate(long address);

	long alloc();

	long cAlloc();

	void free();

	void get();

	void put();
}
