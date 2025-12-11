package net.skds.jvk.platform;

import net.skds.lib2.natives.LinkerUtils;

import java.lang.foreign.SymbolLookup;

final class JVKLinuxPlatform extends VKPlatformFeatures {
	@Override
	protected SymbolLookup loadLibrary0() {
		return LinkerUtils.library("libvulkan.so.1", arena);
	}
}
