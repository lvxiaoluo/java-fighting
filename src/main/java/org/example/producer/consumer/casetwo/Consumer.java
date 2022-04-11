package org.example.producer.consumer.casetwo;

/**
 * @author lvle
 * @date 2021-07-05 14:24
 */
public class Consumer implements Runnable{
    private ResourceStack res;
    Consumer(ResourceStack res){
        this.res=res;
    }
    @Override
    public void run() {
        while(true){
            res.out();
        }
    }
}