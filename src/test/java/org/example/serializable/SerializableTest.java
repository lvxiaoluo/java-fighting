package org.example.serializable;

import java.io.*;
import java.util.Date;

/**
 * @author lvle
 * @date 2021-02-20 17:28
 */
public class SerializableTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("luolin");
        user.setAge(18);
        user.setGener("男");
        user.setBirthday(new Date());
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream("tempFile"));
            stream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File file = new File("tempFile");
        ObjectInputStream inputStream = null;
        try {
             inputStream = new ObjectInputStream(new FileInputStream(file));
            User o = (User) inputStream.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.delete();
        }

    }
}
