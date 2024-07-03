package net.skds.ninvoker;

import lombok.RequiredArgsConstructor;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

@RequiredArgsConstructor
public class UpcallLink<T> {

	private final FunctionDescriptor descriptor;
	private final MethodHandle virtualHandle;

	public MemorySegment bind(T receiver) {
		return NInvoker.LINKER.upcallStub(
				virtualHandle.bindTo(receiver),
				descriptor,
				Arena.global()
		);
	}
}
