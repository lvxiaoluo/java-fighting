package org.example.producer.consumer.casetwo;

/**
 * @author lvle
 * @date 2021-07-05 14:24
 */
public class ResourceStack {
    private String name;
    private int count = 0;
    private boolean flag = false;

    public synchronized void set(String name) {
        //这里必须用循环因为要让每个生产者都知道自己要不要生产。如果不加就可能出现生产者唤醒生产者，然后连续两次生产。
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "--" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        flag = true;
        this.notifyAll();//这里也要用notifyAll()否则，可能造成所有的线程都在等待。
    }

    public synchronized void out() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        flag = false;
        this.notifyAll();
    }
}