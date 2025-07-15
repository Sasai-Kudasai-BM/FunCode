package net.skds.jvk.platform;

import net.skds.lib2.natives.SafeLinker;

import java.lang.foreign.SymbolLookup;

final class JVKWindowsPlatform extends VKPlatformFeatures {
	@Override
	protected SymbolLookup loadLibrary0() {
		return SafeLinker.library("vulkan-1", arena);
	}
}
