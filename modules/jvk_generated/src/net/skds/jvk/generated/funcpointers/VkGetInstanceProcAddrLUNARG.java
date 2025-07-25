package net.skds.jvk.generated.funcpointers;

import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.annotations.AutoGenerated;
import net.skds.lib2.natives.LinkerUtils;
import net.skds.lib2.natives.UpcallLink;

@AutoGenerated
@FunctionalInterface
public interface VkGetInstanceProcAddrLUNARG {
	
	UpcallLink<VkGetInstanceProcAddrLUNARG> LINK = LinkerUtils.createUpcallLink(VkGetInstanceProcAddrLUNARG.class);
	
	@NativeType("PFN_vkVoidFunction*")
	long vkGetInstanceProcAddrLUNARG(@NativeType("VkInstance*") long instanceconst, @NativeType("char*") long pName);
}