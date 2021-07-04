package org.example.jvm;

/**
 * @author lvle
 * @date 2021-04-05 17:20
 *
 * 简单的单例创建方式-饿汉式 --- 浪费内存空间
 */
public class Single {

    //在类加载的时候，程序启动class加载完之后，分配（对象-》堆中），确保线程安全
    //分配内存（堆空间）
    private static final Single INSTANCE = new Single();

    int i =13;

    private Single(){}
    //这个方法暴露都是单例
    public static Single getInstance(){
        return  INSTANCE;
    }

    public static void main(String[] args) {
        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        System.out.println(s1 == s2);

    }


}
