package net.skds.sas3d.vulkan;

import net.skds.jvk.VKDefinitions;
import net.skds.jvk.VkResult;
import net.skds.jvk.generated.enums.*;
import net.skds.jvk.generated.extensions.VkKhrSurface;
import net.skds.jvk.generated.extensions.VkKhrSwapchain;
import net.skds.jvk.generated.extensions.VkKhrWin32Surface;
import net.skds.jvk.generated.structs.*;
import net.skds.lib2.utils.SKDSUtils;

import javax.swing.*;
import java.awt.*;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static net.skds.jvk.generated.VK10.*;
import static net.skds.jvk.generated.enums.VkAccessFlagBits.VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT;
import static net.skds.jvk.generated.enums.VkAccessFlagBits.VK_ACCESS_MEMORY_READ_BIT;
import static net.skds.jvk.generated.enums.VkAttachmentLoadOp.VK_ATTACHMENT_LOAD_OP_CLEAR;
import static net.skds.jvk.generated.enums.VkAttachmentLoadOp.VK_ATTACHMENT_LOAD_OP_DONT_CARE;
import static net.skds.jvk.generated.enums.VkAttachmentStoreOp.VK_ATTACHMENT_STORE_OP_DONT_CARE;
import static net.skds.jvk.generated.enums.VkAttachmentStoreOp.VK_ATTACHMENT_STORE_OP_STORE;
import static net.skds.jvk.generated.enums.VkImageLayout.*;
import static net.skds.jvk.generated.enums.VkPipelineStageFlagBits.*;
import static net.skds.jvk.generated.enums.VkSampleCountFlagBits.VK_SAMPLE_COUNT_1_BIT;
import static net.skds.lib2.natives.SafeAnal.*;

public class VKCore {

	public static final List<String> LAYERS = List.of("VK_LAYER_KHRONOS_validation");
	public static final List<String> EXTENSIONS = List.of("VK_KHR_surface", "VK_KHR_win32_surface");
	public static final List<String> DEVICE_EXTENSIONS = List.of("VK_KHR_swapchain");

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

	final JFrame frame;

	long vertexShaderSize;
	long pVertexShader;
	long fragmentShaderSize;
	long pFragmentShader;

	final long pAllocator = 0;

	int surfaceFormat = VkFormat.VK_FORMAT_R8G8B8A8_UNORM;

	int width;
	int height;

	long instance;
	long hDevice;
	long device;
	int mainQueueFamilyIndex;
	long commandPool;

	long commandBuffer;
	long queue;

	long pipeline;
	long renderPass;

	long vShaderModule;
	long fShaderModule;

	long pipelineLayout;

	long framebuffer;
	long surface;
	long swapchain;

	FramebufferImage[] framebufferImages;
	VkPhysicalDeviceMemoryProperties memoryProperties;
	int deviceFastMemoryType;
	int hostFastMemoryType;

	VkPhysicalDeviceLimits limits;

	final long[] pointers = allocPointers(arena, 4);
	final long lPtr0 = pointers[0];

	public VKCore(boolean debug, JFrame frame, String appName, String engineName) {
		this.debug = debug;
		this.frame = frame;
		this.appName = appName;
		this.engineName = engineName;
		if (debug) {
			this.layersCount = LAYERS.size();
			this.layersPPtr = loadCStrings(LAYERS);
		} else {
			this.layersCount = 0;
			this.layersPPtr = 0;
		}
		this.extensionsCount = EXTENSIONS.size();
		this.extensionsPPtr = loadCStrings(EXTENSIONS);

		this.deviceExtensionsCount = DEVICE_EXTENSIONS.size();
		this.deviceExtensionsPPtr = loadCStrings(DEVICE_EXTENSIONS);

		if (debug) {
			listLayers();
		}
	}

	private long loadCStrings(List<String> strings) {
		int count = strings.size();
		long[] ptrs = new long[count];
		for (int i = 0; i < count; i++) {
			ptrs[i] = arena.allocateFrom(strings.get(i)).address();
		}
		return arena.allocateFrom(ValueLayout.JAVA_LONG, ptrs).address();
	}

	public void initWindow() {
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

	private void initPipeline() {
		Arena arena = Arena.ofAuto();

		VkAttachmentReference attachmentReference = new VkAttachmentReference();
		attachmentReference.attachment = 0;
		attachmentReference.layout = VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL;
		attachmentReference.allocPut(arena);

		VkSubpassDescription subpassDescription = new VkSubpassDescription();
		subpassDescription.inputAttachmentCount = 0;
		subpassDescription.colorAttachmentCount = 1;
		subpassDescription.pColorAttachments = attachmentReference.getAddress();
		subpassDescription.preserveAttachmentCount = 0;
		subpassDescription.pDepthStencilAttachment = 0;
		subpassDescription.pipelineBindPoint = VkPipelineBindPoint.VK_PIPELINE_BIND_POINT_GRAPHICS;
		subpassDescription.allocPut(arena);

		VkAttachmentDescription attachmentDescription = new VkAttachmentDescription();
		attachmentDescription.format = surfaceFormat;
		attachmentDescription.samples = VK_SAMPLE_COUNT_1_BIT;
		attachmentDescription.loadOp = VK_ATTACHMENT_LOAD_OP_CLEAR;
		attachmentDescription.storeOp = VK_ATTACHMENT_STORE_OP_STORE;
		attachmentDescription.stencilLoadOp = VK_ATTACHMENT_LOAD_OP_DONT_CARE;
		attachmentDescription.stencilStoreOp = VK_ATTACHMENT_STORE_OP_DONT_CARE;
		attachmentDescription.initialLayout = VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL;
		attachmentDescription.finalLayout = VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL;
		attachmentDescription.allocPut(arena);

		VkRenderPassCreateInfo renderPassCI = new VkRenderPassCreateInfo();
		renderPassCI.attachmentCount = 1;
		renderPassCI.pAttachments = attachmentDescription.getAddress();
		renderPassCI.subpassCount = 1;
		renderPassCI.pSubpasses = subpassDescription.getAddress();
		renderPassCI.dependencyCount = 0;
		renderPassCI.allocPut(arena);

		vkCheck(vkCreateRenderPass(device, renderPassCI.getAddress(), 0, lPtr0));
		renderPass = getLong(lPtr0);

		VkShaderModuleCreateInfo shaderModuleCi = new VkShaderModuleCreateInfo();
		shaderModuleCi.codeSize = vertexShaderSize;
		shaderModuleCi.pCode = pVertexShader;
		shaderModuleCi.allocPut();
		shaderModuleCi.codeSize = fragmentShaderSize;
		shaderModuleCi.pCode = pFragmentShader;
		shaderModuleCi.allocPut();

		vkCheck(vkCreateShaderModule(device, shaderModuleCi.getAddress(), 0, lPtr0));
		vShaderModule = getLong(lPtr0);
		vkCheck(vkCreateShaderModule(device, shaderModuleCi.getAddress(), 0, lPtr0));
		fShaderModule = getLong(lPtr0);

		VkPipelineShaderStageCreateInfo[] shaderStageCi = VkPipelineShaderStageCreateInfo.WRAPPER.allocArray(2);
		shaderStageCi[0].pName = arena.allocateFrom("main").address();
		shaderStageCi[0].flags = 0;
		shaderStageCi[0].pSpecializationInfo = 0;
		shaderStageCi[0].module = vShaderModule;
		shaderStageCi[0].stage = VkShaderStageFlagBits.VK_SHADER_STAGE_VERTEX_BIT;
		shaderStageCi[0].put();

		shaderStageCi[1].pName = shaderStageCi[0].pName;
		shaderStageCi[1].flags = shaderStageCi[0].flags;
		shaderStageCi[1].pSpecializationInfo = shaderStageCi[0].pSpecializationInfo;
		shaderStageCi[1].module = fShaderModule;
		shaderStageCi[1].stage = VkShaderStageFlagBits.VK_SHADER_STAGE_FRAGMENT_BIT;
		shaderStageCi[1].put();

		VkPipelineRasterizationStateCreateInfo rasterizationCi = new VkPipelineRasterizationStateCreateInfo();
		rasterizationCi.rasterizerDiscardEnable = 0;
		rasterizationCi.cullMode = VkCullModeFlagBits.VK_CULL_MODE_NONE;
		rasterizationCi.polygonMode = VkPolygonMode.VK_POLYGON_MODE_FILL;
		rasterizationCi.depthClampEnable = 0;
		rasterizationCi.frontFace = VkFrontFace.VK_FRONT_FACE_COUNTER_CLOCKWISE;
		rasterizationCi.depthBiasEnable = 0;
		rasterizationCi.lineWidth = 1;
		rasterizationCi.allocPut(arena);

		VkPipelineVertexInputStateCreateInfo vertexInputStateCi = new VkPipelineVertexInputStateCreateInfo();
		vertexInputStateCi.vertexBindingDescriptionCount = 0;
		vertexInputStateCi.vertexAttributeDescriptionCount = 0;
		vertexInputStateCi.allocPut(arena);

		VkPipelineInputAssemblyStateCreateInfo assemblyStateCi = new VkPipelineInputAssemblyStateCreateInfo();
		assemblyStateCi.topology = VkPrimitiveTopology.VK_PRIMITIVE_TOPOLOGY_TRIANGLE_LIST;
		assemblyStateCi.primitiveRestartEnable = 0;
		assemblyStateCi.allocPut(arena);

		VkPipelineColorBlendAttachmentState blendState = new VkPipelineColorBlendAttachmentState();
		blendState.blendEnable = 0; // 1
		blendState.colorWriteMask = VkColorComponentFlagBits.VK_COLOR_COMPONENT_R_BIT |
				VkColorComponentFlagBits.VK_COLOR_COMPONENT_G_BIT |
				VkColorComponentFlagBits.VK_COLOR_COMPONENT_B_BIT |
				VkColorComponentFlagBits.VK_COLOR_COMPONENT_A_BIT;
		blendState.allocPut(arena);

		VkPipelineColorBlendStateCreateInfo blendInfo = new VkPipelineColorBlendStateCreateInfo();
		blendInfo.logicOpEnable = 0;
		blendInfo.attachmentCount = 1;
		blendInfo.pAttachments = blendState.address();
		blendInfo.allocPut(arena);

		VkPipelineLayoutCreateInfo layoutCi = new VkPipelineLayoutCreateInfo();
		layoutCi.setLayoutCount = 0;
		layoutCi.pushConstantRangeCount = 0;
		layoutCi.allocPut(arena);

		vkCheck(vkCreatePipelineLayout(device, layoutCi.address(), 0, lPtr0));
		pipelineLayout = getLong(lPtr0);

		VkPipelineDynamicStateCreateInfo dynamicStateInfo = new VkPipelineDynamicStateCreateInfo();
		dynamicStateInfo.dynamicStateCount = 2;
		dynamicStateInfo.pDynamicStates = arena.push(VkDynamicState.VK_DYNAMIC_STATE_SCISSOR, VkDynamicState.VK_DYNAMIC_STATE_VIEWPORT);
		dynamicStateInfo.allocPut(arena);

		//VkPipelineDepthStencilStateCreateInfo depthStencilInfo = new VkPipelineDepthStencilStateCreateInfo();
		//depthStencilInfo.depthTestEnable = 0;
		//depthStencilInfo.depthWriteEnable = 0;
		//depthStencilInfo.depthBoundsTestEnable = 0;
		//depthStencilInfo.stencilTestEnable = 0;
		//depthStencilInfo.allocPut(arena);


		VkViewport viewport = new VkViewport();
		viewport.height = height;
		viewport.width = width;
		viewport.minDepth = 0.0f;
		viewport.maxDepth = 1.0f;
		viewport.allocPut(arena);
		VkExtent2D extent = new VkExtent2D();
		extent.width = width;
		extent.height = height;
		VkOffset2D offset = new VkOffset2D();
		offset.x = 0;
		offset.y = 0;
		VkRect2D scissor = new VkRect2D();
		scissor.extent = extent;
		scissor.offset = offset;
		scissor.allocPut(arena);

		VkPipelineViewportStateCreateInfo viewportInfo = new VkPipelineViewportStateCreateInfo();
		viewportInfo.scissorCount = 1;
		viewportInfo.pScissors = scissor.address();
		viewportInfo.viewportCount = 1;
		viewportInfo.pViewports = viewport.address();
		viewportInfo.allocPut(arena);

		VkPipelineMultisampleStateCreateInfo multisampleInfo = new VkPipelineMultisampleStateCreateInfo();
		multisampleInfo.pSampleMask = 0;
		multisampleInfo.rasterizationSamples = VK_SAMPLE_COUNT_1_BIT;
		multisampleInfo.allocPut(arena);

		VkGraphicsPipelineCreateInfo pipelineCI = new VkGraphicsPipelineCreateInfo();
		pipelineCI.stageCount = 2;
		pipelineCI.pStages = shaderStageCi[0].address();
		pipelineCI.renderPass = renderPass;
		pipelineCI.subpass = 0;
		pipelineCI.pRasterizationState = rasterizationCi.address();
		pipelineCI.pVertexInputState = vertexInputStateCi.address();
		pipelineCI.pInputAssemblyState = assemblyStateCi.address();
		pipelineCI.pColorBlendState = blendInfo.address();
		pipelineCI.pDynamicState = dynamicStateInfo.address();
		//pipelineCI.pDepthStencilState = depthStencilInfo.address();
		pipelineCI.pViewportState = viewportInfo.address();
		pipelineCI.pMultisampleState = multisampleInfo.address();
		pipelineCI.layout = pipelineLayout;
		pipelineCI.basePipelineHandle = 0;
		pipelineCI.basePipelineIndex = -1;
		pipelineCI.allocPut(arena);

		vkCheck(vkCreateGraphicsPipelines(device, 0, 1, pipelineCI.address(), 0, lPtr0));
		pipeline = getLong(lPtr0);
		if (debug) {
			System.out.println("pipeline: " + pipeline);
		}

	}

	record FramebufferImage(long img, long view, long mem) {

	}

	@SuppressWarnings("SameParameterValue")
	private FramebufferImage[] createFramebufferImages(MemoryStack stack, int count) {

		////long imgPtr = stack.pushLongs(count);
		////check(VkKhrSwapchain.vkGetSwapchainImagesKHR(device, swapchain, stack.push(count), imgPtr));
		//VkImageCreateInfo imageInfo = new VkImageCreateInfo();
		//imageInfo.imageType = VkImageType.VK_IMAGE_TYPE_2D;
		//imageInfo.format = surfaceFormat;
		//imageInfo.sharingMode = VkSharingMode.VK_SHARING_MODE_EXCLUSIVE;
		//imageInfo.arrayLayers = 1;
		//imageInfo.mipLevels = 1;
		//imageInfo.samples = VkSampleCountFlagBits.VK_SAMPLE_COUNT_1_BIT;
		//imageInfo.tiling = VkImageTiling.VK_IMAGE_TILING_OPTIMAL;
		//imageInfo.usage = VkImageUsageFlagBits.VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT;
		//imageInfo.queueFamilyIndexCount = 0;
		//imageInfo.initialLayout = VkImageLayout.VK_IMAGE_LAYOUT_UNDEFINED;
		//imageInfo.extent = new VkExtent3D();
		//imageInfo.extent.depth = 1;
		//imageInfo.extent.width = width;
		//imageInfo.extent.height = height;
		//imageInfo.allocPut(stack);

		//VkMemoryRequirements requirements = new VkMemoryRequirements();
		//requirements.alloc(stack);

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
		FramebufferImage[] images = new FramebufferImage[count];
		long ptr = stack.pushLongs(count);
		vkCheck(VkKhrSwapchain.vkGetSwapchainImagesKHR(device, swapchain, stack.push(count), ptr));

		for (int i = 0; i < count; i++) {
			//check(vkCreateImage(device, imageInfo.address(), pAllocator, lPtr0));
			//long image = getLong(lPtr0);
			long image = getLong(ptr, i);

			//vkGetImageMemoryRequirements(device, image, requirements.address());
			//requirements.get();

			//VkMemoryAllocateInfo memoryAllocateInfo = new VkMemoryAllocateInfo();
			//memoryAllocateInfo.allocationSize = requirements.size;
			//memoryAllocateInfo.memoryTypeIndex = deviceFastMemoryType;
			//memoryAllocateInfo.allocPut(stack);

			//check(vkAllocateMemory(device, memoryAllocateInfo.address(), pAllocator, lPtr0));
			//long mem = getLong(lPtr0);
			//check(vkBindImageMemory(device, image, mem, 0));

			viewInfo.image = image;
			viewInfo.put();

			vkCheck(vkCreateImageView(device, viewInfo.address(), pAllocator, lPtr0));
			long view = getLong(lPtr0);

			images[i] = new FramebufferImage(image, view, 0);
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

			vkCheck(VkKhrWin32Surface.vkCreateWin32SurfaceKHR(instance, surfaceCi.address(), 0, lPtr0));
			surface = getLong(lPtr0);

			vkCheck(VkKhrSurface.vkGetPhysicalDeviceSurfaceFormatsKHR(hDevice, surface, lPtr0, 0));
			int count = getInt(lPtr0);
			VkSurfaceFormatKHR[] formats = VkSurfaceFormatKHR.WRAPPER.allocArray(count, stack);
			vkCheck(VkKhrSurface.vkGetPhysicalDeviceSurfaceFormatsKHR(hDevice, surface, lPtr0, formats[0].address()));
			boolean formatOk = false;
			for (int i = 0; i < count; i++) {
				VkSurfaceFormatKHR format = formats[i];
				format.get();
				if (format.format == surfaceFormat) {
					formatOk = true;
					break;
				}
				if (debug) {
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
			swapchainInfo.presentMode = VkPresentModeKHR.VK_PRESENT_MODE_FIFO_KHR;
			swapchainInfo.clipped = 0;
			swapchainInfo.oldSwapchain = 0;
			swapchainInfo.allocPut(stack);

			vkCheck(VkKhrSwapchain.vkCreateSwapchainKHR(device, swapchainInfo.address(), 0, lPtr0));
			swapchain = getLong(lPtr0);

			framebufferImages = createFramebufferImages(stack, 1);

			VkFramebufferCreateInfo framebufferCi = new VkFramebufferCreateInfo();
			framebufferCi.renderPass = renderPass;
			framebufferCi.attachmentCount = framebufferImages.length;
			framebufferCi.pAttachments = stack.push(framebufferImages[0].view);
			framebufferCi.width = width;
			framebufferCi.height = height;
			framebufferCi.layers = 1;
			framebufferCi.allocPut(stack);
			vkCheck(vkCreateFramebuffer(device, framebufferCi.address(), pAllocator, lPtr0));
			framebuffer = getLong(lPtr0);

			if (debug) {
				System.out.println("framebuffer: " + framebuffer);
				System.out.println("surface: " + surface);
				System.out.println("swapchain: " + swapchain);
			}
			//VkKhrSwapchain.vk
		}
	}

	private void prepare() {
		try (MemoryStack stack = new MemoryStack()) {


			//vkCmdBeginRenderPass(commandBuffer, beginInfo.address(), VkSubpassContents.VK_SUBPASS_CONTENTS_INLINE);


		}
	}

	private void presentTest() {
		try (MemoryStack stack = new MemoryStack()) {


			VkSemaphoreCreateInfo semaphoreInfo = new VkSemaphoreCreateInfo();
			semaphoreInfo.allocPut(stack);
			long pSemaphore = stack.pushLongs(1);
			vkCheck(vkCreateSemaphore(device, semaphoreInfo.address(), pAllocator, pSemaphore));
			long pSemaphore2 = stack.pushLongs(1);
			vkCheck(vkCreateSemaphore(device, semaphoreInfo.address(), pAllocator, pSemaphore2));

			long pIndex = stack.push4();
			vkCheck(VkKhrSwapchain.vkAcquireNextImageKHR(device, swapchain, 0, getLong(pSemaphore), 0, pIndex));
			int index = getInt(pIndex);


			vkCheck(vkResetCommandBuffer(commandBuffer, 0));

			VkCommandBufferBeginInfo beginInfo = new VkCommandBufferBeginInfo();
			//beginInfo.flags = VkCommandBufferUsageFlagBits.VK_COMMAND_BUFFER_USAGE_ONE_TIME_SUBMIT_BIT;
			beginInfo.allocPut(stack);
			vkCheck(vkBeginCommandBuffer(commandBuffer, beginInfo.address()));

			VkExtent2D extent = new VkExtent2D();
			extent.width = width;
			extent.height = height;
			VkOffset2D offset = new VkOffset2D();
			offset.x = 0;
			offset.y = 0;
			VkRenderPassBeginInfo renderPassInfo = new VkRenderPassBeginInfo();
			renderPassInfo.renderPass = renderPass;
			renderPassInfo.framebuffer = framebuffer;
			renderPassInfo.renderArea = new VkRect2D();
			renderPassInfo.renderArea.extent = extent;
			renderPassInfo.renderArea.offset = offset;
			renderPassInfo.clearValueCount = 1;
			renderPassInfo.pClearValues = stack.push(.5f, 0f, .5f, 0f);
			renderPassInfo.allocPut(stack);

			// SHITTY ==============
			//
			VkImageSubresourceRange subresourceRange = new VkImageSubresourceRange();
			subresourceRange.aspectMask = VkImageAspectFlagBits.VK_IMAGE_ASPECT_COLOR_BIT;
			subresourceRange.baseMipLevel = 0;
			subresourceRange.levelCount = 1;
			subresourceRange.baseArrayLayer = 0;
			subresourceRange.layerCount = 1;
			VkImageMemoryBarrier imageMemoryBarrier = new VkImageMemoryBarrier();
			imageMemoryBarrier.srcAccessMask = 0;
			imageMemoryBarrier.dstAccessMask = VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT;
			imageMemoryBarrier.oldLayout = VK_IMAGE_LAYOUT_UNDEFINED;
			imageMemoryBarrier.newLayout = VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL;
			imageMemoryBarrier.srcQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED;
			imageMemoryBarrier.dstQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED;
			imageMemoryBarrier.image = framebufferImages[index].img;
			imageMemoryBarrier.subresourceRange = subresourceRange;
			imageMemoryBarrier.allocPut(stack);
			vkCmdPipelineBarrier(commandBuffer,
					VK_PIPELINE_STAGE_ALL_COMMANDS_BIT,
					VK_PIPELINE_STAGE_COLOR_ATTACHMENT_OUTPUT_BIT,
					0,
					0, 0,
					0, 0,
					1, imageMemoryBarrier.address());
			//
			// SHITTY ==============

			vkCmdBeginRenderPass(commandBuffer, renderPassInfo.address(), VkSubpassContents.VK_SUBPASS_CONTENTS_INLINE);
			//vkCmdNextSubpass(commandBuffer, VkSubpassContents.VK_SUBPASS_CONTENTS_INLINE);
			vkCmdBindPipeline(commandBuffer, VkPipelineBindPoint.VK_PIPELINE_BIND_POINT_GRAPHICS, pipeline);

			VkViewport viewport = new VkViewport();
			viewport.height = height;
			viewport.width = width;
			viewport.minDepth = 0.0f;
			viewport.maxDepth = 1.0f;
			viewport.allocPut(stack);

			VkRect2D scissor = new VkRect2D();
			scissor.extent = extent;
			scissor.offset = offset;
			scissor.allocPut(stack);

			vkCmdSetViewport(commandBuffer, 0, 1, viewport.address());
			vkCmdSetScissor(commandBuffer, 0, 1, scissor.address());

			vkCmdDraw(commandBuffer, 3, 1, 0, 0);

			vkCmdEndRenderPass(commandBuffer);

			// SHITTY ==============
			//
			VkImageMemoryBarrier prePresentBarrier = new VkImageMemoryBarrier();
			prePresentBarrier.srcAccessMask = VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT;
			prePresentBarrier.dstAccessMask = VK_ACCESS_MEMORY_READ_BIT;
			prePresentBarrier.oldLayout = VK_IMAGE_LAYOUT_COLOR_ATTACHMENT_OPTIMAL;
			prePresentBarrier.newLayout = VK_IMAGE_LAYOUT_PRESENT_SRC_KHR;
			prePresentBarrier.srcQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED;
			prePresentBarrier.dstQueueFamilyIndex = VK_QUEUE_FAMILY_IGNORED;
			prePresentBarrier.image = framebufferImages[index].img;
			prePresentBarrier.subresourceRange = subresourceRange;
			prePresentBarrier.allocPut(stack);
			vkCmdPipelineBarrier(commandBuffer,
					VK_PIPELINE_STAGE_ALL_COMMANDS_BIT,
					VK_PIPELINE_STAGE_BOTTOM_OF_PIPE_BIT,
					0,
					0, 0,
					0, 0,
					1, prePresentBarrier.address());
			//
			// SHITTY ==============

			vkCheck(vkEndCommandBuffer(commandBuffer));


			VkSubmitInfo submitInfo = new VkSubmitInfo();
			submitInfo.waitSemaphoreCount = 1;
			submitInfo.pWaitSemaphores = pSemaphore;
			submitInfo.signalSemaphoreCount = 1;
			submitInfo.pSignalSemaphores = pSemaphore2;
			submitInfo.commandBufferCount = 1;
			submitInfo.pCommandBuffers = stack.push(commandBuffer);
			submitInfo.pWaitDstStageMask = stack.push(VK_PIPELINE_STAGE_BOTTOM_OF_PIPE_BIT);
			submitInfo.allocPut(stack);

			vkCheck(vkQueueSubmit(queue, 1, submitInfo.address(), 0));


			VkPresentInfoKHR presentInfo = new VkPresentInfoKHR();
			presentInfo.sType = 1000001001;//VK_STRUCTURE_TYPE_PRESENT_INFO_KHR;
			submitInfo.waitSemaphoreCount = 1;
			submitInfo.pWaitSemaphores = pSemaphore2;
			submitInfo.signalSemaphoreCount = 0;
			presentInfo.swapchainCount = 1;
			presentInfo.pSwapchains = stack.push(swapchain);
			presentInfo.pImageIndices = pIndex;
			presentInfo.pResults = 0;
			presentInfo.allocPut(stack);


			vkCheck(VkKhrSwapchain.vkQueuePresentKHR(queue, presentInfo.address()));

			vkCheck(vkQueueWaitIdle(queue));
		}
	}

	private void allocExtensions() {
		if (debug) {
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
			appInfo.pApplicationName = NInvoker.nullTerminatedString(appName, StandardCharsets.UTF_8, stack);
			appInfo.pEngineName = NInvoker.nullTerminatedString(engineName, StandardCharsets.UTF_8, stack);
			appInfo.applicationVersion = VKDefinitions.VK_API_VERSION_1_0;

			appInfo.allocPut(stack);

			VkInstanceCreateInfo icInfo = new VkInstanceCreateInfo();
			icInfo.pApplicationInfo = appInfo.address();
			icInfo.enabledLayerCount = layersCount;
			icInfo.ppEnabledLayerNames = layersPtr.getPPtr();
			icInfo.enabledExtensionCount = extensionsCount;
			icInfo.ppEnabledExtensionNames = extensionsPtr.getPPtr();

			icInfo.allocPut(stack);

			vkCheck(vkCreateInstance(icInfo.address(), 0, lPtr0));
			instance = getLong(lPtr0);

			if (debug) {
				System.out.println("instance: " + instance);
			}
		}
	}

	private void initDevice() {
		try (MemoryStack stack = new MemoryStack()) {

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
	}

	private void initCommandBuffer() {
		try (MemoryStack stack = new MemoryStack()) {
			VkCommandPoolCreateInfo commandPoolInfo = new VkCommandPoolCreateInfo();
			commandPoolInfo.queueFamilyIndex = mainQueueFamilyIndex;
			commandPoolInfo.flags = VkCommandPoolCreateFlagBits.VK_COMMAND_POOL_CREATE_RESET_COMMAND_BUFFER_BIT;
			commandPoolInfo.alloc(stack);
			commandPoolInfo.put();
			vkCheck(vkCreateCommandPool(device, commandPoolInfo.address(), 0, lPtr0));
			commandPool = getLong(lPtr0);

			VkCommandBufferAllocateInfo cbaInfo = new VkCommandBufferAllocateInfo();
			cbaInfo.level = VkCommandBufferLevel.VK_COMMAND_BUFFER_LEVEL_PRIMARY;
			cbaInfo.commandBufferCount = 1;
			cbaInfo.commandPool = commandPool;
			cbaInfo.alloc(stack);
			cbaInfo.put();

			vkCheck(vkAllocateCommandBuffers(device, cbaInfo.address(), lPtr0));
			commandBuffer = getLong(lPtr0);
			if (debug) {
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
			vkCheck(vkEnumerateInstanceLayerProperties(lPtr0, 0));
			int size = getInt(lPtr0);

			VkLayerProperties[] properties = VkLayerProperties.WRAPPER.allocArray(size, stack);

			vkCheck(vkEnumerateInstanceLayerProperties(lPtr0, properties[0].address()));
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
	}

	private void listDeviceExtensions(long d) {

		try (MemoryStack stack = new MemoryStack()) {
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

	public void dispose() {
		vkDestroyRenderPass(device, renderPass, 0);
		vkDestroyCommandPool(device, commandPool, 0);
		vkDestroyPipeline(device, pipeline, 0);
		vkDestroyPipelineLayout(device, pipelineLayout, 0);
		vkDestroyShaderModule(device, vShaderModule, 0);
		vkDestroyShaderModule(device, fShaderModule, 0);
		vkDestroyFramebuffer(device, framebuffer, 0);
		VkKhrSwapchain.vkDestroySwapchainKHR(device, swapchain, 0);
		VkKhrSurface.vkDestroySurfaceKHR(instance, surface, 0);
		vkDestroyDevice(device, 0);
		vkDestroyInstance(instance, 0);
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
			throw new RuntimeException("VK err " + result + ": " + VKDefinitions.getErr(result));
		}
	}
}
