package org.example.synchroinzed;

/**
 * @author lvle
 * @date 2022-05-10 15:07
 */
public class SynchronizedTest1 {

    public void test1(){
        synchronized (this){
            int i =5;
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

    public synchronized void test2(){
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
        SynchronizedTest1 test = new SynchronizedTest1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.test1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.test2();
            }
        });
        t1.start();
        t2.start();
    }
}
