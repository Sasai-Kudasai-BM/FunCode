package net.skds.jvk.vulkan.pipeline;

import net.skds.jvk.VkUtils;
import net.skds.jvk.generated.enums.VkShaderStageFlagBits;
import net.skds.jvk.generated.structs.*;

import java.lang.foreign.Arena;

public abstract class VkComputePipelineBuilder {

	protected final VkComputePipelineCreateInfo createInfo;
	protected final VkPipelineShaderStageCreateInfo shaderStageCreateInfo;

	protected int attachmentCount;
	protected int dependencyCount;
	protected int subpassCount;

	public VkComputePipelineBuilder(Arena arena) {
		this.createInfo = new VkComputePipelineCreateInfo(arena)
				.sType$Default()
				.flags(0);
		this.shaderStageCreateInfo = this.createInfo.stage()
				.sType$Default()
				.stage(VkShaderStageFlagBits.VK_SHADER_STAGE_COMPUTE_BIT)
				.module(0)
				.pName(VkUtils.P_SHADER_ENTRY_POINT_MAIN);
	}

	public VkComputePipelineCreateInfo build() {
		Arena localArena = Arena.ofAuto();
		var att = new VkAttachmentDescription.Array(localArena, attachmentCount);
		var sub = new VkSubpassDescription.Array(localArena, subpassCount);
		var dep = new VkSubpassDependency.Array(localArena, dependencyCount);
		//initAttachments(att);
		//initSubpasses(sub);
		//initDependencies(dep);
		//this.createInfo.attachmentCount(att.getSize())
		//		.pAttachments(att.getAddress())
		//		.subpassCount(sub.getSize())
		//		.pSubpasses(sub.getAddress())
		//		.dependencyCount(dep.getSize())
		//		.pDependencies(dep.getAddress())
		//;
		return this.createInfo;
	}


}
