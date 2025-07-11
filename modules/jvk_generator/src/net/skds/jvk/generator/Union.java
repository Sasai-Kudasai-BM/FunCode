package net.skds.jvk.generator;

import lombok.Getter;
import net.skds.lib2.utils.StringUtils;
import org.w3c.dom.Element;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.UnionLayout;
import java.util.ArrayList;
import java.util.List;

class Union extends DataType {

	@Getter
	private final List<IDataType> members = new ArrayList<>();
	private UnionLayout layout;


	public Union(Element e) {
		this.name = e.getAttribute("name");

		VKGen.addTask(() -> {
			var mems = e.getElementsByTagName("member");
			for (int i = 0; i < mems.getLength(); i++) {
				Element member = (Element) mems.item(i);
				IDataType type = VKGen.getDataType(member.getElementsByTagName("type").item(0).getTextContent());
				if (member.getTextContent().contains("[")) {
					String cut = StringUtils.cutStringAfter(member.getTextContent(), '[');
					cut = StringUtils.cutStringBefore(cut, ']');
					int l = Integer.parseInt(cut);
					type = new ArrayType(type, "", l);
				}
				if (member.getTextContent().contains("*")) {
					type = new PointerType(type);
				}
				members.add(type);
			}
		});
	}

	@Override
	public MemoryLayout memoryLayout() {
		UnionLayout l = this.layout;
		if (l == null) {
			l = MemoryLayout.unionLayout(members.stream().
					map(IDataType::memoryLayout)
					.toArray(MemoryLayout[]::new)
			);
			this.layout = l;
		}
		return l;
	}


	@Override
	public String toString() {
		return getName();
	}


	//@Override
	//public String nativeTypeName() {
	//	return getName();
	//}
}
