package net.skds.jvk.dev;

import net.skds.jvk.VkUtils;
import net.skds.jvk.shader.ShaderType;
import net.skds.jvk.shader.SpirvPointer;

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

		VkUtils.CLEANER.register(this, () -> {
			shaderc.optionsRelease(options);
			shaderc.compilerRelease(compiler);
		});
	}

	public Result compile(ShaderType shaderType, MemorySegment code, String name) {
		try (Arena localArena = Arena.ofShared()) {
			MemorySegment nameSegment = localArena.allocateFrom(name);
			return compile(shaderType, code, nameSegment.address(), VkUtils.P_SHADER_ENTRY_POINT_MAIN);
		}
	}

	public Result compile(ShaderType shaderType, String code, String name, String entry) {
		try (Arena localArena = Arena.ofShared()) {
			MemorySegment codeSegment = localArena.allocateFrom(code);
			MemorySegment nameSegment = localArena.allocateFrom(name);
			MemorySegment entrySegment = localArena.allocateFrom(entry);
			return compile(shaderType, codeSegment, nameSegment.address(), entrySegment.address());
		}
	}

	public Result compile(ShaderType shaderType, MemorySegment code, long name, long entry) {
		long res = shaderc.compileIntoSpv(
				compiler,
				code.address(),
				code.byteSize() - 1,
				shaderType.shadercKind,
				name,
				entry,
				options
		);
		if (res == 0L)
			throw new AssertionError("Internal error during compilation!");

		try {
			String err = null;
			if (shaderc.resultGetCompilationStatus(res) != Shaderc.CompilationStatus.SHADERC_COMPILATION_STATUS_SUCCESS) {
				err = shaderc.resultGetErrorMessage(res);
			}
			int resultSize = (int) shaderc.resultGetLength(res);
			long pResult = shaderc.resultGetBytes(res);

			Result r = new Result(err, new SpirvPointer(resultSize, pResult));
			VkUtils.CLEANER.register(r.shader, () -> shaderc.resultRelease(res));
			return r;
		} catch (Throwable t) {
			shaderc.resultRelease(res);
			throw new RuntimeException(t);
		}
	}


	public record Result(String err, SpirvPointer shader) {
	}


}
