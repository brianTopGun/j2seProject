package com.design.c02.strategy;

public interface Comparator<T> {

    int compare(T o1, T o2);

    default void m() {
        System.out.println("m");
    }
}
