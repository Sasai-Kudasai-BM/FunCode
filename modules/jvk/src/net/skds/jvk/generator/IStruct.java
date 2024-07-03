package net.skds.jvk.generator;

import java.util.List;

public interface IStruct extends IDataType {

	String comment();
	
	List<StructMember> members();
}
