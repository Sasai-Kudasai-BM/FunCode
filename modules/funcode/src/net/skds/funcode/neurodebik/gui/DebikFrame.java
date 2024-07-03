package net.skds.funcode.neurodebik.gui;

import net.skds.funcode.neurodebik.ai.SimpleNet;
import net.skds.funcode.neurodebik.ai.SimpleValidator;
import net.skds.funcode.neurodebik.ai.TrainerOld;
import net.skds.lib.utils.ArrayUtils;
import net.skds.lib.utils.ThreadUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DebikFrame extends JFrame {

	private final DrawPanel drawPanel = new DrawPanel();
	private SimpleNet nn;

	private final SimpleValidator sv = new SimpleValidator();
	private final float[] probs;

	private TrainerOld trainer;

	final JPanel p2;

	public DebikFrame() throws IOException {
		super("Debik");
		probs = new float[sv.picList0.size()];


		nn = new SimpleNet(5, 20, 256, sv.outputSize(), 0.1f);
		nn.mutate(1);
		createTrainer();

		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		add(drawPanel);
		JPanel rp = new JPanel();
		rp.setLayout(new FlowLayout(FlowLayout.LEFT));
		rp.setPreferredSize(new Dimension(400, 800));
		rp.setBackground(Color.GRAY);

		JButton save = new JButton("save");
		save.addActionListener(e -> {
			System.out.println("lol");
		});
		rp.add(save);

		JLabel label = new JLabel("0/0");

		JButton clear = new JButton("clear");
		clear.addActionListener(e -> {
			var g = drawPanel.ig;
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 16, 16);
			drawPanel.repaint();
		});
		rp.add(clear);

		JButton paint = new JButton("paint");
		paint.addActionListener(e -> {
			var g = drawPanel.ig;
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 16, 16);
			drawPanel.repaint();
		});
		rp.add(paint);

		JButton t100 = new JButton("+100");
		t100.addActionListener(e -> {
			label.setText("process");
			ThreadUtil.runAsync(() -> {
				float r = trainer.train(100);
				label.setText("100 -> " + r);
				System.out.println("100 -> " + r);
			});
		});
		rp.add(t100);
		JButton t1000 = new JButton("+1000");
		t1000.addActionListener(e -> {
			label.setText("process");
			ThreadUtil.runAsync(() -> {
				float r = trainer.train(1000);
				label.setText("1000 -> " + r);
				System.out.println("1000 -> " + r);
			});
		});
		rp.add(t1000);
		JButton t100000 = new JButton("+100000");
		t100000.addActionListener(e -> {
			label.setText("process");
			ThreadUtil.runAsync(() -> {
				float r = trainer.train(100000);
				label.setText("100000 -> " + r);
				System.out.println("100000 -> " + r);
			});
		});
		rp.add(t100000);
		rp.add(label);

		p2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				for (int i = 0; i < probs.length; i++) {
					int y = 24 * i + 50;
					g.drawImage(sv.picList0.get(i), 0, y, null);
					g.setColor(Color.DARK_GRAY);
					g.fillRect(24, y + 4, 100, 8);
					g.setColor(Color.BLUE);
					g.fillRect(24, y + 4, (int) (100 * probs[i]), 8);
				}

			}
		};
		p2.setPreferredSize(rp.getPreferredSize());
		rp.add(p2);
		add(rp);

		Timer timer = new Timer(100, e -> {
			anal();
		});

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		timer.start();
	}

	private void anal() {
		SimpleNet nn = trainer.copyBest();
		if (nn == null) {
			return;
		}

		float[] clr = nn.inputBuffer();
		for (int x = 0; x < 16; x++) {
			for (int y = 0; y < 16; y++) {
				int c = drawPanel.image.getRGB(x, y);
				clr[x * 16 + y] = ((c & 255) + ((c >> 8) & 255) + ((c >> 16) & 255)) / (255f * 3);
			}
		}
		nn.process();
		ArrayUtils.copySameSize(nn.outputBuffer(), probs, probs.length);
		p2.repaint();
	}

	private void createTrainer() {
		trainer = new TrainerOld(10, 3, nn, sv, .1f);
	}
}
