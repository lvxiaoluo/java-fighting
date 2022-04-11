package org.example.producer.consumer;

/**
 * @author lvle
 * @date 2021-07-05 15:55
 */
public class Producer implements Runnable{

    private DemoStack s;

    public Producer(DemoStack stack){
        s = stack;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            char c = (char) (Math.random()*26+'A');
            s.push(c);
            try {
                System.out.println("生产者>>TThreadName>>"+Thread.currentThread().getName()+">>"+c);
                Thread.sleep((long)Math.random()*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
