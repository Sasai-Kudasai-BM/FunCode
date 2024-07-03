package net.skds.sosison.sson;

import net.skds.lib.utils.SKDSUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class SSONIndexer {

	private static final Base64.Decoder DECODER = Base64.getDecoder();

	private SSONIndexer() {
	}

	public static long geIndex(String name) {
		byte[] b = new byte[8];
		DECODER.decode(name.getBytes(StandardCharsets.ISO_8859_1), b);
		return SKDSUtils.arrToLong(b);
	}

}
