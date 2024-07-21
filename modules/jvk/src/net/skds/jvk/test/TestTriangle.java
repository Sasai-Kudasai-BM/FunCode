package net.skds.jvk.test;

import net.skds.jvk.VKDefinitions;
import net.skds.jvk.generated.enums.*;
import net.skds.jvk.generated.extensions.VkKhrSurface;
import net.skds.jvk.generated.extensions.VkKhrSwapchain;
import net.skds.jvk.generated.extensions.VkKhrWin32Surface;
import net.skds.jvk.generated.structs.*;
import net.skds.lib.utils.SKDSUtils;
import net.skds.lib.utils.UnsafeAnal;
import net.skds.nativelib.Kernel32;
import net.skds.ninvoker.MemoryStack;
import net.skds.ninvoker.NInvoker;
import sun.misc.Unsafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.skds.jvk.generated.VK10.*;

public class TestTriangle {

	private static final Unsafe unsafe = UnsafeAnal.UNSAFE;

	public static final boolean DEBUG = true;
	public static final List<String> LAYERS = List.of("VK_LAYER_KHRONOS_validation");
	public static final List<String> EXTENSIONS = List.of("VK_KHR_surface", "VK_KHR_win32_surface");
	public static final List<String> DEVICE_EXTENSIONS = List.of("VK_KHR_swapchain");

	final MemoryStack staticStack = new MemoryStack();

	private int layersCount;
	private final MemoryStack layersPtr = new MemoryStack();
	private int extensionsCount;
	private final MemoryStack extensionsPtr = new MemoryStack();
	private int deviceExtensionsCount;
	private final MemoryStack deviceExtensionsPtr = new MemoryStack();

	final JFrame frame;
	final long hWnd;
	final long hInstance;

	final long vertexShaderSize;
	final long pVertexShader;

	int surfaceFormat = VkFormat.VK_FORMAT_B8G8R8A8_UNORM;

	int width = 800;
	int height = 600;

	long instance;
	long hDevice;
	long device;
	int mainQueueFamilyIndex;
	long commandPool;
	long commandBuffer;
	long queue;
	long pipeline;
	long renderPass;
	long shaderModule;
	long pipelineLayout;
	long framebuffer;
	long surface;
	long swapchain;

	VkPhysicalDeviceLimits limits;

	final long lPtr0 = staticStack.push8();

	public TestTriangle() {
		this.frame = new JFrame() {
			@Override
			public void paintComponents(Graphics g) {
			}
		};
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				discard();
			}
		});
		frame.setVisible(true);
		this.hWnd = NInvoker.getHWnd(frame);
		this.hInstance = Kernel32.getModuleHandle(0);
		this.width = frame.getContentPane().getWidth();
		this.height = frame.getContentPane().getHeight();

		try {
			byte[] sd = Files.readAllBytes(Path.of("shader/vert.spv"));
			vertexShaderSize = sd.length;
			pVertexShader = staticStack.push(sd);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		if (DEBUG) {
			System.out.println("HWND: " + hWnd);
			System.out.println("HINSTANCE: " + hInstance);

			System.out.println("Vertex shader size: " + vertexShaderSize);

			listLayers();
			listExtensions();
		}


		allocExtensions();
		initInstance();
		initDevice();
		initCommandBuffer();
		initPipeline();
		initFramebuffer();

		prepare();

		presentTest();
	}

	private void initPipeline() {
		try (MemoryStack stack = new MemoryStack()) {
			VkSubpassDescription subpassDescription = new VkSubpassDescription();
			subpassDescription.inputAttachmentCount = 0;
			subpassDescription.colorAttachmentCount = 0;
			subpassDescription.preserveAttachmentCount = 0;
			subpassDescription.pDepthStencilAttachment = 0;
			subpassDescription.pipelineBindPoint = VkPipelineBindPoint.VK_PIPELINE_BIND_POINT_GRAPHICS;
			subpassDescription.alloc(stack);
			subpassDescription.put();

			VkRenderPassCreateInfo renderPassCI = new VkRenderPassCreateInfo();
			renderPassCI.attachmentCount = 0;
			renderPassCI.subpassCount = 1;
			renderPassCI.dependencyCount = 0;
			renderPassCI.pSubpasses = subpassDescription.address();
			renderPassCI.alloc(stack);
			renderPassCI.put();

			check(vkCreateRenderPass(device, renderPassCI.address(), 0, lPtr0));
			renderPass = unsafe.getLong(lPtr0);

			VkShaderModuleCreateInfo shaderModuleCi = new VkShaderModuleCreateInfo();
			shaderModuleCi.codeSize = vertexShaderSize;
			shaderModuleCi.pCode = pVertexShader;
			shaderModuleCi.alloc(stack);
			shaderModuleCi.put();

			check(vkCreateShaderModule(device, shaderModuleCi.address(), 0, lPtr0));
			shaderModule = unsafe.getLong(lPtr0);

			VkPipelineShaderStageCreateInfo shaderStageCi = new VkPipelineShaderStageCreateInfo();
			shaderStageCi.pName = stack.pushNT("main", StandardCharsets.UTF_8);
			shaderStageCi.flags = 0;
			shaderStageCi.pSpecializationInfo = 0;
			shaderStageCi.module = shaderModule;
			shaderStageCi.stage = VkShaderStageFlagBits.VK_SHADER_STAGE_VERTEX_BIT;
			shaderStageCi.alloc(stack);
			shaderStageCi.put();

			VkPipelineRasterizationStateCreateInfo rasterizationCi = new VkPipelineRasterizationStateCreateInfo();
			rasterizationCi.rasterizerDiscardEnable = 1;
			rasterizationCi.cullMode = VkCullModeFlagBits.VK_CULL_MODE_NONE;
			rasterizationCi.polygonMode = VkPolygonMode.VK_POLYGON_MODE_FILL;
			rasterizationCi.depthClampEnable = 0;
			rasterizationCi.frontFace = VkFrontFace.VK_FRONT_FACE_COUNTER_CLOCKWISE;
			rasterizationCi.depthBiasEnable = 0;
			rasterizationCi.lineWidth = 1;
			rasterizationCi.allocPut(stack);

			VkPipelineVertexInputStateCreateInfo vertexInputStateCi = new VkPipelineVertexInputStateCreateInfo();
			vertexInputStateCi.vertexBindingDescriptionCount = 0;
			vertexInputStateCi.vertexAttributeDescriptionCount = 0;
			vertexInputStateCi.allocPut(stack);

			VkPipelineInputAssemblyStateCreateInfo assemblyStateCi = new VkPipelineInputAssemblyStateCreateInfo();
			assemblyStateCi.topology = VkPrimitiveTopology.VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST;
			assemblyStateCi.primitiveRestartEnable = 0;
			assemblyStateCi.allocPut(stack);

			VkPipelineLayoutCreateInfo layoutCi = new VkPipelineLayoutCreateInfo();
			layoutCi.setLayoutCount = 0;
			layoutCi.pushConstantRangeCount = 0;
			layoutCi.allocPut(stack);

			check(vkCreatePipelineLayout(device, layoutCi.address(), 0, lPtr0));
			pipelineLayout = unsafe.getLong(lPtr0);

			VkGraphicsPipelineCreateInfo pipelineCI = new VkGraphicsPipelineCreateInfo();
			pipelineCI.stageCount = 1;
			pipelineCI.pStages = shaderStageCi.address();
			pipelineCI.renderPass = renderPass;
			pipelineCI.subpass = 0;
			pipelineCI.pRasterizationState = rasterizationCi.address();
			pipelineCI.pVertexInputState = vertexInputStateCi.address();
			pipelineCI.pInputAssemblyState = assemblyStateCi.address();
			pipelineCI.layout = pipelineLayout;
			pipelineCI.allocPut(stack);

			check(vkCreateGraphicsPipelines(device, 0, 1, pipelineCI.address(), 0, lPtr0));
			pipeline = unsafe.getLong(lPtr0);
			if (DEBUG) {
				System.out.println("pipeline: " + pipeline);
			}
		}
	}

	private void initFramebuffer() {
		try (MemoryStack stack = new MemoryStack()) {

			VkFramebufferCreateInfo framebufferCi = new VkFramebufferCreateInfo();
			framebufferCi.renderPass = renderPass;
			framebufferCi.attachmentCount = 0;
			framebufferCi.width = width;
			framebufferCi.height = height;
			framebufferCi.layers = 1;
			framebufferCi.allocPut(stack);

			check(vkCreateFramebuffer(device, framebufferCi.address(), 0, lPtr0));
			framebuffer = unsafe.getLong(lPtr0);

			VkWin32SurfaceCreateInfoKHR surfaceCi = new VkWin32SurfaceCreateInfoKHR();
			surfaceCi.sType = 1000009000;// VkKhrWin32Surface.VK_STRUCTURE_TYPE_WIN32_SURFACE_CREATE_INFO_KHR; // broken???
			surfaceCi.hinstance = hInstance;
			surfaceCi.hwnd = hWnd;
			surfaceCi.allocPut(stack);

			check(VkKhrWin32Surface.vkCreateWin32SurfaceKHR(instance, surfaceCi.address(), 0, lPtr0));
			surface = unsafe.getLong(lPtr0);

			check(VkKhrSurface.vkGetPhysicalDeviceSurfaceFormatsKHR(hDevice, surface, lPtr0, 0));
			int count = unsafe.getInt(lPtr0);
			VkSurfaceFormatKHR[] formats = VkSurfaceFormatKHR.WRAPPER.allocArray(count, stack);
			check(VkKhrSurface.vkGetPhysicalDeviceSurfaceFormatsKHR(hDevice, surface, lPtr0, formats[0].address()));
			boolean formatOk = false;
			for (int i = 0; i < count; i++) {
				VkSurfaceFormatKHR format = formats[i];
				format.get();
				if (format.format == surfaceFormat) {
					formatOk = true;
					break;
				}
				if (DEBUG) {
					System.out.println("Surface format: " + format.format);
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
			swapchainInfo.oldSwapchain = 0;
			swapchainInfo.allocPut(stack);

			check(VkKhrSwapchain.vkCreateSwapchainKHR(device, swapchainInfo.address(), 0, lPtr0));
			swapchain = unsafe.getLong(lPtr0);

			if (DEBUG) {
				System.out.println("framebuffer: " + framebuffer);
				System.out.println("surface: " + surface);
				System.out.println("swapchain: " + swapchain);
			}
			//VkKhrSwapchain.vk
		}
	}

	private void prepare() {
		try (MemoryStack stack = new MemoryStack()) {
			VkRenderPassBeginInfo beginInfo = new VkRenderPassBeginInfo();
			VkRect2D renderArea = new VkRect2D();
			renderArea.offset = new VkOffset2D();
			renderArea.extent = new VkExtent2D();
			renderArea.offset.x = 0;
			renderArea.offset.y = 0;
			renderArea.extent.width = width;
			renderArea.extent.height = height;
			beginInfo.renderArea = renderArea;
			beginInfo.renderPass = renderPass;
			beginInfo.framebuffer = framebuffer;
			beginInfo.clearValueCount = 1;
			beginInfo.pClearValues = stack.push(.5f, 0f, .5f, 0f);
			beginInfo.allocPut(stack);

			//vkCmdBeginRenderPass(commandBuffer, beginInfo.address(), VkSubpassContents.VK_SUBPASS_CONTENTS_INLINE);


		}
	}

	private void presentTest() {
		try (MemoryStack stack = new MemoryStack()) {
			VkPresentInfoKHR presentInfo = new VkPresentInfoKHR();
			presentInfo.sType = 1000001001;//VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;
			presentInfo.waitSemaphoreCount = 0;
			presentInfo.swapchainCount = 1;
			presentInfo.pSwapchains = stack.push(swapchain);
			presentInfo.pImageIndices = stack.push(0, 1);
			presentInfo.pResults = 0;
			presentInfo.allocPut(stack);

			check(VkKhrSwapchain.vkQueuePresentKHR(queue, presentInfo.address()));
		}
	}

	private void allocExtensions() {
		if (DEBUG) {
			layersCount = LAYERS.size();
			for (String layer : LAYERS) {
				layersPtr.pushNT(layer, StandardCharsets.UTF_8);
			}
			layersPtr.makePPtr();
		}
		extensionsCount = EXTENSIONS.size();
		for (String extension : EXTENSIONS) {
			extensionsPtr.pushNT(extension, StandardCharsets.UTF_8);
		}
		extensionsPtr.makePPtr();
		deviceExtensionsCount = DEVICE_EXTENSIONS.size();
		for (String extension : DEVICE_EXTENSIONS) {
			deviceExtensionsPtr.pushNT(extension, StandardCharsets.UTF_8);
		}
		deviceExtensionsPtr.makePPtr();
	}

	private void initInstance() {

		try (MemoryStack stack = new MemoryStack()) {

			VkApplicationInfo appInfo = new VkApplicationInfo();
			appInfo.applicationVersion = VKDefinitions.vkMakeApiVersion(0, 1, 0, 0);
			appInfo.engineVersion = VKDefinitions.vkMakeApiVersion(0, 1, 0, 0);
			appInfo.pApplicationName = NInvoker.nullTerminatedString("test", StandardCharsets.UTF_8, stack);
			appInfo.pEngineName = NInvoker.nullTerminatedString("test_engine", StandardCharsets.UTF_8, stack);
			appInfo.applicationVersion = VKDefinitions.VK_API_VERSION_1_0;

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

			check(vkCreateInstance(icInfo.address(), 0, lPtr0));
			instance = unsafe.getAddress(lPtr0);

			if (DEBUG) {
				System.out.println("instance: " + instance);
			}
		}
	}

	private void initDevice() {
		try (MemoryStack stack = new MemoryStack()) {

			check(vkEnumeratePhysicalDevices(instance, lPtr0, 0));
			int count = unsafe.getInt(lPtr0);
			long pDevArr = stack.pushLongs(count);
			check(vkEnumeratePhysicalDevices(instance, lPtr0, pDevArr));

			VkPhysicalDeviceProperties properties = new VkPhysicalDeviceProperties();
			properties.alloc(stack);

			//VkPhysicalDeviceProperties
			for (int i = 0; i < count; i++) {
				long d = unsafe.getLong(pDevArr + i * 8L);
				hDevice = d;
				vkGetPhysicalDeviceProperties(d, properties.address());
				properties.get();
				limits = properties.limits;
				if (DEBUG) {
					System.out.println("=============== Device =============");
					System.out.println("deviceID: " + properties.deviceID);
					System.out.println("deviceType: " + properties.deviceType);
					System.out.println("apiVersion: " + VKDefinitions.getVersion(properties.apiVersion)
					);
					System.out.println("driverVersion: " + Integer.toUnsignedString(properties.driverVersion, 16));
					System.out.println("vendorID: " + properties.vendorID);
					System.out.println("pipelineCacheUUID: " + SKDSUtils.HEX_FORMAT_LC.formatHex(properties.pipelineCacheUUID));
					System.out.println("deviceName: " + NInvoker.nullTerminatedString(properties.deviceName, StandardCharsets.UTF_8));
					listDeviceExtensions(d);
					System.out.println("====================================");
				} else {
					break;
				}
			}

			vkGetPhysicalDeviceQueueFamilyProperties(hDevice, lPtr0, 0);
			count = unsafe.getInt(lPtr0);
			VkQueueFamilyProperties[] familyProperties = VkQueueFamilyProperties.WRAPPER.allocArray(count, stack);
			vkGetPhysicalDeviceQueueFamilyProperties(hDevice, lPtr0, familyProperties[0].address());

			int desiredBits = VkQueueFlagBits.VK_QUEUE_GRAPHICS_BIT |
					VkQueueFlagBits.VK_QUEUE_COMPUTE_BIT |
					VkQueueFlagBits.VK_QUEUE_TRANSFER_BIT |
					VkQueueFlagBits.VK_QUEUE_SPARSE_BINDING_BIT;

			for (int i = 0; i < count; i++) {
				VkQueueFamilyProperties fp = familyProperties[i];
				fp.get();

				if (DEBUG) {
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

			long pPrio = stack.push4();
			unsafe.putFloat(pPrio, 1f);
			VkDeviceQueueCreateInfo dqci = new VkDeviceQueueCreateInfo();
			dqci.queueFamilyIndex = mainQueueFamilyIndex;
			dqci.queueCount = 1;
			dqci.pQueuePriorities = pPrio;

			dqci.alloc(stack);
			dqci.put();

			VkDeviceCreateInfo dci = new VkDeviceCreateInfo();
			if (DEBUG) {
				dci.enabledLayerCount = layersCount;
				dci.ppEnabledLayerNames = layersPtr.getPPtr();
			}
			dci.enabledExtensionCount = deviceExtensionsCount;
			dci.ppEnabledExtensionNames = deviceExtensionsPtr.getPPtr();
			dci.queueCreateInfoCount = 1;
			dci.pQueueCreateInfos = dqci.address();

			dci.alloc(stack);
			dci.put();

			check(vkCreateDevice(hDevice, dci.address(), 0, lPtr0));
			device = unsafe.getLong(lPtr0);

			vkGetDeviceQueue(device, mainQueueFamilyIndex, 0, lPtr0);
			queue = unsafe.getLong(lPtr0);

			if (DEBUG) {
				System.out.println("device: " + device);
				System.out.println("queue: " + queue);
			}
		}
	}

	private void initCommandBuffer() {
		try (MemoryStack stack = new MemoryStack()) {
			VkCommandPoolCreateInfo commandPoolInfo = new VkCommandPoolCreateInfo();
			commandPoolInfo.queueFamilyIndex = mainQueueFamilyIndex;
			commandPoolInfo.flags = VkCommandPoolCreateFlagBits.VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT;
			commandPoolInfo.alloc(stack);
			commandPoolInfo.put();
			check(vkCreateCommandPool(device, commandPoolInfo.address(), 0, lPtr0));
			commandPool = unsafe.getLong(lPtr0);

			VkCommandBufferAllocateInfo cbaInfo = new VkCommandBufferAllocateInfo();
			cbaInfo.level = VkCommandBufferLevel.VK_COMMAND_BUFFER_LEVEL_PRIMARY;
			cbaInfo.commandBufferCount = 1;
			cbaInfo.commandPool = commandPool;
			cbaInfo.alloc(stack);
			cbaInfo.put();

			check(vkAllocateCommandBuffers(device, cbaInfo.address(), lPtr0));
			commandBuffer = unsafe.getLong(lPtr0);
			if (DEBUG) {
				System.out.println("commandPool: " + commandPool);
				System.out.println("commandBuffer: " + commandBuffer);
			}

			/*

			VkFenceCreateInfo fci = new VkFenceCreateInfo();
			fci.alloc(stack);
			fci.put();
			long pFence = stack.push8();
			vkCreateFence(device, fci.address(), 0, pFence);
			long fence = UNSAFE.getLong(pFence);
			if (DEBUG) {
				System.out.println("fence: " + fence);
			}
			VkSemaphoreCreateInfo semaphoreCI = new VkSemaphoreCreateInfo();
			semaphoreCI.alloc(stack);
			semaphoreCI.put();
			long pSemaphore = stack.push8();
			vkCreateSemaphore(device, semaphoreCI.address(), 0, pSemaphore);
			long semaphore = UNSAFE.getLong(pSemaphore);
			if (DEBUG) {
				System.out.println("semaphore: " + semaphore);
			}

			vkGetDeviceQueue();

			 */
		}
	}
	//private void initQueue() {
	//	try (MemoryStack stack = new MemoryStack()) {
	//
	//	}
	//}

	private void listLayers() {

		try (MemoryStack stack = new MemoryStack()) {
			check(vkEnumerateInstanceLayerProperties(lPtr0, 0));
			int size = unsafe.getInt(lPtr0);

			VkLayerProperties[] properties = VkLayerProperties.WRAPPER.allocArray(size, stack);

			check(vkEnumerateInstanceLayerProperties(lPtr0, properties[0].address()));
			//properties[0].get();

			for (VkLayerProperties p : properties) {
				p.get();
				System.out.println("======= LayerProperties ==========");
				System.out.println(NInvoker.nullTerminatedString(p.layerName, StandardCharsets.UTF_8));
				System.out.println(NInvoker.nullTerminatedString(p.description, StandardCharsets.UTF_8));
				System.out.println("specVersion: " + p.specVersion);
				System.out.println("specVersion: " + p.implementationVersion);
				System.out.println("=================================");
			}
		}
	}

	private void listExtensions() {

		try (MemoryStack stack = new MemoryStack()) {
			check(vkEnumerateInstanceExtensionProperties(0, lPtr0, 0));
			int size = unsafe.getInt(lPtr0);
			VkExtensionProperties[] properties = VkExtensionProperties.WRAPPER.allocArray(size, stack);
			check(vkEnumerateInstanceExtensionProperties(0, lPtr0, properties[0].address()));
			//properties[0].get();

			for (VkExtensionProperties p : properties) {
				p.get();
				System.out.println("======= ExtensionProperties ==========");
				System.out.println(NInvoker.nullTerminatedString(p.extensionName, StandardCharsets.UTF_8));
				System.out.println("specVersion: " + p.specVersion);
				System.out.println("====================================");
			}
		}
	}

	private void listDeviceExtensions(long d) {

		try (MemoryStack stack = new MemoryStack()) {
			check(vkEnumerateDeviceExtensionProperties(d, 0, lPtr0, 0));
			int size = unsafe.getInt(lPtr0);
			VkExtensionProperties[] properties = VkExtensionProperties.WRAPPER.allocArray(size, stack);
			check(vkEnumerateDeviceExtensionProperties(d, 0, lPtr0, properties[0].address()));
			//properties[0].get();

			for (VkExtensionProperties p : properties) {
				p.get();
				System.out.println("======= DeviceExtensionProperties ==========");
				System.out.println(NInvoker.nullTerminatedString(p.extensionName, StandardCharsets.UTF_8));
				System.out.println("specVersion: " + p.specVersion);
			}
		}
	}

	private void discard() {
		vkDestroyRenderPass(device, renderPass, 0);
		vkDestroyCommandPool(device, commandPool, 0);
		vkDestroyPipeline(device, pipeline, 0);
		vkDestroyPipelineLayout(device, pipelineLayout, 0);
		vkDestroyShaderModule(device, shaderModule, 0);
		vkDestroyFramebuffer(device, framebuffer, 0);
		VkKhrSwapchain.vkDestroySwapchainKHR(device, swapchain, 0);
		VkKhrSurface.vkDestroySurfaceKHR(instance, surface, 0);
		vkDestroyDevice(device, 0);
		vkDestroyInstance(instance, 0);
		if (DEBUG) {
			System.out.println("VK Discarded");
		}
	}

	private static void check(int result) {
		if (result != 0) {
			throw new RuntimeException("VK err " + result + ": " + VKDefinitions.getErr(result));
		}
	}
}
