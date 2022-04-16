package org.example.concurrent.sortprint;

/**
 * @author lvle
 * @date 2022-04-15 17:46
 */
public class Wait_Notify_Number {

    private Object obj = new Object();
    private int maxNum = 100;
    private int num;

    private void printNum(String name, int targetNum) {
        while (true) {
            synchronized (obj) {
                while (num % 3 != targetNum) {
                    if (num >= maxNum) {
                        break;
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (num >= maxNum) {
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName()+"-"+num);
                obj.notifyAll();
            }

        }
    }

    public static void main(String[] args) {
        Wait_Notify_Number wait_notify_number = new Wait_Notify_Number();
        new Thread(()->{
            wait_notify_number.printNum("A",0);
        },"A").start();
        new Thread(()->{
            wait_notify_number.printNum("B",1);
        },"B").start();
        new Thread(()->{
            wait_notify_number.printNum("C",2);
        },"C").start();
    }
}
