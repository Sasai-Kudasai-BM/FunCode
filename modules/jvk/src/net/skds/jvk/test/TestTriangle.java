package net.skds.jvk.test;

import net.skds.jvk.VKDefinitions;
import net.skds.jvk.generated.enums.VkQueueFlagBits;
import net.skds.jvk.generated.enums.VkStructureType;
import net.skds.jvk.generated.structs.*;
import net.skds.lib.utils.SKDSUtils;
import net.skds.lib.utils.UnsafeAnal;
import net.skds.nativelib.Kernel32;
import net.skds.ninvoker.MemoryStack;
import net.skds.ninvoker.NInvoker;
import sun.misc.Unsafe;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import static net.skds.jvk.generated.VK10.*;

public class TestTriangle {

	private static final Unsafe UNSAFE = UnsafeAnal.UNSAFE;

	public static final boolean DEBUG = true;
	public static final Set<String> LAYERS = Set.of("VK_LAYER_KHRONOS_validation");
	public static final Set<String> EXTENSIONS = Set.of("VK_KHR_surface");

	private int layersCount;
	private final MemoryStack layersPtr = new MemoryStack();
	private int extensionsCount;
	private final MemoryStack extensionsPtr = new MemoryStack();

	final JFrame frame;
	final long hWnd;
	final long hMod;

	long instance;
	final long pInstance = UNSAFE.allocateMemory(8);
	long hDevice;
	long device;
	final long pDevice = UNSAFE.allocateMemory(8);

	final long lPtr0 = UNSAFE.allocateMemory(8);
	final long lPtr1 = UNSAFE.allocateMemory(8);
	final long lPtr2 = UNSAFE.allocateMemory(8);
	final long lPtr3 = UNSAFE.allocateMemory(8);

	public TestTriangle() {
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.pack();
		frame.setVisible(true);
		this.hWnd = NInvoker.getHWnd(frame);
		this.hMod = Kernel32.getModuleHandle(0);

		if (DEBUG) {
			System.out.println("HWND: " + hWnd);
			System.out.println("HMODULE: " + hMod);
			listLayers();
			listExtensions();
		}


		allocExtensions();
		initInstance();
		initDevice();

	}


	private void allocExtensions() {
		if (DEBUG) {
			layersCount = LAYERS.size();
			for (String layer : LAYERS) {
				layersPtr.pushNT(layer, StandardCharsets.UTF_8);
			}
			layersPtr.makePPtr();
		}
		extensionsCount = EXTENSIONS.size();
		for (String extension : EXTENSIONS) {
			extensionsPtr.pushNT(extension, StandardCharsets.UTF_8);
		}
		extensionsPtr.makePPtr();
	}

	private void initInstance() {

		try (MemoryStack stack = new MemoryStack()) {

			VkApplicationInfo appInfo = new VkApplicationInfo();
			appInfo.applicationVersion = VKDefinitions.vkMakeApiVersion(0, 1, 0, 0);
			appInfo.engineVersion = VKDefinitions.vkMakeApiVersion(0, 1, 0, 0);
			appInfo.pApplicationName = NInvoker.nullTerminatedString("test", StandardCharsets.UTF_8, stack);
			appInfo.pEngineName = NInvoker.nullTerminatedString("test_engine", StandardCharsets.UTF_8, stack);
			appInfo.sType = VkStructureType.VK_STRUCTURE_TYPE_APPLICATION_INFO;
			appInfo.applicationVersion = VKDefinitions.VK_API_VERSION_1_0;

			appInfo.alloc(stack);
			appInfo.put();

			VkInstanceCreateInfo icInfo = new VkInstanceCreateInfo();
			icInfo.sType = VkStructureType.VK_STRUCTURE_TYPE_INSTANCE_CREATE_INFO;
			icInfo.pApplicationInfo = appInfo.address();
			icInfo.enabledLayerCount = layersCount;
			icInfo.ppEnabledLayerNames = layersPtr.getPPtr();
			icInfo.enabledExtensionCount = extensionsCount;
			icInfo.ppEnabledExtensionNames = extensionsPtr.getPPtr();


			icInfo.alloc(stack);
			icInfo.put();

			check(vkCreateInstance(icInfo.address(), 0, pInstance));
			instance = UNSAFE.getAddress(pInstance);

			if (DEBUG) {
				System.out.println("instance: " + instance);
			}
		}
	}

	private void initDevice() {
		try (MemoryStack stack = new MemoryStack()) {

			check(vkEnumeratePhysicalDevices(instance, lPtr0, 0));
			int count = UNSAFE.getInt(lPtr0);
			long pDevArr = stack.pushLongs(count);
			check(vkEnumeratePhysicalDevices(instance, lPtr0, pDevArr));

			VkPhysicalDeviceProperties properties = new VkPhysicalDeviceProperties();
			properties.alloc(stack);

			//VkPhysicalDeviceProperties
			for (int i = 0; i < count; i++) {
				long d = UNSAFE.getLong(pDevArr + i * 8L);
				hDevice = d;

				if (DEBUG) {
					vkGetPhysicalDeviceProperties(d, properties.address());
					properties.get();
					System.out.println("=============== Device =============");
					System.out.println("deviceID: " + properties.deviceID);
					System.out.println("deviceType: " + properties.deviceType);
					System.out.println("apiVersion: " + VKDefinitions.getVersion(properties.apiVersion)
					);
					System.out.println("driverVersion: " + Integer.toUnsignedString(properties.driverVersion, 16));
					System.out.println("vendorID: " + properties.vendorID);
					System.out.println("pipelineCacheUUID: " + SKDSUtils.HEX_FORMAT_LC.formatHex(properties.pipelineCacheUUID));
					System.out.println("deviceName: " + NInvoker.nullTerminatedString(properties.deviceName, StandardCharsets.UTF_8));
					System.out.println("====================================");
				} else {
					break;
				}
			}

			vkGetPhysicalDeviceQueueFamilyProperties(hDevice, lPtr0, 0);
			count = UNSAFE.getInt(lPtr0);
			VkQueueFamilyProperties[] familyProperties = VkQueueFamilyProperties.WRAPPER.allocArray(count, stack);
			vkGetPhysicalDeviceQueueFamilyProperties(hDevice, lPtr0, familyProperties[0].address());

			int desiredBits = VkQueueFlagBits.VK_QUEUE_GRAPHICS_BIT |
					VkQueueFlagBits.VK_QUEUE_COMPUTE_BIT |
					VkQueueFlagBits.VK_QUEUE_TRANSFER_BIT |
					VkQueueFlagBits.VK_QUEUE_SPARSE_BINDING_BIT;

			int familyIndex = 0;
			for (int i = 0; i < count; i++) {
				VkQueueFamilyProperties fp = familyProperties[i];
				fp.get();

				if (DEBUG) {
					System.out.println("===== Family properties ====");
					System.out.println("queueCount: " + fp.queueCount);
					System.out.println("queueFlags: " + fp.queueFlags);
					System.out.println("timestampValidBits: " + fp.timestampValidBits);
					System.out.println("minImageTransferGranularity: " + fp.minImageTransferGranularity.width + " "
							+ fp.minImageTransferGranularity.height + " "
							+ fp.minImageTransferGranularity.depth
					);
					System.out.println("===========================");
				}
				if ((fp.queueFlags & desiredBits) == desiredBits) {
					familyIndex = i;
					break;
				}
			}

			long pPrio = stack.push4();
			UNSAFE.putFloat(pPrio, 1f);
			VkDeviceQueueCreateInfo dqci = new VkDeviceQueueCreateInfo();
			dqci.sType = VkStructureType.VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO;
			dqci.queueFamilyIndex = familyIndex;
			dqci.queueCount = 1;
			dqci.pQueuePriorities = pPrio;

			dqci.alloc(stack);
			dqci.put();

			VkDeviceCreateInfo dci = new VkDeviceCreateInfo();
			dci.sType = VkStructureType.VK_STRUCTURE_TYPE_DEVICE_CREATE_INFO;
			if (DEBUG) {
				dci.enabledLayerCount = layersCount;
				dci.ppEnabledLayerNames = layersPtr.getPPtr();
			}
			//dci.enabledExtensionCount = extensionsCount;
			//dci.ppEnabledExtensionNames = extensionsPtr.getPPtr();
			dci.queueCreateInfoCount = 1;
			dci.pQueueCreateInfos = dqci.address();

			dci.alloc(stack);
			dci.put();

			check(vkCreateDevice(hDevice, dci.address(), 0, pDevice));
			device = UNSAFE.getLong(pDevice);

			if (DEBUG) {
				System.out.println("device: " + device);
			}
		}
	}


	private void listLayers() {

		try (MemoryStack stack = new MemoryStack()) {
			check(vkEnumerateInstanceLayerProperties(lPtr0, 0));
			int size = UNSAFE.getInt(lPtr0);

			VkLayerProperties[] properties = VkLayerProperties.WRAPPER.allocArray(size, stack);

			check(vkEnumerateInstanceLayerProperties(lPtr0, properties[0].address()));
			//properties[0].get();

			for (VkLayerProperties p : properties) {
				p.get();
				System.out.println("======= LayerProperties ==========");
				System.out.println(NInvoker.nullTerminatedString(p.layerName, StandardCharsets.UTF_8));
				System.out.println(NInvoker.nullTerminatedString(p.description, StandardCharsets.UTF_8));
				System.out.println("specVersion: " + p.specVersion);
				System.out.println("specVersion: " + p.implementationVersion);
				System.out.println("=================================");
			}
		}
	}

	private void listExtensions() {

		try (MemoryStack stack = new MemoryStack()) {
			check(vkEnumerateInstanceExtensionProperties(0, lPtr0, 0));
			int size = UNSAFE.getInt(lPtr0);
			VkExtensionProperties[] properties = VkExtensionProperties.WRAPPER.allocArray(size, stack);
			check(vkEnumerateInstanceExtensionProperties(0, lPtr0, properties[0].address()));
			//properties[0].get();

			for (VkExtensionProperties p : properties) {
				p.get();
				System.out.println("======= ExtensionProperties ==========");
				System.out.println(NInvoker.nullTerminatedString(p.extensionName, StandardCharsets.UTF_8));
				System.out.println("specVersion: " + p.specVersion);
				System.out.println("====================================");
			}
		}
	}

	private static void check(int result) {
		if (result != 0) {
			throw new RuntimeException("VK err " + result);
		}
	}
}
