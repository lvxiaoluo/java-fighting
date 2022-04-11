package org.example.producer.consumer.casethree;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvle
 * @date 2021-07-05 14:31
 */
public class ResourceStack {

    private int count=0;
    private String name;
    private boolean flag=false;
    Lock lock=new ReentrantLock();
    //这里是生产者的监视器
    Condition pro_condition=lock.newCondition();
    //这里是消费者的监视器
    Condition con_condition=lock.newCondition();
    public void set(String name){

        while(true) {
            //这里相当于代替了synchroinzed 代码块。这不过更人性，直接说上锁。
            lock.lock();
            try {
                while (flag) {
                    try {
                        //但是应为await 会抛出异常但不是放锁，所以就必须在finally里释放锁
                        pro_condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.name = name + "--" + count++;
                System.out.println(Thread.currentThread().getName() + "-生产者.." + this.name);
                //生产完成后将标志置为真！
                flag = true;
                //等价于this.notifyAll这里锁匙this对象
                con_condition.signal();
            } catch (Exception e) {
            } finally {
                //但是应为await 会抛出异常但不是放锁，所以就必须在finally里释放锁
                lock.unlock();
            }

        }
    }

    public void out(){
        while(true) {
            lock.lock();
            try {
                while (flag == false) {
                    con_condition.wait();//即使有消费者线程被唤醒也必须判断flag的标志
                }
                System.out.println(Thread.currentThread().getName() + "-消费者.." + name);
                flag = false;
                pro_condition.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
