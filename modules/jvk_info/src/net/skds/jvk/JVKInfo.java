package net.skds.jvk;

import lombok.CustomLog;
import net.skds.jvk.vulkan.VkCore;
import net.skds.jvk.vulkan.VulkanParameters;
import net.skds.jvk.vulkan.device.VkPhysicalDevice;
import net.skds.jvk.vulkan.support.VkExtension;
import net.skds.jvk.vulkan.support.VkLayer;
import net.skds.lib2.utils.logger.SKDSLogger;

@CustomLog
public class JVKInfo {

	static void main() {
		SKDSLogger.replaceOuts();


		VkCore vkCore = new VkCore(new VulkanParameters("JVKInfo", "JVKInfo", true));

		try {
			vkCore.init();

			StringBuilder sb = new StringBuilder("\nBasic Vulkan driver info\n========  Extensions  ========\n");
			for (VkExtension ext : vkCore.getSupportedExtensions().values()) {
				sb.append(ext).append('\n');
			}
			sb.append("==========  Layers  ==========\n");
			for (VkLayer layer : vkCore.getSupportedLayers().values()) {
				sb.append(layer).append('\n');
			}
			sb.append("==========  Devices  =========\n");
			for (VkPhysicalDevice di : vkCore.getPhysicalDevices()) {
				sb.append(di).append('\n');
			}
			log.info(sb);
		} finally {
			vkCore.dispose();
		}
	}
}
