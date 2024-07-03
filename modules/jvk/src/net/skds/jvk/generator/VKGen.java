package net.skds.jvk.generator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VKGen {

	public static final Map<String, IDataType> types = new HashMap<>();
	public static final Map<String, IEnumType> enums = new HashMap<>();
	public static final Map<String, ICommand> commands = new HashMap<>();

	public static final File EXPORT_DIR = new File("generated/jvk");
	public static final String ROOT_PACKAGE = "net.skds.jvk";

	private static void defaultType(String name, NativeTypeEnum nativeType) {
		DataType tp = new DataType();
		tp.name = name;
		tp.nativeType = nativeType;
		types.put(name, tp);
	}

	private static void addDefaultTypes() {
		defaultType("Display", NativeTypeEnum.POINTER);
		defaultType("VisualID", NativeTypeEnum.POINTER);
		defaultType("Window", NativeTypeEnum.POINTER);
		defaultType("RROutput", NativeTypeEnum.POINTER);
		defaultType("wl_display", NativeTypeEnum.POINTER);
		defaultType("wl_surface", NativeTypeEnum.POINTER);
		defaultType("HINSTANCE", NativeTypeEnum.POINTER);
		defaultType("HWND", NativeTypeEnum.POINTER);
		defaultType("HMONITOR", NativeTypeEnum.POINTER);
		defaultType("HANDLE", NativeTypeEnum.POINTER);
		defaultType("SECURITY_ATTRIBUTES", NativeTypeEnum.POINTER);
		defaultType("DWORD", NativeTypeEnum.UINT16_T);
		defaultType("LPCWSTR", NativeTypeEnum.POINTER);
		defaultType("xcb_connection_t", NativeTypeEnum.POINTER);
		defaultType("xcb_visualid_t", NativeTypeEnum.POINTER);
		defaultType("xcb_window_t", NativeTypeEnum.POINTER);
		defaultType("IDirectFB", NativeTypeEnum.POINTER);
		defaultType("IDirectFBSurface", NativeTypeEnum.POINTER);
		defaultType("zx_handle_t", NativeTypeEnum.POINTER);
		defaultType("GgpStreamDescriptor", NativeTypeEnum.POINTER);
		defaultType("GgpFrameToken", NativeTypeEnum.POINTER);
		defaultType("_screen_context", NativeTypeEnum.POINTER);
		defaultType("_screen_window", NativeTypeEnum.POINTER);


		defaultType("ANativeWindow", NativeTypeEnum.VOID); // Android struct
		defaultType("AHardwareBuffer", NativeTypeEnum.VOID); // Android struct
		defaultType("CAMetalLayer", NativeTypeEnum.VOID); // OBJC

		defaultType("VkSampleMask", NativeTypeEnum.UINT32_T);
		defaultType("VkBool32", NativeTypeEnum.UINT32_T);
		defaultType("VkFlags", NativeTypeEnum.UINT32_T);
		defaultType("VkFlags64", NativeTypeEnum.UINT64_T);
		defaultType("VkDeviceSize", NativeTypeEnum.UINT64_T);
		defaultType("VkDeviceAddress", NativeTypeEnum.UINT64_T);
		defaultType("VkRemoteAddressNV", NativeTypeEnum.POINTER);

		for (NativeTypeEnum nt : NativeTypeEnum.values()) {
			types.put(nt.getName(), nt);
		}
	}

	private static void handleType(Element e) {
		String alias = e.getAttribute("alias");
		if (!alias.isEmpty()) {
			String name = e.getAttribute("name");
			IDataType dt = new DataType.Aliased(alias, name);
			types.put(name, dt);
			return;
		}
		DataType dt = new DataType();
		dt.name = e.getElementsByTagName("name").item(0).getTextContent();
		dt.nativeType = NativeTypeEnum.POINTER;
		types.put(dt.name, dt);
	}

	private static void fpnType(Element e) {
		DataType dt = new DataType();
		dt.name = e.getElementsByTagName("name").item(0).getTextContent();
		dt.nativeType = NativeTypeEnum.POINTER;
		types.put(dt.name, dt);
	}

	private static void structType(Element e) {
		IStruct struct = Struct.create(e);
		types.put(struct.getName(), struct);
	}

	private static void unionType(Element e) {
		Union union = new Union(e);
		types.put(union.getName(), union);
	}

	private static void bitmaskType(Element e) {

		String alias = e.getAttribute("alias");
		if (!alias.isEmpty()) {
			IDataType type = new DataType.Aliased(alias, e.getAttribute("name"));
			types.put(type.getName(), type);
			return;
		}

		IDataType type = VKGen.types.get(e.getElementsByTagName("type").item(0).getTextContent());
		String name = e.getElementsByTagName("name").item(0).getTextContent();

		RefType dt = new RefType(type, name);
		types.put(dt.getName(), dt);
	}

	public static void main(String[] args) throws Exception {

		addDefaultTypes();

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(new File("vk.xml"));
		doc.normalize();

		NodeList nl = doc.getDocumentElement().getElementsByTagName("enums");
		for (int i = 0; i < nl.getLength(); i++) {
			var n = nl.item(i);
			if (n instanceof Element e) {
				var t = EnumType.create(e);
				types.put(t.getName(), t);
				enums.put(t.getName(), t);
			}
		}

		nl = ((Element) doc.getDocumentElement().getElementsByTagName("types").item(0)).getElementsByTagName("type");
		for (int i = 0; i < nl.getLength(); i++) {
			var n = nl.item(i);
			if (n instanceof Element e) {
				String category = e.getAttribute("category");
				switch (category) {
					case "handle" -> handleType(e);
					case "funcpointer" -> fpnType(e);
					case "struct" -> structType(e);
					case "union" -> unionType(e);
					case "bitmask" -> bitmaskType(e);
				}
			}
		}

		nl = ((Element) doc.getDocumentElement().getElementsByTagName("commands").item(0)).getElementsByTagName("command");
		for (int i = 0; i < nl.getLength(); i++) {
			var n = nl.item(i);
			if (n instanceof Element e) {
				ICommand command = VKCommand.create(e);
				commands.put(command.name(), command);
			}
		}

		//for (IDataType t : types.values()) {
		//	try {
		//		t.toString();
		//	} catch (Exception e) {
		//		System.out.println(t.getName());
		//		System.out.println(e);
		//	}
		//}
		//for (var c : commands.values()) {
		//	System.out.println(c);
		//}
		//for (IDataType et : types.values()) {
		//	System.out.println(et);
		//	et.generate();
		//	//for (EnumType.Value v : et.values()) {
		//	//	System.out.println("\t" + v);
		//	//}
		//}
	}
}
