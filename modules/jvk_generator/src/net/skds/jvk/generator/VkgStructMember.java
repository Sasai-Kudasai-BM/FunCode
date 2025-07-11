package net.skds.jvk.generator;

import lombok.Setter;

class VkgStructMember {
	final String name;
	final IDataType type;
	final String comment;
	@Setter
	int offset = -1;
	@Setter
	Object value;

	VkgStructMember(String name, IDataType type, String comment) {
		this.name = name;
		this.type = type;
		this.comment = comment;
	}
}
