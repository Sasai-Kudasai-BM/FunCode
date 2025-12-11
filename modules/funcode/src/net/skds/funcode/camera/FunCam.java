package net.skds.funcode.camera;

import net.skds.lib2.utils.logger.SKDSLogger;

public class FunCam {

	public static void main(String[] args) {
		SKDSLogger.replaceOuts();

		/*
		Dimension size = WebcamResolution.VGA.getSize();
		OpenIMAJGrabber grabber = new OpenIMAJGrabber();
		List<Device> devices = grabber.getVideoDevices().get().asArrayList();
		for (var d : devices) {
			System.out.println(d.toString());
		}
		Device device = devices.getFirst();
		Pointer<Device> pDevice = Pointer.getPointer(device);
		grabber.startSession(size.width, size.height, 0, pDevice);

		grabber.nextFrame();
		int w = grabber.getWidth();
		int h = grabber.getHeight();
		System.out.println(w + "x" + h);
		BufferedImage[] imgArr = new BufferedImage[1];
		JFrame frame = new JFrame("Cum");

		frame.add(new JPanel() {
			{
				setPreferredSize(new Dimension(w, h));
			}

			@Override
			protected void paintComponent(Graphics g) {
				//g.drawImage(image, 0, 0, null);
				g.drawImage(imgArr[0], 0, 0, null);
			}

		});
		AWTUtils.initWindow(frame);

		while (frame.isVisible()) {
			grabber.nextFrame();
			byte[] img = grabber.getImage().getBytes(w * h * 3);
			imgArr[0] = ImageUtils.rgbBytesToImage(w, h, img);
			frame.repaint();
			if (!frame.isActive()) ThreadUtils.await(100);
		}

		grabber.stopSession();





	// */

	}
}
