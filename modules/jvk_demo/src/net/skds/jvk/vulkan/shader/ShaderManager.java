package net.skds.jvk.vulkan.shader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ShaderManager {

	public static final File cacheFile = new File("shaders/cache.json");


	private static class ShaderCache {
		Map<String, ShaderCacheEntry> cacheEntryMap = new HashMap<>();
	}

	private record ShaderCacheEntry(String hash, long lastUpdated) {
	}
}
