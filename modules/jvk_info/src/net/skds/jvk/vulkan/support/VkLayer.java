package net.skds.jvk.vulkan.support;

import net.skds.jvk.VkDefinitions;

public record VkLayer(String name, String description, int specVersion, int implementationVersion) {

	@Override
	public String toString() {
		return name + " " + VkDefinitions.getVersion(specVersion) + " v" + implementationVersion + " " + description;
	}
}
