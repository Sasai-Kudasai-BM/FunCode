package net.skds.jvk.generator;

interface ICommand {
	String name();

	String comment();

	IDataType returnType();


	ClassBuilder.Arg[] arguments();
}
