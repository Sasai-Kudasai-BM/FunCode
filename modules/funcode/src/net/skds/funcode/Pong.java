package net.skds.funcode;

import lombok.Getter;
import lombok.Setter;
import net.skds.lib2.mat.FastMath;
import net.skds.lib2.utils.ThreadUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Getter
public class Pong {

	private float ballX;
	private float ballY;

	private float speedX;
	private float speedY;


	@Setter
	private float padSpeed = 0.02f;
	@Setter
	private float ballSpeed = 0.025f;

	@Setter
	private float padSize = 0.1f;

	private float padPos = .5f;

	private int padMove = 0;

	public void start() {
		ballX = .9f;
		ballY = .5f;
		speedX = FastMath.RANDOM.nextFloat() * -.5f;
		if (speedX > -0.05f) {
			speedX -= .1f;
		}
		speedY = FastMath.RANDOM.nextFloat() - .5f;
		normalize();
	}

	private void normalize() {
		float d = ballSpeed / (float) Math.sqrt(speedX * speedX + speedY * speedY);
		speedX *= d;
		speedY *= d;
	}

	public void tick() {
		ballX += speedX;
		ballY += speedY;

		padPos = FastMath.clamp(padPos + padMove * padSpeed, padSize, 1 - padSize);

		if (ballX < 0) {
			speedX = -speedX;
			ballX += speedX;
		} else if (ballX > 1) {
			if (Math.abs(ballY - padPos) > padSize) {
				fail();
			} else {
				speedX = -speedX;
				ballX += speedX;
				bonk();
			}
		}
		if (ballY < 0 || ballY > 1) {
			speedY = -speedY;
			ballY += speedY;
		}
	}

	public void movePad(int move) {
		padMove = FastMath.clamp(-move, -1, 1);
	}

	private void fail() {
		start();
	}

	private void bonk() {

	}

	public static JFrame createFrame(Pong pong) {
		JFrame frame = new JFrame("Pong");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int size = 600;
		int bs = size / 50;
		int bs2 = bs / 2;
		int ps = size / 100;
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.setColor(Color.BLACK);
				g.fillOval((int) (pong.getBallX() * size - bs2), (int) (pong.getBallY() * size - bs2), bs, bs);
				g.setColor(Color.BLUE);
				g.fillRect(size - ps, (int) ((pong.getPadPos() - pong.getPadSize()) * size), ps, (int) (pong.getPadSize() * 2 * size));
			}
		};
		panel.setPreferredSize(new Dimension(size, size));
		frame.add(panel);
		frame.setResizable(false);
		frame.addKeyListener(new KeyAdapter() {

			boolean up = false;
			boolean down = false;

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					up = true;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					down = true;
				}
				command();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					up = false;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					down = false;
				}
				command();
			}

			private void command() {
				int i = up ? 1 : 0;
				i -= down ? 1 : 0;
				pong.movePad(i);
			}
		});
		frame.pack();
		frame.setVisible(true);
		pong.start();
		ThreadUtil.runTickableDaemon(() -> {
			pong.tick();
			panel.repaint();
			return true;
		}, "pong", 20);
		return frame;
	}
}
