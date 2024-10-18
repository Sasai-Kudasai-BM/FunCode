package net.skds.s3d.vulkan;

import net.skds.jvk.VKDefinitions;
import net.skds.jvk.VkResult;
import net.skds.jvk.generated.enums.*;
import net.skds.jvk.generated.extensions.VkKhrSurface;
import net.skds.jvk.generated.extensions.VkKhrSwapchain;
import net.skds.jvk.generated.extensions.VkKhrWin32Surface;
import net.skds.jvk.generated.structs.*;
import net.skds.lib.unsafe.MemoryStack;
import net.skds.lib.utils.SKDSUtils;
import net.skds.nativelib.Kernel32;
import net.skds.ninvoker.NInvoker;
import net.skds.s3d.vulkan.image.VkImage;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static net.skds.jvk.generated.VK10.*;
import static net.skds.lib.unsafe.UnsafeAnal.*;

@SuppressWarnings({"unused", "FieldCanBeLocal"})
public final class VKCore {

	private static final List<String> LAYERS = List.of("VK_LAYER_KHRONOS_validation");
	private static final List<String> EXTENSIONS = List.of("VK_KHR_surface", "VK_KHR_win32_surface");
	private static final List<String> DEVICE_EXTENSIONS = List.of("VK_KHR_swapchain");

	private final boolean debug;
	private final String appName;
	private final String engineName;

	private final MemoryStack mainStack = new MemoryStack();
	private final long ptr0 = mainStack.push8();
	private final long ptr1 = mainStack.push8();

	private final JFrame frame;

	private final int layersCount;
	private final MemoryStack layersPtr = mainStack.pushChild();
	private final int extensionsCount;
	private final MemoryStack extensionsPtr = mainStack.pushChild();
	private final int deviceExtensionsCount;
	private final MemoryStack deviceExtensionsPtr = mainStack.pushChild();

	private final int surfaceFormat = VkFormat.VK_FORMAT_B8G8R8A8_UNORM;
	private final long pAllocator = 0;

	private final int cmdCount = 2;
	private final CommandBuffer[] cmdArray;

	private final int swapchainImageCount = 2;
	private final SwapchainElement[] swapchainElements = new SwapchainElement[swapchainImageCount];

	private long instance;
	private long hDevice;
	private long device;
	private int mainQueueFamilyIndex;
	private long queue;
	private long commandPool;

	long framebuffer;
	long surface;
	long swapchain;

	private int deviceOptimalMemoryType;
	private int hostOptimalMemoryType;
	private int pushOptimalMemoryType;


	private VkPhysicalDeviceLimits limits;
	VkPhysicalDeviceMemoryProperties memoryProperties;

	private long hWnd;
	private long hInstance;
	private int width;
	private int height;


	public VKCore(boolean debug, JFrame frame, String appName, String engineName) {
		this.debug = debug;
		this.frame = frame;
		this.appName = appName;
		this.engineName = engineName;
		if (debug) {
			this.layersCount = LAYERS.size();
			for (String layer : LAYERS) {
				this.layersPtr.pushNT(layer);
			}
			this.layersPtr.makePPtr();
		} else {
			this.layersCount = 0;
		}
		this.extensionsCount = EXTENSIONS.size();
		for (String extension : EXTENSIONS) {
			this.extensionsPtr.pushNT(extension);
		}
		this.extensionsPtr.makePPtr();
		this.deviceExtensionsCount = DEVICE_EXTENSIONS.size();
		for (String extension : DEVICE_EXTENSIONS) {
			this.deviceExtensionsPtr.pushNT(extension);
		}
		this.deviceExtensionsPtr.makePPtr();

		this.cmdArray = new CommandBuffer[cmdCount];

		if (debug) {
			listLayers();
		}
	}

	public void initWindow() {
		this.hWnd = NInvoker.getHWnd(frame);
		this.hInstance = Kernel32.getModuleHandle(0);
		final Component wnd = frame.getContentPane();
		this.width = wnd.getWidth();
		this.height = wnd.getHeight();
	}

	public void init() {
		initWindow();

		initInstance();
		initDevice();
		initCommandBuffer();
		//initPipeline();
		//initFramebuffer();

		//prepare();
	}

	private void initInstance() {

		try (MemoryStack stack = new MemoryStack()) {

			VkApplicationInfo appInfo = new VkApplicationInfo();
			appInfo.applicationVersion = VKDefinitions.vkMakeApiVersion(0, 1, 0, 0);
			appInfo.engineVersion = VKDefinitions.vkMakeApiVersion(0, 1, 0, 0);
			appInfo.pApplicationName = stack.pushNT(appName);
			appInfo.pEngineName = stack.pushNT(engineName);
			appInfo.applicationVersion = VKDefinitions.VK_API_VERSION_1_3;

			appInfo.alloc(stack);
			appInfo.put();

			VkInstanceCreateInfo icInfo = new VkInstanceCreateInfo();
			icInfo.pApplicationInfo = appInfo.address();
			icInfo.enabledLayerCount = layersCount;
			icInfo.ppEnabledLayerNames = layersPtr.getPPtr();
			icInfo.enabledExtensionCount = extensionsCount;
			icInfo.ppEnabledExtensionNames = extensionsPtr.getPPtr();

			icInfo.alloc(stack);
			icInfo.put();

			check(vkCreateInstance(icInfo.address(), pAllocator, ptr0));
			instance = getLong(ptr0);

			if (debug) {
				System.out.println("instance: " + instance);
			}
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

	private void initDevice() {
		try (MemoryStack stack = new MemoryStack()) {

			check(vkEnumeratePhysicalDevices(instance, ptr0, 0));
			int count = getInt(ptr0);
			long pDevArr = stack.pushLongs(count);
			check(vkEnumeratePhysicalDevices(instance, ptr0, pDevArr));

			VkPhysicalDeviceProperties properties = new VkPhysicalDeviceProperties();
			properties.alloc(stack);

			for (int i = 0; i < count; i++) {
				long d = getLong(pDevArr, i);
				hDevice = d;
				vkGetPhysicalDeviceProperties(d, properties.address());
				properties.get();
				limits = properties.limits;

				memoryProperties = new VkPhysicalDeviceMemoryProperties();
				memoryProperties.alloc(stack);
				vkGetPhysicalDeviceMemoryProperties(d, memoryProperties.address());
				memoryProperties.get();

				deviceOptimalMemoryType = selectOptimalMemoryType(VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT);
				hostOptimalMemoryType = selectOptimalMemoryType(VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_COHERENT_BIT |
						VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT |
						VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_CACHED_BIT
				);
				if (hostOptimalMemoryType == -1) {
					hostOptimalMemoryType = selectOptimalMemoryType(VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_COHERENT_BIT |
							VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT
					);
				}
				pushOptimalMemoryType = selectOptimalMemoryType(VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_COHERENT_BIT |
						VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT |
						VkMemoryPropertyFlagBits.VK_MEMORY_PROPERTY_DEVICE_LOCAL_BIT
				);
				if (pushOptimalMemoryType == -1) {
					pushOptimalMemoryType = hostOptimalMemoryType;
				}

				if (debug) {
					System.out.println("=============== Device =============");
					System.out.println("deviceID: " + properties.deviceID);
					System.out.println("deviceType: " + properties.deviceType);
					System.out.println("apiVersion: " + VKDefinitions.getVersion(properties.apiVersion)
					);
					System.out.println("driverVersion: " + Integer.toUnsignedString(properties.driverVersion, 16));
					System.out.println("vendorID: " + properties.vendorID);
					System.out.println("pipelineCacheUUID: " + SKDSUtils.HEX_FORMAT_LC.formatHex(properties.pipelineCacheUUID));
					System.out.println("deviceName: " + NInvoker.nullTerminatedString(properties.deviceName, StandardCharsets.UTF_8));
					System.out.println("===========  Memory  ========= x" + memoryProperties.memoryTypeCount);
					for (int j = 0; j < memoryProperties.memoryTypeCount; j++) {
						VkMemoryType t = memoryProperties.memoryTypes[j];
						System.out.println("Flags: " + t.propertyFlags);
						VkMemoryHeap heap = memoryProperties.memoryHeaps[t.heapIndex];
						System.out.println("Heap Flags: " + heap.flags);
						System.out.println("Heap Size: " + SKDSUtils.memoryCompact(heap.size));
						System.out.println("--------------");
					}
					//listDeviceExtensions(d);
					System.out.println("====================================");
				} else {
					break;
				}
			}

			vkGetPhysicalDeviceQueueFamilyProperties(hDevice, ptr0, 0);
			count = getInt(ptr0);
			VkQueueFamilyProperties[] familyProperties = VkQueueFamilyProperties.WRAPPER.allocArray(count, stack);
			vkGetPhysicalDeviceQueueFamilyProperties(hDevice, ptr0, familyProperties[0].address());

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

			VkDeviceQueueCreateInfo queueInfo = new VkDeviceQueueCreateInfo();
			queueInfo.queueFamilyIndex = mainQueueFamilyIndex;
			queueInfo.queueCount = 1;
			queueInfo.pQueuePriorities = stack.push(1f);

			queueInfo.alloc(stack);
			queueInfo.put();

			VkDeviceCreateInfo dci = new VkDeviceCreateInfo();
			dci.enabledLayerCount = layersCount;
			dci.ppEnabledLayerNames = layersPtr.getPPtr();
			dci.enabledExtensionCount = deviceExtensionsCount;
			dci.ppEnabledExtensionNames = deviceExtensionsPtr.getPPtr();
			dci.queueCreateInfoCount = 1;
			dci.pQueueCreateInfos = queueInfo.address();
			dci.allocPut(stack);

			check(vkCreateDevice(hDevice, dci.address(), pAllocator, ptr0));
			device = getLong(ptr0);

			vkGetDeviceQueue(device, mainQueueFamilyIndex, 0, ptr0);
			queue = getLong(ptr0);
		}
	}

	private void initCommandBuffer() {
		try (MemoryStack stack = new MemoryStack()) {
			VkCommandPoolCreateInfo commandPoolInfo = new VkCommandPoolCreateInfo();
			commandPoolInfo.queueFamilyIndex = mainQueueFamilyIndex;
			commandPoolInfo.flags = VkCommandPoolCreateFlagBits.VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT;
			commandPoolInfo.allocPut(stack);
			check(vkCreateCommandPool(device, commandPoolInfo.address(), pAllocator, ptr0));
			commandPool = getLong(ptr0);

			VkCommandBufferAllocateInfo cbaInfo = new VkCommandBufferAllocateInfo();
			cbaInfo.level = VkCommandBufferLevel.VK_COMMAND_BUFFER_LEVEL_PRIMARY;
			cbaInfo.commandBufferCount = cmdCount;
			cbaInfo.commandPool = commandPool;
			cbaInfo.allocPut(stack);

			check(vkAllocateCommandBuffers(device, cbaInfo.address(), ptr0));

			VkSemaphoreCreateInfo semaphoreInfo = new VkSemaphoreCreateInfo();
			semaphoreInfo.allocPut(stack);

			for (int i = 0; i < cmdCount; i++) {
				long commandBuffer = getLong(ptr0, i);
				check(vkCreateSemaphore(device, semaphoreInfo.address(), pAllocator, ptr1));
				long semaphore = getLong(ptr1);

				cmdArray[i] = new CommandBuffer(commandBuffer, semaphore);
			}
		}
	}

	private VkImage createImage(MemoryStack stack, int w, int h, int imgFormat) {

		VkImageCreateInfo imageInfo = new VkImageCreateInfo();
		imageInfo.imageType = VkImageType.VK_IMAGE_TYPE_2D;
		imageInfo.format = imgFormat;
		imageInfo.sharingMode = VkSharingMode.VK_SHARING_MODE_EXCLUSIVE;
		imageInfo.arrayLayers = 1;
		imageInfo.mipLevels = 1;
		imageInfo.samples = VkSampleCountFlagBits.VK_SAMPLE_COUNT_1_BIT;
		imageInfo.tiling = VkImageTiling.VK_IMAGE_TILING_OPTIMAL;
		imageInfo.usage = VkImageUsageFlagBits.VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT;
		imageInfo.queueFamilyIndexCount = 0;
		imageInfo.initialLayout = VkImageLayout.VK_IMAGE_LAYOUT_UNDEFINED;
		imageInfo.extent = new VkExtent3D();
		imageInfo.extent.depth = 1;
		imageInfo.extent.width = w;
		imageInfo.extent.height = h;
		imageInfo.allocPut(stack);

		VkImageViewCreateInfo viewInfo = new VkImageViewCreateInfo();
		viewInfo.components = new VkComponentMapping();
		viewInfo.components.a = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_A;
		viewInfo.components.r = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_R;
		viewInfo.components.g = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_G;
		viewInfo.components.b = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_B;
		viewInfo.subresourceRange = new VkImageSubresourceRange();
		viewInfo.subresourceRange.aspectMask = VkImageAspectFlagBits.VK_IMAGE_ASPECT_COLOR_BIT;
		viewInfo.subresourceRange.baseArrayLayer = 0;
		viewInfo.subresourceRange.baseMipLevel = 0;
		viewInfo.subresourceRange.layerCount = 1;
		viewInfo.subresourceRange.levelCount = 1;
		viewInfo.flags = 0;
		viewInfo.viewType = VkImageViewType.VK_IMAGE_VIEW_TYPE_2D;
		viewInfo.format = imgFormat;
		viewInfo.alloc(stack);

		check(vkCreateImage(device, imageInfo.address(), pAllocator, ptr0));
		long image = getLong(ptr0);

		VkMemoryRequirements requirements = new VkMemoryRequirements();
		requirements.alloc(stack);

		vkGetImageMemoryRequirements(device, image, requirements.address());
		requirements.get();

		VkMemoryAllocateInfo memoryAllocateInfo = new VkMemoryAllocateInfo();
		memoryAllocateInfo.allocationSize = requirements.size;
		memoryAllocateInfo.memoryTypeIndex = deviceOptimalMemoryType;
		memoryAllocateInfo.allocPut(stack);

		check(vkAllocateMemory(device, memoryAllocateInfo.address(), pAllocator, ptr0));
		long mem = getLong(ptr0);
		check(vkBindImageMemory(device, image, mem, 0));

		viewInfo.image = image;
		viewInfo.put();

		check(vkCreateImageView(device, viewInfo.address(), pAllocator, ptr0));

		return new VkImage(image, mem, getLong(ptr0));
	}


	@SuppressWarnings("SameParameterValue")
	private SwapchainElement[] createFramebufferImages(MemoryStack stack) {

		VkImageViewCreateInfo viewInfo = new VkImageViewCreateInfo();
		viewInfo.components = new VkComponentMapping();
		viewInfo.components.a = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_A;
		viewInfo.components.r = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_R;
		viewInfo.components.g = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_G;
		viewInfo.components.b = VkComponentSwizzle.VK_COMPONENT_SWIZZLE_B;
		viewInfo.subresourceRange = new VkImageSubresourceRange();
		viewInfo.subresourceRange.aspectMask = VkImageAspectFlagBits.VK_IMAGE_ASPECT_COLOR_BIT;
		viewInfo.subresourceRange.baseArrayLayer = 0;
		viewInfo.subresourceRange.baseMipLevel = 0;
		viewInfo.subresourceRange.layerCount = 1;
		viewInfo.subresourceRange.levelCount = 1;
		viewInfo.flags = 0;
		viewInfo.viewType = VkImageViewType.VK_IMAGE_VIEW_TYPE_2D;
		viewInfo.format = surfaceFormat;
		viewInfo.alloc(stack);

		SwapchainElement[] images = new SwapchainElement[swapchainImageCount];
		long ptr = stack.pushLongs(swapchainImageCount);

		check(VkKhrSwapchain.vkGetSwapchainImagesKHR(device, swapchain, stack.push(swapchainImageCount), ptr));
		for (int i = 0; i < swapchainImageCount; i++) {
			long image = getLong(ptr, i);
			viewInfo.image = image;
			viewInfo.put();
			check(vkCreateImageView(device, viewInfo.address(), pAllocator, ptr0));
			long view = getLong(ptr0);
			swapchainElements[i] = new SwapchainElement(image, view);
		}
		return images;
	}

	private void initFramebuffer() {
		try (MemoryStack stack = new MemoryStack()) {

			VkWin32SurfaceCreateInfoKHR surfaceCi = new VkWin32SurfaceCreateInfoKHR();
			surfaceCi.sType = 1000009000;// VkKhrWin32Surface.VK_STRUCTURE_TYPE_WIN32_SURFACE_CREATE_INFO_KHR; // broken???
			surfaceCi.hinstance = hInstance;
			surfaceCi.hwnd = hWnd;
			surfaceCi.allocPut(stack);

			check(VkKhrWin32Surface.vkCreateWin32SurfaceKHR(instance, surfaceCi.address(), pAllocator, ptr0));
			surface = getLong(ptr0);

			check(VkKhrSurface.vkGetPhysicalDeviceSurfaceFormatsKHR(hDevice, surface, ptr0, 0));
			int count = getInt(ptr0);
			VkSurfaceFormatKHR[] formats = VkSurfaceFormatKHR.WRAPPER.allocArray(count, stack);
			check(VkKhrSurface.vkGetPhysicalDeviceSurfaceFormatsKHR(hDevice, surface, ptr0, formats[0].address()));
			boolean formatOk = false;
			for (int i = 0; i < count; i++) {
				VkSurfaceFormatKHR format = formats[i];
				format.get();
				if (format.format == surfaceFormat) {
					formatOk = true;
					break;
				}
			}
			if (!formatOk) {
				throw new RuntimeException("Format VK_FORMAT_B8G8R8A8_UNORM not present");
			}

			VkSwapchainCreateInfoKHR swapchainInfo = new VkSwapchainCreateInfoKHR();
			swapchainInfo.sType = 1000001000;//VkKhrSwapchain.VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR;
			swapchainInfo.surface = surface;
			swapchainInfo.minImageCount = 2;
			swapchainInfo.imageFormat = surfaceFormat;
			swapchainInfo.imageColorSpace = VkColorSpaceKHR.VK_COLOR_SPACE_SRGB_NONLINEAR_KHR;
			swapchainInfo.imageExtent = new VkExtent2D();
			swapchainInfo.imageExtent.width = width;
			swapchainInfo.imageExtent.height = height;
			swapchainInfo.imageArrayLayers = 1;
			swapchainInfo.imageUsage = VkImageUsageFlagBits.VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT;
			swapchainInfo.imageSharingMode = VkSharingMode.VK_SHARING_MODE_EXCLUSIVE;
			swapchainInfo.queueFamilyIndexCount = 1;
			swapchainInfo.pQueueFamilyIndices = stack.push(mainQueueFamilyIndex);
			swapchainInfo.preTransform = VkSurfaceTransformFlagBitsKHR.VK_SURFACE_TRANSFORM_IDENTITY_BIT_KHR;
			swapchainInfo.compositeAlpha = VkCompositeAlphaFlagBitsKHR.VK_COMPOSITE_ALPHA_OPAQUE_BIT_KHR;
			swapchainInfo.presentMode = VkPresentModeKHR.VK_PRESENT_MODE_IMMEDIATE_KHR;
			swapchainInfo.clipped = 0;
			swapchainInfo.oldSwapchain = swapchain;
			swapchainInfo.allocPut(stack);

			check(VkKhrSwapchain.vkCreateSwapchainKHR(device, swapchainInfo.address(), pAllocator, ptr0));
			swapchain = getLong(ptr0);

			createFramebufferImages(stack);

			long ptr = stack.pushLongs(swapchainImageCount);
			for (int i = 0; i < swapchainImageCount; i++) {
				setLong(ptr, i, swapchainElements[i].view());
			}

			VkFramebufferCreateInfo framebufferCi = new VkFramebufferCreateInfo();
			//framebufferCi.renderPass = renderPass; todo
			framebufferCi.attachmentCount = swapchainImageCount;
			framebufferCi.pAttachments = ptr;
			framebufferCi.width = width;
			framebufferCi.height = height;
			framebufferCi.layers = 1;
			framebufferCi.allocPut(stack);
			check(vkCreateFramebuffer(device, framebufferCi.address(), pAllocator, ptr0));
			framebuffer = getLong(ptr0);
		}
	}

	private void listLayers() {

		try (MemoryStack stack = new MemoryStack()) {
			check(vkEnumerateInstanceLayerProperties(ptr0, 0));
			int size = getInt(ptr0);

			VkLayerProperties[] properties = VkLayerProperties.WRAPPER.allocArray(size, stack);

			check(vkEnumerateInstanceLayerProperties(ptr0, properties[0].address()));
			//properties[0].get();

			System.out.println("======= LayerProperties ==========");
			for (VkLayerProperties p : properties) {
				p.get();
				System.out.println(NInvoker.nullTerminatedString(p.layerName, StandardCharsets.UTF_8));
				System.out.println(NInvoker.nullTerminatedString(p.description, StandardCharsets.UTF_8));
				System.out.println("specVersion: " + p.specVersion);
				System.out.println("specVersion: " + p.implementationVersion);
				System.out.println("=================================");
			}
		}
	}

	private static void check(int result) {
		if (result != VkResult.VK_SUCCESS) {
			if (result == VkResult.VK_INCOMPLETE) {
				System.out.println("[WARN] INCOMPLETE vk result");
				return;
			}
			throw new RuntimeException("VK err " + result + ": " + VKDefinitions.getErr(result));
		}
	}

	public void dispose() {
		mainStack.free();

		
		//vkDestroyRenderPass(device, renderPass, 0);
		//vkDestroyPipeline(device, pipeline, 0);
		//vkDestroyPipelineLayout(device, pipelineLayout, 0);
		//vkDestroyShaderModule(device, vShaderModule, 0);
		//vkDestroyShaderModule(device, fShaderModule, 0);

		vkDestroyCommandPool(device, commandPool, 0);
		vkDestroyFramebuffer(device, framebuffer, 0);
		VkKhrSwapchain.vkDestroySwapchainKHR(device, swapchain, 0);
		VkKhrSurface.vkDestroySurfaceKHR(instance, surface, 0);
		vkDestroyDevice(device, 0);
		vkDestroyInstance(instance, 0);
		if (debug) {
			System.out.println("VK disposed");
		}
	}
}
