package org.example.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvle
 * @date 2022-05-10 18:30
 */
public class NioServerTest {

    static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketAddress socketAddress = new InetSocketAddress("localhost", 6666);
        serverSocketChannel.bind(socketAddress);
        serverSocketChannel.configureBlocking(false);

        //有点类似于poll模型
        while (true) {
            for (SocketChannel socketChannel : channelList) {
                int read = socketChannel.read(byteBuffer);
                if (read > 0) {
                    System.out.println("read ... " + read);
                    byteBuffer.flip();
                    byte[] bs = new byte[read];
                    byteBuffer.get(bs);
                    String content = new String(bs);
                    System.out.println(content);
                    byteBuffer.flip();
                }
            }

            SocketChannel accept = serverSocketChannel.accept();
            if (accept != null) {
                System.out.println("conn success -----");
                accept.configureBlocking(false);
                channelList.add(accept);
                System.out.println(channelList.size() + "---- list --- size");
            }
        }
    }
}
