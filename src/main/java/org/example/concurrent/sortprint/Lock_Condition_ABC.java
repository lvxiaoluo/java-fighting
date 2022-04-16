package org.example.concurrent.sortprint;

import java.sql.Connection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvle
 * @date 2022-04-17 00:05
 */
public class Lock_Condition_ABC {

    private int num;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public static void main(String[] args) {
        Lock_Condition_ABC lock_condition_abc = new Lock_Condition_ABC();
        for (int i=0;i< 10;i++){
            new Thread(()->{
                lock_condition_abc.printABC("A",0,c1,c2);
            }).start();
            new Thread(()->{
                lock_condition_abc.printABC("B",1,c2,c3);
            }).start();
            new Thread(()->{
                lock_condition_abc.printABC("C",2,c3,c1);
            }).start();
        }

    }
    private void printABC(String name,int targetNum,Condition curCon,Condition nextCon){
        lock.lock();
        try{
            while (num % 3 != targetNum){
                curCon.await();
            }
            num++;
            System.out.println(name);
            nextCon.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    
}
