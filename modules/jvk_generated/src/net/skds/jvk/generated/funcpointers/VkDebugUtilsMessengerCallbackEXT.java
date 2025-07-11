package net.skds.jvk.generated.funcpointers;

import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.SafeLinker;
import net.skds.lib2.natives.UpcallLink;

@AutoGenerated
@FunctionalInterface
public interface VkDebugUtilsMessengerCallbackEXT {
	
	UpcallLink<VkDebugUtilsMessengerCallbackEXT> LINK = SafeLinker.createUpcallLink(VkDebugUtilsMessengerCallbackEXT.class);
	
	@NativeType("VkBool32")
	int vkDebugUtilsMessengerCallbackEXT(@NativeType("VkDebugUtilsMessageSeverityFlagBitsEXT") int messageSeverity, @NativeType("VkDebugUtilsMessageTypeFlagsEXT") int messageTypesconst, @NativeType("VkDebugUtilsMessengerCallbackDataEXT*") long pCallbackData, @NativeType("void*") long pUserData);
}