package net.skds.jvk.vulkan.pipeline;

import net.skds.jvk.generated.structs.VkAttachmentDescription;
import net.skds.jvk.generated.structs.VkRenderPassCreateInfo;
import net.skds.jvk.generated.structs.VkSubpassDependency;
import net.skds.jvk.generated.structs.VkSubpassDescription;

import java.lang.foreign.Arena;

public abstract class VkRenderPassBuilder {

	protected final VkRenderPassCreateInfo createInfo;

	protected int attachmentCount;
	protected int dependencyCount;
	protected int subpassCount;

	public VkRenderPassBuilder(Arena arena) {
		this.createInfo = new VkRenderPassCreateInfo(arena)
				.sType$Default()
				.flags(0);

	}

	public VkRenderPassCreateInfo build() {
		Arena localArena = Arena.ofAuto();
		var att = new VkAttachmentDescription.Array(localArena, attachmentCount);
		var sub = new VkSubpassDescription.Array(localArena, subpassCount);
		var dep = new VkSubpassDependency.Array(localArena, dependencyCount);
		initAttachments(att);
		initSubpasses(sub);
		initDependencies(dep);
		this.createInfo.attachmentCount(att.getSize())
				.pAttachments(att.getAddress())
				.subpassCount(sub.getSize())
				.pSubpasses(sub.getAddress())
				.dependencyCount(dep.getSize())
				.pDependencies(dep.getAddress())
		;
		return this.createInfo;
	}

	protected abstract void initAttachments(VkAttachmentDescription.Array attachmentDescription);

	protected abstract void initSubpasses(VkSubpassDescription.Array subpassDescriptions);

	protected abstract void initDependencies(VkSubpassDependency.Array subpassDescriptions);


}
