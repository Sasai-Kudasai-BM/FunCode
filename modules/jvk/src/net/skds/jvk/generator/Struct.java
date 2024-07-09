package net.skds.jvk.generator;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

class Struct extends DataType implements IStruct {

	private final List<StructMember> members = new ArrayList<>();


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
				String values = member.getAttribute("values");
				if (!values.isEmpty()) {
					if (!mc.isEmpty()) {
						mc.append(", ");
					}
					mc.append("values = ").append(values);
				}
				IDataType st = VKGen.getDataType(member.getElementsByTagName("type").item(0).getTextContent());
				if (st == null) {
					System.out.println(member.getElementsByTagName("type").item(0).getTextContent());
				}
				if (member.getTextContent().contains("*")) {
					st = new PointerType(st);
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
							System.out.println(v);
							ok = true;
							//System.out.println("--------");
							//System.out.println(mt);
							//System.out.println("========");
						}
					}

					if (!ok) {
						mt = sib1.getTextContent().replace("\n", "").replace(" ", "");
						if (!mt.isBlank()) {
							System.out.println(mt);
						}
					}
				}

				struct.members.add(new StructMember(sn, st, mc.toString()));
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
