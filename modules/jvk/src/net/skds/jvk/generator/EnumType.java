package net.skds.jvk.generator;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

class EnumType extends DataType implements IEnumType {

	protected boolean isBitmask;

	protected List<Value> values = new ArrayList<>();

	public static IEnumType create(Element e) {
		String alias = e.getAttribute("alias");
		String name = e.getAttribute("name");
		if (!alias.isEmpty()) {
			return new Aliased(alias, name);
		}
		//name = name.replace(" ", "");
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


					Object val;
					if (value.isEmpty()) {
						int p = Integer.parseInt(bitpos);
						val = 1L << p;
						if (p > 31) {
							nt = NativeTypeEnum.UINT64_T;
						}
					} else {
						val = nt.parse(value);
					}

					Value vlu = new Value(val, name2, comment2, nt);
					VKGen.enumValues.put(vlu.name, vlu);
					et.values.add(vlu);

				} else if (e2.getNodeName().equals("comment")) {
					et.values.add(new Value(null, null, e2.getTextContent(), null));
				}
			}
		}


		return et;
	}

	public static Value parseValue(Element e) {

		IEnumType et = VKGen.enums.get(e.getAttribute("extends"));

		String name2 = e.getAttribute("name");
		String comment2 = e.getAttribute("comment");

		//System.out.println(name2);

		String alias2 = e.getAttribute("alias");
		if (!alias2.isEmpty()) {
			Value v0 = VKGen.enumValues.get(alias2);
			if (v0 != null) {
				//et.values().add(v2);
				var v2 = new Value(v0.v, name2, comment2, v0.type);
				VKGen.enumValues.put(v2.name, v2);
				return v2;
			}
			if (et == null) {
				throw new RuntimeException("alias null t \"" + alias2 + "\"");
			}
			for (Value v : et.values()) {
				if (alias2.equals(v.name)) {
					//et.values().add(v2);
					var v2 = new Value(v.v, name2, comment2, v.type);
					VKGen.enumValues.put(v2.name, v2);
					return v2;
				}
			}
			return null;
			//throw new RuntimeException("alias \"" + alias2 + "\"");
		}


		String bitpos = e.getAttribute("bitpos");
		String value = e.getAttribute("offset");
		if (value.isEmpty()) {
			value = e.getAttribute("value");
		}
		if (et == null) {
			Value v2 = VKGen.enumValues.get(name2);
			if (v2 == null) {
				v2 = new Value(value.replace("&quot;", ""), name2, comment2, null);
			}
			VKGen.enumValues.put(v2.name, v2);
			return v2;
		} else {
			String type = e.getAttribute("type");
			NativeTypeEnum nt = et.nativeType();
			if (!type.isEmpty()) {
				nt = NativeTypeEnum.valueOf(type.toUpperCase());
			}
			Object val;
			if (value.isEmpty()) {
				int p = Integer.parseInt(bitpos);
				val = 1L << p;
				if (p > 31) {
					nt = NativeTypeEnum.UINT64_T;
				}
			} else {
				val = nt.parse(value);
			}
			Value v2 = new Value(val, name2, comment2, nt);
			//et.values().add(v2);
			VKGen.enumValues.put(v2.name, v2);
			return v2;
		}

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
