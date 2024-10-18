package net.skds.jvk.generated.extensions;
import net.skds.jvk.VKDefinitions;
import net.skds.lib.utils.annotations.AutoGenerated;
import static net.skds.ninvoker.NInvoker.*;
import net.skds.jvk.annotation.NativeType;
import java.lang.invoke.MethodHandle;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkExtConditionalRendering {


	public static final boolean INITIALIZED = VKDefinitions.INITIALIZED;

	public static final int VK_STRUCTURE_TYPE_COMMAND_BUFFER_INHERITANCE_CONDITIONAL_RENDERING_INFO_EXT = 0;

	public static final int VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CONDITIONAL_RENDERING_FEATURES_EXT = 1;

	public static final int VK_STRUCTURE_TYPE_CONDITIONAL_RENDERING_BEGIN_INFO_EXT = 2;

	// read access flag for reading conditional rendering predicate

	/**
	* read access flag for reading conditional rendering predicate
	*/
	public static final int VK_ACCESS_CONDITIONAL_RENDERING_READ_BIT_EXT = 1048576;

	// Specifies the buffer can be used as predicate in conditional rendering

	/**
	* Specifies the buffer can be used as predicate in conditional rendering
	*/
	public static final int VK_BUFFER_USAGE_CONDITIONAL_RENDERING_BIT_EXT = 512;

	// A pipeline stage for conditional rendering predicate fetch

	/**
	* A pipeline stage for conditional rendering predicate fetch
	*/
	public static final int VK_PIPELINE_STAGE_CONDITIONAL_RENDERING_BIT_EXT = 262144;

	private static final MethodHandle vkCmdBeginConditionalRenderingEXT = createHandle("vkCmdBeginConditionalRenderingEXT", VOID, LONG, LONG);

	@NativeType("void")
	public static void vkCmdBeginConditionalRenderingEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer, @NativeType("VkConditionalRenderingBeginInfoEXT*") long pConditionalRenderingBegin) {
		try {
			vkCmdBeginConditionalRenderingEXT.invokeExact(commandBuffer, pConditionalRenderingBegin);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}

	private static final MethodHandle vkCmdEndConditionalRenderingEXT = createHandle("vkCmdEndConditionalRenderingEXT", VOID, LONG);

	@NativeType("void")
	public static void vkCmdEndConditionalRenderingEXT(@NativeType("VkCommandBuffer*") /*external sync*/ long commandBuffer) {
		try {
			vkCmdEndConditionalRenderingEXT.invokeExact(commandBuffer);
		} catch (Throwable e) { throw new RuntimeException(e); }
	}
}