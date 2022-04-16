package org.example.concurrent.sortprint;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvle
 * @date 2022-04-15 18:10
 */
public class Join_ABC {


    static class PrintABC implements Runnable {

        private Thread beforeThread;
        private String name;

        PrintABC(Thread thread, String name) {
            this.beforeThread = thread;
            this.name = name;
        }

        @Override
        public void run() {
            if (beforeThread != null) {
                try {
                    beforeThread.join();
                    System.out.println(Thread.currentThread().getName() + ":" + name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ":" + name);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new PrintABC(null, "A"), "A");
            Thread t2 = new Thread(new PrintABC(t1, "B"), "B");
            Thread t3 = new Thread(new PrintABC(t2, "C"), "C");
            t1.start();
            t2.start();
            t3.start();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
