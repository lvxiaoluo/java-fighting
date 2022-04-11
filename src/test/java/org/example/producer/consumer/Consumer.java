package org.example.producer.consumer;

import java.util.Random;

/**
 * @author lvle
 * @date 2021-07-05 15:55
 */
public class Consumer implements Runnable{

    private DemoStack s;
    public Consumer(DemoStack stack){
        s = stack;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            char c = s.pop();
            System.out.println("消费者>>ThreadName>>"+Thread.currentThread().getName()+">>"+c);
            try {
                Thread.sleep((long) (Math.random()*i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
