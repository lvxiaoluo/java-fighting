package org.example.concurrent.sortprint;

/**
 * @author lvle
 * @date 2022-04-15 16:49
 */
public class Wait_Notify_ABC {

    private Object obj = new Object();

    private  int num;

    private void printStr(String str,int targetNum){
//        for (int i=0;i<10;i++){
            synchronized (obj){
                while (num % 3 != targetNum){
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.print(str);
                obj.notifyAll();
            }
//        }
    }

    public static void main(String[] args) {
        for (int i = 0;i< 100;i++){
            Wait_Notify_ABC waitNotifyABC = new Wait_Notify_ABC();
            new Thread(()->{
                waitNotifyABC.printStr("A", 0);
            }).start();
            new Thread(()->{
                waitNotifyABC.printStr("B", 1);
            }).start();
            new Thread(()->{
                waitNotifyABC.printStr("C", 2);
            }).start();
        }
    }
}
