package net.skds.jvk.dev;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class ShaderCompiler {

	private final VulkanSDK sdk;
	private final Shaderc shaderc;

	private final long compiler;
	private final long options;

	ShaderCompiler(Shaderc shaderc, VulkanSDK sdk, int vkVersion, int spirvVersion, int sourceLanguage) {
		this.sdk = sdk;
		this.shaderc = shaderc;

		long compiler = this.compiler = shaderc.compilerInitialize();
		long options = this.options = shaderc.compileOptionsInitialize();

		shaderc.compileOptionsSetSourceLanguage(options, sourceLanguage);
		shaderc.compileOptionsSetTargetEnv(options, Shaderc.TargetEnv.SHADERC_TARGET_ENV_VULKAN, vkVersion);
		shaderc.compileOptionsSetTargetSpirv(options, spirvVersion);
		shaderc.compileOptionsSetOptimizationLevel(options, Shaderc.OptimizationLevel.SHADERC_OPTIMIZATION_LEVEL_PERFORMANCE);

		sdk.cleaner.register(this, () -> {
			shaderc.optionsRelease(options);
			shaderc.compilerRelease(compiler);
		});
	}

	public Result compile(int shaderKind, String code, String name, String entry) {
		try (Arena localArena = Arena.ofShared()) {
			return compile(localArena, shaderKind, code, name, entry);
		}
	}

	public Result compile(Arena arena, int shaderKind, String code, String name, String entry) {
		MemorySegment codeSegment = arena.allocateFrom(code);
		MemorySegment nameSegment = arena.allocateFrom(name);
		MemorySegment entrySegment = arena.allocateFrom(entry);

		long res = shaderc.compileIntoSpv(
				compiler,
				codeSegment.address(),
				codeSegment.byteSize() - 1,
				shaderKind,
				nameSegment.address(),
				entrySegment.address(),
				options
		);
		if (res == 0L)
			throw new AssertionError("Internal error during compilation!");

		try {
			String err = null;
			if (shaderc.resultGetCompilationStatus(res) != Shaderc.CompilationStatus.SHADERC_COMPILATION_STATUS_SUCCESS) {
				err = shaderc.resultGetErrorMessage(res);
			}
			long resultSize = shaderc.resultGetLength(res);
			long pResult = shaderc.resultGetBytes(res);

			Result r = new Result(err, resultSize, pResult);
			sdk.cleaner.register(r, () -> shaderc.resultRelease(res));
			return r;
		} catch (Throwable t) {
			shaderc.resultRelease(res);
			throw new RuntimeException(t);
		}
	}


	public record Result(String err, long resultSize, long pResult) {
	}

}
