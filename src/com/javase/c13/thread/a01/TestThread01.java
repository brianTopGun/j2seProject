package com.javase.c13.thread.a01;
class TestThread01 {
    public static void main(String[] args) {
//创建两个子线程，让这两个子线程争抢资源：
        Thread01 t1 = new Thread01();
        t1.setPriority(10);//优先级别高
        t1.start();
        Thread02 t2 = new Thread02();
        t2.setPriority(1);//优先级别低
        t2.start();
    }
}

class Thread01 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}
class Thread02 extends Thread{
    @Override
    public void run() {
        for (int i = 20; i <= 30 ; i++) {
            System.out.println(i);
        }
    }
}