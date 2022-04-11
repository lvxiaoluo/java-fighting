package org.example.producer.consumer.casethree;


/**
 * @author lvle
 * @date 2021-07-05 14:25
 */
public class TestProducerConsumerDemo {
    public static void main(String[] args) {
        ResourceStack r = new ResourceStack();
        Producer producer=new Producer(r);
        Consumer consumer=new Consumer(r);
        Thread t1=new Thread(producer);
        Thread t2=new Thread(producer);
        Thread t3=new Thread(consumer);
        Thread t4=new Thread(consumer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
