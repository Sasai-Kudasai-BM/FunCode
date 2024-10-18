package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkKhrGetMemoryRequirements2 {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_BUFFER_MEMORY_REQUIREMENTS_INFO_2_KHR = 0;

	public static final int VK_STRUCTURE_TYPE_IMAGE_MEMORY_REQUIREMENTS_INFO_2_KHR = 1;

	public static final int VK_STRUCTURE_TYPE_IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2_KHR = 2;

	public static final int VK_STRUCTURE_TYPE_MEMORY_REQUIREMENTS_2_KHR = 3;

	public static final int VK_STRUCTURE_TYPE_SPARSE_IMAGE_MEMORY_REQUIREMENTS_2_KHR = 4;

	private static final MethodHandle vkGetImageMemoryRequirements2KHR = createHandle("vkGetImageMemoryRequirements2KHR", VOID, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkGetImageMemoryRequirements2KHR(@NativeType("VkDevice*") long device, @NativeType("VkImageMemoryRequirementsInfo2*") long pInfo, @NativeType("VkMemoryRequirements2*") long pMemoryRequirements) {
		try {
			vkGetImageMemoryRequirements2KHR.invokeExact(device, pInfo, pMemoryRequirements);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetBufferMemoryRequirements2KHR = createHandle("vkGetBufferMemoryRequirements2KHR", VOID, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkGetBufferMemoryRequirements2KHR(@NativeType("VkDevice*") long device, @NativeType("VkBufferMemoryRequirementsInfo2*") long pInfo, @NativeType("VkMemoryRequirements2*") long pMemoryRequirements) {
		try {
			vkGetBufferMemoryRequirements2KHR.invokeExact(device, pInfo, pMemoryRequirements);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkGetImageSparseMemoryRequirements2KHR = createHandle("vkGetImageSparseMemoryRequirements2KHR", VOID, LONG, LONG, LONG, LONG);

	@NativeType("void")
	public static void vkGetImageSparseMemoryRequirements2KHR(@NativeType("VkDevice*") long device, @NativeType("VkImageSparseMemoryRequirementsInfo2*") long pInfo, @NativeType("uint32_t*") /*optional*/ long pSparseMemoryRequirementCount, @NativeType("VkSparseImageMemoryRequirements2*") /*optional*/ long pSparseMemoryRequirements) {
		try {
			vkGetImageSparseMemoryRequirements2KHR.invokeExact(device, pInfo, pSparseMemoryRequirementCount, pSparseMemoryRequirements);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}