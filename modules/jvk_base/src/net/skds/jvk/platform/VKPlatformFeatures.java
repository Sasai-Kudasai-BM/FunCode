package net.skds.jvk.platform;

import lombok.Getter;
import net.skds.lib2.utils.SKDSUtils;

import java.lang.foreign.Arena;
import java.lang.foreign.SymbolLookup;

public abstract sealed class VKPlatformFeatures permits JVKWindowsPlatform {

	private static VKPlatformFeatures instance;

	protected final Arena arena = Arena.ofAuto();
	@Getter
	protected final SymbolLookup library = loadLibrary();

	public static VKPlatformFeatures getInstance() {
		VKPlatformFeatures platform = instance;
		if (platform == null) {
			platform = switch (SKDSUtils.OS_TYPE) {
				case WINDOWS -> new JVKWindowsPlatform();
				default ->
						throw new UnsupportedOperationException(SKDSUtils.OS_TYPE + " VKPlatformFeatures are not supported");
			};
			instance = platform;
		}
		return platform;
	}

	protected abstract SymbolLookup loadLibrary0() throws Exception;

	private SymbolLookup loadLibrary() {
		try {
			return loadLibrary0();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return null;
	}

}
