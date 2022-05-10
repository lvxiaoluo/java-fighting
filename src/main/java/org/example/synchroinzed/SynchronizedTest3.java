package org.example.synchroinzed;

/**
 * @author lvle
 * @date 2022-05-10 15:15
 */
public class SynchronizedTest3 {

    public static synchronized void test1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            test1();
        });

        Thread t2 = new Thread(() -> {
            test2();
        });

        t1.start();
        t2.start();
    }
}
