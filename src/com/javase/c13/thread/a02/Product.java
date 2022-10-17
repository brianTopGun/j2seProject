package com.javase.c13.thread.a02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {

    //品牌
    private String brand;
    //名字
    private String name;

    boolean isOutOfStock = true;//默认情况下没有商品 让生产者先生产  然后消费者再消费
    //setter,getter方法；
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //声明一个Lock锁：
    Lock lock = new ReentrantLock();
    //搞一个生产者的等待队列：
    Condition produceCondition = lock.newCondition();
    //搞一个消费者的等待队列：
    Condition consumeCondition = lock.newCondition();
    //生产商品
    public   void setProduct(String brand,String name){
        lock.lock();
        try {
            if(!isOutOfStock){//灯是红色，证明有商品，生产者不生产，等着消费者消费
                try {
                   // wait();
                    //生产者阻塞，生产者进入等待队列中
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.setBrand(brand);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setName(name);
            //将生产信息做一个打印：
            System.out.println("生产者生产了：" + this.getBrand() + "---" + this.getName());
            //生产完以后，灯变色：变成红色：
            isOutOfStock = false;
            //告诉消费者赶紧来消费：
            //notify();
            consumeCondition.signal();
        }finally {
            lock.unlock();
        }

    }
    //消费商品：
    public   void getProduct(){
        lock.lock();
        try{
        if(isOutOfStock){//flag == false没有商品，等待生产者生产：
            try {
                // wait();
                //消费者等待，消费者线程进入等待队列：
                consumeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费了：" + this.getBrand() + "---" + this.getName());
        //消费完：灯变色：
        isOutOfStock = true;
        //通知生产者生产：
            //notify();
            produceCondition.signal();
        }finally {
            lock.unlock();
        }
    }
}

class ProducerThread extends Thread{//生产者线程
    //共享商品：
    private Product p;
    public ProducerThread(Product p) {
        this.p = p;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {//生产十个商品 i:生产的次数
            if(i % 2 == 0){
                p.setProduct("费列罗","巧克力");
            }else{
                p.setProduct("哈尔滨","啤酒");
            }
        }
    }
}

class CustomerThread extends Thread{//消费者线程
    //共享商品：
    private Product p;
    public CustomerThread(Product p) {
        this.p = p;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {//i:消费次数
            p.getProduct();
        }
    }
}

class Test {
    //这是main方法，程序的入口
    public static void main(String[] args) {
        //共享的商品：
        Product p = new Product();
        //创建生产者和消费者线程：
        ProducerThread pt = new ProducerThread(p);
        CustomerThread ct = new CustomerThread(p);
        pt.start();
        ct.start();
    }
}
