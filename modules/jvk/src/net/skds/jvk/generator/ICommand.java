package net.skds.jvk.generator;

import java.util.List;

public interface ICommand {
	String name();

	String comment();

	IDataType returnType();


	List<CommandArgument> arguments();
}
