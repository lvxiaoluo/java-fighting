package org.example;

import org.example.io.User;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author lvle
 * @date 2021-03-10 23:46
 */
public class IOTest {


    public static void main(String[] args) {
//        testBIO();
        testReadNIO();
//        testWriteNIO();
        testAIOReadFromFile();
        testAIOWriteToFile();
    }

    static void testAIOWriteToFile(){
        Path path = Paths.get("asynchronous.txt");
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel
                    .open(path, StandardOpenOption.READ, StandardOpenOption.WRITE,
                            StandardOpenOption.CREATE);
            CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    System.out.println("Attachment: " + attachment + " " + result + " bytes written");
                    System.out.println("CompletionHandler Thread ID: " + Thread.currentThread().getId());
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.err.println("Attachment: " + attachment + " failed with:");
                    exc.printStackTrace();
                }
            };
            System.out.println("Main Thread ID : "+Thread.currentThread().getId());
            fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0, "First Write", handler);
            fileChannel.write(ByteBuffer.wrap("Box".getBytes()), 0,"Second Write",handler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void testAIOReadFromFile(){
        Path path = Paths.get("/Users/lvle/applicationTools/workApp/leetcode/leetcode_project/out.txt");
        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
            ByteBuffer bf = ByteBuffer.allocate(100_100);
            Future<Integer> result = channel.read(bf, 0);
            while (!result.isDone()){
                ProfitCalculator.calculateTax();
            }
            Integer bytesRead = result.get();
            System.out.println("Bytes read ["+bytesRead+"]");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    static class ProfitCalculator{
        public ProfitCalculator() {
        }

        public static void calculateTax(){
            System.out.println("calculateTax.....");
        }
    }
    //使用NIO写入
    static void  testWriteNIO(){
        String fileName = "out.txt";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            FileChannel channel = fos.getChannel();
            ByteBuffer bf = Charset.forName("UTF-8").encode("你好，我是write NIO");
            System.out.println("初始容量和limit:"+bf.capacity()+ " limit:"+bf.limit());
            int length = 0;
            while ((length = channel.write(bf))==0){
                //注意，这里不需要 clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                System.out.println("写入长度为:"+length);
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用NIO读取
    static void testReadNIO(){
        String path = "/Users/lvle/Downloads/360.jpg";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            FileChannel channel = fileInputStream.getChannel();
            //字节
            int capacity = 100;
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是:"+bf.limit()+" 容量是:"+bf.capacity()+" 位置是:"+bf.position());
            int  length = -1;
            while ((length = channel.read(bf)) != -1){
                /**
                 *  注意，读取后，将位置置为 0，将 limit 置为容量, 以备下次读入到字节缓冲中，从0开始存储
                 */
                bf.clear();
                byte[] bytes = bf.array();
                System.out.write(bytes,0,length);
                System.out.println("限制是:"+bf.limit()+" 容量是:"+bf.capacity()+" 位置是:"+bf.position());
            }
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 使用 BIO 实现文件的读取和写入。
     */
    static void testBIO(){


        User user = new User();
        user.setName("bio");
        user.setAge(10);
        System.out.println(user);

        //Write Obj to file
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(
                    new FileOutputStream(
                            "tempFile"));
            outputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Read Obj from file
        File file = new File("tempFile");
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            User inUser = (User) inputStream.readObject();
            System.out.println(inUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(file.delete());
    }
}
