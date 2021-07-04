package org.example.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lvle
 * @date 2021-05-16 19:09
 */
public class ThreadLocalExampleTest {

    private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) {
        while (true){
            String nowStr = threadLocal.get().format(new Date());
            try {
                Date parse = threadLocal.get().parse(nowStr);
                String parseStr = threadLocal.get().format(parse);
                boolean equals = nowStr.equals(parseStr);
                if (!equals){
                    System.out.println(equals+"["+nowStr+"]"+"["+parseStr+"]");
                }else{
                    System.out.println(equals);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
