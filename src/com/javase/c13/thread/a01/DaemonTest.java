package com.javase.c13.thread.a01;

public class DaemonTest {
    //这是main方法，程序的入口
    public static void main(String[] args) {
        //创建并启动子线程：
        TestThread tt = new TestThread();
        tt.setDaemon(true);//设置伴随线程  注意：先设置，再启动
        tt.start();
        //主线程中还要输出1-10的数字：
        for (int i = 1; i <= 10000 ; i++) {
            System.out.println("main---"+i);
        }
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 1000 ; i++) {
            System.out.println("子线程----"+i);
        }
    }
}