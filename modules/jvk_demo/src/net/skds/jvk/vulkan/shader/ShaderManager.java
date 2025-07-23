package net.skds.jvk.vulkan.shader;

import lombok.AllArgsConstructor;
import lombok.CustomLog;
import lombok.NoArgsConstructor;
import net.skds.jvk.annotation.NativeType;
import net.skds.jvk.dev.ShaderCompiler;
import net.skds.jvk.dev.Shaderc;
import net.skds.jvk.dev.VulkanSDK;
import net.skds.jvk.shader.ShaderType;
import net.skds.jvk.shader.SpirvPointer;
import net.skds.lib2.io.json.JsonUtils;
import net.skds.lib2.natives.MemoryAccess;
import net.skds.lib2.utils.SKDSFiles;
import net.skds.lib2.utils.SKDSUtils;
import net.skds.lib2.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CustomLog
public class ShaderManager {

	private final File spirvDir;
	private final File glslDir;
	private final int glslDirPrefix;
	private final File cacheFile;

	private final int vkVersion;

	private ShaderCache cache;

	public ShaderManager(File rootDir, int vkVersion) {
		this.vkVersion = vkVersion;
		this.spirvDir = new File(rootDir, "spirv");
		this.glslDir = new File(rootDir, "glsl");
		this.cacheFile = new File(rootDir, "cache.json");
		this.glslDirPrefix = glslDir.getPath().length() + 1;
	}

	public SpirvPointer getShader(String name) {
		ShaderCache cache = getCache();
		ShaderCacheEntry ce = cache.cacheEntryMap.get(name);
		if (ce == null) {
			throw new RuntimeException("Shader not found: " + name);
		}
		return ce.spirv;
	}

	public void updateCache() {
		ShaderCache cache = this.cache;
		log.info("Loading shader cache");
		if (cacheFile.exists()) {
			cache = JsonUtils.readJson(cacheFile, ShaderCache.class);
		}
		if (cache == null) {
			cache = new ShaderCache();
		}
		checkCache(cache);
		this.cache = cache;
	}

	private ShaderCache getCache() {
		if (this.cache == null) {
			updateCache();
		}
		return this.cache;
	}

	private void checkCache(ShaderCache cache) {
		boolean dirty = false;
		List<CompileEntry> compileQueue = new ArrayList<>();
		for (var iterator = cache.cacheEntryMap.entrySet().iterator(); iterator.hasNext(); ) {
			var e = iterator.next();
			ShaderCacheEntry sce = e.getValue();
			String key = e.getKey();
			File src = new File(glslDir, key);
			File dst = new File(spirvDir, key + ".spv");
			boolean srcExists = src.exists();
			boolean dstExists = dst.exists();
			if (!srcExists && !dstExists) {
				log.info("Removing " + key);
				iterator.remove();
				dirty = true;
			} else {
				if (srcExists) {
					String hash = SKDSUtils.hashFile(src);
					if (sce.lastUpdated != src.lastModified() && !sce.hash.equals(hash)) {
						compileQueue.add(new CompileEntry(key, hash, cache, src, dst, sce));
						dirty = true;
						continue;
					}
				}
				try {
					MemorySegment segment = SKDSFiles.readToNativeMemory(dst);
					sce.spirv = new SpirvPointer(segment);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
		for (File f : SKDSFiles.collectFiles(glslDir)) {
			String key = f.getPath().substring(glslDirPrefix);

			if (!cache.cacheEntryMap.containsKey(key)) {
				ShaderCacheEntry sce = new ShaderCacheEntry();
				sce.type = ShaderType.byExtension(StringUtils.cutStringAfterFromEnd(key, '.'));
				File src = new File(glslDir, key);
				File dst = new File(spirvDir, key + ".spv");
				String hash = SKDSUtils.hashFile(src);
				compileQueue.add(new CompileEntry(key, hash, cache, src, dst, sce));
				dirty = true;
			}
		}

		if (!compileQueue.isEmpty()) {
			try {
				compileShaders(compileQueue);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		if (dirty) {
			JsonUtils.saveJson(cacheFile, cache);
		}
	}


	private void compileShaders(List<CompileEntry> entries) throws IOException {
		VulkanSDK sdk = VulkanSDK.getInstance();
		ShaderCompiler compiler = sdk.createCompiler(vkVersion, Shaderc.SourceLanguage.SHADERC_SOURCE_LANGUAGE_GLSL);
		for (int i = 0; i < entries.size(); i++) {
			Arena arena = Arena.ofAuto();
			CompileEntry e = entries.get(i);
			log.info("Compiling " + e.key);
			ShaderCacheEntry sce = e.sce;
			MemorySegment input = arena.allocateFrom(Files.readString(e.src.toPath()));
			var r = compiler.compile(sce.type, input, e.key);
			if (r.err() != null) {
				log.error("Shader compilation error: " + r.err());
				continue;
			}
			sce.lastUpdated = e.src.lastModified();
			sce.hash = e.hash;
			var shader = r.shader();
			sce.spirv = shader;
			e.cache.cacheEntryMap.put(e.key, sce);
			MemoryAccess.getByteArray(MemoryAccess.ALL_MEMORY, shader.address(), shader.size());
			SKDSFiles.writeFromNativeMemory(e.dst().toPath(), shader.address(), shader.size());
		}
	}


	private record CompileEntry(String key, String hash, ShaderCache cache, File src, File dst, ShaderCacheEntry sce) {
	}

	private static class ShaderCache {
		Map<String, ShaderCacheEntry> cacheEntryMap = new HashMap<>();
	}

	@NoArgsConstructor
	@AllArgsConstructor
	private static class ShaderCacheEntry {
		String hash = "";
		long lastUpdated;
		@NativeType("VkShaderStageFlagBits")
		ShaderType type;
		transient SpirvPointer spirv;
	}
}
