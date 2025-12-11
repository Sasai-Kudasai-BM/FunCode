package net.skds.sosaldb.server;

import lombok.CustomLog;
import lombok.Getter;
import net.skds.lib2.io.codec.SosisonUtils;
import net.skds.lib2.utils.Console;
import net.skds.lib2.utils.SKDSUtils;
import net.skds.lib2.utils.Types;
import net.skds.lib2.utils.logger.SKDSLogger;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CustomLog
public class SosalDbServer {

	public static final SosalDbServer INSTANCE = new SosalDbServer();
	public final Console console = new Console();

	public static final File cfgFile = new File("config.json");

	private final SDbNetServer netServer = new SDbNetServer();

	@Getter
	private Map<String, UserInfo> users = Map.of();
	@Getter
	private Map<String, DatabaseInfo> databases = Map.of();
	@Getter
	private Config config;

	public SosalDbServer() {
		console.addBasicCommands();
	}

	public void start() {
		SKDSLogger.replaceOuts();
		console.start();
		Config cfg = SosisonUtils.readJson(cfgFile, Config.class);
		if (cfg == null) {
			cfg = new Config();
			SosisonUtils.saveJson(cfgFile, cfg);
		}
		this.config = cfg;

		List<UserInfo> urs = SosisonUtils.readJson(cfg.getUsersFile(), Types.parameterizedType(List.class, UserInfo.class));
		if (urs == null) {
			urs = List.of(new UserInfo("admin", "admin"));
			SosisonUtils.saveJson(cfg.getUsersFile(), urs);
		}
		List<DatabaseInfo> dbs = SosisonUtils.readJson(cfg.getDatabasesFile(), Types.parameterizedType(List.class, DatabaseInfo.class));
		if (dbs == null) {
			dbs = List.of();
			SosisonUtils.saveJson(cfg.getDatabasesFile(), dbs);
		}

		Map<String, UserInfo> users = new HashMap<>();
		Map<String, DatabaseInfo> databases = new HashMap<>();
		for (UserInfo user : urs) {
			users.put(user.username(), user);
		}
		for (DatabaseInfo db : dbs) {
			databases.put(db.getName(), db);
		}
		this.users = users;
		this.databases = databases;

		//this.netServer.start(cfg.getPort());
	}

	public static void main(String[] args) {
		log.log("Starting SosalDbServer...");
		var t = SKDSUtils.startTimeMeasure();
		INSTANCE.start();
		log.log("SosalDbServer started in %.3f sec".formatted(t.query() / 1000));
	}
}
