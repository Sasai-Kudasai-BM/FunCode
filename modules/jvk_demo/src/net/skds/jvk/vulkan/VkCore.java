package net.skds.jvk.vulkan;

import lombok.CustomLog;
import net.skds.jvk.VkDefinitions;
import net.skds.jvk.VkResult;
import net.skds.jvk.generated.structs.*;
import net.skds.lib2.utils.SKDSUtils;

import java.lang.foreign.Arena;
import java.util.List;

import static net.skds.jvk.generated.VK11.*;
import static net.skds.lib2.natives.SafeAnal.*;

@CustomLog
public class VkCore {


	public static final List<String> LAYERS = List.of("VK_LAYER_KHRONOS_validation");
	public static final List<String> EXTENSIONS = List.of("VK_KHR_surface", "VK_KHR_win32_surface");
	public static final List<String> DEVICE_EXTENSIONS = List.of("VK_KHR_swapchain", "VK_EXT_memory_budget");

	final Arena arena = Arena.ofAuto();
	private final boolean debug;
	private final String appName;
	private final String engineName;

	private final int layersCount;
	private final long layersPPtr;
	private final int extensionsCount;
	private final long extensionsPPtr;
	private final int deviceExtensionsCount;
	private final long deviceExtensionsPPtr;

	private final long pAppName;
	private final long pEngineName;

	private final long pAllocator = 0;

	long instance;
	VkDeviceInfo[] devices;

	final long[] pointers = allocPointers(arena, 4);
	final long lPtr0 = pointers[0];
	final long lPtr1 = pointers[1];
	final long lPtr2 = pointers[2];
	final long lPtr3 = pointers[3];

	// rendering
	int width;
	int height;

	public VkCore(boolean debug, String appName, String engineName) {
		this.debug = debug;
		this.appName = appName;
		this.engineName = engineName;
		this.pAppName = loadCString(arena, appName);
		this.pEngineName = loadCString(arena, engineName);
		if (debug) {
			this.layersCount = LAYERS.size();
			this.layersPPtr = loadCStringArray(arena, LAYERS);
		} else {
			this.layersCount = 0;
			this.layersPPtr = 0;
		}
		this.extensionsCount = EXTENSIONS.size();
		this.extensionsPPtr = loadCStringArray(arena, EXTENSIONS);

		this.deviceExtensionsCount = DEVICE_EXTENSIONS.size();
		this.deviceExtensionsPPtr = loadCStringArray(arena, DEVICE_EXTENSIONS);
	}

	public void listLayers() {
		vkCheck(vkEnumerateInstanceLayerProperties(lPtr0, 0));
		int size = getInt(lPtr0);
		VkLayerProperties.Array properties = new VkLayerProperties.Array(arena, size);
		vkCheck(vkEnumerateInstanceLayerProperties(lPtr0, properties.getAddress()));

		System.out.println("===== LayerProperties start =====");
		for (VkLayerProperties property : properties) {
			System.out.println(property.layerName());
			System.out.println(VkDefinitions.getVersion(property.specVersion()));
			System.out.println(property.implementationVersion());
			System.out.println(property.description());
			System.out.println("----------------");
		}
		System.out.println("===== LayerProperties end =======");
	}

	public void init() {

		initInstance();
		devices = listDevices();
		for (VkDeviceInfo di : devices) {
			System.out.println(di);
		}
		//initCommandBuffer();
		//initPipeline();
		//initFramebuffer();

		//prepare();

	}

	private void initInstance() {
		VkApplicationInfo appInfo = new VkApplicationInfo()
				.sType$Default()
				.pApplicationName(pAppName)
				.applicationVersion(VkDefinitions.vkMakeApiVersion(0, 1, 0, 0))
				.pEngineName(pEngineName)
				.engineVersion(VkDefinitions.vkMakeApiVersion(0, 1, 0, 0))
				.apiVersion(VkDefinitions.VK_API_VERSION_1_1);

		VkInstanceCreateInfo icInfo = new VkInstanceCreateInfo()
				.sType$Default()
				.flags(0)
				.pApplicationInfo(appInfo.getAddress())
				.enabledLayerCount(layersCount)
				.ppEnabledLayerNames(layersPPtr)
				.enabledExtensionCount(extensionsCount)
				.ppEnabledExtensionNames(extensionsPPtr);

		vkCheck(vkCreateInstance(icInfo.getAddress(), pAllocator, lPtr0));
		this.instance = getLong(lPtr0);

		if (debug) {
			log.debug("instance: " + instance);
		}

	}

	private void initDevice(VkDeviceInfo deviceInfo) {

	}

	private VkDeviceInfo[] listDevices() {
		vkCheck(vkEnumeratePhysicalDevices(instance, lPtr0, 0));
		int count = getInt(lPtr0);
		long pDevArr = alloc8(arena, count);
		vkCheck(vkEnumeratePhysicalDevices(instance, lPtr0, pDevArr));

		VkPhysicalDeviceProperties.Array properties = new VkPhysicalDeviceProperties.Array(arena, count);
		VkDeviceInfo[] infoArr = new VkDeviceInfo[count];
		for (int i = 0; i < count; i++) {
			long device = getLong(pDevArr, i);
			VkPhysicalDeviceProperties props = properties.get(i);
			vkGetPhysicalDeviceProperties(device, props.getAddress());
			VkPhysicalDeviceMemoryProperties memoryProperties = new VkPhysicalDeviceMemoryProperties();
			vkGetPhysicalDeviceMemoryProperties(device, memoryProperties.getAddress());

			infoArr[i] = new VkDeviceInfo(
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
					VkDeviceInfo.getMemInfo(memoryProperties)
			);


		}
		return infoArr;
	}

	//public void reportMemory(int device) {
	//}


	/*
	private void initDevice() {

		vkCheck(vkEnumeratePhysicalDevices(instance, lPtr0, 0));
		int count = getInt(lPtr0);
		long pDevArr = stack.pushLongs(count);
		vkCheck(vkEnumeratePhysicalDevices(instance, lPtr0, pDevArr));

		VkPhysicalDeviceProperties properties = new VkPhysicalDeviceProperties();
		properties.alloc(stack);

		//VkPhysicalDeviceProperties
		for (int i = 0; i < count; i++) {
			long d = getLong(pDevArr + i * 8L);
			hDevice = d;
			vkGetPhysicalDeviceProperties(d, properties.address());
			properties.get();
			limits = properties.limits;

			memoryProperties = new VkPhysicalDeviceMemoryProperties();
			memoryProperties.alloc(stack);
			vkGetPhysicalDeviceMemoryProperties(d, memoryProperties.address());
			memoryProperties.get();

			deviceFastMemoryType = selectOptimalMemoryType(VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
			hostFastMemoryType = selectOptimalMemoryType(VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_COHERENT_BIT |
					VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT |
					VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_CACHED_BIT
			);
			if (hostFastMemoryType == -1) {
				hostFastMemoryType = selectOptimalMemoryType(VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_COHERENT_BIT |
						VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT
				);
			}

			if (debug) {
				System.out.println("=============== Device =============");
				System.out.println("deviceID: " + properties.deviceID);
				System.out.println("deviceType: " + VKDefinitions.getDeviceType(properties.deviceType));
				System.out.println("apiVersion: " + VKDefinitions.getVersion(properties.apiVersion)
				);
				System.out.println("driverVersion: " + Integer.toUnsignedString(properties.driverVersion, 16));
				System.out.println("vendorID: " + properties.vendorID);
				System.out.println("pipelineCacheUUID: " + SKDSUtils.HEX_FORMAT_LC.formatHex(properties.pipelineCacheUUID));
				System.out.println("deviceName: " + NInvoker.nullTerminatedString(properties.deviceName, StandardCharsets.UTF_8));
				System.out.println("===========  Memory  ========= x" + memoryProperties.memoryTypeCount);
				for (int j = 0; j < memoryProperties.memoryTypeCount; j++) {
					VkMemoryType t = memoryProperties.memoryTypes[j];
					if (t.propertyFlags == 0) continue;
					System.out.print("propertyFlags: " + t.propertyFlags);
					VkMemoryHeap heap = memoryProperties.memoryHeaps[t.heapIndex];
					System.out.print(" heap flags: " + heap.flags);
					System.out.println(" Size: " + SKDSUtils.memoryCompact(heap.size));
				}
				//listDeviceExtensions(d);
				System.out.println("====================================");
			} else {
				break;
			}
		}

		vkGetPhysicalDeviceQueueFamilyProperties(hDevice, lPtr0, 0);
		count = getInt(lPtr0);
		VkQueueFamilyProperties[] familyProperties = VkQueueFamilyProperties.WRAPPER.allocArray(count, stack);
		vkGetPhysicalDeviceQueueFamilyProperties(hDevice, lPtr0, familyProperties[0].address());

		int desiredBits = VkQueueFlagBits.VK_QUEUE_GRAPHICS_BIT |
				VkQueueFlagBits.VK_QUEUE_COMPUTE_BIT |
				VkQueueFlagBits.VK_QUEUE_TRANSFER_BIT |
				VkQueueFlagBits.VK_QUEUE_SPARSE_BINDING_BIT;

		for (int i = 0; i < count; i++) {
			VkQueueFamilyProperties fp = familyProperties[i];
			fp.get();

			if (debug) {
				System.out.println("===== Family properties ====");
				System.out.println("queueCount: " + fp.queueCount);
				System.out.println("queueFlags: " + fp.queueFlags);
				System.out.println("timestampValidBits: " + fp.timestampValidBits);
				System.out.println("minImageTransferGranularity: " + fp.minImageTransferGranularity.width + " "
						+ fp.minImageTransferGranularity.height + " "
						+ fp.minImageTransferGranularity.depth
				);
				System.out.println("===========================");
			}
			if ((fp.queueFlags & desiredBits) == desiredBits) {
				mainQueueFamilyIndex = i;
				break;
			}
		}

		long pPriority = stack.push4();
		setFloat(pPriority, 1f);
		VkDeviceQueueCreateInfo deviceQueueInfo = new VkDeviceQueueCreateInfo();
		deviceQueueInfo.queueFamilyIndex = mainQueueFamilyIndex;
		deviceQueueInfo.queueCount = 1;
		deviceQueueInfo.pQueuePriorities = pPriority;

		deviceQueueInfo.allocPut(stack);

		VkDeviceCreateInfo deviceInfo = new VkDeviceCreateInfo();
		if (debug) {
			deviceInfo.enabledLayerCount = layersCount;
			deviceInfo.ppEnabledLayerNames = layersPtr.getPPtr();
		}
		deviceInfo.enabledExtensionCount = deviceExtensionsCount;
		deviceInfo.ppEnabledExtensionNames = deviceExtensionsPtr.getPPtr();
		deviceInfo.queueCreateInfoCount = 1;
		deviceInfo.pQueueCreateInfos = deviceQueueInfo.address();

		deviceInfo.allocPut(stack);

		vkCheck(vkCreateDevice(hDevice, deviceInfo.address(), 0, lPtr0));
		device = getLong(lPtr0);

		vkGetDeviceQueue(device, mainQueueFamilyIndex, 0, lPtr0);
		queue = getLong(lPtr0);

		if (debug) {
			System.out.println("device: " + device);
			System.out.println("queue: " + queue);
		}

	}


	private void listExtensions() {

		vkCheck(vkEnumerateInstanceExtensionProperties(0, lPtr0, 0));
		int size = getInt(lPtr0);
		VkExtensionProperties[] properties = VkExtensionProperties.WRAPPER.allocArray(size, stack);
		vkCheck(vkEnumerateInstanceExtensionProperties(0, lPtr0, properties[0].address()));
		//properties[0].get();

		for (VkExtensionProperties p : properties) {
			p.get();
			System.out.println("======= ExtensionProperties ==========");
			System.out.println(NInvoker.nullTerminatedString(p.extensionName, StandardCharsets.UTF_8));
			System.out.println("specVersion: " + p.specVersion);
			System.out.println("====================================");
		}

	}

	private void listDeviceExtensions(long d) {

		vkCheck(vkEnumerateDeviceExtensionProperties(d, 0, lPtr0, 0));
		int size = getInt(lPtr0);
		VkExtensionProperties[] properties = VkExtensionProperties.WRAPPER.allocArray(size, stack);
		vkCheck(vkEnumerateDeviceExtensionProperties(d, 0, lPtr0, properties[0].address()));
		//properties[0].get();

		for (VkExtensionProperties p : properties) {
			p.get();
			System.out.println("======= DeviceExtensionProperties ==========");
			System.out.println(NInvoker.nullTerminatedString(p.extensionName, StandardCharsets.UTF_8));
			System.out.println("specVersion: " + p.specVersion);
		}

	}

	private int selectOptimalMemoryType(int flags) {
		for (int i = 0; i < memoryProperties.memoryTypeCount; i++) {
			VkMemoryType type = memoryProperties.memoryTypes[i];
			if ((type.propertyFlags & flags) == flags) {
				return i;
			}
		}
		return -1;
	}

	 */
	public void dispose() {
		//vkDestroyRenderPass(device, renderPass, 0);
		//vkDestroyCommandPool(device, commandPool, 0);
		//vkDestroyPipeline(device, pipeline, 0);
		//vkDestroyPipelineLayout(device, pipelineLayout, 0);
		//vkDestroyShaderModule(device, vShaderModule, 0);
		//vkDestroyShaderModule(device, fShaderModule, 0);
		//vkDestroyFramebuffer(device, framebuffer, 0);
		//VkKhrSwapchain.vkDestroySwapchainKHR(device, swapchain, 0);
		//VkKhrSurface.vkDestroySurfaceKHR(instance, surface, 0);
		//vkDestroyDevice(device, 0);
		vkDestroyInstance(instance, pAllocator);
		if (debug) {
			System.out.println("VK Discarded");
		}
	}


	private static void vkCheck(int result) {
		if (result != VkResult.VK_SUCCESS) {
			if (result == VkResult.VK_INCOMPLETE) {
				System.out.println("[WARN] INCOMPLETE vk result");
				return;
			}
			throw new RuntimeException("VK err " + result + ": " + VkDefinitions.getErr(result));
		}
	}
}
