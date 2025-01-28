package net.skds.sosaldb.server;

import net.skds.lib2.network.ChannelConnection;
import net.skds.lib2.network.TCPServer;
import net.skds.lib2.utils.SKDSByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class SDbNetServer {

	private final TCPServer tcpServer = new TCPServer("SDbNetServer", this::createCC);

	public void start(int port) {
		tcpServer.start(new InetSocketAddress(port));
	}

	private ChannelConnection createCC(SocketChannel sc) {
		return new ChannelConnection() {
			@Override
			public SocketChannel getChannel() {
				return sc;
			}

			@Override
			public void read(SocketChannel channel) throws IOException {
				SKDSByteBuf bb = SKDSByteBuf.allocate(1024);
				int i = channel.read(bb.getBuffer());
				if (i == -1) {
					tcpServer.disconnectSC(sc);
					return;
				}
				System.out.println(i);
				System.out.println(bb.remainingAsString());
			}
		};
	}
}
