package net.skds.funcode.neurodebik;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

public class NeuroDebikMain extends JFrame {

	private BufferedImage image;

	public NeuroDebikMain(String base64Image) {
		this.image = decodeBase64ToImage(base64Image);
		setTitle("Decoded Image");
		setSize(400, 400); // Set a default size for the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center the window
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (image != null) {
			// Get the dimensions of the window
			int width = getWidth();
			int height = getHeight();
			// Draw the image scaled to the size of the window
			g.drawImage(image, 0, 0, width, height, null);
		}
	}

	public static BufferedImage decodeBase64ToImage(String base64Image) {
		try {
			byte[] imageBytes = Base64.getDecoder().decode(base64Image);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
			return ImageIO.read(bis);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String base64Image = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAATlBMVEW3p3BsX0KMSyqGRyhbUDh1PSJuOiBmNBxfMhxfMBpZMh1VLxVVLhpDJxFFJRZIJBMpFw8AAADLekS6aDutXTKNTSx1PSJfMBpIJBM2IBYsnG6hAAAAEnRSTlMAAAAAAAAAAAAAAAAAAAAAAACVcz0/AAAAi0lEQVR42l3PSRLCMAxEUTEYCKOjWfe/KC3CKl3lxX8LV4nW3QhvuOdn6TWgT84ZvevSMIZLhKqItxC6MzHIQvTPCPeQhi2Tw8wlH0T5+zBTIJKvA6VyuLlDNGqcAcJmm0gcR0MLi6cphG4lEFZN0RaadwjaqwWwQpSt6nNJEQOs81lV7zkhGO3P/wKdjhJ90wIsEAAAAABJRU5ErkJggg==";
		SwingUtilities.invokeLater(() -> {
			NeuroDebikMain frame = new NeuroDebikMain(base64Image);
			frame.setVisible(true);
		});
	}
	//public static void main(String[] args) throws IOException {

	//SimpleValidator sv = new SimpleValidator();
	//SimpleNet root = new SimpleNet(5, 20, 256, sv.outputSize(), 0f);
	//root.mutate(1);
	//Trainer trainer = new Trainer(10, 4, root, sv, .5f);

	//System.out.println(trainer.train(10000));

	//new DebikFrame();
	//System.out.println(Base64.getEncoder().encodeToString(Files.readAllBytes(new File("item/acacia_boat.png").toPath())));
	//}
}
