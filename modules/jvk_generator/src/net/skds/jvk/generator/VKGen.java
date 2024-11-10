package net.skds.jvk.generator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

class VKGen {

	private static final Queue<Runnable> tasks = new LinkedList<>();

	public static final List<VKVersion> versions = new ArrayList<>();
	public static final Map<String, IDataType> types = new HashMap<>();
	public static final Map<String, IEnumType> enums = new HashMap<>();
	public static final Map<String, ICommand> commands = new HashMap<>();

	public static final Map<String, EnumType.Value> enumValues = new HashMap<>();

	public static final File EXPORT_DIR = new File("generated/jvk");
	public static final String ROOT_PACKAGE = "net.skds.jvk.generated";

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

		// std video
		defaultType("StdVideoH264ProfileIdc", NativeTypeEnum.VOID);
		defaultType("StdVideoH264Level", NativeTypeEnum.VOID);
		defaultType("StdVideoH264SequenceParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoH264PictureParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoDecodeH264PictureInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoDecodeH264ReferenceInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoDecodeH264Mvc", NativeTypeEnum.VOID);
		defaultType("StdVideoH265ProfileIdc", NativeTypeEnum.VOID);
		defaultType("StdVideoH265Level", NativeTypeEnum.VOID);
		defaultType("StdVideoH265VideoParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoH265SequenceParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoH265PictureParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoDecodeH265PictureInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoDecodeH265ReferenceInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoH264SequenceParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoH264PictureParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH264ReferenceInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH264PictureInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH264RefMemMgmtCtrlOperations", NativeTypeEnum.VOID);
		defaultType("StdVideoH264ProfileIdc", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH264SliceHeader", NativeTypeEnum.VOID);
		defaultType("StdVideoH265VideoParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoH265SequenceParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoH265PictureParameterSet", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH265PictureInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH265SliceSegmentHeader", NativeTypeEnum.VOID);
		defaultType("StdVideoH265ProfileIdc", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH265ReferenceInfo", NativeTypeEnum.VOID);
		defaultType("StdVideoEncodeH265ReferenceModifications", NativeTypeEnum.VOID);
		//

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

	public static void addTask(Runnable task) {
		tasks.add(task);
	}

	public static String filterName(String nane) {
		return nane.replace("\t", "").replace(" ", "").replace("\n", "");
	}

	public static IDataType getDataType(String nane) {
		return types.get(filterName(nane));
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
		dt.name = filterName(e.getElementsByTagName("name").item(0).getTextContent());
		dt.nativeType = NativeTypeEnum.POINTER;
		types.put(dt.name, dt);
	}

	private static void fpnType(Element e) {
		DataType dt = new DataType();
		dt.name = filterName(e.getElementsByTagName("name").item(0).getTextContent());
		dt.nativeType = NativeTypeEnum.POINTER;
		types.put(dt.name, dt);
	}

	private static void structType(Element e) {
		IStruct struct = Struct.create(e);
		types.put(struct.getName(), struct);
	}

	private static void enumType(Element e) {
		if (e.hasAttribute("alias")) {
			var t = EnumType.create(e);
			types.put(t.getName(), t);
			enums.put(t.getName(), t);
		}
	}

	private static void unionType(Element e) {
		Union union = new Union(e);
		types.put(union.getName(), union);
	}

	private static void flushTasks() {
		for (Runnable r; (r = tasks.poll()) != null; ) {
			r.run();
		}
	}


	private static void bitmaskType(Element e) {

		String alias = e.getAttribute("alias");
		if (!alias.isEmpty()) {
			IDataType type = new DataType.Aliased(alias, e.getAttribute("name"));
			types.put(type.getName(), type);
			return;
		}

		IDataType type = VKGen.getDataType(e.getElementsByTagName("type").item(0).getTextContent());
		String name = VKGen.filterName(e.getElementsByTagName("name").item(0).getTextContent());

		RefType dt = new RefType(type, name);
		types.put(dt.getName(), dt);
	}

	public static void main(String[] args) throws Exception {
		/*
		var res = HttpUtils.downloadFromNet("https://registry.khronos.org/vulkan/specs/1.3-extensions/man/html/VkInstanceCreateInfo.html");
		res.readAll();
		String ps = new String(res.getContent());
		int start = ps.indexOf("<!--ChunkedSearchboxMarker-->");
		int end = ps.indexOf("<h2 id=\"_document_notes\">", start);
		String cut = ps.substring(start, end).replace("<br>", "");
		end = cut.lastIndexOf("<div class=\"sect1\">");
		cut = cut.substring(0, end) + "</div>";

		System.out.println(cut);

		var fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder0 = fac.newDocumentBuilder();

		Document document = builder0.parse(new InputSource(new StringReader(cut)));
		document.normalizeDocument();


		if (true) return;

 		*/

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
					case "enum" -> enumType(e);
				}
			}
		}

		flushTasks();

		types.forEach((n, t) -> {

		});

		nl = ((Element) doc.getDocumentElement().getElementsByTagName("commands").item(0)).getElementsByTagName("command");
		for (int i = 0; i < nl.getLength(); i++) {
			var n = nl.item(i);
			if (n instanceof Element e) {
				ICommand command = VKCommand.create(e);
				commands.put(command.name(), command);
			}
		}

		nl = doc.getDocumentElement().getElementsByTagName("feature");
		for (int i = 0; i < nl.getLength(); i++) {
			var n = nl.item(i);
			if (n instanceof Element e) {
				VKVersion version = VKVersion.create(e);
				versions.add(version);
			}
		}

		flushTasks();
		var nl0 = doc.getDocumentElement().getElementsByTagName("extensions");
		for (int j = 0; j < nl0.getLength(); j++) {
			nl = ((Element) nl0.item(j)).getElementsByTagName("extension");
			for (int i = 0; i < nl.getLength(); i++) {
				var n = nl.item(i);
				if (n instanceof Element e) {
					VKVersion version = VKVersion.create(e);
					versions.add(version);
				}
			}
		}
		flushTasks();

		for (VKVersion version : versions) {
			version.export();
		}

		//for (IEnumType enumType : enums.values()) {
		//	enumType.generate();
		//}
		for (IDataType t : types.values()) {
			t.generate();
		}


		//for (IDataType t : types.values()) {
		//	try {
		//		t.toString();
		//	} catch (Exception e) {
		//		System.out.println(t.getName());
		//		System.out.println(e);
		//	}
		//}
		//for (var c : versions) {
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
