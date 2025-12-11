package net.skds.jvk;

import lombok.CustomLog;
import net.skds.jvk.vulkan.WavesDemo;
import net.skds.jvk.vulkan.device.VkPhysicalDevice;
import net.skds.lib2.utils.logger.SKDSLogger;

@CustomLog
public class JVKDemo {

	static void main() {
		SKDSLogger.replaceOuts();
		WavesDemo wavesDemo = new WavesDemo();

		wavesDemo.start();

		for (VkPhysicalDevice di : wavesDemo.vkCore.getPhysicalDevices()) {
			log.info(di);
		}


	}
}
