package net.skds.ninvoker;

import net.skds.lib2.unsafe.UnsafeAnal;
import net.skds.ninvoker.struct.AbstractNativeStructure;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import sun.misc.Unsafe;

import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;

public class NInvokerTest {

	private static final long NULL = 0L;
	private static final Unsafe unsafe = UnsafeAnal.UNSAFE;

	private static final int VK_MAX_EXTENSION_NAME_SIZE = 256;
	private static final int VK_MAX_DESCRIPTION_SIZE = 256;


	public static void main(String[] args) throws Throwable {

		//MemoryLayout layout = MemoryLayout.structLayout(
		//		MemoryLayout.sequenceLayout(256, ValueLayout.JAVA_BYTE),
		//		ValueLayout.JAVA_INT,
		//		ValueLayout.JAVA_INT,
		//		MemoryLayout.sequenceLayout(256, ValueLayout.JAVA_BYTE)
		//);


		System.loadLibrary("vulkan-1");

		SymbolLookup symbolLookup = SymbolLookup.loaderLookup();
		//MemorySegment ms = symbolLookup.find("GetKeyState").orElseThrow();
		//MemorySegment ms = symbolLookup.find("glGetIntegerv").orElseThrow();


		MethodHandle handle = Linker.nativeLinker().downcallHandle(
				symbolLookup.find("vkEnumerateInstanceLayerProperties").orElseThrow(),
				FunctionDescriptors.ILL
		);


		long longPtr = unsafe.allocateMemory(8);
		long intPtr = unsafe.allocateMemory(4);
		int result = (int) handle.invokeExact(intPtr, NULL);

		int size = unsafe.getInt(intPtr);

		//size = 1;
		//unsafe.putInt(intPtr, size);

		System.out.println(result);
		System.out.println(size);

		VkLayerProperties[] properties = VK_LAYER_PROPERTIES.allocArray(size);

		result = (int) handle.invokeExact(intPtr, properties[0].address());
		//System.out.println(result);

		for (int i = 0; i < size; i++) {
			VkLayerProperties p = properties[i];
			p.get();
			System.out.println(NInvoker.nullTerminatedString(p.name, StandardCharsets.UTF_8));
			//System.out.println(Integer.toHexString(p.specVer));
			//System.out.println(Integer.toHexString(p.implVer));
			//System.out.println(NInvoker.nullTerminatedString(p.description, StandardCharsets.UTF_8));

			//System.out.println(segment.get(JAVA_INT, VK_MAX_EXTENSION_NAME_SIZE + 4));
			//System.out.println(segment.getString(VK_MAX_EXTENSION_NAME_SIZE + 4 * 2));
		}

		properties[0].free();

	}

	private static final NativeStructureWrapper VK_LAYER_PROPERTIES = new NativeStructureWrapper(VkLayerProperties.class);

	private static final class VkLayerProperties extends AbstractNativeStructure {

		@ArrayLength(VK_MAX_EXTENSION_NAME_SIZE)
		byte[] name;
		int specVer;
		int implVer;
		@ArrayLength(VK_MAX_DESCRIPTION_SIZE)
		byte[] description;

		@Override
		protected NativeStructureWrapper getWrapper() {
			return VK_LAYER_PROPERTIES;
		}
	}
}
