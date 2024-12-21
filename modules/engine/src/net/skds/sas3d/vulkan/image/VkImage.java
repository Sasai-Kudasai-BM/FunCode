package net.skds.sas3d.vulkan.image;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VkImage {
	private long img;
	private long mem;
	private long view;
}
