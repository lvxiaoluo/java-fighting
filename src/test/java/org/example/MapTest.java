package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvle
 * @date 2021-03-04 22:44
 */
public class MapTest {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        HashMap<String,String> map  = new HashMap<>();
        map.put("test", "leetcode");
        Class<?> aClass = map.getClass();
        Method capacity = aClass.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity>>"+capacity.invoke(map));

        Field size = aClass.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size>>"+size.get(map));

        int cpu = Runtime.getRuntime().availableProcessors();
        System.out.println(cpu);

    }
}
