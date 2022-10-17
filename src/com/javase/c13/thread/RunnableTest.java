package com.javase.c13.thread;

public class RunnableTest {
    public static void main(String[] args) {
        //创建子线程对象：
        TestThread tt = new TestThread();
        Thread t = new Thread(tt,"子线程");
//        t.start();
        //主线程里面也是打印1-10数字：
//        for (int i = 1; i <= 10 ; i++) {
//            System.out.println(Thread.currentThread().getName()+"---"+i);
//        }

        //定义一个线程对象：
        BuyTicketThread buyTicketThread = new BuyTicketThread();
        //窗口1买票：
        Thread t1 = new Thread(buyTicketThread,"窗口1");
        t1.start();
        //窗口2买票：
        Thread t2 = new Thread(buyTicketThread,"窗口2");
        t2.start();
        //窗口3买票：
        Thread t3 = new Thread(buyTicketThread,"窗口3");
        t3.start();
    }
}

class BuyTicketThread implements Runnable {
    int ticketNum = 10;
    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            if(ticketNum > 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我在"+Thread.currentThread().getName()+"买到了北京到哈尔滨的第" + ticketNum-- + "张车票");
            }
        }
    }
}
class TestThread implements Runnable{
    @Override
    public void run() {
        //输出1-10数字：
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"----"+i);
        }
    }
}