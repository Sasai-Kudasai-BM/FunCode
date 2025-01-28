package net.skds.sosaldb.server;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DatabaseInfo {

	private String name;
	private Set<String> users;

	public DatabaseInfo(String name) {
		this.name = name;
		this.users = new HashSet<>();
	}
}
