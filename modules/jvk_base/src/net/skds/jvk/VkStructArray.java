package net.skds.jvk;

import net.skds.lib2.natives.struct.CStruct;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.util.Iterator;
import java.util.function.Consumer;

public abstract class VkStructArray<T extends CStruct> extends CStruct implements Iterable<T> {

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

	public VkStructArray(MemorySegment segment, long offset, T[] array, StructConstructor<T> constructor, MemoryLayout layout) {
		this.layout = layout;
		this.array = array;
		long s = layout.byteSize();
		this.segment = segment;
		this.offset = offset;
		for (int i = 0; i < array.length; i++) {
			array[i] = constructor.create(segment, i * s);
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

	@Override
	public Iterator<T> iterator() {
		return new Iterator<>() {
			int i;

			@Override
			public boolean hasNext() {
				return i < array.length;
			}

			@Override
			public T next() {
				return array[i++];
			}
		};
	}

	@Override
	public void forEach(Consumer<? super T> action) {
		for (int i = 0; i < array.length; i++) {
			action.accept(array[i]);
		}
	}
}
