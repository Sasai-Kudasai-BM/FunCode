package net.skds.telegram;

import net.skds.lib2.utils.logger.SKDSLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TelegramBot {

	static void main() throws IOException {
		SKDSLogger.replaceOuts();
		String token = Files.readString(Path.of("token.txt"));
		String request = "https://api.telegram.org/bot" + token;

		String wh = request + "/setWebhook";
		
	}
}
