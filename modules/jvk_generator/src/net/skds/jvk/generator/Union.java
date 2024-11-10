package net.skds.jvk.generator;

import lombok.Getter;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

class Union extends DataType {

	@Getter
	private final List<IDataType> members = new ArrayList<>();
	int size = -1;


	public Union(Element e) {
		this.name = e.getAttribute("name");

		VKGen.addTask(() -> {
			var mems = e.getElementsByTagName("member");
			for (int i = 0; i < mems.getLength(); i++) {
				Element member = (Element) mems.item(i);
				IDataType type = VKGen.getDataType(member.getElementsByTagName("type").item(0).getTextContent());
				if (member.getTextContent().contains("*")) {
					type = new PointerType(type);
				}
				members.add(type);
			}
		});
	}


	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int size() {
		if (size == -1) {
			int s = 0;
			for (IDataType dt : members) {
				s = Math.max(s, dt.size());
			}
			size = s;
		}
		return size;
	}

	//@Override
	//public String nativeTypeName() {
	//	return getName();
	//}
}
