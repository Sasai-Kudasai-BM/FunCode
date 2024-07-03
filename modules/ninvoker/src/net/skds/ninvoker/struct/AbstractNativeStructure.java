package net.skds.ninvoker.struct;

public abstract class AbstractNativeStructure {

	long address;

	protected abstract NativeStructureWrapper getWrapper();

	public final long address() {
		return address;
	}

	public final long alloc() {
		return getWrapper().alloc(this);
	}

	public final long cAlloc() {
		return getWrapper().cAlloc(this);
	}

	public final void free() {
		getWrapper().free(this);
	}

	public final void read() {
		getWrapper().read(this);
	}

	public final void write() {
		getWrapper().write(this);
	}
}
