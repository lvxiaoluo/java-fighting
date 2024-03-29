package org.example.producer.consumer.caseone;

/**
 * @author lvle
 * @date 2021-07-05 14:13
 */
public class Consumer implements Runnable {
    private SynchronizedStack stack;

    public Consumer(SynchronizedStack s) {
        stack = s;
    }

    @Override
    public void run() {
        char ch;
        for (int i = 0; i < 100; i++) {
            ch = stack.pop();
            System.out.println("Consumed:" + ch);
            try {
                // 每产生一个字符线程就睡眠一下
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}

