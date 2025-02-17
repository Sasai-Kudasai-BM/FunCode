package net.skds.sas3d.vulkan.pipeline;

import net.skds.jvk.generated.structs.VkRenderPassCreateInfo;
import net.skds.sas3d.vulkan.image.VkImage;

import java.util.List;

public class RenderPass {

	VkRenderPassCreateInfo createInfo = new VkRenderPassCreateInfo();

	List<SubPass> subPasses;
	List<RenderPass> dependencies;
	List<VkImage> attachments;
}
