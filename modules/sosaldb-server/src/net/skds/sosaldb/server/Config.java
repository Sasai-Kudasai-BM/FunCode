package net.skds.sosaldb.server;

import lombok.Getter;

import java.nio.file.Path;

@SuppressWarnings("FieldMayBeFinal")
@Getter
public class Config {

	private int port = 50420;

	private Path usersFile = Path.of("users.json");
	private Path databasesFile = Path.of("databases.json");
	
}
