package com.design.c01.singleton;

public enum Mgr05 {
    instance;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr05.instance.hashCode());
            }).start();
        }
    }
}
