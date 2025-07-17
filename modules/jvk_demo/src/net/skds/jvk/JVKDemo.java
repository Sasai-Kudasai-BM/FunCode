package net.skds.jvk;

import lombok.CustomLog;
import net.skds.jvk.dev.ShaderCompiler;
import net.skds.jvk.dev.Shaderc;
import net.skds.jvk.dev.VulkanSDK;
import net.skds.jvk.vulkan.TriangleDemo;
import net.skds.jvk.vulkan.device.VkDeviceInfo;
import net.skds.lib2.utils.logger.SKDSLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@CustomLog
public class JVKDemo {

	public static void main(String[] args) throws IOException {
		SKDSLogger.replaceOuts();
		TriangleDemo triangleDemo = new TriangleDemo();

		triangleDemo.start();

		for (VkDeviceInfo di : triangleDemo.vkCore.getDevices()) {
			log.info(di);
		}


		VulkanSDK sdk = VulkanSDK.getInstance();
		ShaderCompiler compiler = sdk.createCompiler(
				VkDefinitions.VK_API_VERSION_1_1,
				Shaderc.SpirvVersion.SHADERC_SPIRV_VERSION_1_3,
				Shaderc.SourceLanguage.SHADERC_SOURCE_LANGUAGE_GLSL
		);

		ShaderCompiler.Result result = compiler.compile(
				Shaderc.ShaderKind.SHADERC_FRAGMENT_SHADER,
				Files.readString(Path.of("shader/shader.frag")),
				"test",
				"main"
		);

		System.out.println(result);

	}
}
