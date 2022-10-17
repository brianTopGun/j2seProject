package com.javase.c13.thread;

public class ThreadTest extends Thread
{

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(this.getName()+"----"+i);
        }
    }
}

class  Test{
    public static void main(String[] args) {
        //主线程中也要输出十个数：
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("main1-----"+i);
        }
        //制造其他线程，要跟主线程争抢资源：
        //具体的线程对象：子线程
        ThreadTest tt = new ThreadTest();
        tt.setName("myThread");
        //tt.run();//调用run方法，想要执行线程中的任务 -->这个run方法不能直接调用，直接调用就会被当做一个普通方法
        //想要tt子线程真正起作用比如要启动线程：
        tt.start();//start()是Thread类中的方法
        //主线程中也要输出十个数：
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("main2-----"+i);
        }
    }
}
