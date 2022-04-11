package org.example.producer.consumer;

/**
 * @author lvle
 * @date 2021-07-05 16:18
 */
public class DemoTest {
    public static void main(String[] args) {
        DemoStack demoStack = new DemoStack(100);
        Producer producer = new Producer(demoStack);
        Consumer consumer = new Consumer(demoStack);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();

    }
}
