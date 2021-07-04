package org.example;

/**
 * @author lvle
 * @date 2021-02-20 02:06
 */
public class SwitchDemoString {
    public static void main(String[] arrstring) {
        String string;
        switch (string = "world") {
            case "hello": {
                System.out.println("hello");
                break;
            }
            case "world": {
                System.out.println("world");
                break;
            }
        }
    }
}