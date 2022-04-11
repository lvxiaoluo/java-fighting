package org.example.producer.consumer.casethree;

/**
 * @author lvle
 * @date 2021-07-05 14:34
 */
public class Consumer implements Runnable{
    private ResourceStack resource;
    Consumer(ResourceStack resource){
        this.resource=resource;
    }

    @Override
    public void run() {
        resource.out();
    }
}