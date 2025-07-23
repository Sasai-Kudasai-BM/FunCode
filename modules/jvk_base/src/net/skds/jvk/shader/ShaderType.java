package net.skds.jvk.shader;

import net.skds.jvk.dev.Shaderc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public enum ShaderType {
	VERTEX(1, Shaderc.ShaderKind.SHADERC_VERTEX_SHADER, "vert"),
	TESSELLATION_CONTROL(2, Shaderc.ShaderKind.SHADERC_TESS_CONTROL_SHADER, "tesc"),
	TESSELLATION_EVALUATION(4, Shaderc.ShaderKind.SHADERC_TESS_EVALUATION_SHADER, "tese"),
	GEOMETRY(8, Shaderc.ShaderKind.SHADERC_GEOMETRY_SHADER, "geom"),
	FRAGMENT(16, Shaderc.ShaderKind.SHADERC_FRAGMENT_SHADER, "frag"),
	COMPUTE(32, Shaderc.ShaderKind.SHADERC_COMPUTE_SHADER, "comp");

	public final int vkFlag;
	public final int shadercKind;
	public final String extension;
	public final String dotExtension;

	public static final ShaderType[] VALUES = values();

	private static final Map<String, ShaderType> EXTENSIONS = new HashMap<>();

	ShaderType(int vkFlag, int shadercKind, String extension) {
		this.vkFlag = vkFlag;
		this.shadercKind = shadercKind;
		this.extension = extension;
		this.dotExtension = "." + extension;
	}

	public static ShaderType byExtension(String ext) {
		return Objects.requireNonNull(EXTENSIONS.get(ext), () -> "Unknown shader file extension " + ext);
	}

	static {
		for (ShaderType t : VALUES) {
			EXTENSIONS.put(t.extension, t);
		}
	}
}
