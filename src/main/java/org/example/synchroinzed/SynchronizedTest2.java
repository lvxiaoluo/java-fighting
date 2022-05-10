package org.example.synchroinzed;

/**
 * @author lvle
 * @date 2022-05-10 15:15
 */
public class SynchronizedTest2 {

    public void test1(){
        synchronized (SynchronizedTest2.class){
            int i = 5;
            while (i-- > 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void test2(){
        int i = 5;
        while (i-- > 0){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedTest2 test = new SynchronizedTest2();
        Thread t1 = new Thread(() -> {
            test.test1();
        });

        Thread t2 = new Thread(() -> {
            SynchronizedTest2.test2();
        });

        t1.start();
        t2.start();
    }
}
