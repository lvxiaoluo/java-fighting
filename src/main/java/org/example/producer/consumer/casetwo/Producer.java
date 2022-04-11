package org.example.producer.consumer.casetwo;

/**
 * @author lvle
 * @date 2021-07-05 14:23
 */
public class Producer implements Runnable {
    private ResourceStack res;

    public Producer(ResourceStack res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.set("商品");
        }
    }
}