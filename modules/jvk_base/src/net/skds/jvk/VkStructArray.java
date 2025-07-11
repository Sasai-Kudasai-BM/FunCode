package net.skds.jvk;

import net.skds.lib2.natives.struct.CStruct;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;

public abstract class VkStructArray<T extends CStruct> extends CStruct {

	private final T[] array;
	private final MemoryLayout layout;

	public VkStructArray(Arena arena, T[] array, StructConstructor<T> constructor, MemoryLayout layout) {
		this.layout = layout;
		this.array = array;
		long s = layout.byteSize();
		MemorySegment segment1 = arena.allocate(array.length * s);
		this.segment = segment1;
		for (int i = 0; i < array.length; i++) {
			array[i] = constructor.create(segment1, i * s);
		}
	}

	@Override
	public int getSize() {
		return (int) (array.length * layout.byteSize());
	}

	@Override
	public int getAlignment() {
		return (int) layout.byteAlignment();
	}

	public T get(int i) {
		return array[i];
	}

	public int length() {
		return array.length;
	}

	@FunctionalInterface
	public interface StructConstructor<T extends CStruct> {
		T create(MemorySegment segment, long offset);
	}
}
