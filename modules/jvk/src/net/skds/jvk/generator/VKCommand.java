package net.skds.jvk.generator;

import lombok.RequiredArgsConstructor;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class VKCommand implements ICommand {

	private String name;
	private String comment = "";
	private IDataType returnType;
	//private final List<String> successCodes = new ArrayList<>();
	//private final List<String> errorCodes = new ArrayList<>();
	private final List<CommandArgument> arguments = new ArrayList<>();

	public static ICommand create(Element e) {
		if (e.hasAttribute("alias")) {
			String name = e.getAttribute("name");
			String alias = e.getAttribute("alias");
			return new Aliased(alias, name);
		}
		VKCommand command = new VKCommand();
		StringBuilder comment = new StringBuilder();

		Element prt = (Element) e.getElementsByTagName("proto").item(0);

		command.name = prt.getElementsByTagName("name").item(0).getTextContent();
		command.returnType = VKGen.getDataType(prt.getElementsByTagName("type").item(0).getTextContent());

		String successCodes = e.getAttribute("successcodes");
		if (!successCodes.isEmpty()) {
			comment.append("\nsuccesscodes = ").append(successCodes);
		}
		String errorCodes = e.getAttribute("errorcodes");
		if (!errorCodes.isEmpty()) {
			comment.append("\nerrorcodes = ").append(errorCodes);
		}

		var params = e.getElementsByTagName("param");
		for (int i = 0; i < params.getLength(); i++) {
			Element param = (Element) params.item(i);

			boolean prOp = param.hasAttribute("optional");
			boolean extSync = param.hasAttribute("externsync");

			var tp = param.getElementsByTagName("type");
			if (tp.getLength() == 0) {
				continue;
			}

			IDataType at = VKGen.getDataType(tp.item(0).getTextContent());
			if (param.getTextContent().contains("*")) {
				at = new PointerType(at);
			}
			String an = param.getElementsByTagName("name").item(0).getTextContent();

			StringBuilder ac = new StringBuilder();
			if (prOp) {
				ac.append("optional");
				if (extSync) {
					ac.append(", ");
				}
			}
			if (extSync) {
				ac.append("external sync");
			}

			command.arguments.add(new CommandArgument(an, at, ac.toString()));
		}

		command.comment = comment.toString();
		return command;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(returnType.getName()).append(" ").append(name).append("(");
		for (CommandArgument arg : arguments) {
			sb.append(arg.type()).append(" ").append(arg.name());
			if (!arg.comment().isEmpty()) {
				sb.append("/* ").append(arg.comment()).append(" */");
			}
			sb.append(", ");
		}
		if (!arguments.isEmpty()) {
			sb.setLength(sb.length() - 2);
		}
		return sb.append(")").toString();
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String comment() {
		return comment;
	}

	@Override
	public IDataType returnType() {
		return returnType;
	}

	@Override
	public List<CommandArgument> arguments() {
		return arguments;
	}

	@RequiredArgsConstructor
	private static class Aliased implements ICommand {
		final String alias;
		final String name;
		ICommand parent;

		private ICommand getParent() {
			if (parent == null) {
				parent = VKGen.commands.get(alias);
			}
			return parent;
		}

		@Override
		public String name() {
			return name;
		}

		@Override
		public String comment() {
			return getParent().comment();
		}

		@Override
		public IDataType returnType() {
			return getParent().returnType();
		}

		@Override
		public List<CommandArgument> arguments() {
			return getParent().arguments();
		}

		@Override
		public String toString() {
			return getParent().toString();
		}
	}
}
