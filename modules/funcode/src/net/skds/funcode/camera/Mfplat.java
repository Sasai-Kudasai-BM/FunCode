package net.skds.funcode.camera;

import net.skds.lib2.natives.AbstractLinkedLibrary;

import java.lang.invoke.MethodHandle;

import static net.skds.lib2.natives.LinkerUtils.*;

/**
 * @noinspection DataFlowIssue
 */
public class Mfplat extends AbstractLinkedLibrary {

	private static Mfplat instance;

	private final MethodHandle mfCreateAttributes = createHandle(lib, "MFCreateAttributes", INT, PTR, INT);

	public Mfplat() {
		super("Mfplat");
	}

	public int mfCreateAttributes(long ppMFAttributes, int cInitialSize) {
		try {
			return (int) mfCreateAttributes.invokeExact(ppMFAttributes, cInitialSize);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}


	public static Mfplat getInstance() {
		Mfplat inst = instance;
		if (inst == null) {
			synchronized (Mfplat.class) {
				inst = instance;
				if (inst == null) {
					try {
						inst = new Mfplat();
						instance = inst;
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
		}
		return inst;
	}
}
