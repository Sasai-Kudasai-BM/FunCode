package net.skds.jvk.vulkan.pipeline;

import net.skds.jvk.generated.structs.*;

import java.lang.foreign.Arena;

public class VkGraphicsPipelineBuilder {

	protected final VkGraphicsPipelineCreateInfo createInfo;

	protected VkPipelineShaderStageCreateInfo.Array pStages;
	protected final VkPipelineVertexInputStateCreateInfo pVertexInputState;
	protected final VkPipelineInputAssemblyStateCreateInfo pInputAssemblyState;
	protected final VkPipelineTessellationStateCreateInfo pTessellationState;
	protected final VkPipelineViewportStateCreateInfo pViewportState;
	protected final VkPipelineRasterizationStateCreateInfo pRasterizationState;
	protected final VkPipelineMultisampleStateCreateInfo pMultisampleState;
	protected final VkPipelineDepthStencilStateCreateInfo pDepthStencilState;
	protected final VkPipelineColorBlendStateCreateInfo pColorBlendState;
	protected final VkPipelineDynamicStateCreateInfo pDynamicState;


	public VkGraphicsPipelineBuilder(Arena arena) {
		//this.pStages = new VkPipelineShaderStageCreateInfo(arena);
		this.pVertexInputState = new VkPipelineVertexInputStateCreateInfo(arena);
		this.pInputAssemblyState = new VkPipelineInputAssemblyStateCreateInfo(arena);
		this.pTessellationState = new VkPipelineTessellationStateCreateInfo(arena);
		this.pViewportState = new VkPipelineViewportStateCreateInfo(arena);
		this.pRasterizationState = new VkPipelineRasterizationStateCreateInfo(arena);
		this.pMultisampleState = new VkPipelineMultisampleStateCreateInfo(arena);
		this.pDepthStencilState = new VkPipelineDepthStencilStateCreateInfo(arena);
		this.pColorBlendState = new VkPipelineColorBlendStateCreateInfo(arena);
		this.pDynamicState = new VkPipelineDynamicStateCreateInfo(arena);

		this.createInfo = new VkGraphicsPipelineCreateInfo(arena)
				.sType$Default()
				.flags(0)
				.pStages(pStages.getAddress())
				.pVertexInputState(pVertexInputState.getAddress())
				.pInputAssemblyState(pInputAssemblyState.getAddress())
				.pTessellationState(pTessellationState.getAddress())
				.pViewportState(pViewportState.getAddress())
				.pRasterizationState(pRasterizationState.getAddress())
				.pMultisampleState(pMultisampleState.getAddress())
				.pDepthStencilState(pDepthStencilState.getAddress())
				.pColorBlendState(pColorBlendState.getAddress())
				.pDynamicState(pDynamicState.getAddress())
		;
	}

	public void init() {
		initStages();
		initVertexInputState();
		initInputAssemblyState();
		initTessellationState();
		initViewportState();
		initRasterizationState();
		initMultisampleState();
		initDepthStencilStat();
		initColorBlendState();
		initDynamicState();
	}

	public void initStages() {

	}

	public void initVertexInputState() {

	}

	public void initInputAssemblyState() {

	}

	public void initTessellationState() {

	}

	public void initViewportState() {

	}

	public void initRasterizationState() {

	}

	public void initMultisampleState() {

	}

	public void initDepthStencilStat() {

	}

	public void initColorBlendState() {

	}

	public void initDynamicState() {

	}
}
