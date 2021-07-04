package org.example.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lvle
 * @date 2021-05-16 19:01
 */
public class UnsafeThreadLocalExampleTest {

    private static final SimpleDateFormat F =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        while (true){
            new Thread(()->{
                String nowStr = F.format(new Date());
                try {
                    Date parse = F.parse(nowStr);
                    String format = F.format(parse);
                    boolean flag = nowStr.equals(format);
                    if (!flag){
                        System.out.println(flag+"["+nowStr+"]"+"["+format+"]");
                    }else{
                        System.out.println(flag);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
