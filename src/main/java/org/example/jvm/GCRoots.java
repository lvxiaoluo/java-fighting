package org.example.jvm;

/**
 * @author lvle
 * @date 2021-03-31 00:09
 */
public class GCRoots {

    //是引用，不是根
    private Object instance = null;

    //静态变量
    private static Object so = new Object();

    //常量
    private final static Object fo = new Object();

    public static void main(String[] args) {
        //局部变量
        Object o1 = new Object();
        //JNI的指针（native方法中入参和出参 有指针）
        o1.hashCode();
    }

    public static void none(){
        //gcRoots 是根
        GCRoots gcRoots = new GCRoots();
        gcRoots =  null;
    }

}
