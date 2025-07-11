package net.skds.jvk.generator;

import net.skds.lib2.misc.clazz.classbuilder.CBMethod;

import java.util.List;

interface ICommand {
	String name();

	String comment();

	IDataType returnType();


	List<CBMethod.Arg> arguments();
}
