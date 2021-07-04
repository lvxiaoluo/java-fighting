package org.example.reflect;

/**
 * @author lvle
 * @date 2021-03-11 22:31
 */
public class TwoFactory {

    public static Fruit getInstance(String className){
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
