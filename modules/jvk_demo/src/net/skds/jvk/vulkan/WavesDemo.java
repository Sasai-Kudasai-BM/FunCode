package net.skds.jvk.vulkan;

import net.skds.jvk.VkDefinitions;
import net.skds.jvk.generated.enums.VkCommandBufferLevel;
import net.skds.jvk.generated.enums.VkQueueFlagBits;
import net.skds.jvk.generated.structs.VkDeviceQueueCreateInfo;
import net.skds.jvk.vulkan.command.VkCommandPool;
import net.skds.jvk.vulkan.device.VkDevice;
import net.skds.jvk.vulkan.device.VkPhysicalDevice;
import net.skds.jvk.vulkan.shader.ShaderManager;
import net.skds.lib2.natives.MemoryAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.foreign.Arena;

public class WavesDemo {

	public final VkCore vkCore = new VkCore(new VulkanParameters("TriangleDemo", "TriangleDemo", true));

	private final JFrame frame = new JFrame("WavesDemo") {
		{
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					vkCore.dispose();
				}
			});
			setPreferredSize(new Dimension(1200, 800));
			pack();
		}

		@Override
		public void paint(Graphics g) {
		}

		@Override
		public Graphics getGraphics() {
			return null;
		}
	};

	private final ShaderManager shaderManager = new ShaderManager(new File("shaders"), VkDefinitions.VK_API_VERSION_1_1);
	private VkDevice vkDevice;
	private VkCommandPool commandPool;

	public void start() {
		shaderManager.updateCache();
		initVk();
		frame.setVisible(true);
	}

	private void initVk() {
		vkCore.init();
		Arena localArena = Arena.ofAuto();
		VkPhysicalDevice physicalDevice = vkCore.getPhysicalDevices()[0];
		int queue = physicalDevice.selectOptimalQueueFamily(VkQueueFlagBits.VK_QUEUE_COMPUTE_BIT, 0, 1);
		VkDeviceQueueCreateInfo.Array queues = new VkDeviceQueueCreateInfo.Array(localArena, 1);
		queues.get(0)
				.sType$Default()
				.flags(0)
				.queueFamilyIndex(queue)
				.queueCount(1)
				.pQueuePriorities(MemoryAccess.loadArray(localArena, 1f));

		this.vkDevice = vkCore.initDevice(0, queues, null);

		this.commandPool = vkCore.initCommandPool(this.vkDevice.handle(),
				physicalDevice.queues()[queue],
				VkCommandBufferLevel.VK_COMMAND_BUFFER_LEVEL_PRIMARY,
				1
		);
	}
}
