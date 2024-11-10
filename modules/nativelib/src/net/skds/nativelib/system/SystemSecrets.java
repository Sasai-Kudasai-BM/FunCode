package net.skds.nativelib.system;

import net.skds.lib2.utils.SKDSUtils;

import java.util.function.Supplier;

final class SystemSecrets {

	private static SystemMethods sys;
	static Supplier<SystemMethods> sysSup = () -> {
		sys = switch (SKDSUtils.OS_TYPE) {
			case WINDOWS -> new WinSys();
			default -> throw new UnsupportedOperationException("Unsupported os \"" + SKDSUtils.OS_TYPE + "\"");
		};
		sysSup = () -> sys;
		return sys;
	};
}
