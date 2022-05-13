package org.example.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author lvle
 * @date 2022-05-10 20:18
 */
public class NioClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 6666));
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("this is a test".getBytes()));
        System.out.println("-----end");
    }
}
