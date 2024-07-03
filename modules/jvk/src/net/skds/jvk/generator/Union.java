package net.skds.jvk.generator;

import lombok.Getter;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class Union extends DataType {

	@Getter
	private final List<IDataType> members = new ArrayList<>();

	public Union(Element e) {
		this.name = e.getAttribute("name");

		var mems = e.getElementsByTagName("member");
		for (int i = 0; i < mems.getLength(); i++) {
			Element member = (Element) mems.item(i);
			IDataType type = VKGen.types.get(member.getElementsByTagName("type").item(0).getTextContent());
			if (member.getTextContent().contains("*")) {
				type = new PointerType(type);
			}
			members.add(type);
		}
	}


	@Override
	public int size() {
		return 0;
	}
}
