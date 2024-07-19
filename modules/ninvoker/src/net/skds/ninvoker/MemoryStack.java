package net.skds.ninvoker;

import lombok.Getter;
import net.skds.lib.utils.UnsafeAnal;
import net.skds.lib.utils.collection.LongList;
import sun.misc.Unsafe;

import java.nio.charset.Charset;

public class MemoryStack implements AutoCloseable {

	private static final Unsafe unsafe = UnsafeAnal.UNSAFE;

	private final LongList ll = new LongList();
	@Getter
	private long pPtr;

	public long makePPtr() {
		if (pPtr != 0) {
			throw new IllegalStateException();
		}
		pPtr = unsafe.allocateMemory(ll.size() * 8L);
		//NInvoker.transferArray(ll.getElements(), pPtr, ll.size(), 0);
		for (int i = 0; i < ll.size(); i++) {
			unsafe.putLong(pPtr + 8L * i, ll.getLong(i));
		}
		return pPtr;
	}

	public long push8() {
		long adr = unsafe.allocateMemory(8);
		ll.addLong(adr);
		return adr;
	}

	public long push4() {
		long adr = unsafe.allocateMemory(4);
		ll.addLong(adr);
		return adr;
	}

	public long push2() {
		long adr = unsafe.allocateMemory(2);
		ll.addLong(adr);
		return adr;
	}

	public long push() {
		long adr = unsafe.allocateMemory(1);
		ll.addLong(adr);
		return adr;
	}

	public long push(int size) {
		long adr = unsafe.allocateMemory(size);
		ll.addLong(adr);
		return adr;
	}


	public long pushLongs(int count) {
		long adr = unsafe.allocateMemory(count * 8L);
		ll.addLong(adr);
		return adr;
	}

	public long pushNT(String string, Charset charset) {
		byte[] data = string.getBytes(charset);
		long address = unsafe.allocateMemory(data.length + 1);
		NInvoker.transferArray(data, address, data.length, 0);
		unsafe.putByte(address + data.length, (byte) 0);
		ll.addLong(address);
		return address;
	}

	public long pushNT(String string, Charset charset, int allocSize) {
		byte[] data = string.getBytes(charset);
		long address = unsafe.allocateMemory(allocSize);
		NInvoker.transferArray(data, address, data.length, 0);
		unsafe.putByte(address + data.length, (byte) 0);
		ll.addLong(address);
		return address;
	}

	public long pushInt() {
		long adr = unsafe.allocateMemory(4);
		ll.addLong(adr);
		return adr;
	}

	public void free() {
		ll.forEach(unsafe::freeMemory);
		if (pPtr != 0) {
			unsafe.freeMemory(pPtr);
			pPtr = 0;
		}
	}

	@Override
	public void close() {
		free();
	}
}
