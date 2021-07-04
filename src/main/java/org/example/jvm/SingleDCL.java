package org.example.jvm;

/**
 * @author lvle
 * @date 2021-04-05 17:27
 * 类中 成员变量、方法
 */
public class SingleDCL {

    /** 需要添加volatile,指令重排成员变量出现半初始化*/
    private static volatile SingleDCL INSTANCE;

    int i = 13;

    private SingleDCL(){

    }
    //获取单例的方法
    public static SingleDCL getInstance(){
        //第一次检查
        if(INSTANCE == null){
            //加锁
            //减少锁的粒度
            synchronized (SingleDCL.class){
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //第二次检查
                //多线程下，线程1执行synchronized 创建了一个对象，然后跳出synchronized,线程2紧接着进入创建一个新的对象
                if(INSTANCE == null){
                    INSTANCE = new SingleDCL();
//                    字节码class的角度
                }
            }
        }
        return INSTANCE;
    }

    /**
     *  Class字节码
     *  new #4 <org/example/jvm/SingleDCL>  --- 在堆划出一块空间
     *
     * 21 invokespecial #5 <org/example/jvm/SingleDCL.<init>> --- 构造方法
     * 24 putstatic #3 <org/example/jvm/SingleDCL.INSTANCE> --- 把引用INSTANCE指向
     */
    public static void main(String[] args) {
        //通过多线程检查是不是单例
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(SingleDCL.getInstance().hashCode())).start();
        }

    }

}
