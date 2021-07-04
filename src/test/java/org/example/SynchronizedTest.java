package org.example;

/**
 * @author lvle
 * @date 2021-02-17 21:34
 */
public class SynchronizedTest {

    public synchronized void doSome(){
        System.out.println("synchronized....");
    }

    public void doSome1(){
        synchronized (SynchronizedTest.class){
            System.out.println("synchronized!");
        }
    }
}
