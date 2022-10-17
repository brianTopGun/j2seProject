package com.javase.c13.thread.a01;

public class TestThread02 extends Thread {
    public TestThread02(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(this.getName()+"----"+i);
        }
    }
}
class Test{
    //这是main方法，程序的入口
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 100 ; i++) {
            System.out.println("main-----"+i);
            if(i == 6){
                //创建子线程：
                TestThread02 tt = new TestThread02("子线程");
                tt.start();
                tt.join();//“半路杀出个程咬金”
            }
        }
    }
}
