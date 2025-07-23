package net.skds.jvk;

import lombok.experimental.UtilityClass;
import net.skds.jvk.dev.Shaderc;

import java.lang.foreign.Arena;
import java.lang.ref.Cleaner;

import static net.skds.jvk.VkDefinitions.*;

@UtilityClass
public class VkUtils {

	private static final Arena GLOBAL_ARENA = Arena.global();
	public static final Cleaner CLEANER = Cleaner.create();

	public static final long P_SHADER_ENTRY_POINT_MAIN = GLOBAL_ARENA.allocateFrom("main").address();

	public static int getMaxSpirvVersion(int vkVersion) {
		vkVersion = vkApiVersionSkipPatch(vkVersion);
		if (vkVersion == VK_API_VERSION_1_0) {
			return Shaderc.SpirvVersion.SHADERC_SPIRV_VERSION_1_0;
		} else if (vkVersion == VK_API_VERSION_1_1) {
			return Shaderc.SpirvVersion.SHADERC_SPIRV_VERSION_1_3;
		} else if (vkVersion == VK_API_VERSION_1_2) {
			return Shaderc.SpirvVersion.SHADERC_SPIRV_VERSION_1_5;
		} else if (vkVersion == VK_API_VERSION_1_3) {
			return Shaderc.SpirvVersion.SHADERC_SPIRV_VERSION_1_6;
		} else {
			return Shaderc.SpirvVersion.SHADERC_SPIRV_VERSION_1_6;
		}
	}

	public static int vkApiVersionSkipPatch(int version) {
		return version & ~0xFFF;
	}
}
