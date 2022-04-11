package org.example.producer.consumer.caseone;

/**
 * @author lvle
 * @date 2021-07-05 14:06
 */
public class SynchronizedStack {
    //当前存储元素
    private int index = 0;
    //总容量
    private int size = 100;
    // 内存共享区
    private char[] data;
    public SynchronizedStack(int size) {
        System.out.println("栈被创建");
        this.size = size;
        data = new char[size];
    }

    /**
     * 生产数据
     * @param c c
     */
    public synchronized void push(char c) {
        while (index == size) {
            try {
                System.err.println("栈满了");
                // 等待，直到有数据出栈
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        data[index] = c;
        index++;
        //通知其它线程把数据出栈
        this.notify();
    }

    /**
     * 消费数据
     *
     * @return
     */
    public synchronized char pop() {
        while (index == 0) {
            try {
                System.err.println("栈空了");
                this.wait();// 等待，直到有数据出栈
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        index--; // 指针向下移动
        char ch = data[index];
        this.notify(); // 通知其它线程把数据入栈
        return ch;
    }

    // 显示堆栈内容
    public synchronized void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println("ThreadName>>"+Thread.currentThread().getName());
        this.notify(); // 通知其它线程显示堆栈内容
    }
}
