package org.example.io;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lvle
 * @date 2022-05-10 10:57
 */
public class BioServerTest {

/**
 * @Author linhao
 * @Date created in 11:16 上午 2021/8/15
 */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6378);
        while (true) {
            System.out.println("wait conn --------");
            Socket socket = serverSocket.accept();
            System.out.println("conn ok ---------");
            byte[] bytes = new byte[1024];
            System.out.println("wait data ---------");
            socket.getInputStream().read(bytes);
            System.out.printf("data is %s",new String(bytes));
        }
    }
}
