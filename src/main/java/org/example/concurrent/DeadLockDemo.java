package org.example.concurrent;

/**
 * @author lvle
 * @date 2021-03-28 17:00
 */
public class DeadLockDemo {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+" get resource1");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"wait get resource2");
                    synchronized (resource2){
                        System.out.println(Thread.currentThread()+" get resource2");
                    }
                }


            }
        },"线程1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2){
                    System.out.println(Thread.currentThread()+" get resource2");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"wait get resource1");
                    synchronized (resource1){
                        System.out.println(Thread.currentThread()+" get resource1");
                    }
                }


            }
        },"线程2").start();




    }
}
