package net.skds.jvk.generated.structs;
import net.skds.ninvoker.struct.NativeStructureWrapper;
import net.skds.ninvoker.struct.ArrayLength;
import net.skds.jvk.generated.structs.VkExtent2D;
import net.skds.lib2.utils.annotations.AutoGenerated;
import net.skds.jvk.annotation.NativeType;
import net.skds.ninvoker.struct.AbstractNativeStructure;

@AutoGenerated
@SuppressWarnings("unused")
public final class VkPhysicalDeviceSampleLocationsPropertiesEXT extends AbstractNativeStructure {


	public static final NativeStructureWrapper WRAPPER = new NativeStructureWrapper(VkPhysicalDeviceSampleLocationsPropertiesEXT.class);

	/**
	* values = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT
	*/
	@NativeType("VkStructureType")
	public int sType;

	/**
	* optional
	*/
	@NativeType("void*")
	public long pNext;

	@NativeType("VkSampleCountFlags")
	public int sampleLocationSampleCounts;

	@NativeType("VkExtent2D")
	public VkExtent2D maxSampleLocationGridSize;

	@ArrayLength(2)
	@NativeType("float[2]")
	public float[] sampleLocationCoordinateRange;

	@NativeType("uint32_t")
	public int sampleLocationSubPixelBits;

	@NativeType("VkBool32")
	public int variableSampleLocations;


	@Override
	protected NativeStructureWrapper getWrapper() {
		return WRAPPER;
	}
}