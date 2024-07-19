package net.skds.jvk.generated.extensions;
import net.skds.jvk.annotation.NativeType;
import static net.skds.ninvoker.NInvoker.*;
import java.lang.invoke.MethodHandle;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrPushDescriptor {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PUSH_DESCRIPTOR_PROPERTIES_KHR = 0;

	// Descriptors are pushed via flink:vkCmdPushDescriptorSetKHR

	/**
	* Descriptors are pushed via flink:vkCmdPushDescriptorSetKHR
	*/
	public static final int VK_DESCRIPTOR_SET_LAYOUT_CREATE_PUSH_DESCRIPTOR_BIT_KHR = 1;

	private static final MethodHandle vkCmdPushDescriptorSetKHR = createHandle("vkCmdPushDescriptorSetKHR", VOID, LONG, INT, LONG, INT, INT, LONG);

	@NativeType("void")
	public static void vkCmdPushDescriptorSetKHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkPipelineBindPoint") int pipelineBindPoint, @NativeType("VkPipelineLayout*") long layout, @NativeType("uint32_t") int set, @NativeType("uint32_t") int descriptorWriteCount, @NativeType("VkWriteDescriptorSet*") long pDescriptorWrites) {
		try {
			vkCmdPushDescriptorSetKHR.invokeExact(commandBuffer, pipelineBindPoint, layout, set, descriptorWriteCount, pDescriptorWrites);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdPushDescriptorSetWithTemplateKHR = createHandle("vkCmdPushDescriptorSetWithTemplateKHR", VOID, LONG, LONG, LONG, INT, LONG);

	@NativeType("void")
	public static void vkCmdPushDescriptorSetWithTemplateKHR(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkDescriptorUpdateTemplate*") long descriptorUpdateTemplate, @NativeType("VkPipelineLayout*") long layout, @NativeType("uint32_t") int set, @NativeType("void*") long pData) {
		try {
			vkCmdPushDescriptorSetWithTemplateKHR.invokeExact(commandBuffer, descriptorUpdateTemplate, layout, set, pData);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	// Create descriptor update template for pushed descriptor updates

	/**
	* Create descriptor update template for pushed descriptor updates
	*/
	public static final int VK_DESCRIPTOR_UPDATE_TEMPLATE_TYPE_PUSH_DESCRIPTORS_KHR = 1;

	// Create descriptor update template for pushed descriptor updates
}