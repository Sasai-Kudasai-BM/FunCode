package net.skds.jvk.dev;

import lombok.Getter;
import net.skds.lib2.natives.LinkerUtils;
import net.skds.lib2.utils.SKDSUtils;
import net.skds.lib2.utils.exception.UnsupportedSystemException;

import java.io.File;
import java.lang.foreign.Arena;
import java.lang.foreign.SymbolLookup;
import java.lang.ref.Cleaner;
import java.util.stream.Stream;


public class VulkanSDK {

	private static VulkanSDK instance;

	@Getter
	private final File rootDir;

	final Cleaner cleaner;
	private final Shaderc shaderc;

	private VulkanSDK() {
		this.rootDir = findSDKRoot();
		File shadercBinary = new File(this.rootDir, shadercPath());
		Arena arena = Arena.ofAuto();
		SymbolLookup shadercLib = LinkerUtils.library(shadercBinary.getPath(), arena);
		this.shaderc = new Shaderc(shadercLib);
		this.cleaner = Cleaner.create();
	}

	public ShaderCompiler createCompiler(int vkVersion, int spirvVersion, int sourceLanguage) {
		return new ShaderCompiler(shaderc, this, vkVersion, spirvVersion, sourceLanguage);
	}

	private static String shadercPath() {
		return switch (SKDSUtils.OS_TYPE) {
			case WINDOWS -> "Bin/shaderc_shared.dll";
			default -> throw new UnsupportedSystemException();
		};
	}

	private static File findSDKRoot() {
		File f = null;
		for (File r : File.listRoots()) {
			f = findSDK(r, 2);
			if (f != null) break;
		}

		if (f == null) {
			throw notInstalled();
		}
		String[] sdks = f.list();
		if (sdks == null) throw notInstalled();
		String sdk = Stream.of(sdks)
				.filter(s -> s.contains("."))
				.max(String::compareTo)
				.orElseThrow(VulkanSDK::notInstalled);
		return new File(f, sdk);
	}

	private static File findSDK(File root, int depth) {
		if (depth <= 0) {
			return null;
		}
		File[] files = root.listFiles();
		if (files != null) for (int i = 0; i < files.length; i++) {
			File dir = files[i];
			if (dir.isDirectory()) {
				if (dir.getName().endsWith("VulkanSDK")) return dir;
			} else continue;
			File sdk = findSDK(dir, depth - 1);
			if (sdk != null) return sdk;
		}

		return null;
	}

	private static IllegalStateException notInstalled() {
		return new IllegalStateException("VulkanSDK not found");
	}

	public static VulkanSDK getInstance() {
		VulkanSDK sdk = instance;
		if (sdk == null) {
			sdk = new VulkanSDK();
			instance = sdk;
		}
		return sdk;
	}
}
