package net.skds.sosaldb.server;

import net.skds.lib2.utils.SKDSUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public record UserInfo(String username, byte[] pwdHash) {

	public UserInfo(String username, String password) {
		this(username, SKDSUtils.getSHA1().digest(password.getBytes(StandardCharsets.UTF_8)));
	}

	public boolean matchPass(String pass) {
		byte[] sha = SKDSUtils.getSHA1().digest(pass.getBytes(StandardCharsets.UTF_8));
		return Arrays.equals(sha, pwdHash);
	}
}
