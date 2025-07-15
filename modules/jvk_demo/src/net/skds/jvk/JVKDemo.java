package net.skds.jvk;

import net.skds.jvk.vulkan.VkCore;
import net.skds.lib2.utils.logger.SKDSLogger;

public class JVKDemo {

	public static void main(String[] args) {
		SKDSLogger.replaceOuts();
		VkCore vkCore = new VkCore(true, "JVKDemo", "JVKDemo");

		vkCore.listLayers();
		vkCore.init();

		vkCore.dispose();
	}
}
