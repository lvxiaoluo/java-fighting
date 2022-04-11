package org.example.producer.consumer.casethree;

/**
 * @author lvle
 * @date 2021-07-05 14:33
 */
public class Producer implements Runnable{
    private ResourceStack resource;
    Producer(ResourceStack resource){
        this.resource=resource;
    }

    @Override
    public void run() {
        resource.set("商品");
    }
}