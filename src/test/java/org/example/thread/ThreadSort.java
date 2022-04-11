package org.example.thread;

/**
 * @author lvle
 * @date 2021-07-05 16:37
 */
public class ThreadSort {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(">>>>> thread 1"));
        Thread t2 = new Thread(() -> System.out.println(">>>>> thread 2"));
        Thread t3 = new Thread(() -> System.out.println(">>>>> thread 3"));
        Thread t4 = new Thread(() -> System.out.println(">>>>> thread 4"));
        Thread t5 = new Thread(() -> System.out.println(">>>>> thread 5"));

        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            t4.start();
            t4.join();
            t5.start();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
