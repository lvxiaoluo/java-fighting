package org.example.producer.consumer;

/**
 * @author lvle
 * @date 2021-07-05 15:55
 */
public class DemoStack {
    private int index;

    private int size;

    private char[] ch;

    public DemoStack(int size){
        this.size = size;
        ch = new char[size];
    }

    public synchronized void push(char c){
        while (index == size){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ch[index] = c;
        index ++;
        this.notify();
    }

    public synchronized char pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;
        char c = ch[index];
        this.notify();
        return c;
    }
}
