package org.example.producer.consumer.casetwo;

/**
 * @author lvle
 * @date 2021-07-05 14:25
 */
public class TestProducerConsumerDemo {
    public static void main(String[] args) {
        ResourceStack r=new ResourceStack();
        Producer pro=new Producer(r);
        Consumer con=new Consumer(r);
        Thread t1=new Thread(pro);
        Thread t2=new Thread(pro);
        Thread t3=new Thread(con);
        Thread t4=new Thread(con);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
