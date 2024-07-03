package net.skds.jvk.generator;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class EnumType extends DataType implements IEnumType {

	protected boolean isBitmask;

	protected List<Value> values = new ArrayList<>();

	public static IEnumType create(Element e) {
		String alias = e.getAttribute("alias");
		String name = e.getAttribute("name");
		if (!alias.isEmpty()) {
			return new Aliased(alias, name);
		}
		name = name.replace(" ", "");
		EnumType et = new EnumType();
		String bitwidth = e.getAttribute("bitwidth");
		switch (bitwidth) {
			case "" -> et.nativeType = NativeTypeEnum.INT32_T;
			case "64" -> et.nativeType = NativeTypeEnum.INT64_T;
			default -> throw new RuntimeException("bitwidth " + bitwidth);
		}

		et.name = name;
		et.comment = e.getAttribute("comment");
		et.isBitmask = e.getAttribute("type").equals("bitmask");

		var l = e.getChildNodes();
		loopa:
		for (int i = 0; i < l.getLength(); i++) {
			var n = l.item(i);
			if (n instanceof Element e2) {
				if (e2.getNodeName().equals("enum")) {

					String name2 = e2.getAttribute("name");
					String comment2 = e2.getAttribute("comment");
					String alias2 = e2.getAttribute("alias");
					if (!alias2.isEmpty()) {
						for (Value v : et.values) {
							if (alias2.equals(v.name)) {
								et.values.add(new Value(v.v, name2, comment2, v.type));
								continue loopa;
							}
						}
						throw new RuntimeException("alias " + alias2);
					}
					String type = e2.getAttribute("type");
					NativeTypeEnum nt = et.nativeType;
					if (!type.isEmpty()) {
						nt = NativeTypeEnum.valueOf(type.toUpperCase());
					}

					String bitpos = e2.getAttribute("bitpos");
					String value = e2.getAttribute("value");


					Object val = value.isEmpty() ? 1L << Integer.parseInt(bitpos) : nt.parse(value);

					et.values.add(new Value(val, name2, comment2, nt));

				} else if (e2.getNodeName().equals("comment")) {
					et.values.add(new Value(null, null, e2.getTextContent(), null));
				}
			}
		}


		return et;
	}
	
	@Override
	public boolean isBitmask() {
		return isBitmask;
	}

	@Override
	public List<Value> values() {
		return values;
	}

	@Override
	public String toString() {
		return name + "[enum " + values.size() + "; " + nativeType + (isBitmask ? "; bitmask" : "") + "]";
	}

	public record Value(Object v, String name, String comment, NativeTypeEnum type) {

	}

	//private enum Type {
	//	ENUM, BITMASK
	//}

	private static class Aliased extends DataType.Aliased implements IEnumType {

		public Aliased(String alias, String name) {
			super(alias, name);
		}

		@Override
		protected IEnumType getParent() {
			if (parent == null) {
				parent = VKGen.enums.get(alias);
			}
			return (IEnumType) parent;
		}

		@Override
		public boolean isBitmask() {
			return getParent().isBitmask();
		}

		@Override
		public List<Value> values() {
			return getParent().values();
		}

		@Override
		public String toString() {
			return name + "[enum " + values().size() + "; " + nativeType() + (isBitmask() ? "; bitmask" : "") + "]";
		}
	}
}
