package org.example.concurrent.sortprint;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvle
 * @date 2022-04-15 18:27
 */
public class Lock_ABC {

    private ReentrantLock lock = new ReentrantLock();
    private int num;


    public static void main(String[] args) {
        Lock_ABC lock_abc = new Lock_ABC();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                lock_abc.printABC("A", 0);
            }).start();
            new Thread(() -> {
                lock_abc.printABC("B", 1);
            }).start();
            new Thread(() -> {
                lock_abc.printABC("C", 2);
            }).start();
        }

    }

    private void printABC(String name, int targetNum) {
        lock.lock();
        try {
            if (num % 3 == targetNum) {
                num++;
                System.out.println(Thread.currentThread().getName() + ":" + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
