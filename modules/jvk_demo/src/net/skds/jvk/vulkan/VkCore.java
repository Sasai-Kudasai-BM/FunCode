package net.skds.jvk.vulkan;

import lombok.CustomLog;
import lombok.Getter;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.VkResult;
import net.skds.jvk.annotation.NativeType;
import net.skds.jvk.generated.enums.VkCommandPoolCreateFlagBits;
import net.skds.jvk.generated.structs.*;
import net.skds.jvk.vulkan.command.VkCommandBuffer;
import net.skds.jvk.vulkan.command.VkCommandPool;
import net.skds.jvk.vulkan.device.VkDevice;
import net.skds.jvk.vulkan.device.VkPhysicalDevice;
import net.skds.jvk.vulkan.device.VkQueue;
import net.skds.jvk.vulkan.device.VkQueueFamilyInfo;
import net.skds.jvk.vulkan.pipeline.VkRenderPass;
import net.skds.jvk.vulkan.pipeline.VkRenderPassBuilder;
import net.skds.jvk.vulkan.support.VkExtension;
import net.skds.jvk.vulkan.support.VkLayer;
import net.skds.lib2.utils.SKDSUtils;
import net.skds.lib2.utils.collection.LongList;

import java.lang.foreign.Arena;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.skds.jvk.generated.VK11.*;
import static net.skds.lib2.natives.MemoryAccess.*;

@CustomLog
public class VkCore {


	public static final List<String> DEBUG_LAYERS = List.of("VK_LAYER_KHRONOS_validation");
	public static final List<String> EXTENSIONS = List.of("VK_KHR_surface", "VK_KHR_win32_surface");
	public static final List<String> DEVICE_EXTENSIONS = List.of("VK_KHR_swapchain");

	private final Arena arena = Arena.ofAuto();

	// public

	// private
	private final VulkanParameters vkParam;
	@Getter
	private final Map<String, VkLayer> supportedLayers = new HashMap<>();
	@Getter
	private final Map<String, VkExtension> supportedExtensions = new HashMap<>();

	private final int layersCount;
	private final long layersPPtr;
	private final int extensionsCount;
	private final long extensionsPPtr;
	private final int deviceExtensionsCount;
	private final long deviceExtensionsPPtr;

	private final long pAppName;
	private final long pEngineName;

	private final long pAllocator;

	@Getter
	long instance;
	@Getter
	VkPhysicalDevice[] physicalDevices;
	@Getter
	final LongList deviceInstances = new LongList();
	@Getter
	final List<VkCommandPool> commandPools = new ArrayList<>();
	@Getter
	final List<VkRenderPass> renderPasses = new ArrayList<>();

	final long[] pointers = allocPointers(arena, 2);
	final long lPtr0 = pointers[0];
	final long lPtr1 = pointers[1];

	public VkCore(VulkanParameters parameters) {
		this.vkParam = parameters;
		this.pAppName = loadCString(arena, parameters.appName());
		this.pEngineName = loadCString(arena, parameters.engineName());
		if (parameters.debug()) {
			this.layersCount = DEBUG_LAYERS.size();
			this.layersPPtr = loadCStringArray(arena, DEBUG_LAYERS);
		} else {
			this.layersCount = 0;
			this.layersPPtr = 0;
		}
		this.extensionsCount = EXTENSIONS.size();
		this.extensionsPPtr = loadCStringArray(arena, EXTENSIONS);

		this.deviceExtensionsCount = DEVICE_EXTENSIONS.size();
		this.deviceExtensionsPPtr = loadCStringArray(arena, DEVICE_EXTENSIONS);

		this.pAllocator = 0;
	}

	public void init() {

		listLayers();
		listExtensions();

		initInstance();
		this.physicalDevices = listDevices();
		//initCommandBuffer();
		//initPipeline();
		//initFramebuffer();

		//prepare();

	}

	public void listLayers() {
		Arena localArena = Arena.ofAuto();
		vkCheck(vkEnumerateInstanceLayerProperties(lPtr0, 0));
		int size = getInt(lPtr0);
		VkLayerProperties.Array properties = new VkLayerProperties.Array(localArena, size);
		vkCheck(vkEnumerateInstanceLayerProperties(lPtr0, properties.getAddress()));

		for (VkLayerProperties property : properties) {
			String name = property.layerName();

			supportedLayers.put(name, new VkLayer(
					name,
					property.description(),
					property.specVersion(),
					property.implementationVersion()
			));
		}
	}

	public void listExtensions() {
		Arena localArena = Arena.ofAuto();
		vkCheck(vkEnumerateInstanceExtensionProperties(0, lPtr0, 0));
		int size = getInt(lPtr0);
		VkExtensionProperties.Array properties = new VkExtensionProperties.Array(localArena, size);
		vkCheck(vkEnumerateInstanceExtensionProperties(0, lPtr0, properties.getAddress()));

		for (VkExtensionProperties extension : properties) {
			String name = extension.extensionName();
			supportedExtensions.put(name, new VkExtension(
					name,
					extension.specVersion()
			));
		}
	}

	private void initInstance() {
		Arena localArena = Arena.ofAuto();
		VkApplicationInfo appInfo = new VkApplicationInfo(localArena)
				.sType$Default()
				.pApplicationName(pAppName)
				.applicationVersion(VkDefinitions.vkMakeApiVersion(0, 1, 0, 0))
				.pEngineName(pEngineName)
				.engineVersion(VkDefinitions.vkMakeApiVersion(0, 1, 0, 0))
				.apiVersion(VkDefinitions.VK_API_VERSION_1_1);

		VkInstanceCreateInfo icInfo = new VkInstanceCreateInfo(localArena)
				.sType$Default()
				.flags(0)
				.pApplicationInfo(appInfo.getAddress())
				.enabledLayerCount(layersCount)
				.ppEnabledLayerNames(layersPPtr)
				.enabledExtensionCount(extensionsCount)
				.ppEnabledExtensionNames(extensionsPPtr);

		vkCheck(vkCreateInstance(icInfo.getAddress(), pAllocator, lPtr0));
		this.instance = getLong(lPtr0);

		if (vkParam.debug()) {
			log.debug("instance: " + instance);
		}

	}

	private VkPhysicalDevice[] listDevices() {
		Arena localArena = Arena.ofAuto();

		vkCheck(vkEnumeratePhysicalDevices(instance, lPtr0, 0));
		int count = getInt(lPtr0);
		long pDevArr = alloc8(localArena, count);
		vkCheck(vkEnumeratePhysicalDevices(instance, lPtr0, pDevArr));

		VkPhysicalDeviceProperties.Array properties = new VkPhysicalDeviceProperties.Array(arena, count);
		VkPhysicalDevice[] infoArr = new VkPhysicalDevice[count];
		for (int i = 0; i < count; i++) {
			long device = getLong(pDevArr, i);
			VkPhysicalDeviceProperties props = properties.get(i);
			vkGetPhysicalDeviceProperties(device, props.getAddress());
			VkPhysicalDeviceMemoryProperties memoryProperties = new VkPhysicalDeviceMemoryProperties(localArena);
			vkGetPhysicalDeviceMemoryProperties(device, memoryProperties.getAddress());

			vkGetPhysicalDeviceQueueFamilyProperties(device, lPtr0, 0);
			int qCount = getInt(lPtr0);
			VkQueueFamilyProperties.Array familyProperties = new VkQueueFamilyProperties.Array(localArena, qCount);
			vkGetPhysicalDeviceQueueFamilyProperties(device, lPtr0, familyProperties.getAddress());

			VkQueueFamilyInfo[] queues = new VkQueueFamilyInfo[qCount];
			for (int j = 0; j < qCount; j++) {
				VkQueueFamilyProperties fp = familyProperties.get(j);
				queues[j] = new VkQueueFamilyInfo(
						j,
						fp.queueFlags(),
						fp.queueCount(),
						fp.timestampValidBits(),
						fp.minImageTransferGranularity()
				);
			}

			vkCheck(vkEnumerateDeviceExtensionProperties(device, 0, lPtr0, 0));
			int extCount = getInt(lPtr0);
			VkExtensionProperties.Array extProperties = new VkExtensionProperties.Array(extCount);
			vkCheck(vkEnumerateDeviceExtensionProperties(device, 0, lPtr0, extProperties.getAddress()));
			HashMap<String, VkExtension> extensions = new HashMap<>();
			for (VkExtensionProperties ep : extProperties) {
				String name = ep.extensionName();
				extensions.put(name, new VkExtension(
						name,
						ep.specVersion()
				));
			}

			infoArr[i] = new VkPhysicalDevice(
					device,
					props.apiVersion(),
					props.driverVersion(),
					props.vendorID(),
					props.deviceID(),
					props.deviceType(),
					props.deviceName(),
					SKDSUtils.uuid(props.pipelineCacheUUIDArray()),
					props.limits(),
					props.sparseProperties(),
					VkPhysicalDevice.getMemInfo(memoryProperties),
					queues,
					extensions
			);


		}
		return infoArr;
	}


	public VkDevice initDevice(int deviceIndex, VkDeviceQueueCreateInfo.Array queues, VkPhysicalDeviceFeatures features) {
		Arena localArena = Arena.ofAuto();

		VkDeviceCreateInfo deviceCreateInfo = new VkDeviceCreateInfo(localArena)
				.sType$Default()
				.flags(0)
				.queueCreateInfoCount(queues.length())
				.pQueueCreateInfos(queues.getAddress())
				.enabledExtensionCount(deviceExtensionsCount)
				.ppEnabledExtensionNames(deviceExtensionsPPtr);
		if (features != null) deviceCreateInfo.pEnabledFeatures(features.getAddress());

		if (vkParam.debug()) {
			deviceCreateInfo.enabledLayerCount(layersCount)
					.ppEnabledLayerNames(layersPPtr);
		}
		VkPhysicalDevice deviceInfo = physicalDevices[deviceIndex];

		vkCheck(vkCreateDevice(deviceInfo.handle(), deviceCreateInfo.getAddress(), pAllocator, lPtr0));
		long device = getLong(lPtr0);

		ArrayList<VkQueue> queues2 = new ArrayList<>();
		for (int i = 0; i < queues.length(); i++) {
			VkDeviceQueueCreateInfo queueCreateInfo = queues.get(i);
			int qCount = queueCreateInfo.queueCount();
			int familyIndex = queueCreateInfo.queueFamilyIndex();
			for (int j = 0; j < qCount; j++) {
				vkGetDeviceQueue(device, familyIndex, j, lPtr0);
				long queue = getLong(lPtr0);
				queues2.add(new VkQueue(queue, j, familyIndex));
			}
		}
		if (vkParam.debug()) {
			log.debug("device: " + device);
			log.debug("queues: " + queues2);
		}
		deviceInstances.addLong(device);
		return new VkDevice(device, queues2.toArray(new VkQueue[0]), deviceInfo);
	}

	public VkCommandPool initCommandPool(long deviceHandle, VkQueueFamilyInfo queue, @NativeType("VkCommandBufferLevel") int bufferLevel, int bufferCount) {
		Arena localArena = Arena.ofAuto();

		VkCommandPoolCreateInfo commandPoolCreateInfo = new VkCommandPoolCreateInfo(localArena)
				.sType$Default()
				.flags(VkCommandPoolCreateFlagBits.VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT)
				.queueFamilyIndex(queue.index());
		vkCheck(vkCreateCommandPool(deviceHandle, commandPoolCreateInfo.getAddress(), pAllocator, lPtr0));
		long commandPool = getLong(lPtr0);
		VkCommandBufferAllocateInfo allocateInfo = new VkCommandBufferAllocateInfo(localArena)
				.sType$Default()
				.commandPool(commandPool)
				.level(bufferLevel)
				.commandBufferCount(bufferCount);
		long pBuffers = alloc8(localArena, bufferCount);
		vkCheck(vkAllocateCommandBuffers(deviceHandle, allocateInfo.getAddress(), pBuffers));
		VkCommandBuffer[] commandBuffers = new VkCommandBuffer[bufferCount];
		for (int i = 0; i < bufferCount; i++) {
			commandBuffers[i] = new VkCommandBuffer(getLong(pBuffers, i), commandPool);
		}
		VkCommandPool cp = new VkCommandPool(commandPool, deviceHandle, commandBuffers);
		this.commandPools.add(cp);
		return cp;
	}

	public VkRenderPass createRenderPass(long device, VkRenderPassBuilder builder) {
		vkCheck(vkCreateRenderPass(device, builder.build().getAddress(), pAllocator, lPtr0));
		long rp = getLong(lPtr0);
		VkRenderPass renderPass = new VkRenderPass(device, rp, builder);
		this.renderPasses.add(renderPass);
		return renderPass;
	}

	public void initFrameBuffer(long device) {
		Arena localArena = Arena.ofAuto();

		VkFramebufferCreateInfo framebufferCreateInfo = new VkFramebufferCreateInfo(localArena)
				.sType$Default()
				.flags(0)
				//.
				;

		vkCheck(vkCreateFramebuffer(device, framebufferCreateInfo.getAddress(), pAllocator, lPtr0));
	}

	public void dispose() {
		if (instance == 0) {
			log.debug("VK Not initialized");
			return;
		}
		//vkDestroyRenderPass(device, renderPass, 0);
		//vkDestroyCommandPool(device, commandPool, 0);
		//vkDestroyPipeline(device, pipeline, 0);
		//vkDestroyPipelineLayout(device, pipelineLayout, 0);
		//vkDestroyShaderModule(device, vShaderModule, 0);
		//vkDestroyShaderModule(device, fShaderModule, 0);
		//vkDestroyFramebuffer(device, framebuffer, 0);
		//VkKhrSwapchain.vkDestroySwapchainKHR(device, swapchain, 0);
		//VkKhrSurface.vkDestroySurfaceKHR(instance, surface, 0);
		for (int i = 0; i < renderPasses.size(); i++) {
			renderPasses.get(i).vkClean(pAllocator);
		}
		for (int i = 0; i < commandPools.size(); i++) {
			commandPools.get(i).vkClean(pAllocator);
		}
		commandPools.clear();
		for (int i = 0; i < deviceInstances.size(); i++) {
			vkDestroyDevice(deviceInstances.getLong(i), pAllocator);
		}
		deviceInstances.clear();
		vkDestroyInstance(instance, pAllocator);
		if (vkParam.debug()) {
			log.debug("VK Discarded");
		}
	}


	public static void vkCheck(int result) {
		if (result != VkResult.VK_SUCCESS) {
			if (result == VkResult.VK_INCOMPLETE) {
				log.error("[WARN] INCOMPLETE vk result");
				return;
			}
			throw new RuntimeException("VK err " + result + ": " + VkDefinitions.getErr(result));
		}
	}
}
