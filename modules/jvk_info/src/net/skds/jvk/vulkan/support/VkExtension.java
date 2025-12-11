package net.skds.jvk.vulkan.support;

public record VkExtension(String name, int specVersion) {
	@Override
	public String toString() {
		return name + " v" + specVersion;
	}
}
