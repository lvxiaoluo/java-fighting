package org.example.producer.consumer.caseone;

/**
 * @author lvle
 * @date 2021-07-05 14:14
 */
public class TestProducerConsumer {
    public static void main(String[] args) {
        // 下面的消费者类对象和生产者类对象所操作的是同一个同步堆栈对象
        SynchronizedStack stack = new SynchronizedStack(5);
        Runnable producer = new Producer(stack);
        Runnable consumer = new Consumer(stack);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
    }
}
