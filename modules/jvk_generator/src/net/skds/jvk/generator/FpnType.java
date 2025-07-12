package net.skds.jvk.generator;

import lombok.CustomLog;
import lombok.Getter;
import net.skds.jvk.annotation.NativeType;
import net.skds.lib2.misc.clazz.classbuilder.*;
import net.skds.lib2.natives.SafeLinker;
import net.skds.lib2.natives.UpcallLink;
import net.skds.lib2.utils.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CustomLog
class FpnType extends DataType {

	public static final String PACKAGE = VKGen.ROOT_PACKAGE + ".funcpointers";

	@Getter
	private final List<CommandArgument> arguments = new ArrayList<>();

	@Getter
	private IDataType returnType;

	public FpnType(Element e) {
		this.nativeType = NativeTypeEnum.POINTER;
		Node prev = e.getPreviousSibling();
		if (prev.getNodeName().equals("comment")) {
			this.comment = prev.getTextContent();
		}
		var nodes0 = e.getChildNodes();
		for (int i = 0; i < nodes0.getLength(); i++) {
			var n = nodes0.item(i);
			if (n.getNodeName().equals("name")) {
				this.name = VKGen.filterName(n.getTextContent());
			}
		}
		var text = e.getTextContent().replace("typedef ", "");
		String typeName = StringUtils.cutStringBefore(text, ' ');
		VKGen.addTask(() -> {
			IDataType type = VKGen.getDataType(typeName.replace("*", ""));
			Objects.requireNonNull(type);
			if (typeName.contains("*")) {
				type = new PointerType(type);
			}
			this.returnType = type;
			var nodes = e.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				var n = nodes.item(i);
				if (n.getNodeName().equals("type")) {
					String atn = n.getTextContent();
					String argName = VKGen.filterName(n.getNextSibling().getTextContent());
					IDataType argType = VKGen.getDataType(atn.replace("*", ""));
					Objects.requireNonNull(argType);
					if (argName.contains("*")) {
						argType = new PointerType(argType);
					}
					argName = StringUtils.cutStringBefore(argName, ')').replace("*", "").replace(",", "");
					arguments.add(new CommandArgument(argName, argType, null));
				}
			}
		});
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public void generate() {
		String name = getName().substring(4);
		TextClassBuilder cb = new TextClassBuilder(PACKAGE, StringUtils.uppercaseFirstChar(name), ClassType.INTERFACE)
				.annotation(new CBAnnotation(FunctionalInterface.class))
				.setJavadoc(new CBJavadoc(comment))
				.checkImport(SafeLinker.class)
				.checkImport(UpcallLink.class);

		cb.addElement(new CBField(
				"LINK",
				0,
				CBType.of(UpcallLink.class, cb.name),
				null,
				null,
				new CodeBody("SafeLinker.createUpcallLink("
						+ cb.name
						+ ".class);")
		));
		cb.addElement(new CBMethod(
				StringUtils.lowercaseFirstChar(name),
				0,
				VKGen.cbType(returnType),
				List.of(new CBAnnotation(NativeType.class, StringUtils.quote(returnType.nativeTypeName()))),
				null,
				CommandArgument.arguments(arguments),
				null
		));
		// array
		VKGen.export(cb);
	}


}
