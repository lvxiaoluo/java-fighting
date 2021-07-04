package org.example.reflect;

/**
 * @author lvle
 * @date 2021-03-11 22:29
 */
public class TestReflect {

    public static void main(String[] args) {
        Fruit f = OneFactory.getInstance("Orange");
        f.eat();

        Fruit twoFruit = TwoFactory.getInstance("org.example.reflect.Apple");
        twoFruit.eat();
    }
}
