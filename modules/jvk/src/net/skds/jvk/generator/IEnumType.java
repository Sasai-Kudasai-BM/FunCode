package net.skds.jvk.generator;

import java.util.List;

public interface IEnumType extends IDataType {

	boolean isBitmask();

	List<EnumType.Value> values();
}
