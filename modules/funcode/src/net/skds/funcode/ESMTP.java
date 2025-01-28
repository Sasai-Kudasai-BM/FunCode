package net.skds.funcode;

import net.skds.lib2.utils.SKDSByteBuf;
import net.skds.lib2.utils.logger.SKDSLogger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ESMTP {


	static int num = 0;

	public static void main(String[] args) throws IOException {
		SKDSLogger.replaceOuts();
		InetSocketAddress address = new InetSocketAddress("smtp.yandex.ru", 25);

		System.out.println("connecting...");
		try (SocketChannel sc = SocketChannel.open(address)) {
			Selector selector = Selector.open();
			sc.configureBlocking(false);
			final Socket socket = sc.socket();
			socket.setTcpNoDelay(true);
			socket.setSoTimeout(2000);
			sc.register(selector, SelectionKey.OP_READ);

			System.out.println("connected");

			//ByteBuffer bb = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
			//while (bb.hasRemaining()) {
			//	sc.write(bb);
			//}

			//bb = ByteBuffer.wrap("".getBytes(StandardCharsets.UTF_8));
			//while (bb.hasRemaining()) {
			//	sc.write(bb);
			//}

			while (sc.isConnected() && !sc.socket().isClosed()) {
				System.out.println("wait for msg...");
				try {
					selector.select(k -> {
						if (k.isReadable()) {
							select((SocketChannel) k.channel());
						} else {
							k.cancel();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
					sc.close();
					selector.close();
				}
			}
		}
	}

	static void select(SocketChannel sc) {
		try {
			SKDSByteBuf bb = SKDSByteBuf.allocate(1024);
			while (sc.isConnected()) {
				int i = sc.read(bb.getBuffer());
				if (i == -1) {
					sc.close();
					return;
				} else if (i <= 0) {
					break;
				}
			}
			bb.flip();
			byte[] data = bb.remainingAsArray();
			String text = new String(data);
			//System.out.println("c " + bb.remaining());
			//System.out.println(SKDSUtils.HEX_FORMAT_LC.formatHex(data));
			System.out.println(text);
			bb.clear();

			if (num++ == 0) {
				ByteBuffer bb2 = ByteBuffer.wrap("EHLO smtp.yandex.ru\n".getBytes(StandardCharsets.UTF_8));
				while (bb2.hasRemaining()) {
					sc.write(bb2);
				}
			}
			if (num++ == 1) {
				ByteBuffer bb2 = ByteBuffer.wrap("ENHANCEDSTATUSCODES \n".getBytes(StandardCharsets.UTF_8));
				while (bb2.hasRemaining()) {
					sc.write(bb2);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
