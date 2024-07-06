package net.skds.jvk.generator;

public interface ICommand {
	String name();

	String comment();

	IDataType returnType();


	ClassBuilder.Arg[] arguments();
}
