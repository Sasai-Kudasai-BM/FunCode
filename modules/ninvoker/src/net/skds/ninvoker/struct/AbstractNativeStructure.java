package net.skds.ninvoker.struct;

import net.skds.ninvoker.MemoryStack;

public abstract class AbstractNativeStructure implements NativeData {

	long address;

	protected abstract NativeStructureWrapper getWrapper();

	@Override
	public final int size() {
		return getWrapper().size;
	}

	@Override
	public final long address() {
		return address;
	}

	@Override
	public final void delegate(long address) {
		this.address = address;
	}

	@Override
	public final long alloc() {
		return getWrapper().alloc(this);
	}

	@Override
	public final long alloc(MemoryStack stack) {
		return getWrapper().alloc(this, stack);
	}

	@Override
	public final long cAlloc() {
		return getWrapper().cAlloc(this);
	}

	@Override
	public final void free() {
		getWrapper().free(this);
	}

	@Override
	public final void get() {
		getWrapper().get(this);
	}

	@Override
	public final void put() {
		getWrapper().put(this);
	}
}
