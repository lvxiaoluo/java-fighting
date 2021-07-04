package org.example;

/**
 * @author lvle
 * @date 2021-02-19 20:22
 *
 * -128 至 127 之间的整数(§3.10.1)
 *
 * true 和 false 的布尔值 (§3.10.3)
 *
 * ‘\u0000’至 ‘\u007f’之间的字符(§3.10.4)
 */
public class BoxingAndUnBoxingTest {

    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 20;
        System.out.println(i + j);

        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println("i1==i2 : "+(i1 == i2));

        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println("i3==i4 : "+(i3 == i4));


        Boolean b1 = true;
        boolean b2 = true;
        System.out.println("b1==b2 : "+(b1 == b2));

    }
}
