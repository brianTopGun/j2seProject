package com.design.c01.singleton;
/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr03 {

    //volatile 解决JIT 优化的问题，指令重排的问题
    private static volatile Mgr03 INSTANCE;

    private Mgr03(){
    }

    public static Mgr03 getInstance(){
        if(null == INSTANCE){
            synchronized (Mgr03.class){
                if(null == INSTANCE) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr03();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }
    }
}
