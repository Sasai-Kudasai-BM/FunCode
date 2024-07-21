package net.skds.jvk.generator;

import net.skds.lib.utils.SKDSUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

class Struct extends DataType implements IStruct {

	private final List<StructMember> members = new ArrayList<>();

	@Override
	public int size() {
		return members.stream().mapToInt(sm -> sm.type().size()).sum();
	}

	public static IStruct create(Element e) {
		String name = e.getAttribute("name");
		String alias = e.getAttribute("alias");
		if (!alias.isEmpty()) {
			return new Aliased(alias, name);
		}
		Struct struct = new Struct();
		struct.name = name;

		VKGen.addTask(() -> {
			var members = e.getElementsByTagName("member");
			for (int i = 0; i < members.getLength(); i++) {
				Element member = (Element) members.item(i);
				StringBuilder mc = new StringBuilder();

				boolean optional = member.hasAttribute("optional");
				if (optional) {
					mc.append("optional");
				}
				Object val = null;
				String values = member.getAttribute("values");
				if (!values.isEmpty()) {
					if (!mc.isEmpty()) {
						mc.append(", ");
					}
					EnumType.Value v = VKGen.enumValues.get(values);
					if (v != null) {
						val = v.v();
					}
					mc.append("values = ").append(values);
				}
				IDataType st = VKGen.getDataType(member.getElementsByTagName("type").item(0).getTextContent());
				if (st == null) {
					System.out.println(member.getElementsByTagName("type").item(0).getTextContent());
				}
				Node nn = member.getElementsByTagName("name").item(0);
				String sn = nn.getTextContent();

				String mt = member.getTextContent();


				if (mt.contains("[")) {
					var sib1 = nn.getNextSibling();
					var sib2 = sib1.getNextSibling();
					boolean ok = false;
					if (sib2 != null) {
						if (sib2.getNodeName().equals("enum")) {
							//System.out.println(sib2.getTextContent());
							EnumType.Value v = VKGen.enumValues.get(sib2.getTextContent());
							//System.out.println(v);
							ok = true;
							//System.out.println("--------");
							//System.out.println(mt);
							//System.out.println("========");

							st = new ArrayType(st, v.name(), (Integer) v.v());
							System.out.println(st);
						}
					}

					if (!ok) {
						mt = sib1.getTextContent().replace("\n", "").replace(" ", "");
						if (!mt.isBlank()) {

							String mt2 = SKDSUtils.cutStringAfter(mt, '[');
							String mt3 = SKDSUtils.cutStringBefore(mt2, ']');
							int s = Integer.parseInt(mt3);
							if (!mt2.isBlank()) {
								mt2 = SKDSUtils.cutStringAfter(mt2, '[');
								mt3 = SKDSUtils.cutStringBefore(mt2, ']');
								s *= Integer.parseInt(mt3);
							}

							st = new ArrayType(st, "", s);
							//System.out.println(st);
							//System.out.println(s);
							//System.out.println(mt);
						}
					}
				}

				if (member.getTextContent().contains("*")) {
					st = new PointerType(st);
				}

				struct.members.add(new StructMember(sn, st, mc.toString(), val));
			}
		});
		return struct;
	}

	private static class Aliased extends DataType.Aliased implements IStruct {

		public Aliased(String alias, String name) {
			super(alias, name);
		}

		@Override
		protected IStruct getParent() {
			if (parent == null) {
				parent = VKGen.getDataType(alias);
			}
			return (IStruct) parent;
		}


		@Override
		public String toString() {
			return getParent().toString();
		}


		@Override
		public List<StructMember> members() {
			return getParent().members();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name).append("[struct][ ");

		for (StructMember member : members()) {
			sb.append(member.type().getName()).append(" ").append(member.name());
			if (!member.comment().isEmpty()) {
				sb.append("/* ").append(member.comment()).append(" */");
			}
			sb.append(", ");
		}
		if (!members().isEmpty()) {
			sb.setLength(sb.length() - 2);
		}
		return sb.append("]").toString();
	}

	@Override
	public List<StructMember> members() {
		return members;
	}
}
