package net.skds.jvk.generator;

import lombok.CustomLog;
import net.skds.lib2.natives.MemoryAccess;
import net.skds.lib2.utils.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.StructLayout;
import java.util.ArrayList;
import java.util.List;

@CustomLog
class Struct extends DataType implements IStruct {

	private final List<VkgStructMember> members = new ArrayList<>();
	private StructLayout layout;

	@Override
	public StructLayout memoryLayout() {
		StructLayout l = this.layout;
		if (l == null) {
			List<MemoryLayout> elements = new ArrayList<>();
			int offset = 0;
			int max = 0;
			for (VkgStructMember member : members) {
				if (member.type.nativeType() == NativeTypeEnum.VOID) {
					log.warn("Skipping struct member " + member.type + " " + member.name);
					continue;
				}
				MemoryLayout e = member.type.memoryLayout();
				e = e.withName(member.type.nativeTypeName() + " " + member.name);
				int a = (int) e.byteAlignment();
				int pad = MemoryAccess.calcPadding(offset, a);
				if (pad != 0) {
					offset += pad;
					elements.add(MemoryLayout.paddingLayout(pad));
				}
				member.setOffset(offset);
				offset += (int) e.byteSize();
				max = Math.max(max, a);
				elements.add(e);
			}
			int pad = MemoryAccess.calcPadding(offset, max);
			if (pad != 0) {
				elements.add(MemoryLayout.paddingLayout(pad));
			}

			l = MemoryLayout.structLayout(elements.toArray(new MemoryLayout[0])).withName(getName());
			this.layout = l;
		}
		return l;
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
				if (!VKGen.isApiAllowed(member.getAttribute("api")))
					continue;
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

					mc.append("values = ").append(values);
				}
				var tNode = member.getElementsByTagName("type").item(0);
				String stn = tNode.getTextContent();
				IDataType st = VKGen.getDataType(stn);
				if (st == null) {
					System.err.println(stn);
				} else if (tNode.getNextSibling() != null && tNode.getNextSibling().getTextContent().startsWith("*")) {
					st = new PointerType(st);
				}
				Node nn = member.getElementsByTagName("name").item(0);
				String sn = nn.getTextContent();

				//String mt = member.getTextContent();

				var sib1 = nn.getNextSibling();
				if (sib1 != null && sib1.getTextContent().startsWith("[")) {

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

							st = new ArrayType(st, (Integer) v.v());
							//System.out.println(st);
						}
					}

					if (!ok) {
						String mt = sib1.getTextContent().replace("\n", "").replace(" ", "");
						if (!mt.isBlank()) {

							String mt2 = StringUtils.cutStringAfter(mt, '[');
							String mt3 = StringUtils.cutStringBefore(mt2, ']');
							int s0 = Integer.parseInt(mt3);
							int s = s0;
							int s1 = 0;
							mt2 = StringUtils.cutStringAfter(mt2, ']');
							if (!mt2.isBlank()) {
								mt2 = StringUtils.cutStringAfter(mt2, '[');
								mt3 = StringUtils.cutStringBefore(mt2, ']');
								s1 = Integer.parseInt(mt3);
								s *= s1;
							}

							st = s1 == 0 ? new ArrayType(st, s) : new ArrayType(st, s, new int[]{s0, s1});
							//System.out.println(st);
							//System.out.println(s);
							//System.out.println(mt);
						}
					}
				}
				VkgStructMember member1 = new VkgStructMember(sn, st, mc.toString());
				if (!values.isEmpty()) VKGen.addEndTask(() -> {
					EnumType.Value v = VKGen.enumValues.get(values);
					if (v != null) {
						member1.setValue(v.v());
					} else {
						System.err.println("kek " + values);
					}
				});

				struct.members.add(member1);
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
		public List<VkgStructMember> members() {
			return getParent().members();
		}

		@Override
		public StructLayout memoryLayout() {
			return getParent().memoryLayout();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name).append("[struct][ ");

		for (VkgStructMember member : members()) {
			sb.append(member.type.getName()).append(" ").append(member.name);
			if (!member.comment.isEmpty()) {
				sb.append("/* ").append(member.comment).append(" */");
			}
			sb.append(", ");
		}
		if (!members().isEmpty()) {
			sb.setLength(sb.length() - 2);
		}
		return sb.append("]").toString();
	}

	@Override
	public List<VkgStructMember> members() {
		return members;
	}
}
