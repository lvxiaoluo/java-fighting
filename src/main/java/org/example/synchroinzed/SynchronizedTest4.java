package org.example.synchroinzed;

/**
 * @author lvle
 * @date 2022-05-10 15:15
 */
public class SynchronizedTest4 {

    public void test1() {
        int i = 5;
        synchronized (this){
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public  void test2() {
        int i = 5;
        synchronized (this){
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest4 test1 = new SynchronizedTest4();
        Thread t1 = new Thread(() -> {
            test1.test1();
        });

        SynchronizedTest4 test2 = new SynchronizedTest4();
        Thread t2 = new Thread(() -> {
            test2.test2();
        });

        t1.start();
        t2.start();
    }
}
