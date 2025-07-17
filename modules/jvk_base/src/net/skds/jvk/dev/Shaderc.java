package net.skds.jvk.dev;

import net.skds.lib2.natives.MemoryAccess;

import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import static net.skds.lib2.natives.LinkerUtils.*;

public final class Shaderc {

	private final MethodHandle compilerInitialize;
	private final MethodHandle compileOptionsInitialize;
	private final MethodHandle compileOptionsSetSourceLanguage;
	private final MethodHandle compileOptionsSetTargetEnv;
	private final MethodHandle compileOptionsSetTargetSpirv;
	private final MethodHandle compileOptionsSetOptimizationLevel;
	private final MethodHandle compileIntoSpv;
	private final MethodHandle resultGetCompilationStatus;
	private final MethodHandle resultGetErrorMessage;
	private final MethodHandle resultGetBytes;
	private final MethodHandle resultGetLength;
	private final MethodHandle compilerRelease;
	private final MethodHandle optionsRelease;
	private final MethodHandle resultRelease;

	Shaderc(SymbolLookup lookup) {
		this.compilerInitialize = createHandle(lookup, "shaderc_compiler_initialize", LONG);
		this.compileOptionsInitialize = createHandle(lookup, "shaderc_compile_options_initialize", LONG);
		this.compileOptionsSetSourceLanguage = createHandle(lookup, "shaderc_compile_options_set_source_language", VOID, LONG, INT);
		this.compileOptionsSetTargetEnv = createHandle(lookup, "shaderc_compile_options_set_target_env", VOID, LONG, INT, INT);
		this.compileOptionsSetTargetSpirv = createHandle(lookup, "shaderc_compile_options_set_target_spirv", VOID, LONG, INT);
		this.compileOptionsSetOptimizationLevel = createHandle(lookup, "shaderc_compile_options_set_optimization_level", VOID, LONG, INT);
		this.compileIntoSpv = createHandle(lookup, "shaderc_compile_into_spv", LONG, LONG, LONG, LONG, INT, LONG, LONG, LONG);
		this.resultGetCompilationStatus = createHandle(lookup, "shaderc_result_get_compilation_status", INT, LONG);
		this.resultGetErrorMessage = createHandle(lookup, "shaderc_result_get_error_message", LONG, LONG);
		this.resultGetLength = createHandle(lookup, "shaderc_result_get_length", LONG, LONG);
		this.resultGetBytes = createHandle(lookup, "shaderc_result_get_bytes", LONG, LONG);
		this.compilerRelease = createHandle(lookup, "shaderc_compiler_release", VOID, LONG);
		this.optionsRelease = createHandle(lookup, "shaderc_compile_options_release", VOID, LONG);
		this.resultRelease = createHandle(lookup, "shaderc_result_release", VOID, LONG);
	}

	public long compileIntoSpv(long compiler, long pSourceText, long sourceTextSize, int shaderKind,
							   long pInputFileName, long pEntryPointName, long additionalOptions) {
		try {
			return (long) compileIntoSpv.invokeExact(compiler, pSourceText, sourceTextSize, shaderKind, pInputFileName, pEntryPointName, additionalOptions);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public void compilerRelease(long compiler) {
		try {
			compilerRelease.invokeExact(compiler);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public void optionsRelease(long options) {
		try {
			optionsRelease.invokeExact(options);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public void resultRelease(long result) {
		try {
			resultRelease.invokeExact(result);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public int resultGetCompilationStatus(long pResult) {
		try {
			return (int) resultGetCompilationStatus.invokeExact(pResult);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public long resultGetBytes(long pResult) {
		try {
			return (long) resultGetBytes.invokeExact(pResult);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public long resultGetLength(long pResult) {
		try {
			return (long) resultGetLength.invokeExact(pResult);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public String resultGetErrorMessage(long pResult) {
		try {
			long p = (long) resultGetErrorMessage.invokeExact(pResult);
			return MemoryAccess.ALL_MEMORY.getString(p);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public long compilerInitialize() {
		try {
			return (long) compilerInitialize.invokeExact();
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public long compileOptionsInitialize() {
		try {
			return (long) compileOptionsInitialize.invokeExact();
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public void compileOptionsSetTargetSpirv(long options, int version) {
		try {
			compileOptionsSetTargetSpirv.invokeExact(options, version);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public void compileOptionsSetOptimizationLevel(long options, int level) {
		try {
			compileOptionsSetOptimizationLevel.invokeExact(options, level);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public void compileOptionsSetSourceLanguage(long options, int lang) {
		try {
			compileOptionsSetSourceLanguage.invokeExact(options, lang);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

	public void compileOptionsSetTargetEnv(long options, int target, int version) {
		try {
			compileOptionsSetTargetEnv.invokeExact(options, target, version);
		} catch (Throwable t) {
			throw new Error(t);
		}
	}


	public static final class SourceLanguage {
		public static final int SHADERC_SOURCE_LANGUAGE_GLSL = 0;
		public static final int SHADERC_SOURCE_LANGUAGE_HLSL = 1;
	}

	public static final class TargetEnv {
		public static final int SHADERC_TARGET_ENV_VULKAN = 0;  // SPIR-V under Vulkan semantics
		public static final int SHADERC_TARGET_ENV_OPENGL = 1;  // SPIR-V under OpenGL semantics
		// NOTE: SPIR-V code generation is not supported for shaders under OpenGL
		// compatibility profile.
		//SHADERC_TARGET_ENV_OPENGL_COMPAT,  // SPIR-V under OpenGL semantics,
		// including compatibility profile
		// functions
		//SHADERC_TARGET_ENV_WEBGPU         // Deprecated, SPIR-V under WebGPU
	}

	public static final class SpirvVersion {
		// Use the values used for word 1 of a SPIR-V binary:
		// - bits 24 to 31: zero
		// - bits 16 to 23: major version number
		// - bits 8 to 15: minor version number
		// - bits 0 to 7: zero
		public static final int SHADERC_SPIRV_VERSION_1_0 = 0x010000;
		public static final int SHADERC_SPIRV_VERSION_1_1 = 0x010100;
		public static final int SHADERC_SPIRV_VERSION_1_2 = 0x010200;
		public static final int SHADERC_SPIRV_VERSION_1_3 = 0x010300;
		public static final int SHADERC_SPIRV_VERSION_1_4 = 0x010400;
		public static final int SHADERC_SPIRV_VERSION_1_5 = 0x010500;
		public static final int SHADERC_SPIRV_VERSION_1_6 = 0x010600;
	}

	public static final class OptimizationLevel {
		public static final int SHADERC_OPTIMIZATION_LEVEL_ZERO = 0;  // no optimization
		public static final int SHADERC_OPTIMIZATION_LEVEL_SIZE = 1;  // optimize towards reducing code size
		public static final int SHADERC_OPTIMIZATION_LEVEL_PERFORMANCE = 2;  // optimize towards performance
	}

	public static final class CompilationStatus {
		public static final int SHADERC_COMPILATION_STATUS_SUCCESS = 0;
		public static final int SHADERC_COMPILATION_STATUS_INVALID_STAGE = 1;
		public static final int SHADERC_COMPILATION_STATUS_COMPILATION_ERROR = 2;
		public static final int SHADERC_COMPILATION_STATUS_INTERNAL_ERROR = 3;
		public static final int SHADERC_COMPILATION_STATUS_NULL_RESULT_OBJECT = 4;
		public static final int SHADERC_COMPILATION_STATUS_INVALID_ASSEMBLY = 5;
		public static final int SHADERC_COMPILATION_STATUS_VALIDATION_ERROR = 6;
		public static final int SHADERC_COMPILATION_STATUS_TRANSFORMATION_ERROR = 7;
		public static final int SHADERC_COMPILATION_STATUS_CONFIGURATION_ERROR = 8;
	}

	public static final class ShaderKind {
		private static int i;
		// Forced shader kinds. These shader kinds force the compiler to compile the
		// source code as the specified kind of shader.
		public static final int SHADERC_VERTEX_SHADER = i++;
		public static final int SHADERC_FRAGMENT_SHADER = i++;
		public static final int SHADERC_COMPUTE_SHADER = i++;
		public static final int SHADERC_GEOMETRY_SHADER = i++;
		public static final int SHADERC_TESS_CONTROL_SHADER = i++;
		public static final int SHADERC_TESS_EVALUATION_SHADER = i++;

		public static final int SHADERC_GLSL_VERTEX_SHADER = SHADERC_VERTEX_SHADER;
		public static final int SHADERC_GLSL_FRAGMENT_SHADER = SHADERC_FRAGMENT_SHADER;
		public static final int SHADERC_GLSL_COMPUTE_SHADER = SHADERC_COMPUTE_SHADER;
		public static final int SHADERC_GLSL_GEOMETRY_SHADER = SHADERC_GEOMETRY_SHADER;
		public static final int SHADERC_GLSL_TESS_CONTROL_SHADER = SHADERC_TESS_CONTROL_SHADER;
		public static final int SHADERC_GLSL_TESS_EVALUATION_SHADER = SHADERC_TESS_EVALUATION_SHADER;

		// Deduce the shader kind from #pragma annotation in the source code. compiler
		// will emit error if #pRAGMA ANNOTATION IS NOT FOUND.
		public static final int SHADERC_GLSL_INFER_FROM_SOURCE = i++;

		// Default shader kinds. compiler will fall back to compile the source code as
		// the specified kind of shader when #pragma annotation is not found in the
		// source code.
		public static final int SHADERC_GLSL_DEFAULT_VERTEX_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_FRAGMENT_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_COMPUTE_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_GEOMETRY_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_TESS_CONTROL_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_TESS_EVALUATION_SHADER = i++;
		public static final int SHADERC_SPIRV_ASSEMBLY = i++;
		public static final int SHADERC_RAYGEN_SHADER = i++;
		public static final int SHADERC_ANYHIT_SHADER = i++;
		public static final int SHADERC_CLOSESTHIT_SHADER = i++;
		public static final int SHADERC_MISS_SHADER = i++;
		public static final int SHADERC_INTERSECTION_SHADER = i++;
		public static final int SHADERC_CALLABLE_SHADER = i++;
		public static final int SHADERC_GLSL_RAYGEN_SHADER = SHADERC_RAYGEN_SHADER;
		public static final int SHADERC_GLSL_ANYHIT_SHADER = SHADERC_ANYHIT_SHADER;
		public static final int SHADERC_GLSL_CLOSESTHIT_SHADER = SHADERC_CLOSESTHIT_SHADER;
		public static final int SHADERC_GLSL_MISS_SHADER = SHADERC_MISS_SHADER;
		public static final int SHADERC_GLSL_INTERSECTION_SHADER = SHADERC_INTERSECTION_SHADER;
		public static final int SHADERC_GLSL_CALLABLE_SHADER = SHADERC_CALLABLE_SHADER;
		public static final int SHADERC_GLSL_DEFAULT_RAYGEN_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_ANYHIT_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_CLOSESTHIT_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_MISS_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_INTERSECTION_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_CALLABLE_SHADER = i++;
		public static final int SHADERC_TASK_SHADER = i++;
		public static final int SHADERC_MESH_SHADER = i++;
		public static final int SHADERC_GLSL_TASK_SHADER = SHADERC_TASK_SHADER;
		public static final int SHADERC_GLSL_MESH_SHADER = SHADERC_MESH_SHADER;
		public static final int SHADERC_GLSL_DEFAULT_TASK_SHADER = i++;
		public static final int SHADERC_GLSL_DEFAULT_MESH_SHADER = i++;
	}

}
