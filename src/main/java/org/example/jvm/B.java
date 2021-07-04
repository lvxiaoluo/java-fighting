package org.example.jvm;

/**
 * @author lvle
 * @date 2021-04-04 22:06
 */
public class B {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();
        a3 = a1;
        a1= a2;
        a2 = null;
        a3 = a1;
        //有多少对象符合垃圾回收的条件
    }


}
class A {
    Long l = 1200L;
    public void a1(){
        System.out.println("hello");
    }
    //注意 l = 12L会不同
    //包装类型有缓存
}