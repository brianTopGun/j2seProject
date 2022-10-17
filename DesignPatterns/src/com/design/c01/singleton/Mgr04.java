package com.design.c01.singleton;

public class Mgr04 {

    private Mgr04(){

    }

    private static class Mgr04Instance{
        public static final Mgr04 INSTANCE = new Mgr04();
    }

    public  static Mgr04 getInstance(){
        return Mgr04Instance.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}