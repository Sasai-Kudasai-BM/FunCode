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

		defaultType("VkFlags", NativeTypeEnum.UINT32_T);
		defaultType("VkFlags64", NativeTypeEnum.UINT64_T);

		for (NativeTypeEnum nt : NativeTypeEnum.values()) {
			defaultType(nt.name().toLowerCase(), nt);
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

	public static void main(String[] args) throws Exception {

		addDefaultTypes();

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(new File("C:/VulkanSDK/1.3.216.0/share/vulkan/registry/vk.xml"));
		doc.normalize();

		NodeList nl = doc.getDocumentElement().getElementsByTagName("enums");
		for (int i = 0; i < nl.getLength(); i++) {
			var n = nl.item(i);
			if (n instanceof Element e) {
				var t = EnumType.create(e);
				types.put(t.name(), t);
				enums.put(t.name(), t);
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
				}
			}
		}

		for (IDataType et : types.values()) {
			System.out.println(et);

			//for (EnumType.Value v : et.values()) {
			//	System.out.println("\t" + v);
			//}
		}
	}
}
