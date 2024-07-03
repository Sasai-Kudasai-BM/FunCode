package net.skds.jvk.generator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiFunction;

public class VKGenOld {

	static List<EnumValue> apiConstants = new ArrayList<>();
	static Map<String, EnumValue> apiConstantsMap = new HashMap<>();

	static Map<String, VKType> vkTypeMap = new HashMap<>();

	static Map<String, VKCommand> vkCommandMap = new HashMap<>();

	static Map<String, TypeEnum> enums = new HashMap<>();
	//static Map<String, EnumValue> enumValues = new HashMap<>();

	static List<VKVersion> versions = new ArrayList<>();

	static ConcurrentLinkedQueue<Runnable> doLater = new ConcurrentLinkedQueue<>();


	private static class TypeEnum implements Cloneable {
		String name;
		EnumType type;
		TypeEnum clone;
		Map<String, EnumValue> valuesMap = new HashMap<>();
		List<EnumValue> values = new ArrayList<>();
		//VKType vkType;

		interface BiIntFunction {
			int apply(int a, int b);
		}

		BiFunction<Integer, Integer, Integer> keka = (a, b) -> a * b;
		BiIntFunction keka2 = (a, b) -> a * b;

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Enum ").append(name).append(": ").append(type);//.append(" VK[").append(vkType).append("]");
			for (EnumValue v : values) {
				sb.append(v);
			}
			return sb.toString();
		}

		@Override
		public TypeEnum clone() {
			TypeEnum t = new TypeEnum();
			t.name = name;
			t.type = type;
			t.valuesMap = valuesMap;
			t.values = values;
			t.clone = this;
			this.clone = t;
			return t;
		}
	}

	private static class VKVersion {
		String ver;
		List<VKType> types = new ArrayList<>();
		//List<EnumValue> enumValues = new ArrayList<>();
		List<TypeEnum> enums = new ArrayList<>();
		List<VKCommand> commands = new ArrayList<>();

		@Override
		public String toString() {
			return ver;
		}
	}

	private static class VKType implements Cloneable {
		Object type;
		String name;
		TypeCategory category;
		ArrayList<Object> structure = new ArrayList<>();

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(name).append(": ").append(type).append(" ").append(category);
			if (category == TypeCategory.STRUCT) {
				sb.append(" [\n");
				for (Object o : structure) {
					sb.append("     ").append((o instanceof VKType tp ? tp.name : (o instanceof TypeEnum tp ? tp.name : o))).append("\n");
				}
				sb.append("]");
			}
			return sb.toString();
		}

		@Override
		public VKType clone() {
			VKType t = new VKType();
			t.type = type;
			t.name = name;
			t.category = category;
			t.structure = new ArrayList<>(structure);
			return t;
		}
	}

	private static class EnumValue implements Cloneable {
		Object value;
		String name;
		String comment;
		TypeEnum parent;

		@Override
		public EnumValue clone() {
			EnumValue t = new EnumValue();
			t.name = name;
			t.value = value;
			t.comment = comment;
			return t;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("\n     ").append(name).append(" = ").append(value);
			if (comment != null) {
				sb.append(" // ").append(comment);
			}
			return sb.toString();
		}
	}

	@AllArgsConstructor
	private enum EnumType {
		BITMASK(int.class),
		ENUM(int.class),
		UINT32_T(int.class),
		FLOAT(float.class),
		UINT64_T(long.class);

		final Class<?> jType;
	}

	@AllArgsConstructor
	private enum EnumBaseType {
		UINT8_T(byte.class),
		INT8_T(byte.class),
		UINT16_T(short.class),
		INT16_T(short.class),
		UINT32_T(int.class),
		INT32_T(int.class),
		INT(int.class),
		UINT64_T(long.class),
		INT64_T(long.class),
		VOID(long.class),
		FLOAT(float.class),
		DOUBLE(double.class),
		CHAR(byte.class),
		SIZE_T(int.class),
		DWORD(int.class) {
			@Override
			String getName() {
				return super.name();
			}
		},
		BOOL(boolean.class) {
			@Override
			String getName() {
				return super.name();
			}
		},
		Window(long.class) {
			@Override
			String getName() {
				return super.name();
			}
		},
		HANDLE(int.class) {
			@Override
			String getName() {
				return super.name();
			}
		},
		LPCWSTR(char.class) {
			@Override
			String getName() {
				return super.name();
			}
		},
		;

		final Class<?> jType;


		String getName() {
			return super.name().toLowerCase();
		}
	}

	private enum TypeCategory {
		BITMASK, ENUM, INCLUDE, DEFINE, BASETYPE, HANDLE, FUNCPOINTER, STRUCT, UNION
	}

	private static void parseEnum(Element n) {

		TypeEnum t = new TypeEnum();
		t.name = n.getAttributes().getNamedItem("name").getNodeValue();
		t.type = EnumType.valueOf(n.getAttributes().getNamedItem("type").getNodeValue().toUpperCase());
		n.normalize();

		//t.vkType = vkTypeMap.get(t.name);

		var list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node vn = list.item(i);
			if (!vn.hasAttributes() || !vn.getNodeName().equals("enum")) {
				continue;
			}
			//String name = vn.getNodeName();
			String name = vn.getAttributes().getNamedItem("name").getNodeValue();
			Node alias = vn.getAttributes().getNamedItem("alias");
			if (alias != null) {
				doLater.offer(() -> {
					EnumValue val = t.valuesMap.get(alias.getNodeValue()).clone();
					val.name = name;
					t.valuesMap.put(val.name, val);
					t.values.add(val);
				});
				continue;
			}
			EnumValue enumValue = new EnumValue();
			enumValue.name = name;
			Node value = vn.getAttributes().getNamedItem("value");
			Node bitpos = vn.getAttributes().getNamedItem("bitpos");
			String strVal = null;
			if (value != null) {
				strVal = value.getNodeValue();
			} else if (bitpos != null) {
				strVal = bitpos.getNodeValue();
			}
			if (strVal == null) {
				continue;
			}
			if (strVal.startsWith("0x")) {
				strVal = String.valueOf(Long.parseUnsignedLong(strVal.replace("0x", ""), 16));
			}
			switch (t.type) {
				case BITMASK -> {
					if (vn.getAttributes().getNamedItem("bitwidth") == null) {
						enumValue.value = 1 << Integer.parseInt(strVal);
					} else switch (vn.getAttributes().getNamedItem("bitwidth").getNodeValue()) {
						case "64" -> enumValue.value = 1L << Long.parseLong(strVal);
						case "32" -> enumValue.value = 1 << Integer.parseInt(strVal);
						case "16" -> enumValue.value = (short) (1 << Short.parseShort(strVal));
						case "8" -> enumValue.value = (byte) (1 << Byte.parseByte(strVal));
					}
				}
				case ENUM, UINT32_T -> {
					enumValue.value = Integer.parseInt(strVal);
				}
				case FLOAT -> {
					enumValue.value = Float.parseFloat(strVal);
				}
				case UINT64_T -> {
					enumValue.value = Long.parseLong(strVal);
				}
			}
			Node comment = vn.getAttributes().getNamedItem("comment");
			if (comment != null) {
				enumValue.comment = comment.getNodeValue();
			}
			t.valuesMap.put(enumValue.name, enumValue);
			t.values.add(enumValue);
		}

		enums.put(t.name, t);
		VKType ent = new VKType();
		ent.type = EnumBaseType.INT;
		ent.category = TypeCategory.ENUM;
		ent.name = t.name;
		vkTypeMap.put(t.name, ent);
	}

	private static void apiConst(Node n) {
		var list = n.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node vn = list.item(i);
			//String name = vn.getNodeName();
			if (!vn.hasAttributes()) {
				continue;
			}
			String name = vn.getAttributes().getNamedItem("name").getNodeValue();
			Node alias = vn.getAttributes().getNamedItem("alias");
			if (alias != null) {

				doLater.offer(() -> {
					EnumValue val = apiConstantsMap.get(alias.getNodeValue()).clone();
					val.name = name;
					apiConstantsMap.put(val.name, val);
					apiConstants.add(val);
				});
				continue;
			}
			EnumType t = EnumType.valueOf(vn.getAttributes().getNamedItem("type").getNodeValue().toUpperCase());
			EnumValue enumValue = new EnumValue();
			enumValue.name = name;
			Node value = vn.getAttributes().getNamedItem("value");
			Node bitpos = vn.getAttributes().getNamedItem("bitpos");
			String strVal = null;
			if (value != null) {
				strVal = value.getNodeValue();
			} else if (bitpos != null) {
				strVal = bitpos.getNodeValue();
			}
			if (strVal == null) {
				continue;
			}
			if (strVal.startsWith("(~")) {
				strVal = strVal.replace("(~", "").replace("U", "").replace("L", "").replace(")", "");
				if (strVal.startsWith("0x")) {
					strVal = String.valueOf(Long.parseUnsignedLong(strVal.replace("0x", ""), 16));
				}
				switch (t) {
					case UINT32_T -> {
						enumValue.value = ~Integer.parseInt(strVal);
					}
					case UINT64_T -> {
						enumValue.value = ~Long.parseLong(strVal);
					}
				}
			} else {
				if (strVal.startsWith("0x")) {
					strVal = String.valueOf(Long.parseUnsignedLong(strVal.replace("0x", ""), 16));
				}
				switch (t) {
					case BITMASK -> {
						enumValue.value = 1L << Long.parseLong(strVal);
					}
					case ENUM, UINT32_T -> {
						enumValue.value = Integer.parseInt(strVal);
					}
					case FLOAT -> {
						enumValue.value = Float.parseFloat(strVal);
					}
					case UINT64_T -> {
						enumValue.value = Long.parseLong(strVal);
					}
				}
			}
			Node comment = vn.getAttributes().getNamedItem("comment");
			if (comment != null) {
				enumValue.comment = comment.getNodeValue();
			}
			apiConstantsMap.put(enumValue.name, enumValue);
			apiConstants.add(enumValue);
		}
	}

	private static void types(TypeCategory category, Element e) {
		VKType type = new VKType();
		type.category = category;
		switch (category) {
			case ENUM -> {
				String alias0 = e.getAttribute("alias");
				if (!alias0.isEmpty()) {
					doLater.offer(() -> {
						TypeEnum t = enums.get(alias0).clone();
						t.name = e.getAttributes().getNamedItem("name").getNodeValue();
						enums.put(t.name, t);
					});
				}
			}
			case BASETYPE -> {

				if (e.getElementsByTagName("type").item(0) == null) {

					type.type = long.class;
				} else {
					String t = e.getElementsByTagName("type").item(0).getTextContent();
					type.type = EnumBaseType.valueOf(t.toUpperCase());
				}


				type.name = e.getElementsByTagName("name").item(0).getTextContent();
				vkTypeMap.put(type.name, type);
			}
			case FUNCPOINTER -> {
				type.type = long.class;
				type.name = e.getElementsByTagName("name").item(0).getTextContent();
				vkTypeMap.put(type.name, type);
			}
			case HANDLE -> {
				//VKType t = vkTypeMap.get(alias.getNodeValue());
				if (e.hasAttribute("alias")) {
					doLater.offer(() -> {
						VKType t = vkTypeMap.get(e.getAttribute("alias")).clone();
						t.name = e.getAttribute("name");
						vkTypeMap.put(t.name, t);
					});
					break;
				}
				type.name = e.getElementsByTagName("name").item(0).getTextContent();
				vkTypeMap.put(type.name, type);
			}
			case BITMASK -> {
				var alias = e.getAttributeNode("alias");
				if (alias != null) {

					doLater.offer(() -> {
						String name = e.getAttributeNode("name").getNodeValue();
						VKType t = vkTypeMap.get(alias.getNodeValue()).clone();
						t.name = name;
						vkTypeMap.put(t.name, t);
					});
					break;
				}

				type.type = e.getElementsByTagName("type").item(0).getTextContent();
				type.name = e.getElementsByTagName("name").item(0).getTextContent();
				vkTypeMap.put(type.name, type);
			}
			case STRUCT, UNION -> {
				String alias = e.getAttribute("alias");
				if (!alias.isEmpty()) {
					doLater.offer(() -> {
						VKType t = vkTypeMap.get(alias);
						if (t != null) {
							t = t.clone();
							t.name = e.getAttribute("name");
							vkTypeMap.put(t.name, t);
						} else {
							System.err.println("alias err " + alias);
						}
					});
					break;
				}
				String ext = e.getAttribute("structextends");
				if (!ext.isEmpty()) {

					doLater.offer(() -> {
						ArrayList<Object> list = new ArrayList<>(type.structure);
						type.structure.clear();
						for (String strct : ext.split(",")) {
							VKType ts = vkTypeMap.get(strct);
							if (ts == null) {
								System.err.println("structextends err " + ext);
							} else {
								type.structure.addAll(ts.structure);
							}
						}
						type.structure.addAll(list);

					});
				}
				var mem = e.getElementsByTagName("member");
				for (int i = 0; i < mem.getLength(); i++) {
					Element m = (Element) mem.item(i);
					//String typeName = m.getTextContent().split("\\s\\s", 2)[0];
					var comment = m.getElementsByTagName("comment");
					StructMember stm = new StructMember(
							m.getElementsByTagName("type").item(0).getTextContent(),
							m.getElementsByTagName("name").item(0).getTextContent(),
							comment.getLength() > 0 ? comment.item(0).getTextContent() : "",
							m.getTextContent().contains("const"),
							m.getTextContent().contains("*"),
							m.hasAttribute("optional"),
							m.getAttribute("value"),
							m.getAttribute("len")
					);

					type.structure.add(stm);

				}
				type.name = e.getAttributeNode("name").getNodeValue();
				vkTypeMap.put(type.name, type);
			}
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	private static class VKCommand implements Cloneable {
		Object type;
		String name;
		boolean returnPointer;
		ArrayList<StructMember> args = new ArrayList<>();
		String sc;
		String ec;

		@Override
		public String toString() {
			String sb = name + " " + type + "[" +
					",\n    name: " + name +
					",\n    returnptr:" + returnPointer +
					",\n    args:(\n" + args +
					"),\n    success:" + sc +
					",\n    err:" + ec +
					"\n[";
			return sb;
		}

		@Override
		public VKCommand clone() {
			VKCommand clone = new VKCommand();
			clone.type = type;
			clone.name = name;
			clone.returnPointer = returnPointer;
			clone.args = args;
			clone.ec = ec;
			clone.sc = sc;
			return clone;
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	private static class StructMember {
		Object type;
		String name;
		String comment;
		boolean cnst;
		boolean pointer;
		boolean optional;
		Object value;
		Object len;

		public StructMember(Object type, String name) {
			this.type = type;
			this.name = name;
		}

		@Override
		public String toString() {
			String sb = "StructMember{" + "type=" + (type instanceof StructMember sm ? sm.name : (type instanceof VKType tp ? tp.name : type)) +
					", name='" + name + '\'' +
					", comment='" + comment + '\'' +
					", cnst=" + cnst +
					", pointer=" + pointer +
					", optional=" + optional +
					", value=" + value +
					", len=" + len +
					'}';
			return sb;
		}
	}

	static void buttplugType(String name) {
		VKType t = new VKType();
		t.type = "buttplug";
		t.name = name;
		t.category = TypeCategory.BASETYPE;
		vkTypeMap.put(t.name, t);
	}

	public static void main(String[] args) throws Exception {

		for (EnumBaseType bt : EnumBaseType.values()) {
			VKType t = new VKType();
			t.type = bt.jType;
			t.name = bt.getName();
			t.category = TypeCategory.BASETYPE;
			vkTypeMap.put(t.name, t);
		}
		buttplugType("LPVOID");
		VKType t2 = new VKType();
		t2.name = "SECURITY_ATTRIBUTES";
		t2.category = TypeCategory.STRUCT;
		t2.structure.add(new StructMember(vkTypeMap.get("DWORD"), "nLength"));
		t2.structure.add(new StructMember(vkTypeMap.get("LPVOID"), "lpSecurityDescriptor"));
		t2.structure.add(new StructMember(vkTypeMap.get("BOOL"), "bInheritHandle"));
		vkTypeMap.put(t2.name, t2);
		//DWORD nLength;
		//LPVOID lpSecurityDescriptor;
		//BOOL bInheritHandle;
		//buttplugType("Display");
		//buttplugType("VisualID");
		//buttplugType("RROutput");
		//buttplugType("wl_display");
		//buttplugType("wl_surface");
		//buttplugType("HINSTANCE");
		//buttplugType("HWND");
		//buttplugType("HMONITOR");
		//buttplugType("xcb_connection_t");
		//buttplugType("xcb_visualid_t");
		//buttplugType("xcb_window_t");
		//buttplugType("IDirectFB");
		//buttplugType("IDirectFBSurface");
		//buttplugType("zx_handle_t");
		//buttplugType("GgpStreamDescriptor");
		//buttplugType("GgpFrameToken");
		//buttplugType("_screen_context");
		//buttplugType("_screen_window");
//
		//buttplugType("StdVideoH265ProfileIdc");
		//buttplugType("StdVideoH265VideoParameterSet");
		//buttplugType("StdVideoH265SequenceParameterSet");
		//buttplugType("StdVideoH265PictureParameterSet");
		//buttplugType("StdVideoH265DecPicBufMgr");
		//buttplugType("StdVideoH265HrdParameters");
		//buttplugType("StdVideoH265VpsFlags");
		//buttplugType("StdVideoH265Level");
		//buttplugType("StdVideoH265SpsFlags");
		//buttplugType("StdVideoH265ScalingLists");
		//buttplugType("StdVideoH265SequenceParameterSetVui");
		//buttplugType("StdVideoH265PredictorPaletteEntries");
		//buttplugType("StdVideoH265PpsFlags");
		//buttplugType("StdVideoH265SubLayerHrdParameters");
		//buttplugType("StdVideoH265HrdFlags");
		//buttplugType("StdVideoH265SpsVuiFlags");
		//buttplugType("StdVideoH265SliceType");
		//buttplugType("StdVideoH265PictureType");
		//buttplugType("StdVideoDecodeH265PictureInfo");
		//buttplugType("StdVideoDecodeH265ReferenceInfo");
		//buttplugType("StdVideoDecodeH265PictureInfoFlags");
		//buttplugType("StdVideoDecodeH265ReferenceInfoFlags");
		//buttplugType("VkVideoDecodeH265ProfileEXT");
		//buttplugType("StdVideoEncodeH264SliceHeader");
		//buttplugType("StdVideoDecodeH264ReferenceInfo");
		//buttplugType("StdVideoH264SequenceParameterSet");
		//buttplugType("StdVideoH264PictureParameterSet");
		//buttplugType("StdVideoEncodeH265ReferenceInfo");
		//buttplugType("StdVideoH264SequenceParameterSet");
		//buttplugType("StdVideoH264PictureParameterSet");
		//buttplugType("VkAccelerationStructureTypeNV");
		//buttplugType("StdVideoDecodeH264PictureInfo");
		//buttplugType("StdVideoDecodeH264Mvc");
		//buttplugType("StdVideoH264ProfileIdc");
		//buttplugType("StdVideoEncodeH265ReferenceModifications");
		//buttplugType("StdVideoEncodeH264PictureInfo");
		//buttplugType("StdVideoEncodeH264ReferenceInfo");
		//buttplugType("StdVideoEncodeH265SliceSegmentHeader");
		//buttplugType("StdVideoEncodeH264RefMemMgmtCtrlOperations");
		//buttplugType("StdVideoH264Level");
		//buttplugType("StdVideoEncodeH265PictureInfo");

		//XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream("C:/VulkanSDK/1.3.216.0/share/vulkan/registry/vk.xml")));

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(new File("C:/VulkanSDK/1.3.216.0/share/vulkan/registry/vk.xml"));
		doc.normalize();


		NodeList tps = doc.getDocumentElement().getElementsByTagName("types").item(0).getChildNodes();
		for (int i = 0; i < tps.getLength(); i++) {
			Node n = tps.item(i);
			//if (n instanceof Element e && e.hasAttribute("alias"))
			//	System.out.println("ebaaa " + e.getAttribute("alias"));
			if (n.hasAttributes() && n.getNodeName().equals("type")) {
				if (n.getAttributes().getNamedItem("category") != null) {
					TypeCategory category = TypeCategory.valueOf(n.getAttributes().getNamedItem("category").getNodeValue().toUpperCase());
					types(category, ((Element) n));
				} else {
					String name = n.getAttributes().getNamedItem("name").getNodeValue();
					if (!vkTypeMap.containsKey(name)) {
						buttplugType(name);
					}
				}
			}
		}
		NodeList ens = doc.getDocumentElement().getElementsByTagName("enums");
		for (int i = 0; i < ens.getLength(); i++) {
			Node n = ens.item(i);
			if (n.hasAttributes() && n.getAttributes().getNamedItem("name") != null) {
				if (n.getAttributes().getNamedItem("type") == null) {
					apiConst(n);
					continue;
				}
				parseEnum((Element) n);
			}
		}

		Runnable r;
		while ((r = doLater.poll()) != null) r.run();

		for (VKType type : vkTypeMap.values()) {
			for (Object o : type.structure) {
				StructMember stm = (StructMember) o;
				Object t = stm.type;
				//if (t == null) {
				//	System.err.println("NULL type from " + type.name);
				//	continue;
				//}
				stm.type = vkTypeMap.get(t);
				if (stm.type == null) {
					stm.type = enums.get(t);
				}
				if (stm.type == null && t instanceof String) {
					System.err.println("Unknown type " + t);
				}
			}
		}

		//for (TypeEnum type : enums.values()) {
		//	for (EnumValue value : type.values) {
		//		value.parent = type;
		//		enumValues.put(value.name, value);
		//	}
		//}

		NodeList cmd = doc.getDocumentElement().getElementsByTagName("commands").item(0).getChildNodes();
		for (int i = 0; i < cmd.getLength(); i++) {
			Node n0 = cmd.item(i);
			if (!n0.getNodeName().equals("command")) {
				continue;
			}
			if (n0 instanceof Element n) {

				if (!n.getAttribute("alias").isEmpty()) {
					doLater.offer(() -> {
						VKCommand command = vkCommandMap.get(n.getAttribute("alias"));
						if (command == null) {
							System.err.println("alias err \"" + n.getAttribute("alias") + "\"");
							return;
						}
						command = command.clone();
						command.name = n.getAttribute("name");
						vkCommandMap.put(command.name, command);
					});

					continue;
				}

				VKCommand command = new VKCommand();
				command.sc = n.getAttribute("successcodes");
				command.ec = n.getAttribute("errorcodes");

				Element proto = (Element) n.getElementsByTagName("proto").item(0);
				command.returnPointer = proto.getTextContent().contains("*");

				String typeName = proto.getElementsByTagName("type").item(0).getTextContent();
				command.name = proto.getElementsByTagName("name").item(0).getTextContent();


				var lst = n.getElementsByTagName("param");
				for (int j = 0; j < lst.getLength(); j++) {

					Element par = (Element) lst.item(j);
					boolean op = par.hasAttribute("optional");
					var name2 = par.getElementsByTagName("name").item(0);
					if (name2 == null) {
						System.out.println("null name skip " + par.getTextContent());
						continue;
					}
					String typeName2 = par.getElementsByTagName("type").item(0).getTextContent();
					VKType vkt = vkTypeMap.get(typeName2);
					if (vkt == null) {
						System.err.println("null vkt " + typeName2);
						continue;
					}
					StructMember member = new StructMember(vkt, name2.getTextContent());
					member.pointer = par.getTextContent().contains("*");
					member.len = par.getAttribute("len");

					command.args.add(member);
				}

				command.type = vkTypeMap.get(typeName);
				if (command.type == null) {
					System.err.println("pizdec " + typeName);
				}
				vkCommandMap.put(command.name, command);

			} else {

				doLater.offer(() -> {
					String alias = n0.getAttributes().getNamedItem("alias").getNodeValue();

					VKCommand command = vkCommandMap.get(alias);
					if (command == null) {
						System.err.println("alias err \"" + alias + "\"");
						return;
					}
					command.name = n0.getAttributes().getNamedItem("name").getNodeValue();
					command = command.clone();
					vkCommandMap.put(command.name, command);
				});
			}
		}

		while ((r = doLater.poll()) != null) r.run();

		//NodeList extensions = ((Element) doc.getDocumentElement().getElementsByTagName("extensions").item(0)).getElementsByTagName("extension");
		//for (int i = 0; i < extensions.getLength(); i++) {
		//	Element e = (Element) extensions.item(i);
		//}

		NodeList features = doc.getDocumentElement().getElementsByTagName("feature");
		for (int i = 0; i < features.getLength(); i++) {
			Element e = (Element) features.item(i);
			if (!e.getAttribute("api").equals("vulkan")) {
				continue;
			}
			VKVersion version = new VKVersion();
			version.ver = "VK" + e.getAttribute("number").replace(".", "");

			NodeList list = e.getElementsByTagName("type");
			for (int j = 0; j < list.getLength(); j++) {
				Element t = (Element) list.item(j);
				String tName = t.getAttribute("name");
				var type = vkTypeMap.get(tName);
				if (type == null) {
					System.out.println("skip assume define type " + tName);
					continue;
				}
				version.types.add(type);
			}
			list = e.getElementsByTagName("enum");
			for (int j = 0; j < list.getLength(); j++) {
				Element t = (Element) list.item(j);
				String tName = t.getAttribute("name");
				var type = enums.get(tName);
				if (type == null) {
					tName = t.getAttribute("extends");
					type = enums.get(tName);
				}
				if (type == null) {
					System.out.println("skip enum type assume api constant " + t.getAttribute("name"));
					continue;
				}
				version.enums.add(type);
				//if (type.parent.clone != null) {
				//	version.enums.add(type.parent.clone);
				//}
				//version.enumValues.add(type);
			}
			list = e.getElementsByTagName("command");
			for (int j = 0; j < list.getLength(); j++) {
				Element t = (Element) list.item(j);
				String tName = t.getAttribute("name");
				var type = vkCommandMap.get(tName);
				if (type == null) {
					System.err.println("skip command type " + tName);
					continue;
				}
				version.commands.add(type);
			}

			versions.add(version);
			System.out.println(version);
		}

		System.out.println("XML Parsed");
		//System.out.println(apiConstants);

		//System.out.println("===========API CONSTANTS============");
		//for (EnumValue t : apiConstants) System.out.print(t);
		//System.out.println();
		//System.out.println("====================================");
		//for (TypeEnum t : enums.values()) System.out.println(t);
		//System.out.println("====================================");
		////for (VKType t : vkTypeMap.values()) System.out.println(t);
		//for (VKCommand t : vkCommandMap.values()) System.out.println(t);

		genClasses();

	}

	static void genClasses() throws Exception {
		//File projDir = new File(new File("").getAbsoluteFile().getParentFile(), "modules/funcode/src/");
		File projDir = new File("out/src/");
		File vkClasses = new File(projDir, "net/skds/vulkan/");
		System.out.println("Export to " + vkClasses);

		File enumFolder = new File(vkClasses, "enums/");
		enumFolder.mkdirs();

		String pack = "package net.skds.vulkan.enums;\n\n";
		for (TypeEnum te : enums.values()) {
			File tef = new File(enumFolder, te.name + ".java");
			StringBuilder sb = new StringBuilder(pack).append("public final class ").append(te.name).append(" {\n");

			for (EnumValue v : te.values) {
				sb.append("\tpublic static final ")
						.append(switch (v.value.getClass().getSimpleName()) {
							case "Integer" -> "int";
							case "Long" -> "long";
							default -> throw new IllegalArgumentException(String.valueOf(v.value.getClass()));
						})
						.append(" ")
						.append(v.name)
						.append(" = ")
						.append(v.value)
						.append(";");
				sb.append("\t".repeat(Math.max(0, -v.name.length() / 4 + 11)));
				if (v.comment != null) {
					sb.append(" //").append(v.comment);
				}
				sb.append("\n");

			}

			sb.append("}");
			Files.writeString(tef.toPath(), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}

		VKVersion lastVer = null;
		pack = "package net.skds.vulkan;\n\n";
		for (VKVersion ver : versions) {
			File tef = new File(vkClasses, ver.ver + ".java");
			StringBuilder sb = new StringBuilder(pack)
					.append("""
							import net.skds.funcode.ninvoker.NInvoker;
							import java.lang.invoke.MethodHandle;
							""")
					.append("public class ").append(ver.ver);
			if (lastVer != null) {
				sb.append(" extends ").append(lastVer.ver);
			}
			sb.append(" {\n");
			lastVer = ver;

			StringBuilder sb2 = new StringBuilder();
			for (VKCommand command : ver.commands) { // private static final MethodHandle getKeyState = createWinHandle("GetKeyState", SHORT, INT);
				sb.append("\tpublic static ");
				sb2.append("\tprivate static final MethodHandle ");
				sb2.append(command.name).append(" = NInvoker.createHandle(\"").append(command.name).append("\", NInvoker.");

				String rt = vkType(command.type, sb, sb2);
				sb.append(" ")
						.append(command.name)
						.append("(");
				for (StructMember arg : command.args) {
					sb2.append(", NInvoker.");
					if (arg.pointer) {
						sb.append("long ").append(arg.name);
						sb2.append("LONG");
					} else {
						vkType(arg.type, sb, sb2);
						sb.append(" ").append(arg.name);
					}
					sb.append(", ");
				}
				if (!command.args.isEmpty()) {
					sb.setLength(sb.length() - 2);
				}
				sb2.append(");\n");
				sb.append(") {\n");
				sb.append("""
						\t\ttry {
						""");
				sb.append("\t\t\t");
				if (!rt.equals("void")) {
					sb.append("return (").append(rt).append(") ");
				}
				sb.append(command.name).append(".invokeExact(");

				for (StructMember arg : command.args) {
					sb.append(arg.name).append(", ");
				}
				if (!command.args.isEmpty()) {
					sb.setLength(sb.length() - 2);
				}
				sb.append("""				
						);
						\t\t} catch (Throwable t) {
						\t\t\tthrow new RuntimeException(t);
						\t\t}
						""");
				sb.append("\t}\n");

			}

			sb.append(sb2);
			sb.append("}");
			Files.writeString(tef.toPath(), sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}

	}

	private static String vkType(Object type, StringBuilder sb, StringBuilder sb2) {
		String t;
		if (type instanceof VKType vkt) {
			if (vkt.type instanceof EnumBaseType ebt) {
				t = (ebt.jType.getSimpleName());
			} else if (vkt.category == TypeCategory.BASETYPE) {
				t = (EnumBaseType.valueOf(vkt.name.toUpperCase()).jType.getSimpleName());
			} else if (vkt.category == TypeCategory.HANDLE || vkt.category == TypeCategory.FUNCPOINTER) {
				t = ("long");
			} else if (vkt.category == TypeCategory.BITMASK) {
				t = ("int");
			} else if (vkt.type instanceof EnumType et) {
				t = (et.jType.getSimpleName());
			} else {
				t = String.valueOf(type);
			}
		} else if (type instanceof EnumType et) {
			t = et.jType.getSimpleName();
		} else if (type instanceof EnumBaseType ebt) {
			t = ebt.jType.getSimpleName();
		} else {
			t = type + " keks ??? ";
		}
		sb.append(t);
		sb2.append(t.toUpperCase());
		return t.toLowerCase();
	}

}
