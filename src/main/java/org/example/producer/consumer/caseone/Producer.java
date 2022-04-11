package org.example.producer.consumer.caseone;

/**
 * @author lvle
 * @date 2021-07-05 14:08
 */
public class Producer implements Runnable{

    private SynchronizedStack stack;

    public Producer(SynchronizedStack s) {
        stack = s;
    }
    @Override
    public void run() {
        char ch;
        for (int i=0;i< 100;i++){
            //随机产生100个字符
            ch = (char) (Math.random()*26 + 'A');
            stack.push(ch);
            System.out.println("Produced: "+ ch);
            try{
                //每产生一个字符线程就休眠一下
                Thread.sleep((int) (Math.random() * 1000));
            }catch(InterruptedException e){

            }
        }
    }
}
